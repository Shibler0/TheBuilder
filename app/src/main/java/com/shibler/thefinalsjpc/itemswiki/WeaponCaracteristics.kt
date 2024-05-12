package com.shibler.thefinalsjpc.itemswiki

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shibler.thefinalsjpc.ui.theme.Base
import com.shibler.thefinalsjpc.ui.theme.backgroundColor


@Composable
fun weaponCaracteristics(dps : Int, magsize : Int, reloadTime: Double, criticalDamage: Int, damagePerBullet: Int) {

    Column (
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 13.dp, end = 13.dp)
            .background(backgroundColor, RoundedCornerShape(13.dp))
    ) {

        Row (
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ){

            Column (
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .weight(1f)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp, start = 10.dp, end = 10.dp)
                        .background(Base, RoundedCornerShape(5.dp)),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = "DPS", color = Color.White, style = MaterialTheme.typography.headlineMedium, fontSize = 17.sp)
                }

                Text(text = "$dps", color = Color.White, style = MaterialTheme.typography.headlineMedium, fontSize = 17.sp)

            }

            Column (
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .weight(1f)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp, end = 10.dp)
                        .background(Base, RoundedCornerShape(5.dp)),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = "MAGSIZE", color = Color.White, style = MaterialTheme.typography.headlineMedium, fontSize = 17.sp)
                }

                Text(text = "$magsize", color = Color.White, style = MaterialTheme.typography.headlineMedium, fontSize = 17.sp)

            }

            Column (
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .weight(1f)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp, end = 10.dp)
                        .background(Base, RoundedCornerShape(5.dp)),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = "RELOAD TIME", color = Color.White, style = MaterialTheme.typography.headlineMedium, fontSize = 17.sp)
                }

                Text(text = "$reloadTime", color = Color.White, style = MaterialTheme.typography.headlineMedium, fontSize = 17.sp)

            }

        }
        Row (
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ){

        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .weight(1f)
        ) {

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 10.dp ,top = 10.dp, end = 10.dp)
                        .background(Base, RoundedCornerShape(5.dp)),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = "CRITICAL DAMAGE", color = Color.White, style = MaterialTheme.typography.headlineMedium, fontSize = 17.sp)
                }

                Text(text = "$criticalDamage", color = Color.White, style = MaterialTheme.typography.headlineMedium, fontSize = 17.sp)

            }

            Column (
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .weight(1f)
            ) {

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp, end = 10.dp)
                        .background(Base, RoundedCornerShape(5.dp)),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = "DAMAGE PER HIT", color = Color.White, style = MaterialTheme.typography.headlineMedium, fontSize = 17.sp)
                }

                Text(text = "$damagePerBullet", color = Color.White, style = MaterialTheme.typography.headlineMedium, fontSize = 17.sp)

            }



        }

    }

}