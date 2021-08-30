package com.dbracamo.task.repository;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.dbracamo.task.entity.*;

public interface StateRepository extends JpaRepository<States, Long> {
    Optional<States> findByName(String name);
    Optional<States> findById(Long id);
}