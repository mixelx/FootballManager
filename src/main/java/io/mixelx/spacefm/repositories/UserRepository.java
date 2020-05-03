package io.mixelx.spacefm.repositories;

import io.mixelx.spacefm.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

}
