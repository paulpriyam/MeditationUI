package com.plcoding.meditationuiyoutube.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.plcoding.meditationuiyoutube.BottomMenuContent
import com.plcoding.meditationuiyoutube.Feature
import com.plcoding.meditationuiyoutube.R
import com.plcoding.meditationuiyoutube.ui.theme.*
import com.plcoding.meditationuiyoutube.util.Screen

@Composable
fun HomeScreen(navController: NavController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(DeepBlue)
            .padding(20.dp)
    ) {
        Column {
            GreetingSection()
            ChipSection(chips = listOf("Sweet sleep", "Insomnia", "Depression"))
            CurrentMeditationSection()
            FeatureSection(
                features =
                listOf(
                    Feature(
                        title = "Sleep meditation",
                        R.drawable.ic_headphone,
                        BlueViolet1,
                        BlueViolet2,
                        BlueViolet3
                    ),
                    Feature(
                        title = "Tips for sleeping",
                        R.drawable.ic_videocam,
                        LightGreen1,
                        LightGreen2,
                        LightGreen3
                    ),
                    Feature(
                        title = "Night island",
                        R.drawable.ic_headphone,
                        OrangeYellow1,
                        OrangeYellow2,
                        OrangeYellow3
                    ),
                    Feature(
                        title = "Calming sounds",
                        R.drawable.ic_headphone,
                        Beige1,
                        Beige2,
                        Beige3
                    ),
                    Feature(
                        title = "Melancholy Sounds",
                        R.drawable.ic_headphone,
                        Red1,
                        Red2,
                        Red3
                    ),
                    Feature(
                        title = "Metal ",
                        R.drawable.ic_headphone,
                        Purple1,
                        Purple2,
                        Purple3
                    )
                )
            )
        }
//        BottomMenu(
//            list = listOf(
//                BottomMenuContent("Home", R.drawable.ic_home, Screen.HomeScreen.route),
//                BottomMenuContent("Meditate", R.drawable.ic_bubble, Screen.MeditateScreen.route),
//                BottomMenuContent("Sleep", R.drawable.ic_moon, Screen.SleepScreen.route),
//                BottomMenuContent("Music", R.drawable.ic_music, Screen.MusicScreen.route),
//                BottomMenuContent("Profile", R.drawable.ic_profile, Screen.ProfileScreen.route),
//            ),
//            modifier = Modifier.align(Alignment.BottomCenter),
//            navController
//        )
    }
}

@Composable
fun GreetingSection(name: String = "Priyam") {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(verticalArrangement = Arrangement.Center) {
            Text(
                text = "Good Morning, $name",
                style = MaterialTheme.typography.h1
            )
            Text(
                text = "We widh you have a good day",
                style = MaterialTheme.typography.subtitle2,
                color = TextWhite
            )
        }
        Icon(
            painter = painterResource(id = R.drawable.ic_search),
            contentDescription = "search_icon",
            modifier = Modifier.size(24.dp),
            tint = Color.White
        )
    }
}

@Composable
fun ChipSection(chips: List<String>) {
    var selectedChip by remember {
        mutableStateOf(0)
    }
    LazyRow {
        items(chips.size) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .padding(
                        top = 16.dp,
                        bottom = 16.dp,
                        end = if (it == chips.size - 1) 0.dp else 16.dp
                    )
                    .clickable {
                        selectedChip = it
                    }
                    .clip(RoundedCornerShape(8.dp))
                    .background(if (selectedChip == it) ButtonBlue else DarkerButtonBlue)
                    .padding(vertical = 8.dp, horizontal = 16.dp)
            ) {
                Text(text = chips[it], color = TextWhite)
            }
        }
    }

}

@Composable
fun CurrentMeditationSection(color: Color = LightRed) {
    Box(
        modifier = Modifier
            .padding(vertical = 8.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(color)
            .fillMaxWidth()
            .padding(vertical = 16.dp, horizontal = 8.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(verticalArrangement = Arrangement.Center) {
                Text(
                    text = "Daily Thoughts",
                    style = MaterialTheme.typography.h2
                )
                Text(
                    text = "Meditation 3-10 mins",
                    style = MaterialTheme.typography.body1,
                    color = TextWhite
                )
            }
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .background(ButtonBlue)
                    .padding(8.dp),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_play),
                    contentDescription = "play",
                    tint = Color.White,
                    modifier = Modifier.size(16.dp)
                )
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun FeatureSection(features: List<Feature>) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "Features",
            style = MaterialTheme.typography.h1,
            modifier = Modifier.padding(vertical = 8.dp)
        )
        LazyVerticalGrid(
            cells = GridCells.Fixed(2),
            contentPadding = PaddingValues(bottom = 100.dp),
            modifier = Modifier.fillMaxHeight()
        ) {
            items(features.size) {
                FeatureItem(feature = features[it])
            }
        }
    }

}

@Composable
fun FeatureItem(feature: Feature) {
    BoxWithConstraints(
        modifier = Modifier
            .padding(7.dp)
            .aspectRatio(1F)
            .clip(RoundedCornerShape(8.dp))
            .background(feature.darkColor)
            .padding(8.dp)
    ) {
        Text(
            text = feature.title,
            style = Typography.body2,
            color = Color.White,
            modifier = Modifier.align(Alignment.TopStart)
        )
        Icon(
            painter = painterResource(id = feature.iconId),
            contentDescription = feature.title,
            tint = Color.White,
            modifier = Modifier
                .align(
                    Alignment.BottomStart,
                )
                .size(24.dp)
        )
        Text(
            text = "start",
            style = MaterialTheme.typography.body1,
            color = TextWhite,
            modifier = Modifier
                .clickable {
//no implementation
                }
                .clip(RoundedCornerShape(8.dp))
                .background(ButtonBlue)
                .padding(vertical = 8.dp, horizontal = 16.dp)
                .align(Alignment.BottomEnd)
        )
    }
}

@Composable
fun BottomMenu(
    list: List<BottomMenuContent>,
    modifier: Modifier = Modifier,
    navController: NavController,
    activeHighlightColor: Color = ButtonBlue,
    activeTextColor: Color = Color.White,
    inactiveTextColor: Color = AquaBlue,
    initialSelectedItemIndex: Int = 0
) {
    var selectedItemIndex by remember {
        mutableStateOf(initialSelectedItemIndex)
    }
    Row(
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .background(DeepBlue)
            .padding(vertical = 8.dp)
    ) {
        list.forEachIndexed { index, item ->
            BottomMenuItem(
                item = item,
                isSelected = index == selectedItemIndex,
                activeHighlightColor,
                activeTextColor,
                inactiveTextColor
            ) {
                selectedItemIndex = index
                navController.navigate(list[index].route+"/PRIYAM")
            }
        }
    }
}

@Composable
fun BottomMenuItem(
    item: BottomMenuContent,
    isSelected: Boolean,
    activeHighlightColor: Color = ButtonBlue,
    activeTextColor: Color = Color.White,
    inactiveTextColor: Color = AquaBlue,
    onItemClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.clickable {
            onItemClick()
        }
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .clip(RoundedCornerShape(8.dp))
                .background(if (isSelected) activeHighlightColor else Color.Transparent)
                .padding(8.dp),

        ) {
            Icon(
                painter = painterResource(id = item.iconId),
                contentDescription = item.title,
                tint = if (isSelected) activeTextColor else inactiveTextColor,
                modifier = Modifier.size(20.dp)
            )
        }
        Text(text = item.title, color = if (isSelected) activeTextColor else inactiveTextColor)
    }
}
