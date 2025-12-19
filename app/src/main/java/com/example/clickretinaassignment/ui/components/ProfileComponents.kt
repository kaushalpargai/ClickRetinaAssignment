package com.example.clickretinaassignment.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.clickretinaassignment.R

@Composable
fun ProfileHeader(
    username: String,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(200.dp)
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(
                        Color(0xFF4A148C),
                        Color(0xFF1A237E),
                        Color(0xFF0D47A1)
                    )
                )
            )
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 48.dp)
                .align(Alignment.TopCenter)
        ) {
            Text(
                text = username,
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier
                    .background(
                        color = Color.Black.copy(alpha = 0.3f),
                        shape = CircleShape
                    )
                    .padding(horizontal = 16.dp, vertical = 8.dp)
                    .align(Alignment.Center)
            )
        }
        
        IconButton(
            onClick = { },
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(top = 48.dp, end = 16.dp)
        ) {
            Icon(
                painter = painterResource(R.drawable.setting),
                contentDescription = "Settings",
                tint = Color.Unspecified,
                modifier = Modifier.size(24.dp)
            )
        }
    }
}

@Composable
fun ProfileAvatar(
    avatarUrl: String,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    
    AndroidView(
        factory = { ctx ->
            ImageView(ctx).apply {
                scaleType = ImageView.ScaleType.CENTER_CROP
            }
        },
        update = { imageView ->
            Glide.with(context)
                .load(avatarUrl)
                .circleCrop()
                .into(imageView)
        },
        modifier = modifier
            .size(120.dp)
            .clip(CircleShape)
            .border(4.dp, Color.White, CircleShape)
    )
}

@Composable
fun StatsSection(
    followers: Int,
    following: Int,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 32.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    color = Color(0xFFF5F5F5),
                    shape = MaterialTheme.shapes.medium
                )
                .padding(vertical = 16.dp, horizontal = 24.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = followers.toString(),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Text(
                    text = "Followers",
                    fontSize = 14.sp,
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
                )
            }
            
            Spacer(modifier = Modifier.width(24.dp))
            
            Surface(
                modifier = Modifier.size(48.dp),
                shape = CircleShape,
                color = Color(0xFF5C6BC0),
                shadowElevation = 4.dp
            ) {
                Box(
                    contentAlignment = Alignment.Center
                ) {
                    Row(
                        horizontalArrangement = Arrangement.spacedBy(2.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "S",
                            color = Color.White,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = "S",
                            color = Color.White,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }
            
            Spacer(modifier = Modifier.width(24.dp))
            
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = following.toString(),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Text(
                    text = "Following",
                    fontSize = 14.sp,
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
                )
            }
        }
    }
}

@Composable
fun SocialLinksRow(
    websiteUrl: String?,
    instagramUrl: String?,
    facebookUrl: String?,
    onLinkClick: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        websiteUrl?.let {
            IconButton(onClick = { onLinkClick(it) }) {
                Icon(
                    painter = painterResource(R.drawable.website),
                    contentDescription = "Website",
                    tint = Color.Unspecified,
                    modifier = Modifier.size(24.dp)
                )
            }
        }
        
        Spacer(modifier = Modifier.width(8.dp))
        
        Text(
            text = "•",
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.4f),
            fontSize = 12.sp
        )
        
        Spacer(modifier = Modifier.width(8.dp))
        
        instagramUrl?.let {
            IconButton(onClick = { onLinkClick(it) }) {
                Icon(
                    painter = painterResource(R.drawable.instagram),
                    contentDescription = "Instagram",
                    tint = Color.Unspecified,
                    modifier = Modifier.size(24.dp)
                )
            }
        }
        
        Spacer(modifier = Modifier.width(8.dp))
        
        Text(
            text = "•",
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.4f),
            fontSize = 12.sp
        )
        
        Spacer(modifier = Modifier.width(8.dp))
        
        facebookUrl?.let {
            IconButton(onClick = { onLinkClick(it) }) {
                Icon(
                    painter = painterResource(R.drawable.facebook),
                    contentDescription = "Facebook",
                    tint = Color.Unspecified,
                    modifier = Modifier.size(24.dp)
                )
            }
        }
    }
}

@Composable
fun TabSection(
    shots: Int,
    collections: Int,
    modifier: Modifier = Modifier
) {
    var selectedTab by remember { mutableStateOf(0) }
    
    Column(modifier = modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Box(
                modifier = Modifier
                    .weight(1f)
                    .padding(4.dp)
            ) {
                TextButton(
                    onClick = { selectedTab = 0 },
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            color = if (selectedTab == 0) Color(0xFFE8EAF6) else Color.Transparent,
                            shape = MaterialTheme.shapes.medium
                        )
                ) {
                    Text(
                        text = "$shots shots",
                        color = if (selectedTab == 0) 
                            Color(0xFF5C6BC0)
                        else 
                            MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f),
                        fontWeight = if (selectedTab == 0) FontWeight.Bold else FontWeight.Normal
                    )
                }
            }
            
            Box(
                modifier = Modifier
                    .weight(1f)
                    .padding(4.dp)
            ) {
                TextButton(
                    onClick = { selectedTab = 1 },
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            color = if (selectedTab == 1) Color(0xFFE8EAF6) else Color.Transparent,
                            shape = MaterialTheme.shapes.medium
                        )
                ) {
                    Text(
                        text = "$collections Collections",
                        color = if (selectedTab == 1) 
                            Color(0xFF5C6BC0)
                        else 
                            MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f),
                        fontWeight = if (selectedTab == 1) FontWeight.Bold else FontWeight.Normal
                    )
                }
            }
        }
    }
}

@Composable
fun EmptyStateView(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(32.dp),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(R.drawable.no_content_image),
            contentDescription = "No content",
            modifier = Modifier.size(400.dp)
        )
    }
}
