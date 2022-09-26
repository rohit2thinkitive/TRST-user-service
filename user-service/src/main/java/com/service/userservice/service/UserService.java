package com.service.userservice.service;

import com.service.userservice.entities.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
@Service
public interface UserService {
    UUID saveUser(User user);
    List<User> getUsers();
    List<User> getByName(String name);
    Optional<User> getById(UUID id);
    void updateUser(UUID id, User user);
    void patchUser(UUID id, Map map);
}
