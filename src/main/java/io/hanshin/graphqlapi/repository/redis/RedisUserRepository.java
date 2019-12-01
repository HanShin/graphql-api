package io.hanshin.graphqlapi.repository.redis;

import io.hanshin.graphqlapi.model.redis.User;
import org.springframework.data.repository.CrudRepository;

public interface RedisUserRepository extends CrudRepository<User,Long> {
}
