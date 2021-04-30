package com.loki.greeting;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
 
@XmlRootElement (name="Employees")
public class EmployeeListVO implements Serializable
{
    private static final long serialVersionUID = 1L;
     
    private List<EmployeeVO> employee = new ArrayList<EmployeeVO>();

	public List<EmployeeVO> getEmployee() {
		return employee;
	}

	public void setEmployee(List<EmployeeVO> employee) {
		this.employee = employee;
	}
 
   
}
