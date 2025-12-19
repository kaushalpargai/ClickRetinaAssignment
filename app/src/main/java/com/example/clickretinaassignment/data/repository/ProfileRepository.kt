package com.example.clickretinaassignment.data.repository

import com.example.clickretinaassignment.data.api.RetrofitInstance
import com.example.clickretinaassignment.data.model.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

sealed class Result<out T> {
    data class Success<T>(val data: T, val fromApi: Boolean = true) : Result<T>()
    data class Error(val message: String) : Result<Nothing>()
}

class ProfileRepository {
    
    suspend fun getProfile(): Result<UserProfile> = withContext(Dispatchers.IO) {
        try {
            val response = RetrofitInstance.apiService.getProfile()
            
            if (response.isSuccessful && response.body() != null) {
                val profile = response.body()!!.user
                Result.Success(profile, fromApi = true)
            } else {
                val mockProfile = getMockProfile()
                Result.Success(mockProfile, fromApi = false)
            }
        } catch (e: Exception) {
            val mockProfile = getMockProfile()
            Result.Success(mockProfile, fromApi = false)
        }
    }
    
    private fun getMockProfile(): UserProfile {
        return UserProfile(
            name = "Bruno Pham",
            username = "@brunopham",
            avatar = "https://i.postimg.cc/fyHcPdKT/Avatar.png",
            location = Location(
                city = "Da Nang",
                country = "Vietnam"
            ),
            social = Social(
                website = "https://brunopham.com",
                profiles = listOf(
                    SocialProfile(platform = "Instagram", url = "https://instagram.com/brunopham"),
                    SocialProfile(platform = "Facebook", url = "https://facebook.com/brunopham")
                )
            ),
            statistics = Statistics(
                followers = 220,
                following = 150,
                activity = Activity(
                    shots = 0,
                    collections = 0
                )
            )
        )
    }
}
