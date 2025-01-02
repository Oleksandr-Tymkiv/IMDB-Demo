package com.project.security_module.users.repositories;

import com.project.security_module.users.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Async
    CompletableFuture<Optional<User>> findByEmail(String email);

}
