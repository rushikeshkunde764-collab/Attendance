package com.attendanceTracker.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.attendanceTracker.model.Attendance;
import com.attendanceTracker.service.AttendanceService;

@RestController
@RequestMapping("/attendance")
public class AttendanceController {

    @Autowired 
    private AttendanceService service;

    // ✅ MARK ATTENDANCE (FIXED)
    @PostMapping("/mark")
    public ResponseEntity<?> mark(@RequestParam Long studentId,
                                 @RequestParam Long teacherId,
                                 @RequestParam Long subjectId,
                                 @RequestParam String status) {

        try {
            Attendance attendance = service.mark(studentId, teacherId, subjectId, status);

            return ResponseEntity.ok(attendance);

        } catch (RuntimeException e) {

            return ResponseEntity
                    .status(HttpStatus.CONFLICT)
                    .body(e.getMessage());
        }
    }

    // ✅ MONTH DATA
    @GetMapping("/month")
    public ResponseEntity<Page<Attendance>> month(@RequestParam String month,
                                                 @RequestParam int page,
                                                 @RequestParam int size) {

        Page<Attendance> result = service.getByMonth(month, page, size);
        return ResponseEntity.ok(result);
    }

    // ✅ WEEK DATA
    @GetMapping("/week")
    public ResponseEntity<Page<Attendance>> week(@RequestParam int week,
                                                @RequestParam int page,
                                                @RequestParam int size) {

        Page<Attendance> result = service.getByWeek(week, page, size);
        return ResponseEntity.ok(result);
    }
    @GetMapping("/day")
    public ResponseEntity<Page<Attendance>> day(@RequestParam String date,
                                                @RequestParam int page,
                                                @RequestParam int size) {

        LocalDate localDate = LocalDate.parse(date);

        Page<Attendance> result = service.getByDate(localDate, page, size);

        return ResponseEntity.ok(result);
    }
}