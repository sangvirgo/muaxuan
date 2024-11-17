package com.sang.rest;

import com.sang.entity.Employee;
import com.sang.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {
    private EmployeeService employee;

    @Autowired
    public EmployeeRestController(EmployeeService theEm) {
        this.employee=theEm;
    }

    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employee.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployee(@PathVariable int employeeId) {
        Employee temp=employee.findById(employeeId);

        if (temp==null) {
            throw new RuntimeException("Employee id not found - "+ employeeId);
        }
        return temp;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee temp) {
//        Đặt ID của temp là 0 để đảm bảo rằng JPA sẽ xem đây là một đối tượng mới và thực hiện thêm nó vào cơ sở dữ liệu thay vì cập nhật một bản ghi hiện có.
        temp.setId(0);
        Employee emp= employee.save(temp);
        return emp;
    }
}
