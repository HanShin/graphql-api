package io.hanshin.graphqlapi.graphql;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import io.hanshin.graphqlapi.model.entity.ConferenceRoom;
import io.hanshin.graphqlapi.model.entity.Reservation;
import io.hanshin.graphqlapi.model.entity.User;
import io.hanshin.graphqlapi.repository.ConferenceRoomRepository;
import io.hanshin.graphqlapi.repository.ReservationRepository;
import io.hanshin.graphqlapi.repository.UserRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class ReservationDataFetcher implements DataFetcher<Reservation> {

    private final ReservationRepository reservationRepository;
    private final ConferenceRoomRepository conferenceRoomRepository;
    private final UserRepository userRepository;

    public ReservationDataFetcher(ReservationRepository reservationRepository,
                                  ConferenceRoomRepository conferenceRoomRepository,
                                  UserRepository userRepository){
        this.reservationRepository = reservationRepository;
        this.conferenceRoomRepository = conferenceRoomRepository;
        this.userRepository = userRepository;
    }


    @Override
    public Reservation get(DataFetchingEnvironment environment) {
        ConferenceRoom conferenceRoom = conferenceRoomRepository.getOne(((Integer)(environment.getArgument("ConferenceRoom"))).longValue());
        LocalDateTime startDt = LocalDateTime.parse(environment.getArgument("start_dt"));
        LocalDateTime endDt = LocalDateTime.parse(environment.getArgument("end_dt"));
        List<Reservation> reservationList = reservationRepository.findByConferenceRoomAndStartDtAfterAndEndDtBefore(
                conferenceRoom,
                endDt,
                startDt
        );

        if(reservationList.size() > 0){
            return null;
        }

        User user = userRepository.getOne(((Integer)environment.getArgument("User")).longValue());
        Reservation reservation = Reservation.builder().user(user)
                .conferenceRoom(conferenceRoom)
                .startDt(startDt)
                .endDt(endDt)
                .build();

        return reservationRepository.save(reservation);


    }
}
