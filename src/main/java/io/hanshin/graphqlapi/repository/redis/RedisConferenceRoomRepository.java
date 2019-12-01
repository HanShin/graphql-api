package io.hanshin.graphqlapi.repository.redis;

import io.hanshin.graphqlapi.model.redis.ConferenceRoom;
import org.springframework.data.repository.CrudRepository;

public interface RedisConferenceRoomRepository extends CrudRepository<ConferenceRoom,Long> {
}
