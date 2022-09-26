package com.service.userservice.serviceTest;

import com.service.userservice.entities.User;
import com.service.userservice.facade.ServiceFacade;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public class UserServiceImplTest implements ServiceFacade {
    @Override
    public UUID saveUser(User user) {
        return null;
    }

    @Override
    public List<User> getUsers() {
        return null;
    }

    @Override
    public List<User> getByName(String name) {
        return null;
    }

    @Override
    public Optional<User> getById(UUID id) {
        return Optional.empty();
    }

    @Override
    public void updateUser(UUID id, User user) {

    }

    @Override
    public void patchUser(UUID id, Map map) {

    }
}
