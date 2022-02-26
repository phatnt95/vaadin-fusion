package com.example.application.repository;

import com.example.application.entity.Lead;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeadsRepository extends JpaRepository<Lead, Long> {
}
