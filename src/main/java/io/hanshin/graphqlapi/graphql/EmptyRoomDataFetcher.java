package io.hanshin.graphqlapi.graphql;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import io.hanshin.graphqlapi.model.ConferenceRoom;
import io.hanshin.graphqlapi.repository.ConferenceRoomRepository;
import io.hanshin.graphqlapi.repository.ReservationRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmptyRoomDataFetcher implements DataFetcher<List<ConferenceRoom>> {
    private final ReservationRepository reservationRepository;
    private final ConferenceRoomRepository conferenceRoomRepository;


    public EmptyRoomDataFetcher (ReservationRepository reservationRepository,
            ConferenceRoomRepository conferenceRoomRepository){
        this.reservationRepository = reservationRepository;
        this.conferenceRoomRepository = conferenceRoomRepository;
    }


    @Override
    public List<ConferenceRoom> get(DataFetchingEnvironment environment) {
        return null;
    }
}
