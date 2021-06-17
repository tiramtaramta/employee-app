package com.example.employees

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping

@Controller
class HtmlController {

    @GetMapping("/")
    fun hr(model: Model): String {
        model["title"] = "HR"
        return "HR"
    }
}