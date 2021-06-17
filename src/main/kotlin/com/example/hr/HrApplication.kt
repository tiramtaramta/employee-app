package com.example.hr

import org.springframework.boot.Banner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class HrApplication

fun main(args: Array<String>) {
	runApplication<HrApplication>(*args){
		setBannerMode(Banner.Mode.OFF)
	}
}
