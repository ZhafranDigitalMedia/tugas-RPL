package com.example.tugas

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideCar() : JobApi{
        return Retrofit.Builder()
            .baseUrl("https://www.arbeitnow.com/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(JobApi::class.java)
    }
}