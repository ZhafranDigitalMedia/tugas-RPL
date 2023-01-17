package com.example.tugas

import androidx.lifecycle.ViewModel
import com.example.tugas.model.JobResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class JobViewModel @Inject constructor(private val carResponse: JobRepository): ViewModel() {

    suspend fun searchcar(search: String): JobResponse{
        return carResponse.searchMeal(search)
    }
}