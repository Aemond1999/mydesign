package com.hya.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hya.R;
import com.hya.pojo.Dept;
import com.hya.pojo.Employee;
import com.hya.pojo.User;
import com.hya.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/employee")
@RestController
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/getAll")
    public R getAll() {
        List<Employee> list = employeeService.list();
        return new R(true, list);
    }

    @DeleteMapping("/delete/{id}")
    public R delete(@PathVariable String id) {
        QueryWrapper<Employee> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("emp_id", id);
        return new R(employeeService.remove(queryWrapper));
    }

    @PostMapping("/add")
    public R add(@RequestBody Employee employee) {

        return new R(employeeService.save(employee));
    }

    @GetMapping("/getById/{id}")
    public R getById(@PathVariable String id) {
        QueryWrapper<Employee> queryWrapper = new QueryWrapper<>();
        queryWrapper.select().eq("emp_id", id);
        return new R(true, employeeService.getOne(queryWrapper));
    }
    @GetMapping("/getByDept/{dept}")
    public R getByDept(@PathVariable String dept) {
        QueryWrapper<Employee> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("dept_name", dept);
        return new R(true, employeeService.list(queryWrapper));
    }

    @PutMapping("/update")
    public R update(@RequestBody Employee employee) {
        QueryWrapper<Employee> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("emp_id", employee.getEmpId());
        employee.setEmpId(null);
        return new R(employeeService.update(employee, queryWrapper));
    }


}
