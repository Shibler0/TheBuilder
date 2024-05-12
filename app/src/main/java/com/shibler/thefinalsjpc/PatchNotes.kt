package com.shibler.thefinalsjpc

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview
@Composable
fun PatchNote() {

    Column (
        modifier = Modifier
            .fillMaxSize()
    ) {

        Text(
            text = "Hotfix 1.6.1",
            style = MaterialTheme.typography.headlineSmall,
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp,
            modifier = Modifier
                .padding(bottom = 40.dp)
        )

        Text(
            text = "This hotfix will bring back the balance changes and the fix to crossplay matchmaking from Patch 1.5.5 that were accidentally lost in the Mid-Season Update 1.6.0. \n" +
                    "\n" +
                    "Sorry for the confusion, yolks!\n" +
                    "\n" +
                    "We’ve also made changes to fix the leaderboard and you might see a surprise when you start the game, so keep your eyes peeled.",
            style = MaterialTheme.typography.headlineSmall,
            color = Color.White
        )

    }


}