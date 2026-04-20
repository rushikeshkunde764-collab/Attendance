package com.attendanceTracker.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import com.attendanceTracker.service.AttendanceService;
import com.attendanceTracker.repository.StudentRepository;
import com.attendanceTracker.repository.TeacherRepository;
import com.attendanceTracker.repository.SubjectRepository;

@Controller
public class DashboardController {

    private final AttendanceService attendanceService;
    private final StudentRepository studentRepo;
    private final TeacherRepository teacherRepo;
    private final SubjectRepository subjectRepo;

    public DashboardController(AttendanceService attendanceService,
                               StudentRepository studentRepo,
                               TeacherRepository teacherRepo,
                               SubjectRepository subjectRepo) {
        this.attendanceService = attendanceService;
        this.studentRepo = studentRepo;
        this.teacherRepo = teacherRepo;
        this.subjectRepo = subjectRepo;
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model) {

        model.addAttribute("students", studentRepo.findAll());
        model.addAttribute("teachers", teacherRepo.findAll());
        model.addAttribute("subjects", subjectRepo.findAll());
        model.addAttribute("list", attendanceService.getAll());

        return "attendance"; // your HTML file
    }
}