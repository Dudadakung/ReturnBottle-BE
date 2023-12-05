package com.dudadakung.returnbottle.service;

import com.dudadakung.returnbottle.domain.User;
import com.dudadakung.returnbottle.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {
    final private UserRepository userRepository;

    public void setUser(User user) {
        userRepository.save(user);
    }

    public User getUser(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("해당 유저가 없습니다. id=" + id));
    }
}
