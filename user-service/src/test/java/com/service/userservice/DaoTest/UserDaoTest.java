package com.service.userservice.DaoTest;

import com.service.userservice.entities.User;
import com.service.userservice.facade.DaoFacade;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class UserDaoTest implements DaoFacade {
    @Override
    public UUID save(User user) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public List<User> findByFirstName(String name) {
        return null;
    }

    @Override
    public Optional<User> findById(UUID id) {
        return Optional.empty();
    }
}
