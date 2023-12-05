package com.dudadakung.returnbottle.repository;

import com.dudadakung.returnbottle.domain.ReturnPlace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReturnPlaceRepository extends JpaRepository<ReturnPlace, Long> {
}
