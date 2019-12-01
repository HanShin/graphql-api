package io.hanshin.graphqlapi.repository;

import io.hanshin.graphqlapi.model.ConferenceRoom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConferenceRoomRepository extends JpaRepository<ConferenceRoom, Long> {
}
