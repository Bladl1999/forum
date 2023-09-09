package com.forum.repository;

import com.forum.model.entity.Role;
import com.forum.model.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface RoleRepository extends JpaRepository<Role, UUID> {
    List<Users> findUsersByRole(String role);
}
