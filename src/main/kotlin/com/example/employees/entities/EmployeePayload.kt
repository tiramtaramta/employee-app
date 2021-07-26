package com.example.employees.entities

import java.time.LocalDate

data class EmployeePayload(
    val userName: String,
    val jobDescriptionId: Long,
    val firstName: String,
    val lastName: String,
    val middleName: String,
    val emailId: String,
    val dayOfBirth: LocalDate
)