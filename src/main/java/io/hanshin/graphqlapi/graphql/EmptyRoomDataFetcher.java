package io.hanshin.graphqlapi.graphql;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import io.hanshin.graphqlapi.mapper.EmptyConferenceRoomMapper;
import io.hanshin.graphqlapi.model.ConferenceRoom;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class EmptyRoomDataFetcher implements DataFetcher<List<ConferenceRoom>> {
    private final EmptyConferenceRoomMapper emptyConferenceRoomMapper;

    public EmptyRoomDataFetcher (EmptyConferenceRoomMapper emptyConferenceRoomMapper){
        this.emptyConferenceRoomMapper = emptyConferenceRoomMapper;
    }


    @Override
    public List<ConferenceRoom> get(DataFetchingEnvironment environment) {
        LocalDateTime startDt = LocalDateTime.parse(environment.getArgument("start_dt"));

        return emptyConferenceRoomMapper.getEmptyConferenceRoom(startDt);
    }
}
