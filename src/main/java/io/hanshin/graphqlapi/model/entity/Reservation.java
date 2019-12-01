package io.hanshin.graphqlapi.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Entity
@Table(name = "reservation")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @OneToOne
    @JoinColumn(name="user_id")
    private User user;

    @OneToOne
    @JoinColumn(name = "conference_room_id")
    private ConferenceRoom conferenceRoom;


    @Column(name = "start_dt")
    private LocalDateTime startDt;

    public String getStart_dt(){
        return this.startDt.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    @Column(name = "end_dt")
    private LocalDateTime endDt;

    public String getEnd_dt(){
        return this.endDt.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }


    public static Reservation of(io.hanshin.graphqlapi.model.redis.Reservation reservation){
        Reservation entityReservation = new Reservation();
        entityReservation.id = reservation.getId();
        entityReservation.user =  User.of(reservation.getUser());
        entityReservation.conferenceRoom = ConferenceRoom.of( reservation.getConferenceRoom());
        entityReservation.startDt = reservation.getStartDt();
        entityReservation.endDt = reservation.getEndDt();
        return entityReservation;

    }
}
