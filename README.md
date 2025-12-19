# Profile Viewer Android App

A modern Android application built with Jetpack Compose that displays user profile information fetched from an API.

## Features

- **User Profile Display**: Shows name, username, avatar, location, and statistics
- **Social Media Links**: Opens website, Instagram, and Facebook links in Chrome Custom Tabs
- **Statistics**: Displays followers and following counts
- **Tabs**: Shots and Collections tabs with selection highlighting
- **MVVM Architecture**: Clean separation of concerns
- **Error Handling**: Loading, success, and error states
- **Offline Support**: Automatic fallback to mock data when API is unavailable

## Tech Stack

- **Language**: Kotlin
- **UI Framework**: Jetpack Compose
- **Architecture**: MVVM (Model-View-ViewModel)
- **Networking**: Retrofit + OkHttp
- **Image Loading**: Glide
- **Async**: Kotlin Coroutines + Flow
- **Browser**: Chrome Custom Tabs

## Project Structure

```
app/src/main/java/com/example/clickretinaassignment/
├── data/
│   ├── api/
│   │   ├── ProfileApiService.kt      # Retrofit API interface
│   │   └── RetrofitInstance.kt       # Retrofit singleton
│   ├── model/
│   │   └── UserProfile.kt            # Data models
│   └── repository/
│       └── ProfileRepository.kt      # Data repository
├── ui/
│   ├── components/
│   │   └── ProfileComponents.kt      # Reusable UI components
│   ├── screen/
│   │   ├── ProfileScreen.kt          # Main profile screen
│   │   ├── LoadingScreen.kt          # Loading state
│   │   └── ErrorScreen.kt            # Error state
│   ├── theme/
│   │   └── Theme.kt                  # App theme
│   └── viewmodel/
│       └── ProfileViewModel.kt       # ViewModel
└── MainActivity.kt                    # Entry point
```

## Setup & Installation

### Prerequisites

- Android Studio Hedgehog or later
- JDK 17 or later
- Android SDK (API 24+)

### Steps

1. Clone the repository
2. Open the project in Android Studio
3. Sync Gradle files
4. Run the app on an emulator or physical device

```bash
./gradlew assembleDebug
./gradlew installDebug
```

## API Configuration

The app fetches data from:
```
https://raw.githubusercontent.com/android-assesment/profile/refs/heads/main/data.json
```

If the API is unavailable, the app automatically falls back to mock data.

## UI Components

### ProfileHeader
- Gradient background (Purple → Blue)
- Centered username with semi-transparent background
- Settings icon

### ProfileAvatar
- Circular avatar image loaded with Glide
- White border

### StatsSection
- Followers and Following counts
- Light gray background
- Center action button

### SocialLinksRow
- Website, Instagram, and Facebook icons
- Opens links in Chrome Custom Tabs

### TabSection
- Shots and Collections tabs
- Selected tab highlighted with background

### EmptyStateView
- Custom illustration
- "No content yet" message

## Compose Previews

All screens have preview functions for easy UI development:
- `LoadingScreenPreview()`
- `ErrorScreenPreview()`
- `ProfileScreenPreview()`

## Dependencies

```kotlin
// Jetpack Compose
implementation("androidx.compose.ui:ui")
implementation("androidx.compose.material3:material3")

// Networking
implementation("com.squareup.retrofit2:retrofit:2.9.0")
implementation("com.squareup.retrofit2:converter-gson:2.9.0")
implementation("com.squareup.okhttp3:logging-interceptor:4.12.0")

// Image Loading
implementation("com.github.bumptech.glide:glide:4.16.0")

// ViewModel
implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.10.0")

// Chrome Custom Tabs
implementation("androidx.browser:browser:1.8.0")
```

## Building for Production

```bash
./gradlew assembleRelease
```

The APK will be generated at:
```
app/build/outputs/apk/release/app-release.apk
```

## License

This project is created as an assignment for ClickRetina.

## Author

Developed with Kotlin and Jetpack Compose
