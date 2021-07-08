package com.example.employees

import org.springframework.boot.Banner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class EmployeeApplication

fun main(args: Array<String>) {
	runApplication<EmployeeApplication>(*args){
		setBannerMode(Banner.Mode.OFF)
	}
}
