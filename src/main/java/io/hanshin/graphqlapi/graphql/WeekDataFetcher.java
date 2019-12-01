package io.hanshin.graphqlapi.graphql;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import io.hanshin.graphqlapi.model.Reservation;
import io.hanshin.graphqlapi.repository.ReservationRepository;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class WeekDataFetcher implements DataFetcher<List<Reservation>> {

    private final ReservationRepository reservationRepository;

    public WeekDataFetcher(ReservationRepository reservationRepository){
        this.reservationRepository = reservationRepository;
    }


    @Override
    public List<Reservation> get(DataFetchingEnvironment environment) {
        LocalDateTime currentDateTime = LocalDateTime.now();
        int weekValue = currentDateTime.getDayOfWeek().getValue();

        LocalDateTime startDt = currentDateTime
                .minusDays(weekValue - 1);
        LocalDateTime endDt = currentDateTime
                .plusDays(7 - weekValue);
        return reservationRepository.findByStartDtAfterAndEndDtBefore(endDt,startDt);
    }
}
