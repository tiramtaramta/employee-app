package com.example.employees.ws

import com.example.employees.entities.Employee
import com.example.employees.entities.EmployeePayload
import com.example.employees.services.EmployeeService
import org.springframework.stereotype.Service
import springfox.documentation.swagger2.mappers.ModelMapperImpl
import javax.jws.WebMethod
import javax.jws.WebResult
import javax.jws.WebService
import javax.xml.bind.annotation.XmlElementWrapper

@WebService(targetNamespace = "http://employee.com/services/employees")
@Service
class EmployeesEndpoint(var employeeService: EmployeeService, var modelMapper: ModelMapperImpl) {
    @WebMethod
    @XmlElementWrapper(name = "employees")
    @WebResult(name = "employee")
    fun listEmployees(): List<EmployeePayload> {
        return employeeService.getAllEmployees().map { toDto(it) }
    }

    fun toDto(employee: Employee): EmployeePayload {
        return EmployeePayload(
            employee.userName,
            employee.jobDescription.id!!,
            employee.firstName,
            employee.lastName,
            employee.middleName!!,
            employee.emailId,
            employee.dayOfBirth
        )
    }
}