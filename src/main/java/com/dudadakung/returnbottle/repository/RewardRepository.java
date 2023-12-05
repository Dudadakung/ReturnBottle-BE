package com.dudadakung.returnbottle.repository;

import com.dudadakung.returnbottle.domain.Reward;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RewardRepository extends JpaRepository<Reward, Long> {
}
