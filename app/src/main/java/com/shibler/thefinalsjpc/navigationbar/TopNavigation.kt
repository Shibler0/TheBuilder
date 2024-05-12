package com.shibler.thefinalsjpc.navigationbar


import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.shibler.thefinalsjpc.ui.theme.Base
import com.shibler.thefinalsjpc.ui.theme.Gray


@Composable
fun TopNavigation(navController: NavController, topBarState: MutableState<Boolean>) {

    AnimatedVisibility(
        visible = topBarState.value
    ) {

        var selectedButtonIndex by remember { mutableIntStateOf(1) }

        Row(
            modifier = Modifier
                .padding(top = 0.dp)
                .fillMaxWidth()
                .background(Base)
        ) {

            Spacer(modifier = Modifier.width(30.dp))

            OutlinedButton(
                onClick = {
                    navController.navigate("Loadout")
                    selectedButtonIndex = 1
                },
                border = BorderStroke(1.dp, Color.White),
                shape = RoundedCornerShape(50.dp),
                colors = ButtonDefaults.outlinedButtonColors(containerColor = if (selectedButtonIndex == 1) Color.White else Color.Transparent),
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .padding(top = 50.dp),
            ) {

                Text(
                    text = "Heavy",
                    color = if (selectedButtonIndex == 1) Gray else Color.White,
                    fontSize = 12.sp,
                )

            }

            Spacer(modifier = Modifier.width(10.dp))

            OutlinedButton(
                onClick = {
                    navController.navigate("Loadout2")
                    selectedButtonIndex = 2
                },
                border = BorderStroke(1.dp, Color.White),
                shape = RoundedCornerShape(50.dp),
                colors = ButtonDefaults.outlinedButtonColors(containerColor = if (selectedButtonIndex == 2) Color.White else Color.Transparent),
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .padding(top = 50.dp)
            ) {

                Text(
                    text = "Medium",
                    color = if (selectedButtonIndex == 2) Gray else Color.White,
                    fontSize = 12.sp
                )

            }

            Spacer(modifier = Modifier.width(10.dp))

            OutlinedButton(
                onClick = {
                    navController.navigate("Loadout3")
                    selectedButtonIndex = 3
                },
                border = BorderStroke(1.dp, Color.White),
                shape = RoundedCornerShape(50.dp),
                colors = ButtonDefaults.outlinedButtonColors(containerColor = if (selectedButtonIndex == 3) Color.White else Color.Transparent),
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .padding(top = 50.dp)
            ) {

                Text(
                    text = "Light",
                    color = if (selectedButtonIndex == 3) Gray else Color.White,
                    fontSize = 12.sp
                )

            }

            Spacer(modifier = Modifier.width(30.dp))

        }

    }
}