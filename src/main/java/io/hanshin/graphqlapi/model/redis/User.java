package io.hanshin.graphqlapi.model.redis;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.redis.core.RedisHash;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@RedisHash("user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column(name="name")
    private String name;

    @Column(name = "team")
    private String team;

    public static User of(io.hanshin.graphqlapi.model.entity.User user){
        User redisUser = new User();
        redisUser.id = user.getId();
        redisUser.name = user.getName();
        redisUser.team = user.getTeam();
        return redisUser;
    }
}
