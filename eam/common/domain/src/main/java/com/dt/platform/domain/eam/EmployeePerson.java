package com.dt.platform.domain.eam;

import org.github.foxnic.web.domain.hrm.Person;

public class EmployeePerson extends Person {

    private String employeeId;

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }


}
