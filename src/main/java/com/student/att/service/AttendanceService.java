package com.student.att.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.att.model.Attendance;
import com.student.att.repository.AttendanceRepository;

@Service
public class AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository;

    public Attendance createAttendance(Attendance attendance) {

        Attendance existing = attendanceRepository
                .findByStudentIdAndAttendanceDate(
                        attendance.getStudentId(),
                        attendance.getAttendanceDate()
                );

        if (existing != null) {
            existing.setStatus(attendance.getStatus());
            return attendanceRepository.save(existing);
        }

        return attendanceRepository.save(attendance);
    }

    public List<Attendance> getAllAttendance() {
        return attendanceRepository.findAll();
    }
}