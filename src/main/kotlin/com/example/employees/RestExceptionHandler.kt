package com.example.employees

import com.example.employees.entities.EmployeeNotFoundException
import com.example.employees.entities.JobDescriptionNotFoundException
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import java.lang.Exception
import javax.persistence.EntityNotFoundException

@ControllerAdvice
class RestExceptionHandler: ResponseEntityExceptionHandler() {
    override fun handleHttpMessageNotReadable(
        ex: HttpMessageNotReadableException,
        headers: HttpHeaders,
        status: HttpStatus,
        request: WebRequest
    ): ResponseEntity<Any> {
        val error = "Malformed JSON request"
        return buildResponseEntity(ApiError(HttpStatus.BAD_REQUEST, error, ex))
    }

    override fun handleExceptionInternal(
        ex: Exception,
        body: Any?,
        headers: HttpHeaders,
        status: HttpStatus,
        request: WebRequest
    ): ResponseEntity<Any> {
        val error = "Server error happened"
        return buildResponseEntity(ApiError(HttpStatus.INTERNAL_SERVER_ERROR, error, ex))
    }

    @ExceptionHandler(value = [(JobDescriptionNotFoundException::class)])
    fun handleJobDescriptionNotFound(ex: JobDescriptionNotFoundException, request: WebRequest): ResponseEntity<Any> {
        return buildResponseEntity(ApiError(HttpStatus.NOT_FOUND, "JobDescription not found", ex))
    }

    @ExceptionHandler(value = [(EmployeeNotFoundException::class)])
    fun handleEmployeeNotFound(ex: EmployeeNotFoundException, request: WebRequest): ResponseEntity<Any> {
        return buildResponseEntity(ApiError(HttpStatus.NOT_FOUND, "Employee not found", ex))
    }

    private fun buildResponseEntity(apiError: ApiError): ResponseEntity<Any> {
        return ResponseEntity(apiError, apiError.status)
    }
}