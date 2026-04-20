package com.attendanceTracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.attendanceTracker.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}