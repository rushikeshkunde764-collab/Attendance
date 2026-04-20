package com.attendanceTracker.repository;
import java.time.LocalDate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.attendanceTracker.model.Attendance;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {

    boolean existsByStudentIdAndDate(Long studentId, LocalDate date);

    Page<Attendance> findByMonth(String month, Pageable pageable);

    Page<Attendance> findByWeekNumber(int weekNumber, Pageable pageable);
    Page<Attendance> findByDate(LocalDate date, Pageable pageable);
}