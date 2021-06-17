package com.example.employees.entities

import org.springframework.http.HttpStatus

class EmployeeNotFoundException(status: HttpStatus, message: String): Exception(message) {

}
