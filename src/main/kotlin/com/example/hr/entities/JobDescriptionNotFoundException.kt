package com.example.hr.entities

import org.springframework.http.HttpStatus

class JobDescriptionNotFoundException(status: HttpStatus, message: String): Exception(message) {

}
