package com.service.userservice.controller;

import com.service.userservice.entities.User;
import com.service.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

@RestController
@RequestMapping("/trst/user")
public class UserController {

    @Autowired
    UserService userService;
    //--------------------POST to save user with all detail---------------
    @PostMapping("")
    public ResponseEntity<UUID> saveUser(@RequestBody User user){
        user.setCreatedAt(LocalDateTime.now());
        user.setUpdatedAt(LocalDateTime.now());

        return new ResponseEntity(userService.saveUser(user), HttpStatus.CREATED);
    }


    //------------------GET to get list of user----------------------
    @GetMapping("")
    public ResponseEntity<List<User>> getUsers(){

        return new ResponseEntity(userService.getUsers(), HttpStatus.OK);
    }

    //-----------------GET user by first Name
    @GetMapping("/")
    public ResponseEntity<Optional<List<User>>> getByName(@RequestParam String name){
        return new ResponseEntity(userService.getByName(name),HttpStatus.OK);
    }

    //-----------------GET user by id

    @GetMapping("/{id}")
    public ResponseEntity<User> getById(@PathVariable("id") UUID id){
        return new ResponseEntity(userService.getById(id),HttpStatus.OK);
    }

    //----------------PUT user
    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable("id") UUID id ,@RequestBody User user){

        userService.updateUser(id, user);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    //--------------PATCH user
    @PatchMapping("/{id}/")
    public ResponseEntity<?> patchUser(@PathVariable("id")UUID id , @RequestBody Map<Object, Object> map){
        userService.patchUser(id, map);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
