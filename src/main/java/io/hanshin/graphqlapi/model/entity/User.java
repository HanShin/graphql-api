package io.hanshin.graphqlapi.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name="name")
    private String name;

    @Column(name = "team")
    private String team;

    public static User of(io.hanshin.graphqlapi.model.redis.User user){
        User entityUser = new User();
        entityUser.id = user.getId();
        entityUser.name = user.getName();
        entityUser.team = user.getTeam();
        return entityUser;
    }
}
