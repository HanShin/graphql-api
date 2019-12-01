package io.hanshin.graphqlapi.graphql;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import io.hanshin.graphqlapi.model.entity.ConferenceRoom;
import io.hanshin.graphqlapi.redis.RedisService;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class RedisConferenceRoomDataFetcher implements DataFetcher<List<ConferenceRoom>> {

    private final RedisService redisService;

    public RedisConferenceRoomDataFetcher(RedisService redisService){
        this.redisService = redisService;
    }

    @Override
    public List<ConferenceRoom> get(DataFetchingEnvironment environment) throws Exception {
        return redisService.getConferenceRooms();
    }
}
