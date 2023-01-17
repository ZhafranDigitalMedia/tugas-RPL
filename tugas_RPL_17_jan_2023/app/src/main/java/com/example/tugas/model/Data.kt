package com.example.tugas.model

data class Data(
    val company_name: String,
    val created_at: Int,
    val description: String,
    val job_types: List<String>,
    val location: String,
    val remote: Boolean,
    val slug: String,
    val tags: List<String>,
    val title: String,
    val url: String
)