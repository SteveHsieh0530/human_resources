package com.steve.service;

import com.steve.model.Attendance;
import com.steve.model.Employee;

import java.util.HashMap;
import java.util.List;

public interface AttendanceService {

    boolean clockInAndClockOut(Employee employee);

}
