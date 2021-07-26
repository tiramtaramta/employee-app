package com.example.employees.services

import com.example.employees.entities.JobDescriptionNotFoundException
import com.example.employees.entities.JobDescriptionRepository
import com.example.employees.entities.JobDescription
import com.example.employees.entities.JobDescriptionPayload
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.ExceptionHandler
import javax.persistence.EntityNotFoundException

@Service
class JobDescriptionService(private val jobDescriptionRepository: JobDescriptionRepository) {
    fun getAllJobDescriptions(): List<JobDescription> = jobDescriptionRepository.findAll()

    fun getJobDescriptionById(jobDescriptionId: Long): JobDescription = jobDescriptionRepository.findById(jobDescriptionId)
            .orElseThrow { JobDescriptionNotFoundException(HttpStatus.NOT_FOUND, "No matching jobDescription was found") }
    fun createJobDescription(payload: JobDescriptionPayload): JobDescription {
        return jobDescriptionRepository.save(
                JobDescription(
                        id = 0,
                        title = payload.title,
                        description = payload.description,
                        addedAt = payload.addedAt
                )
        )
    }
    fun updateJobDescriptionById(jobDescriptionId: Long, payload: JobDescriptionPayload): JobDescription {
        return if (jobDescriptionRepository.existsById(jobDescriptionId)) {
            jobDescriptionRepository.save(
                    JobDescription(
                            id = jobDescriptionId,
                            title = payload.title,
                            description = payload.description,
                            addedAt = payload.addedAt
                    )
            )
        } else throw JobDescriptionNotFoundException(HttpStatus.NOT_FOUND, "No matching jobDescription was found")
    }

    fun deleteJobDescriptionById(jobDescriptionId: Long) {
        return if (jobDescriptionRepository.existsById(jobDescriptionId)) {
            jobDescriptionRepository.deleteById(jobDescriptionId)
        } else throw JobDescriptionNotFoundException(HttpStatus.NOT_FOUND, "No matching jobDescription was found")
    }
}