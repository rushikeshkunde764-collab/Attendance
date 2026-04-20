package com.attendanceTracker.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.attendanceTracker.model.Attendance;
import com.attendanceTracker.model.Student;
import com.attendanceTracker.model.Teacher;
import com.attendanceTracker.model.Subject;

import com.attendanceTracker.repository.AttendanceRepository;
import com.attendanceTracker.repository.StudentRepository;
import com.attendanceTracker.repository.TeacherRepository;
import com.attendanceTracker.repository.SubjectRepository;

@Service
public class AttendanceService {

    @Autowired private AttendanceRepository repo;
    @Autowired private StudentRepository studentRepo;
    @Autowired private TeacherRepository teacherRepo;
    @Autowired private SubjectRepository subjectRepo;

    // ✅ MARK ATTENDANCE
    public Attendance mark(Long studentId,
                           Long teacherId,
                           Long subjectId,
                           String status) {

        Student student = studentRepo.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        Teacher teacher = teacherRepo.findById(teacherId)
                .orElseThrow(() -> new RuntimeException("Teacher not found"));

        Subject subject = subjectRepo.findById(subjectId)
                .orElseThrow(() -> new RuntimeException("Subject not found"));

        LocalDate date = LocalDate.now();

        // prevent duplicate
        boolean exists = repo.existsByStudentIdAndDate(studentId, date);
        if (exists) {
            throw new RuntimeException("Attendance already marked for today");
        }

        Attendance a = new Attendance();
        a.setStudent(student);
        a.setTeacher(teacher);
        a.setSubject(subject);
        a.setDate(date);

        String month = date.getMonth().name().substring(0, 3);
        a.setMonth(month);

        int week = date.get(java.time.temporal.WeekFields.ISO.weekOfWeekBasedYear());
        a.setWeekNumber(week);

        a.setStatus(status);

        return repo.save(a);
    }

    // ✅ GET ALL (FOR DASHBOARD)
    public List<Attendance> getAll() {
        return repo.findAll();
    }

    // ✅ MONTH FILTER
    public Page<Attendance> getByMonth(String month, int page, int size) {
        return repo.findByMonth(month, PageRequest.of(page, size));
    }

    // ✅ WEEK FILTER
    public Page<Attendance> getByWeek(int week, int page, int size) {
        return repo.findByWeekNumber(week, PageRequest.of(page, size));
    }
    public Page<Attendance> getByDate(LocalDate date, int page, int size) {
        return repo.findByDate(date, PageRequest.of(page, size));
    }
}