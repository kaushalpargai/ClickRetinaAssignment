package com.example.clickretinaassignment

import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.browser.customtabs.CustomTabsIntent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.clickretinaassignment.ui.screen.ErrorScreen
import com.example.clickretinaassignment.ui.screen.LoadingScreen
import com.example.clickretinaassignment.ui.screen.ProfileScreen
import com.example.clickretinaassignment.ui.theme.ClickRetinaAssignmentTheme
import com.example.clickretinaassignment.ui.viewmodel.ProfileUiState
import com.example.clickretinaassignment.ui.viewmodel.ProfileViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ClickRetinaAssignmentTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ProfileApp(
                        onLinkClick = { url ->
                            openCustomTab(url)
                        }
                    )
                }
            }
        }
    }
    
    private fun openCustomTab(url: String) {
        val customTabsIntent = CustomTabsIntent.Builder()
            .setShowTitle(true)
            .build()
        
        customTabsIntent.launchUrl(this, Uri.parse(url))
    }
}

@Composable
fun ProfileApp(
    onLinkClick: (String) -> Unit,
    viewModel: ProfileViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsState()
    
    when (val state = uiState) {
        is ProfileUiState.Loading -> {
            LoadingScreen()
        }
        is ProfileUiState.Success -> {
            ProfileScreen(
                profile = state.profile,
                onLinkClick = onLinkClick
            )
        }
        is ProfileUiState.Error -> {
            ErrorScreen(
                message = state.message,
                onRetry = { viewModel.retry() }
            )
        }
    }
}