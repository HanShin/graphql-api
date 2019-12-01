package io.hanshin.graphqlapi.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "conference_room")
public class ConferenceRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name="name")
    private String name;

    @Column(name = "size")
    private String size;

    public static ConferenceRoom of(io.hanshin.graphqlapi.model.redis.ConferenceRoom conferenceRoom){
        ConferenceRoom entityConferenceRoom = new ConferenceRoom();
        entityConferenceRoom.id = conferenceRoom.getId();
        entityConferenceRoom.name = conferenceRoom.getName();
        entityConferenceRoom.size = conferenceRoom.getSize();
        return entityConferenceRoom;
    }

}
