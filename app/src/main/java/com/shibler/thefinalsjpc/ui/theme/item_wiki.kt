package com.shibler.thefinalsjpc.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun WikiItems(isLeft: Boolean, image: Int, name: String) {

    val shape = if(isLeft)
        RoundedCornerShape(topStart = 0.dp,
        topEnd = 10.dp,
        bottomEnd = 10.dp,
        bottomStart = 10.dp)
        else
        RoundedCornerShape(topStart = 0.dp,
            topEnd = 10.dp,
            bottomEnd = 10.dp,
            bottomStart = 10.dp)

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp)
            .background(
                Gray,
                shape
                )
            )
     {
        Image(painter = painterResource(id = image), contentDescription = "akm", modifier = Modifier.fillMaxSize())
        Text(
            text = name,
            color = Color.White,
            style = MaterialTheme.typography.headlineMedium,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(start = 2.dp)
        )
    }

}