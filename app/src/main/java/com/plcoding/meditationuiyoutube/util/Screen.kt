package com.plcoding.meditationuiyoutube.util

sealed class Screen(val route: String) {
    object HomeScreen : Screen("home_screen")
    object MeditateScreen : Screen("meditate_screen")
    object SleepScreen : Screen("sleep_screen")
    object MusicScreen : Screen("music_screen")
    object ProfileScreen : Screen("profile_screen")
}
