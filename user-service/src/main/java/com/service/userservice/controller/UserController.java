package com.service.userservice.controller;

import com.service.userservice.entities.User;
import com.service.userservice.exception.UserNameAlreadyExistException;
import com.service.userservice.repository.UserDao;
import com.service.userservice.service.UserServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

@RestController
@RequestMapping("/trst/user")
public class UserController extends AbstractController {

    @Autowired
    UserServiceImpl userServiceImpl;
    @Autowired
    UserDao userDao;
    //--------------------POST to save user with all detail---------------
    @PostMapping("")
    @ResponseStatus(value = HttpStatus.CREATED)
    @Operation(summary = "to save user details for the first time ")
    @ApiResponse(responseCode = "201", description = "user saved successfully!")
    @ApiResponse(responseCode = "500", description = "error occured because of username already exist")
    public ResponseEntity<UUID> saveUser(@RequestBody User user){

        if (userDao.findByUserName(user.getUserName())!=null){throw new UserNameAlreadyExistException();
        }
        user.setCreatedAt(LocalDateTime.now(ZoneId.of("UTC")));
        user.setUpdatedAt(LocalDateTime.now(ZoneId.of("UTC")));
        return new ResponseEntity(serviceFacade.saveUser(user), HttpStatus.CREATED);
    }
    //------------------GET to get list of user----------------------
    @GetMapping("")
    @ResponseStatus(value = HttpStatus.OK)
    @Operation(summary = "get all users ")
    public ResponseEntity<List<User>> getUsers(){
        return new ResponseEntity(serviceFacade.getUsers(), HttpStatus.OK);
    }
    //-----------------GET user by first Name
    @GetMapping("/")
    @ResponseStatus(value = HttpStatus.OK)
    @Operation(summary = "get user by its first name ")
    public ResponseEntity<Optional<List<User>>> getByName(@RequestParam String name){
        return new ResponseEntity(serviceFacade.getByName(name),HttpStatus.OK);
    }
    //-----------------GET user by id
    @GetMapping("/{id}")
    @ResponseStatus(value = HttpStatus.OK)
    @Operation(summary = "get user by its id (UUID) in string")
    public ResponseEntity<User> getById(@PathVariable("id") UUID id){
        return new ResponseEntity(serviceFacade.getById(id),HttpStatus.OK);
    }
    //----------------PUT user
    @PutMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @Operation(summary = "update whole field of user by id")
    public ResponseEntity<?> updateUser(@PathVariable("id") UUID id ,@RequestBody User user){
        serviceFacade.updateUser(id, user);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
    //--------------PATCH user
    @PatchMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    @Operation(summary = "patch user details by id(UUID)")
    public ResponseEntity<?> patchUser(@PathVariable("id")UUID id , @RequestBody Map<Object, Object> map){
        serviceFacade.patchUser(id, map);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
    //--------------DELETE user by id
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "delete user by id (UUID)")
    public ResponseEntity<String> deleteUser(@PathVariable UUID id){
        userDao.deleteById(id);
        return new ResponseEntity("User Deleted",HttpStatus.OK);
    }
}
