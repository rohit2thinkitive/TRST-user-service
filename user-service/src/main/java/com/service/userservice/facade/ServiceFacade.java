package com.service.userservice.facade;

import com.service.userservice.entities.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Component
public interface ServiceFacade {
    public UUID saveUser(User user);

    List<User> getUsers();
    public List<User> getByName(String name);
    public Optional<User> getById(UUID id);
    public void updateUser(UUID id, User user);
    public void patchUser(UUID id, Map map);
}
