package com.steve.service;

import com.steve.model.Employee;

public interface AttendanceService {

    boolean clockInAndClockOut(Employee employee);
}
