package com.example.employees.services

import com.example.employees.entities.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service

@Service
class EmployeeService(private val employeeRepository: EmployeeRepository) {

    @Autowired
    lateinit var jobDescriptionRepository: JobDescriptionRepository

    fun getAllEmployees(): List<Employee> = employeeRepository.findAll()

    fun getEmployeesById(employeeId: Long): Employee = employeeRepository.findById(employeeId)
            .orElseThrow { EmployeeNotFoundException(HttpStatus.NOT_FOUND, "No matching employee was found") }
    fun createEmployee(payload: EmployeePayload): Employee{
        return employeeRepository.save(Employee(
                id = 0,
                jobDescription = jobDescriptionRepository.findById(payload.jobDescriptionId)
                        .orElseThrow { JobDescriptionNotFoundException(HttpStatus.NOT_FOUND, "No matching jobDescription was found") },
                userName = payload.userName,
                firstName = payload.firstName,
                middleName = payload.middleName,
                lastName = payload.lastName,
                emailId = payload.emailId,
                dayOfBirth = payload.dayOfBirth
        ))
    }

    fun updateEmployeeById(employeeId: Long, payload: EmployeePayload): Employee {
        return if (employeeRepository.existsById(employeeId)) {
            employeeRepository.save(
                    Employee(
                            id = employeeId,
                            jobDescription = jobDescriptionRepository.findById(payload.jobDescriptionId)
                                    .orElseThrow { JobDescriptionNotFoundException(HttpStatus.NOT_FOUND, "No matching jobDescription was found") },
                            userName = payload.userName,
                            firstName = payload.firstName,
                            middleName = payload.middleName,
                            lastName = payload.lastName,
                            emailId = payload.emailId,
                            dayOfBirth = payload.dayOfBirth
                    )
            )
        } else throw EmployeeNotFoundException(HttpStatus.NOT_FOUND, "No matching employee was found")
    }

    fun deleteEmployeesById(employeeId: Long) {
        return if (employeeRepository.existsById(employeeId)) {
            employeeRepository.deleteById(employeeId)
        } else throw EmployeeNotFoundException(HttpStatus.NOT_FOUND, "No matching employee was found")
    }
}