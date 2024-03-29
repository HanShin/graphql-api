package io.hanshin.graphqlapi.graphql;

import graphql.ExecutionResult;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;

@Slf4j
@Component
public class GraphProvider implements GraphUseCase {


    @Value("classpath:reservation.graphql")
    Resource resource;

    private GraphQL graphQL;

    private final ReservationDataFetcher reservationDataFetcher;
    private final EmptyRoomDataFetcher emptyRoomDataFetcher;
    private final WeekDataFetcher weekDataFetcher;
    private final RedisConferenceRoomDataFetcher redisConferenceRoomDataFetcher;
    private final RedisReservationDataFetcher redisReservationDataFetcher;
    private final RedisUserDataFetcher redisUserDataFetcher;

    public GraphProvider(ReservationDataFetcher reservationDataFetch,
                        EmptyRoomDataFetcher emptyRoomDataFetch,
                        WeekDataFetcher weekDataFetcher,
                        RedisConferenceRoomDataFetcher redisConferenceRoomDataFetcher,
                        RedisReservationDataFetcher redisReservationDataFetcher,
                        RedisUserDataFetcher redisUserDataFetcher){
        this.reservationDataFetcher = reservationDataFetch;
        this.emptyRoomDataFetcher = emptyRoomDataFetch;
        this.weekDataFetcher = weekDataFetcher;
        this.redisConferenceRoomDataFetcher = redisConferenceRoomDataFetcher;
        this.redisReservationDataFetcher = redisReservationDataFetcher;
        this.redisUserDataFetcher = redisUserDataFetcher;

    }

    @PostConstruct
    private void loadSchema() throws IOException {
        File schemaFile = resource.getFile();
        TypeDefinitionRegistry typeDefinitionRegistry = new SchemaParser().parse(schemaFile);
        RuntimeWiring runtimeWiring = RuntimeWiring.newRuntimeWiring()
                .type("Query", typeWiring -> typeWiring
                    .dataFetcher("users", redisUserDataFetcher)
                    .dataFetcher("conferenceRooms", redisConferenceRoomDataFetcher)
                    .dataFetcher("reservations", redisReservationDataFetcher)
                    .dataFetcher("getThisWeekReservations", weekDataFetcher)
                    .dataFetcher("getEmptyConferenceRooms", emptyRoomDataFetcher))
                .type("Mutation", typeWiring -> typeWiring
                .dataFetcher("reservation", reservationDataFetcher))
                .build();
        GraphQLSchema graphQLSchema = new SchemaGenerator().makeExecutableSchema(typeDefinitionRegistry,runtimeWiring);
        graphQL = GraphQL.newGraphQL(graphQLSchema).build();
    }

    @Override
    public ExecutionResult execute(String query) {
        return graphQL.execute(query);
    }

}
