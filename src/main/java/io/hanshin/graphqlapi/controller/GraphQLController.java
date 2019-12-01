package io.hanshin.graphqlapi.controller;

import io.hanshin.graphqlapi.graphql.GraphUseCase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping
public class GraphQLController {

    private final GraphUseCase graphUseCase;

    public GraphQLController(GraphUseCase graphUseCase){
        this.graphUseCase = graphUseCase;
    }
}
