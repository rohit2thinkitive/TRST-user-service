package com.service.userservice.repository;

import com.service.userservice.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.UUID;

@Repository
public interface UserDao extends JpaRepository<User, UUID> {

//    @Query("Select * from user_table u where u.firstName=:name")
    List<User> findByFirstName(String name);
}
