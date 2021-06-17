package com.example.employees.entities

import org.springframework.data.jpa.repository.JpaRepository

interface JobDescriptionRepository: JpaRepository<JobDescription, Long> {
}