package com.example.employees.controllers

import com.example.employees.entities.JobDescription
import com.example.employees.entities.JobDescriptionPayload
import com.example.employees.services.JobDescriptionService
import org.springframework.web.bind.annotation.*

@RestController
class JobDescriptionController(private val jobDescriptionService: JobDescriptionService) {

    @GetMapping("/jobdescriptions")
    fun getAllJobDescription(): List<JobDescription> = jobDescriptionService.getAllJobDescriptions()

    @GetMapping("/jobdescriptions/{id}")
    fun getJobDescriptionById(@PathVariable("id") jobDescriptionId: Long): JobDescription =
            jobDescriptionService.getJobDescriptionById(jobDescriptionId)

    @PostMapping("/jobdescriptions")
    fun createJobDescription(@RequestBody payload: JobDescriptionPayload): JobDescription = jobDescriptionService.createJobDescription(payload)

    @PutMapping("/jobdescriptions/{id}")
    fun updateJobDescriptionById(@PathVariable("id") jobDescriptionId: Long, @RequestBody payload: JobDescriptionPayload): JobDescription =
            jobDescriptionService.updateJobDescriptionById(jobDescriptionId, payload)

    @DeleteMapping("/jobdescriptions/{id}")
    fun deleteJobDescriptionById(@PathVariable("id") jobDescriptionId: Long): Unit =
            jobDescriptionService.deleteJobDescriptionById(jobDescriptionId)
}