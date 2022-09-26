package com.service.userservice.facade;

import com.service.userservice.entities.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Component
public interface DaoFacade {
    public UUID save(User user);
    public List<User> findAll();
    public List<User> findByFirstName(String name);
    public Optional<User> findById(UUID id);
}
