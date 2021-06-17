package com.example.employees.services

import com.example.employees.entities.JobDescriptionNotFoundException
import com.example.employees.entities.JobDescriptionRepository
import com.example.employees.entities.JobDescription
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service

@Service
class JobDescriptionService(private val jobDescriptionRepository: JobDescriptionRepository) {
    fun getAllJobDescriptions(): List<JobDescription> = jobDescriptionRepository.findAll()

    fun getJobDescriptionById(jobDescriptionId: Long): JobDescription = jobDescriptionRepository.findById(jobDescriptionId)
            .orElseThrow { JobDescriptionNotFoundException(HttpStatus.NOT_FOUND, "No matching jobDescription was found") }
    fun createJobDescription(jobDescription: JobDescription): JobDescription = jobDescriptionRepository.save(jobDescription)

    fun updateJobDescriptionById(jobDescriptionId: Long, jobDescription: JobDescription): JobDescription {
        return if (jobDescriptionRepository.existsById(jobDescriptionId)) {
            jobDescriptionRepository.save(
                    JobDescription(
                            id = jobDescription.id,
                            title = jobDescription.title,
                            description = jobDescription.description,
                            addedAt = jobDescription.addedAt
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