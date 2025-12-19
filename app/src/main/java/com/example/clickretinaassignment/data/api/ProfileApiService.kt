package com.example.clickretinaassignment.data.api

import com.example.clickretinaassignment.data.model.ProfileResponse
import retrofit2.Response
import retrofit2.http.GET

interface ProfileApiService {
    @GET("data.json")
    suspend fun getProfile(): Response<ProfileResponse>
}
