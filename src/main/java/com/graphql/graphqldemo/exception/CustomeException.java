package com.graphql.graphqldemo.exception;

import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.GraphqlErrorBuilder;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.graphql.execution.DataFetcherExceptionResolverAdapter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class CustomeException extends DataFetcherExceptionResolverAdapter {
    @Override
    public GraphQLError resolveToSingleError(Throwable ex, DataFetchingEnvironment env) {
        ErrorType errorType = determineErrorType(ex);
        // Create a custom error
        GraphQLError error = GraphqlErrorBuilder.newError()
                .errorType(errorType)
                .message(ex.getMessage())
                .path(env.getExecutionStepInfo().getPath())
                .location(env.getField().getSourceLocation())
                .build();

        return error;
    }

    private ErrorType determineErrorType(Throwable ex) {
        if (ex.getMessage().contains("book not available with id")) {
            return ErrorType.DataFetchingException;
        }

        return ErrorType.ValidationError;
    }

}
