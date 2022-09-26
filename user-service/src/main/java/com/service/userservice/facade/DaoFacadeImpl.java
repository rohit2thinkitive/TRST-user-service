package com.service.userservice.facade;

import com.service.userservice.entities.User;
import com.service.userservice.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Component
public class DaoFacadeImpl implements DaoFacade{
    @Autowired
    UserDao userDao;

    @Override
    public UUID save(User user) {
        return userDao.save(user).getUserId();
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public List<User> findByFirstName(String name) {
        return userDao.findByFirstName(name);
    }

    @Override
    public Optional<User> findById(UUID id) {
        return userDao.findById(id);
    }
}
