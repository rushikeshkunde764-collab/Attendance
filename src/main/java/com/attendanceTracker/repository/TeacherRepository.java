package com.attendanceTracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.attendanceTracker.model.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}