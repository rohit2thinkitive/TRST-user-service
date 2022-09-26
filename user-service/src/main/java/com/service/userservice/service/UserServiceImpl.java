package com.service.userservice.service;

import com.service.userservice.entities.User;
import com.service.userservice.facade.DaoFacade;
import com.service.userservice.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;
import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserDao userDao;
    @Autowired
    DaoFacade daoFacade;

    public UUID saveUser(User user){
        return daoFacade.save(user);
    }

    public List<User> getUsers() {
        return daoFacade.findAll();
    }

    public List<User> getByName(String name) {
        return daoFacade.findByFirstName(name);
    }

    public Optional<User> getById(UUID id) {
        return daoFacade.findById(id);
    }

    public void updateUser(UUID id, User user) {
        Optional<User> u = daoFacade.findById(id);
        user.setUserId(u.get().getUserId());
        user.setCreatedAt(u.get().getCreatedAt());
        user.setUpdatedAt(LocalDateTime.now());
        daoFacade.save(user);
    }
    //------service for PATCH implementation-----------
    public void patchUser(UUID id, Map map) {
        User u = daoFacade.findById(id).get();
        if(u!=null){
           map.forEach((Key , value)->{
              Field field= ReflectionUtils.findField( User.class, (String) Key);
              field.setAccessible(true);
              ReflectionUtils.setField(field ,u, value);
           });
           daoFacade.save(u);
       }
    }
}
