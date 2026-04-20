//package com.attendanceTracker.controller;
//
//import java.util.List;
//
//
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.attendanceTracker.model.Student;
//import com.attendanceTracker.service.StudentService;
//
//
//@RestController
//@RequestMapping("/students")
//public class StudentController {
//
//    private final StudentService service;
//
//    public StudentController(StudentService service) {
//        this.service = service;
//    }
//
//    @PostMapping("/add")
//    public Student add(@RequestBody Student s) {
//        return service.addStudent(s);
//    }
//
//    @GetMapping("/all")
//    public List<Student> all() {
//        return service.getAll();
//    }
//}