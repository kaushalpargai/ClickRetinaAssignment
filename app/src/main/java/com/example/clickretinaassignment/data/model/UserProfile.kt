package com.example.clickretinaassignment.data.model

import com.google.gson.annotations.SerializedName

data class ProfileResponse(
    @SerializedName("user") val user: UserProfile
)

data class UserProfile(
    @SerializedName("name") val name: String,
    @SerializedName("username") val username: String,
    @SerializedName("avatar") val avatar: String,
    @SerializedName("location") val location: Location,
    @SerializedName("social") val social: Social,
    @SerializedName("statistics") val statistics: Statistics
)

data class Location(
    @SerializedName("city") val city: String,
    @SerializedName("country") val country: String
)

data class Social(
    @SerializedName("website") val website: String?,
    @SerializedName("profiles") val profiles: List<SocialProfile>
) {
    val instagram: String?
        get() = profiles.find { it.platform.equals("Instagram", ignoreCase = true) }?.url
    
    val facebook: String?
        get() = profiles.find { it.platform.equals("Facebook", ignoreCase = true) }?.url
}

data class SocialProfile(
    @SerializedName("platform") val platform: String,
    @SerializedName("url") val url: String
)

data class Statistics(
    @SerializedName("followers") val followers: Int,
    @SerializedName("following") val following: Int,
    @SerializedName("activity") val activity: Activity
)

data class Activity(
    @SerializedName("shots") val shots: Int,
    @SerializedName("collections") val collections: Int
)
