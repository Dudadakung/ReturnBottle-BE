package com.dudadakung.returnbottle.repository;

import com.dudadakung.returnbottle.domain.UserItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserItemRepository extends JpaRepository<UserItem, Long> {

    Optional<List<UserItem>> findAllByUserId(Long id);
}
