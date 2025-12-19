# Profile Viewer Android App

A modern Android application built with Jetpack Compose that displays user profile information fetched from an API with a beautiful, polished UI.

## Features

- **User Profile Display**: Shows name, username (from API), avatar, location, and statistics
- **Social Media Links**: Opens website, Instagram, and Facebook links in Chrome Custom Tabs
- **Statistics Section**: Displays followers and following counts with elegant background styling
- **Interactive Tabs**: Shots and Collections tabs with visual selection highlighting
- **MVVM Architecture**: Clean separation of concerns with ViewModel and Repository pattern
- **Error Handling**: Loading, success, and error states with retry functionality
- **Offline Support**: Automatic fallback to mock data when API is unavailable
- **Compose Previews**: All screens have preview functions for rapid UI development
- **Custom UI Components**: Reusable, production-ready Compose components

## Screenshots

The app features a modern design with:
- Gradient header background (Purple → Blue)
- Centered username with semi-transparent background
- Circular avatar with white border
- Light gray background for stats section
- Custom social media icons
- Tab selection with background highlighting
- Empty state with custom illustration

## Tech Stack

- **Language**: Kotlin
- **UI Framework**: Jetpack Compose
- **Architecture**: MVVM (Model-View-ViewModel)
- **Networking**: Retrofit + OkHttp
- **Image Loading**: Glide
- **Async**: Kotlin Coroutines + Flow
- **Browser**: Chrome Custom Tabs
- **Min SDK**: API 24 (Android 7.0)

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
│   │   ├── Color.kt                  # Color definitions
│   │   ├── Theme.kt                  # App theme
│   │   └── Type.kt                   # Typography
│   └── viewmodel/
│       └── ProfileViewModel.kt       # ViewModel
└── MainActivity.kt                    # Entry point
```

## Setup & Installation

### Prerequisites

- Android Studio Hedgehog or later
- JDK 17 or later
- Android SDK (API 24+)
- Git

### Steps

1. Clone the repository
```bash
git clone https://github.com/kaushalpargai/ClickRetinaAssignment.git
cd ClickRetinaAssignment
```

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

If the API is unavailable, the app automatically falls back to mock data to ensure a seamless user experience.

## UI Components

### ProfileHeader
- Gradient background (Deep Purple → Deep Blue → Blue)
- Centered username with semi-transparent dark background
- Settings icon at top-right
- Proper padding to avoid system UI overlap

### ProfileAvatar
- Circular avatar image loaded with Glide
- White border (4dp)
- 120dp size

### StatsSection
- Followers and Following counts
- Light gray background (#F5F5F5)
- Center action button with "S S" indicator
- Rounded corners with Material Design shapes

### SocialLinksRow
- Custom PNG icons for Website, Instagram, and Facebook
- Opens links in Chrome Custom Tabs
- Dot separators between icons

### TabSection
- Shots and Collections tabs
- Selected tab highlighted with light indigo background (#E8EAF6)
- Bold text and color change for selected state
- Smooth interaction

### EmptyStateView
- Custom illustration (400dp)
- Clean, minimalist design
- Centered layout

## Compose Previews

All screens have preview functions for easy UI development in Android Studio:
- `LoadingScreenPreview()` - Shows loading spinner
- `ErrorScreenPreview()` - Shows error message with retry button
- `ProfileScreenPreview()` - Shows full profile with sample data

To view previews, open any screen file and click "Split" or "Design" view in Android Studio.

## Dependencies

```kotlin
// Jetpack Compose
implementation("androidx.compose.ui:ui")
implementation("androidx.compose.material3:material3")
implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.10.0")

// Networking
implementation("com.squareup.retrofit2:retrofit:2.9.0")
implementation("com.squareup.retrofit2:converter-gson:2.9.0")
implementation("com.squareup.okhttp3:logging-interceptor:4.12.0")

// Image Loading
implementation("com.github.bumptech.glide:glide:4.16.0")

// Chrome Custom Tabs
implementation("androidx.browser:browser:1.8.0")
```

## Building for Production

Generate a release APK:
```bash
./gradlew assembleRelease
```

The APK will be generated at:
```
app/build/outputs/apk/release/app-release.apk
```

## Key Features Implemented

✅ Clean MVVM architecture  
✅ Retrofit for API calls with error handling  
✅ Glide for efficient image loading  
✅ Chrome Custom Tabs for external links  
✅ Compose previews for all screens  
✅ Custom drawable resources  
✅ Production-ready code (no debug logs or comments)  
✅ Proper .gitignore for Android projects  
✅ Comprehensive README documentation  

## Repository

**GitHub**: https://github.com/kaushalpargai/ClickRetinaAssignment

## License

This project is created as an assignment for ClickRetina.

## Author

Developed by Kaushal Pargai using Kotlin and Jetpack Compose
