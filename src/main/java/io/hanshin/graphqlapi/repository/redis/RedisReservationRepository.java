package io.hanshin.graphqlapi.repository.redis;

import io.hanshin.graphqlapi.model.redis.Reservation;
import org.springframework.data.repository.CrudRepository;

public interface RedisReservationRepository extends CrudRepository<Reservation,Long> {
}
