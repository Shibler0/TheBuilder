package com.shibler.thefinalsjpc.itemswiki

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.shibler.thefinalsjpc.R
import com.shibler.thefinalsjpc.SkinsRarity
import com.shibler.thefinalsjpc.ui.theme.WeaponRarity

@Composable
fun itemInfos(navController: NavController, camos : List<SkinsRarity>, weaponName : String, dps: Int, magSize: Int, critDamage : Int, damagePerBullet : Int, reloadTime : Double) {

    val sortedSkin = camos.sortedBy { when(it.rarity) {
        "legendary" -> 1
        "epic" -> 2
        "rare" -> 3
        "common" -> 4
        else -> 5
    } }

    Image(
        painter = painterResource(id = R.drawable.keyboard_arrow_left),
        contentDescription = "keyboard Arrow left",
        modifier = Modifier
            .padding(top = 40.dp, start = 20.dp)
            .clickable { navController.navigate("Items") }
            .size(60.dp)
        )

    Column (
        modifier = Modifier
            .padding(top = 50.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(text = weaponName, color = Color.White, style = MaterialTheme.typography.headlineMedium, fontSize = 26.sp)

        Row (
            modifier = Modifier
                .horizontalScroll(rememberScrollState())

        ){

            for (i in sortedSkin) {
                WeaponRarity(skin = i.camo, color = i.rarity, weaponName)
            }
        }

        weaponCaracteristics(
            dps = dps,
            magsize = magSize,
            reloadTime = reloadTime,
            criticalDamage = critDamage,
            damagePerBullet = damagePerBullet
        )



    }








}