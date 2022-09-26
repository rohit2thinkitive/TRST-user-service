package com.service.userservice.facade;

import com.service.userservice.entities.User;
import com.service.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
@Component
public class ServiceFacadeImpl implements ServiceFacade{
    @Autowired
    UserService userService;

    public UUID saveUser(User user){
        return userService.saveUser(user);
    }


    public List<User> getUsers(){
        return userService.getUsers();
    }

    public List<User> getByName(String name){
        return userService.getByName(name);
    }

    public Optional<User> getById(UUID id){
        return userService.getById(id);
    }

    public void updateUser(UUID id, User user){
         userService.updateUser(id,user);
    }
    public void patchUser(UUID id, Map map){
        userService.patchUser(id,map);
    }
}
