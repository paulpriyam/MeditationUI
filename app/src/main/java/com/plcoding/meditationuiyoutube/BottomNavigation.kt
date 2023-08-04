package com.plcoding.meditationuiyoutube

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.plcoding.meditationuiyoutube.ui.theme.ButtonBlue
import com.plcoding.meditationuiyoutube.ui.theme.DarkerButtonBlue
import com.plcoding.meditationuiyoutube.ui.theme.DeepBlue
import com.plcoding.meditationuiyoutube.util.Screen

@Composable
fun BottomNavigation(navController: NavController) {
    val items = listOf<BottomMenuContent>(
        BottomMenuContent("Home", R.drawable.ic_home, Screen.HomeScreen.route),
        BottomMenuContent("Meditate", R.drawable.ic_bubble, Screen.MeditateScreen.route),
        BottomMenuContent("Sleep", R.drawable.ic_moon, Screen.SleepScreen.route),
        BottomMenuContent("Music", R.drawable.ic_music, Screen.MusicScreen.route),
        BottomMenuContent("Profile", R.drawable.ic_profile, Screen.ProfileScreen.route),
    )
    androidx.compose.material.BottomNavigation(
        backgroundColor = DeepBlue,
        contentColor = DarkerButtonBlue,
        elevation = 8.dp
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach { item ->
            BottomNavigationItem(
                icon = {
                Icon(
                    painter = painterResource(id = item.iconId),
                    contentDescription = item.title,
                    modifier = Modifier.size(24.dp)
                )
            }, label = { Text(text = item.title) },
                unselectedContentColor = DarkerButtonBlue,
                selectedContentColor = DarkerButtonBlue.copy(alpha = 0.5f),
                selected = currentRoute == item.route,
                onClick = {
                    val route =
                        if (item.route == Screen.HomeScreen.route) item.route else item.route + "/${item.title}"
                    navController.navigate(route) {
                        navController.graph.startDestinationRoute?.let { startRoute ->
                            popUpTo(startRoute) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }

                })
        }
    }
}