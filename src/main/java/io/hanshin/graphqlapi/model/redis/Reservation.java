package io.hanshin.graphqlapi.model.redis;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.redis.core.RedisHash;

import javax.persistence.Id;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@NoArgsConstructor
@RedisHash("Reservation")
public class Reservation {

    @Id
    private long id;

    private User user;
    private ConferenceRoom conferenceRoom;

    private LocalDateTime startDt;

    public String getStart_dt(){
        return this.startDt.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    private LocalDateTime endDt;

    public String getEnd_dt(){
        return this.endDt.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    public static Reservation of(io.hanshin.graphqlapi.model.entity.Reservation reservation){
        Reservation redisReservation = new Reservation();
        redisReservation.id = reservation.getId();
        redisReservation.user = User.of(reservation.getUser());
        redisReservation.conferenceRoom = ConferenceRoom.of(reservation.getConferenceRoom());
        redisReservation.startDt = reservation.getStartDt();
        redisReservation.endDt = reservation.getStartDt();
        return redisReservation;
    }



}
