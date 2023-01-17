package com.example.tugas.model

data class Meta(
    val current_page: Int,
    val from: Int,
    val info: String,
    val path: String,
    val per_page: Int,
    val terms: String,
    val to: Int
)