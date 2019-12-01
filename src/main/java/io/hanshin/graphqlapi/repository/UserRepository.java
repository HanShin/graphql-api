package io.hanshin.graphqlapi.repository;

import io.hanshin.graphqlapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
