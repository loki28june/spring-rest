package com.loki.greeting;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greet")
public class EmployeeController {
	private final AtomicLong id = new AtomicLong();
	private String template = "Hello %s %s";

	@RequestMapping(value = "/hello/{name}", method = RequestMethod.GET)
	public Greeting hello(@PathVariable String name,
			@RequestParam(name = "surname", defaultValue = "Bangar") String lastName) {
		return new Greeting(id.incrementAndGet(), String.format(template, name, lastName));
	}

	@RequestMapping(value = "/employees", produces="application/xml")
	public EmployeeListVO getAllEmployees() {
		EmployeeListVO employee = new EmployeeListVO();

		EmployeeVO empOne = new EmployeeVO(1, "Lokesh", "Gupta", "howtodoinjava@gmail.com");
		EmployeeVO empTwo = new EmployeeVO(2, "Amit", "Singhal", "asinghal@yahoo.com");
		EmployeeVO empThree = new EmployeeVO(3, "Kirti", "Mishra", "kmishra@gmail.com");

		employee.getEmployee().add(empOne);
		employee.getEmployee().add(empTwo);
		employee.getEmployee().add(empThree);

		return employee;
	}

	@RequestMapping(value = "/employees/{id}")
	public ResponseEntity<EmployeeVO> getEmployeeById(@PathVariable("id") int employeeID) {
		if (employeeID <= 3) {
			EmployeeVO employee = new EmployeeVO(1, "Lokesh", "Gupta", "howtodoinjava@gmail.com");
			return new ResponseEntity<EmployeeVO>(employee, HttpStatus.OK);
		}
		return new ResponseEntity<EmployeeVO>(HttpStatus.NOT_FOUND);
	}

}
