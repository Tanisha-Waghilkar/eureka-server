package com.student.student.repository;

import com.student.student.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, Long> {

    boolean existsByEmail(String email);

    boolean existsByPhone(String phone);
}