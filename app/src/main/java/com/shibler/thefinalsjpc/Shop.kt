package com.shibler.thefinalsjpc

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.shibler.thefinalsjpc.ui.theme.Base
import java.util.Calendar

@Preview
@Composable
fun Shop() {

    val calendar = Calendar.getInstance()

    val hours = (11 - calendar.get(Calendar.HOUR_OF_DAY) + 24) % 24

    val dayOfWeek = when (calendar.get(Calendar.DAY_OF_WEEK)) {
        Calendar.MONDAY -> 2
        Calendar.TUESDAY -> 1
        Calendar.WEDNESDAY -> 7
        Calendar.THURSDAY -> 6
        Calendar.FRIDAY -> 5
        Calendar.SATURDAY -> 4
        Calendar.SUNDAY -> 3
        else -> 10
    }



    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(5.dp)
            .background(Base)
            .verticalScroll(rememberScrollState()),
    ) {
        Box(modifier = Modifier
            .fillMaxWidth(),
            contentAlignment = Alignment.CenterEnd
        ) {
            Text(text = if(dayOfWeek == 7 &&  hours < 11 || dayOfWeek == 1 && hours >= 11){ "Store refresh in $hours hours" } else "Store refresh : $dayOfWeek days", style = MaterialTheme.typography.headlineMedium, fontStyle = FontStyle.Italic, color = Color.White, modifier = Modifier.padding(end = 11.dp) )
        }

        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, end = 10.dp)
        ){
            Image(painter = painterResource(id = R.drawable.shop_pistoleroneon),
                contentDescription = "NTM",
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(7.dp))
                    .weight(1f)
            )

            Spacer(modifier = Modifier.width(7.dp))

            Image(painter = painterResource(id = R.drawable.shop_skinsbp),
                contentDescription = "NTM",
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(7.dp))
                    .weight(1f)
            )
        }

        Spacer(modifier = Modifier.height(7.dp))

        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, end = 10.dp)
        ){
            Image(painter = painterResource(id = R.drawable.shop_quaterback),
                contentDescription = "NTM",
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(7.dp))
                    .weight(1f)
            )

            Spacer(modifier = Modifier.width(7.dp))

            Image(painter = painterResource(id = R.drawable.shop_dragon),
                contentDescription = "NTM",
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(7.dp))
                    .weight(1f)
            )
        }

        Spacer(modifier = Modifier.height(7.dp))

        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, end = 10.dp)
        ){
            Image(painter = painterResource(id = R.drawable.shop_boreal),
                contentDescription = "NTM",
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(7.dp))
                    .weight(1f)
            )

            Spacer(modifier = Modifier.width(7.dp))

            Image(painter = painterResource(id = R.drawable.shop_firecreature),
                contentDescription = "NTM",
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(7.dp))
                    .weight(1f)
            )
        }

        Spacer(modifier = Modifier.height(7.dp))

        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, end = 10.dp)
        ){
            Image(painter = painterResource(id = R.drawable.shop_hazmatsuit),
                contentDescription = "NTM",
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(7.dp))
                    .weight(1f)
            )

            Spacer(modifier = Modifier.width(7.dp))

            Image(painter = painterResource(id = R.drawable.shop_military),
                contentDescription = "NTM",
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(7.dp))
                    .weight(1f)
            )
        }

        Spacer(modifier = Modifier.height(7.dp))

        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 10.dp, end = 10.dp)
        ){
            Image(painter = painterResource(id = R.drawable.shop_fizzytiger),
                contentDescription = "NTM",
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(7.dp))
                    .weight(1f)
            )

            Spacer(modifier = Modifier.width(7.dp))

            Image(painter = painterResource(id = R.drawable.shop_neon),
                contentDescription = "NTM",
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(7.dp))
                    .weight(1f)
            )
        }



    }
}