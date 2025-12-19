package com.example.clickretinaassignment.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.clickretinaassignment.data.model.*
import com.example.clickretinaassignment.ui.components.*

@Composable
fun ProfileScreen(
    profile: UserProfile,
    onLinkClick: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .verticalScroll(rememberScrollState())
    ) {
        Box(
            modifier = Modifier.fillMaxWidth()
        ) {
            ProfileHeader(
                username = profile.username,
                modifier = Modifier.fillMaxWidth()
            )
        }
        
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .offset(y = (-60).dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ProfileAvatar(
                avatarUrl = profile.avatar
            )
            
            Spacer(modifier = Modifier.height(16.dp))
            
            Text(
                text = profile.name,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onSurface
            )
            
            Spacer(modifier = Modifier.height(4.dp))
            
            Text(
                text = "${profile.location.city}, ${profile.location.country}",
                fontSize = 14.sp,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
            )
            
            Spacer(modifier = Modifier.height(24.dp))
            
            StatsSection(
                followers = profile.statistics.followers,
                following = profile.statistics.following
            )
            
            Spacer(modifier = Modifier.height(24.dp))
            
            SocialLinksRow(
                websiteUrl = profile.social.website,
                instagramUrl = profile.social.instagram,
                facebookUrl = profile.social.facebook,
                onLinkClick = onLinkClick
            )
            
            Spacer(modifier = Modifier.height(24.dp))
            
            TabSection(
                shots = profile.statistics.activity.shots,
                collections = profile.statistics.activity.collections
            )
            
            Spacer(modifier = Modifier.height(16.dp))
            
            EmptyStateView()
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ProfileScreenPreview() {
    MaterialTheme {
        ProfileScreen(
            profile = UserProfile(
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
                        collections = 10
                    )
                )
            ),
            onLinkClick = {}
        )
    }
}
