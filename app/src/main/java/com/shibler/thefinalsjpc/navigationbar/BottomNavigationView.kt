package com.shibler.thefinalsjpc.navigationbar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
import com.shibler.thefinalsjpc.ui.theme.Base

data class BottomNavigation(val title:String, val icon: ImageVector)

val items = listOf(
    BottomNavigation(
        title = "Loadout",
        icon = Icons.Rounded.ShoppingCart
    ),
    BottomNavigation(
        title = "Shop",
        icon = Icons.Rounded.ShoppingCart
    ),
    BottomNavigation(
        title = "Patch notes",
        icon = Icons.Rounded.Settings
    ),
    BottomNavigation(
        title = "All items",
        icon = Icons.Rounded.Settings
    )
)

@Composable
fun BottomNavigationView(navController: NavController) {

    var selectedTabIndex by remember {
        mutableIntStateOf(0)
    }

    NavigationBar {

        Column(

        ) {

            Row(
                modifier = Modifier
                    .background(Base)
                    .fillMaxWidth(),
            ) {

                items.forEachIndexed { index, item ->
                    NavigationBarItem(
                        selected = index == selectedTabIndex,
                        onClick = {
                            selectedTabIndex = index


                            when (index) {

                                0 -> navController.navigate("Loadout")
                                1 -> navController.navigate("Shop")
                                2 -> navController.navigate("Settings")
                                3 -> navController.navigate("Items")
                            }
                        },
                        icon = {
                            Icon(
                                imageVector = item.icon,
                                contentDescription = item.title,
                                tint = MaterialTheme.colorScheme.onBackground
                            )
                        },
                        label = {
                            Text(
                                text = item.title,
                                color = Color.White,
                                style = MaterialTheme.typography.headlineLarge
                            )
                        }
                    )
                }

            }
        }
    }

}