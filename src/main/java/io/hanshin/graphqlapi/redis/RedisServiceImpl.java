package io.hanshin.graphqlapi.redis;

import io.hanshin.graphqlapi.model.entity.ConferenceRoom;
import io.hanshin.graphqlapi.model.entity.Reservation;
import io.hanshin.graphqlapi.model.entity.User;
import io.hanshin.graphqlapi.repository.ConferenceRoomRepository;
import io.hanshin.graphqlapi.repository.ReservationRepository;
import io.hanshin.graphqlapi.repository.UserRepository;
import io.hanshin.graphqlapi.repository.redis.RedisConferenceRoomRepository;
import io.hanshin.graphqlapi.repository.redis.RedisReservationRepository;
import io.hanshin.graphqlapi.repository.redis.RedisUserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Slf4j
@Service
public class RedisServiceImpl implements RedisService {

    private final RedisConferenceRoomRepository redisConferenceRoomRepository;
    private final RedisReservationRepository redisReservationRepository;
    private final RedisUserRepository redisUserRepository;

    private final ConferenceRoomRepository conferenceRoomRepository;
    private final ReservationRepository reservationRepository;
    private final UserRepository userRepository;

    public RedisServiceImpl(
                            RedisConferenceRoomRepository redisConferenceRoomRepository,
                            RedisReservationRepository redisReservationRepository,
                            RedisUserRepository redisUserRepository,
                            ConferenceRoomRepository conferenceRoomRepository,
                            ReservationRepository reservationRepository,
                            UserRepository userRepository){
        this.redisConferenceRoomRepository = redisConferenceRoomRepository;
        this.redisReservationRepository = redisReservationRepository;
        this.redisUserRepository = redisUserRepository;
        this.conferenceRoomRepository = conferenceRoomRepository;
        this.reservationRepository = reservationRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void updateUsers() {
        List<User> userList = userRepository.findAll();
        List<io.hanshin.graphqlapi.model.redis.User> redisUserList = new ArrayList<>();
        userList.forEach(item -> redisUserList.add(io.hanshin.graphqlapi.model.redis.User.of(item)));
        redisUserRepository.saveAll(redisUserList);
    }

    @Override
    public void updateConferenceRooms() {
        List<ConferenceRoom> conferenceRoomList = conferenceRoomRepository.findAll();
        List<io.hanshin.graphqlapi.model.redis.ConferenceRoom> redisConferenceRoomList = new ArrayList<>();
        conferenceRoomList.forEach(item -> redisConferenceRoomList.add(io.hanshin.graphqlapi.model.redis.ConferenceRoom.of(item)));
        redisConferenceRoomRepository.saveAll(redisConferenceRoomList);
    }

    @Override
    public void updateReservations() {
        List<Reservation> reservationList = reservationRepository.findAll();
        List<io.hanshin.graphqlapi.model.redis.Reservation> redisReservationList = new ArrayList<>();
        reservationList.forEach(item -> redisReservationList.add(io.hanshin.graphqlapi.model.redis.Reservation.of(item)));
        redisReservationRepository.saveAll(redisReservationList);
    }

    @Override
    public List<User> getUsers() {

        List<User> userList = new ArrayList<>();
        Iterator<io.hanshin.graphqlapi.model.redis.User> iterator = redisUserRepository.findAll().iterator();
        iterator.forEachRemaining(item -> userList.add( User.of(item)));

        return userList;
    }

    @Override
    public List<ConferenceRoom> getConferenceRooms() {
        List<ConferenceRoom> conferenceRoomList = new ArrayList<>();
        Iterator<io.hanshin.graphqlapi.model.redis.ConferenceRoom> iterator = redisConferenceRoomRepository.findAll().iterator();
        iterator.forEachRemaining(item -> conferenceRoomList.add( ConferenceRoom.of(item)));

        return conferenceRoomList;
    }

    @Override
    public List<Reservation> getReservations() {
        List<Reservation> reservationList = new ArrayList<>();
        Iterator<io.hanshin.graphqlapi.model.redis.Reservation> iterator = redisReservationRepository.findAll().iterator();
        iterator.forEachRemaining(item -> reservationList.add( Reservation.of(item)));

        return reservationList;
    }
}
