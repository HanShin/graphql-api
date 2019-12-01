package io.hanshin.graphqlapi.model;

import io.hanshin.graphqlapi.model.enums.ConferenceRoomSize;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "conference_room")
public class ConferenceRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name="name")
    private String name;

    @Column(name = "size")
    private ConferenceRoomSize size;
}
