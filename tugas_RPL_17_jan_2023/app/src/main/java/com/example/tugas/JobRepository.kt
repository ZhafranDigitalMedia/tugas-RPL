package com.example.tugas

import com.example.tugas.model.JobResponse
import javax.inject.Inject

class JobRepository @Inject constructor(private val jobApi: JobApi) {
    suspend fun searchMeal(format: String): JobResponse {
        return jobApi.Job()
    }
}