package com.student.att.repository;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.att.model.Attendance;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {

    Attendance findByStudentIdAndAttendanceDate(
            Long studentId,
            LocalDate attendanceDate
    );
}