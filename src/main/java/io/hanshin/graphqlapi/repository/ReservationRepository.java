package io.hanshin.graphqlapi.repository;

import io.hanshin.graphqlapi.model.entity.ConferenceRoom;
import io.hanshin.graphqlapi.model.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    List<Reservation> findByConferenceRoomAndStartDtGreaterThanEqualAndEndDtLessThanEqual(ConferenceRoom conferenceRoom,
                                                                        LocalDateTime startDt,
                                                                        LocalDateTime endDt);



    List<Reservation> findByStartDtBetween(LocalDateTime startDt,
                                           LocalDateTime endDt);
}
