package io.hanshin.graphqlapi.graphql;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import io.hanshin.graphqlapi.model.entity.Reservation;
import io.hanshin.graphqlapi.redis.RedisService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RedisReservationDataFetcher implements DataFetcher<List<Reservation>> {

    private final RedisService redisService;

    public RedisReservationDataFetcher(RedisService redisService){
        this.redisService = redisService;
    }

    @Override
    public List<Reservation> get(DataFetchingEnvironment environment) throws Exception {
        return redisService.getReservations();
    }
}
