package io.hanshin.graphqlapi.graphql;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import io.hanshin.graphqlapi.model.entity.User;
import io.hanshin.graphqlapi.redis.RedisService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RedisUserDataFetcher implements DataFetcher<List<User>> {

    private final RedisService redisService;

    public RedisUserDataFetcher(RedisService redisService){
        this.redisService = redisService;
    }

    @Override
    public List<User> get(DataFetchingEnvironment environment) throws Exception {
        return redisService.getUsers();
    }
}
