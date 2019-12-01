package io.hanshin.graphqlapi.mapper;

import io.hanshin.graphqlapi.model.entity.ConferenceRoom;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by Shin Han
 * Since 2019-05-16
 */
@Repository
@Mapper
public interface EmptyConferenceRoomMapper {

    @Select(
            "SELECT id AS id," +
            "name AS name," +
            "size AS size\n" +
            "FROM conference_room\n" +
            "WHERE id not in(\n" +
            "    SELECT conference_room_id\n" +
            "    FROM reservation\n" +
            "    WHERE #{start_dt} BETWEEN reservation.start_dt AND reservation.end_dt);\n "
    )
    List<ConferenceRoom> getEmptyConferenceRoom(@Param("start_dt")LocalDateTime startDt);

}
