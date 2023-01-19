package com.example.tugas.Detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tugas.AppModule
import com.example.tugas.JobApi
import com.example.tugas.model.JobResponse
import kotlinx.coroutines.launch

class DetailViewModel: ViewModel() {

    private val api: JobApi = AppModule.provideCar()

    private val _isloding: MutableLiveData<Boolean> = MutableLiveData()
    val isloding: LiveData<Boolean> = _isloding

    private val _username: MutableLiveData<String> = MutableLiveData()
    val username: LiveData<String> = _username

    private val _detailUser: MutableLiveData<JobResponse?> = MutableLiveData()
    val detailUser: LiveData<JobResponse?> = _detailUser


    fun getDetailUser(username: String){
        viewModelScope.launch {
            _isloding.value = true
            try {
                val repose = api.Job()
                _detailUser.value = repose
            }catch (e: Exception){
                _detailUser.value = null
            }finally {
                _isloding.value = false
            }
        }
    }
}