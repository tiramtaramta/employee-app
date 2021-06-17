package com.example.hr.controllers

import com.example.hr.entities.Employee
import com.example.hr.entities.JobDescription
import com.example.hr.services.EmployeeService
import com.example.hr.services.JobDescriptionService
import org.springframework.web.bind.annotation.*

@RestController
class JobDescriptionController(private val jobDescriptionService: JobDescriptionService) {

    @GetMapping("/jobdescription")
    fun getAllJobDescription(): List<JobDescription> = jobDescriptionService.getAllJobDescriptions()

    @GetMapping("/jobdescription/{id}")
    fun getJobDescriptionById(@PathVariable("id") jobDescriptionId: Long): JobDescription =
            jobDescriptionService.getJobDescriptionById(jobDescriptionId)

    @PostMapping("/jobdescription")
    fun createJobDescription(@RequestBody payload: JobDescription): JobDescription = jobDescriptionService.createJobDescription(payload)

    @PutMapping("/jobdescription/{id}")
    fun updateJobDescriptionById(@PathVariable("id") jobDescriptionId: Long, @RequestBody payload: JobDescription): JobDescription =
            jobDescriptionService.updateJobDescriptionById(jobDescriptionId, payload)

    @DeleteMapping("/jobdescription/{id}")
    fun deleteJobDescriptionById(@PathVariable("id") jobDescriptionId: Long): Unit =
            jobDescriptionService.deleteJobDescriptionById(jobDescriptionId)
}