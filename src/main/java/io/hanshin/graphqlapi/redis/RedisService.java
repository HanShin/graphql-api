package io.hanshin.graphqlapi.redis;

import io.hanshin.graphqlapi.model.ConferenceRoom;
import io.hanshin.graphqlapi.model.Reservation;
import io.hanshin.graphqlapi.model.User;

import java.util.List;

public interface RedisService {

    List<User> getUsers();
    List<ConferenceRoom> getConferenceRooms();
    List<Reservation> getReservations();
}
