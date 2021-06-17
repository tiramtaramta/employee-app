package com.example.hr.entities

import org.springframework.data.jpa.repository.JpaRepository

interface JobDescriptionRepository: JpaRepository<JobDescription, Long> {
}