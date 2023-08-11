package com.forum.repository;

import com.forum.model.entity.Thread;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ThreadRepository extends JpaRepository<Thread, UUID> {

}
