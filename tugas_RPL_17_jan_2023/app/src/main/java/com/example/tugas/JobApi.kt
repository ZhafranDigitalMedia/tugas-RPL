package com.example.tugas

import com.example.tugas.model.JobResponse
import retrofit2.http.GET

interface JobApi {

    @GET("job-board-api")
    suspend fun Job(
//        @Query("format") format: String = FORMAT
    ): JobResponse

//    companion object{
//        const val FORMAT = "json"
//    }
}