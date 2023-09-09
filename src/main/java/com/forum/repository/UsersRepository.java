package com.forum.repository;

import com.forum.model.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UsersRepository extends JpaRepository<Users, UUID> {
    @Modifying
    @Query("UPDATE Users u SET u.name = :name, u.surname = :surname, u.role = :role," +
            " u.email = :email, u.password = :password WHERE u.id = :id")
    void updateUser(@Param("id") Long id, @Param("name") String name, @Param("surname") String surname,
                    @Param("role") String role, @Param("email") String email, @Param("password") String password);
}
