package io.hanshin.graphqlapi.redis;

import io.hanshin.graphqlapi.model.entity.ConferenceRoom;
import io.hanshin.graphqlapi.model.entity.Reservation;
import io.hanshin.graphqlapi.model.entity.User;

import java.util.List;

public interface RedisService {

    void updateUsers();
    void updateConferenceRooms();
    void updateReservations();

    List<User> getUsers();
    List<ConferenceRoom> getConferenceRooms();
    List<Reservation> getReservations();
}
