package io.hanshin.graphqlapi.schedule;

import io.hanshin.graphqlapi.redis.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class GraphQLScheduler {

    private final RedisService redisService;

    public GraphQLScheduler(RedisService redisService){
        this.redisService = redisService;
    }


    @Scheduled(cron = "${cron.exp.redis.user}")
    public void updateUsers() throws Exception {
        redisService.updateUsers();
    }

    @Scheduled(cron = "${cron.exp.redis.conference-room}")
    public void updateConferenceRooms() throws Exception {
        redisService.updateConferenceRooms();
    }

    @Scheduled(cron = "${cron.exp.redis.reservation}")
    public void updateReservations() throws Exception {
        redisService.updateReservations();
    }

}
