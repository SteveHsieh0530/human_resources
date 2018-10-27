package com.steve.dao;

import com.steve.model.Attendance;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public interface AttendanceDao {

    Attendance getAttendanceByDayAndEmp(HashMap<String, Object> search);

    void saveAttendance(Attendance newAtt);

    void updateAttendance(Attendance attendance);
}
