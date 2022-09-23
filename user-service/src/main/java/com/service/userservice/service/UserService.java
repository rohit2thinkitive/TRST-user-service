package com.service.userservice.service;

import com.service.userservice.entities.User;
import com.service.userservice.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {
    @Autowired
    UserDao userDao;

    public UUID saveUser(User user){
        return userDao.save(user).getUserId();
    }

    public List<User> getUsers() {
        return userDao.findAll();
    }

    public List<User> getByName(String name) {
        return userDao.findByFirstName(name);
    }

    public Optional<User> getById(UUID id) {
        return userDao.findById(id);
    }


    public void updateUser(UUID id, User user) {

        Optional<User> u = userDao.findById(id);
        user.setUserId(u.get().getUserId());  //to transfer id
        user.setCreatedAt(u.get().getCreatedAt());  //to transfer creation date
        user.setUpdatedAt(LocalDateTime.now());     // to update date of updation
        userDao.save(user);
    }

    //------very important implementation-----------
    public void patchUser(UUID id, Map map) {

         User u = userDao.findById(id).get();

        // for map all the field send from frontend
        // this uses reflection.util class which maps all the available field provided by request parameter
        // and map to relevent field
        // throws 500 error when the key received is not matching any of the fields of class

        if(u!=null){
           map.forEach((Key , value)->{
              Field field= ReflectionUtils.findField( User.class, (String) Key);
              field.setAccessible(true);
              ReflectionUtils.setField(field ,u, value);


           });
           userDao.save(u);
       }
    }
}
