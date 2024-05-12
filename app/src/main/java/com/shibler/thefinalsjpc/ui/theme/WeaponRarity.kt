package com.shibler.thefinalsjpc.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp


@Composable
fun WeaponRarity(skin : Int, color: String, weaponName : String) {

    Column {
        Spacer(
            modifier = Modifier
                .padding(top = 20.dp)
                .width(330.dp)
                .height(4.dp)
                .background(
                    when(color) {
                        "legendary" -> legendarySkin
                        "epic" -> epicSkin
                        "rare" -> rareSkin
                        "common" -> commonSkin
                        else -> Color.White }
                    , RoundedCornerShape(4.dp))
        )
        Image(
            painter = painterResource(id = skin), contentDescription = weaponName,
            modifier = Modifier
                .width(330.dp)
        )


    }

    Spacer(modifier = Modifier.width(40.dp))


}