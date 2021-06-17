package com.example.hr.entities

import org.springframework.http.HttpStatus

class EmployeeNotFoundException(status: HttpStatus, message: String): Exception(message) {

}
