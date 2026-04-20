package com.attendanceTracker.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.attendanceTracker.model.Subject;




public interface SubjectRepository extends JpaRepository<Subject, Long> {
}