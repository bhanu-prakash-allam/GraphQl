package com.graphql.graphqldemo.exception;

import graphql.ErrorClassification;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

import java.util.List;

public class BookNotFoundException extends RuntimeException implements GraphQLError {
    public BookNotFoundException(String message)
    {
        super(message);
    }

    public String getMessage()
    {
        return super.getMessage();
    }

    @Override
    public List<SourceLocation> getLocations() {
        return null;
    }

    @Override
    public ErrorClassification getErrorType() {
        return null;
    }
}
