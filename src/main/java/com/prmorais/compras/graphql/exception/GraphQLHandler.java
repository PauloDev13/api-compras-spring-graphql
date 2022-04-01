package com.prmorais.compras.graphql.exception;

import com.fasterxml.jackson.annotation.JsonIgnore;
import graphql.ExceptionWhileDataFetching;
import graphql.GraphQLError;
//import graphql.servlet.GenericGraphQLError;
//import graphql.servlet.GraphQLErrorHandler;
import graphql.kickstart.execution.error.GenericGraphQLError;
import graphql.kickstart.execution.error.GraphQLErrorHandler;
import graphql.validation.ValidationError;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class GraphQLHandler implements GraphQLErrorHandler {

    private final Environment env;

    @Override
    public List<GraphQLError> processErrors(List<GraphQLError> list) {
        return list.stream().map(this::getErros).collect(Collectors.toList());
    }

    private GraphQLError getErros(GraphQLError error) {
        if (error instanceof ExceptionWhileDataFetching exceptionError) {
            if (exceptionError.getException() instanceof DomainException) {
                Throwable ex = exceptionError.getException();
                String msg = ex.getMessage();
                return new SimpleError(msg);
            }

            String[] profiles = env.getActiveProfiles();
            if (!ArrayUtils.contains(profiles, "dev")) {
                return new SimpleError("Ocorreu um erro ao processar a transação");
            }

        } else if (error instanceof ValidationError) {
            String msg = error.getMessage();
            return new SimpleError(msg);
        }
        return error;
    }
}

class SimpleError extends GenericGraphQLError {

    SimpleError(String message) {
        super(message);
    }

    @Override
    @JsonIgnore
    public List<Object> getPath() {
        return null;
    }

    @Override
    @JsonIgnore
    public Map<String, Object> getExtensions() {
        return null;
    }
}
