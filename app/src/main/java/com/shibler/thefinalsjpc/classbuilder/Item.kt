package com.shibler.thefinalsjpc.classbuilder

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shibler.thefinalsjpc.db.ItemData
import com.shibler.thefinalsjpc.ui.theme.Base
import com.shibler.thefinalsjpc.ui.theme.gradientBottom
import com.shibler.thefinalsjpc.ui.theme.gradientTop



@Composable
fun Item (itemData: ItemData, onClick: () -> Unit) {

    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .clip(
                RoundedCornerShape(
                    8.dp
                )
            )
            .border(shape = RoundedCornerShape(8.dp), width = 2.dp, color = when(itemData.type) {
                0 -> Color.Cyan
                1 -> Color.Red
                2 -> Color.White
                else -> Color.Transparent
            })

    ) {
        Box(

            modifier = Modifier
                .padding(bottom = 0.dp)
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            gradientTop, gradientBottom
                        )
                    )
                )
                .width(80.dp)
                .clickable {
                    onClick()
                }

        ) {

            itemData.image?.let { painterResource(id = it) }?.let {
                Image(
                    painter = it, contentDescription = "specialization",
                    modifier = Modifier
                        .height(80.dp)
                )
            }

        }

        Box(
            modifier = Modifier
                .padding(top = 0.dp)
                .background(Base)
                .width(80.dp)
                .height(16.dp),
            contentAlignment = Alignment.Center

        ) {

            itemData.text?.let {
                Text(
                    text = it,
                    style = MaterialTheme.typography.headlineMedium,
                    fontSize = 10.sp,
                    fontStyle = FontStyle.Italic,
                    color = Color.White,
                    modifier = Modifier
                        .padding(top = 1.dp, bottom = 1.dp)
                )
            }

        }

    }

}