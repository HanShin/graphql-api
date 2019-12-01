package io.hanshin.graphqlapi.controller;

import graphql.ExecutionResult;
import io.hanshin.graphqlapi.graphql.GraphUseCase;
import io.hanshin.graphqlapi.model.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/graphql")
public class GraphQLController {

    private final GraphUseCase graphUseCase;

    public GraphQLController(GraphUseCase graphUseCase){
        this.graphUseCase = graphUseCase;
    }

    @PostMapping
    public ResponseEntity<Object> graphByQuery(@RequestBody Data data){
        ExecutionResult executionResult = graphUseCase.execute(data.getQuery());
        return new ResponseEntity<>(executionResult, HttpStatus.OK);
    }
}
