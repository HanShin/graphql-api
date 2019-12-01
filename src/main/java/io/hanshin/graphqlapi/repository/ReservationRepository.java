package io.hanshin.graphqlapi.repository;

import io.hanshin.graphqlapi.model.ConferenceRoom;
import io.hanshin.graphqlapi.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    List<Reservation> findByConferenceRoomAndStartDtAfterAndEndDtBefore(ConferenceRoom conferenceRoom,
                                                                        LocalDateTime endDt,
                                                                        LocalDateTime startDt);



    List<Reservation> findByStartDtBetween(LocalDateTime startDt,
                                           LocalDateTime endDt);
}
