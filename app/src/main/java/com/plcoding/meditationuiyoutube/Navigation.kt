package com.plcoding.meditationuiyoutube

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.plcoding.meditationuiyoutube.ui.*
import com.plcoding.meditationuiyoutube.util.Screen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.HomeScreen.route) {
        composable(route = Screen.HomeScreen.route) {
            HomeScreen(navController)
        }
        composable(
            route = Screen.ProfileScreen.route + "/{name}",
            arguments = listOf(
                navArgument("name") {
                    type = NavType.StringType
                    defaultValue = "Priyam"
                    nullable = true
                }
            )
        ) { entry ->
            ProfileScreen(name = entry.arguments?.getString("name"))
        }

        composable(
            route = Screen.MeditateScreen.route + "/{name}",
            arguments = listOf(
                navArgument("name") {
                    type = NavType.StringType
                    defaultValue = "Priyam"
                    nullable = true
                }
            )
        ) { entry ->
            MeditationScreen(name = entry.arguments?.getString("name"))
        }

        composable(
            route = Screen.MusicScreen.route + "/{name}",
            arguments = listOf(
                navArgument("name") {
                    type = NavType.StringType
                    defaultValue = "Priyam"
                    nullable = true
                }
            )
        ) { entry ->
            MusicScreen(name = entry.arguments?.getString("name"))
        }

        composable(
            route = Screen.SleepScreen.route + "/{name}",
            arguments = listOf(
                navArgument("name") {
                    type = NavType.StringType
                    defaultValue = "Priyam"
                    nullable = true
                }
            )
        ) { entry ->
            SleepScreen(name = entry.arguments?.getString("name"))
        }
    }
}