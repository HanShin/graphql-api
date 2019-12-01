package io.hanshin.graphqlapi.redis;

import io.hanshin.graphqlapi.model.ConferenceRoom;
import io.hanshin.graphqlapi.model.Reservation;
import io.hanshin.graphqlapi.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class RedisServiceImpl implements RedisService {

    private final RedisTemplate<String, Object> redisTemplate;

    public RedisServiceImpl(RedisTemplate<String, Object> redisTemplate){
        this.redisTemplate = redisTemplate;
    }

    @Override
    public List<User> getUsers() {
        return null;
    }

    @Override
    public List<ConferenceRoom> getConferenceRooms() {
        return null;
    }

    @Override
    public List<Reservation> getReservations() {
        return null;
    }
}
