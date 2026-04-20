//package com.attendanceTracker.controller;
//
//
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//
//import com.attendanceTracker.service.AttendanceService;
//
//@Controller
//public class ViewController {
//
//    private final AttendanceService service;
//
//    public ViewController(AttendanceService service) {
//        this.service = service;
//    }
//
//    @GetMapping("/view")
//    public String view(Model model) {
//        model.addAttribute("list", service.getAll());
//        return "attendance";
//    }
//}