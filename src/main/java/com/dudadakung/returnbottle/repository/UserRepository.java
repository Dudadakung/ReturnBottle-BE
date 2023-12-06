package com.dudadakung.returnbottle.repository;

import com.dudadakung.returnbottle.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // email과 password로 유저를 찾는다.
    Optional<User> findByEmailAndPassword(String email, String password);

    Optional<User> findByUniqueId(String uniqueId);

}
