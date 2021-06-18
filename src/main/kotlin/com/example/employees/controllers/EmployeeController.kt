package com.example.employees.controllers

import com.example.employees.entities.Employee
import com.example.employees.entities.EmployeePayload
import com.example.employees.services.EmployeeService
import org.springframework.web.bind.annotation.*

@RestController
class EmployeeController(private val employeeService: EmployeeService) {

    @GetMapping("/employees")
    fun getAllEmployees(): List<Employee> = employeeService.getAllEmployees()

    @GetMapping("/employees/{id}")
    fun getEmployeesById(@PathVariable("id") employeeId: Long): Employee =
            employeeService.getEmployeesById(employeeId)

    @PostMapping("/employees")
    fun createEmployee(@RequestBody payload: EmployeePayload): Employee = employeeService.createEmployee(payload)

    @PutMapping("/employees/{id}")
    fun updateEmployeeById(@PathVariable("id") employeeId: Long, @RequestBody payload: EmployeePayload): Employee =
            employeeService.updateEmployeeById(employeeId, payload)

    @DeleteMapping("/employees/{id}")
    fun deleteEmployeesById(@PathVariable("id") employeeId: Long): Unit =
            employeeService.deleteEmployeesById(employeeId)
}