package io.hanshin.graphqlapi.model.redis;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.redis.core.RedisHash;

import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@RedisHash("ConferenceRoom")
public class ConferenceRoom {
    @Id
    private long id;
    private String name;
    private String size;

    public static ConferenceRoom of(io.hanshin.graphqlapi.model.entity.ConferenceRoom conferenceRoom){
        ConferenceRoom redisConferenceRoom = new ConferenceRoom();
        redisConferenceRoom.id = conferenceRoom.getId();
        redisConferenceRoom.name = conferenceRoom.getName();
        redisConferenceRoom.size = conferenceRoom.getSize();

        return redisConferenceRoom;
    }
}
