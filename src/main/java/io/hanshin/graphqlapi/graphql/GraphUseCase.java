package io.hanshin.graphqlapi.graphql;

import graphql.ExecutionResult;

public interface GraphUseCase {
    ExecutionResult execute(String query);
}
