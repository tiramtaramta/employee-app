package com.example.employees.entities

import java.time.LocalDateTime

data class JobDescriptionPayload(val title:String, val description:String, val addedAt: LocalDateTime)