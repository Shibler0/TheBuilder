package com.shibler.thefinalsjpc.itemswiki

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shibler.thefinalsjpc.GunStatsCamo
import com.shibler.thefinalsjpc.SkinsRarity
import com.shibler.thefinalsjpc.ui.theme.Base
import com.shibler.thefinalsjpc.ui.theme.Gray


@Composable
fun AllItems(onNavigate : () -> Unit, viewModel: SharedViewModel, gunstats: List<GunStatsCamo>?) {

    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Base)
            .verticalScroll(rememberScrollState())

    ) {

        ItemsList(gunstats = gunstats, viewModel = viewModel, onNavigate = onNavigate)
    }
}

@Composable
fun ItemsList(onNavigate : () -> Unit,gunstats: List<GunStatsCamo>?, viewModel: SharedViewModel) {

    if (gunstats != null) {
        for(i in gunstats.indices step 2) {

            var camoList = mutableListOf<SkinsRarity>()
            
            Spacer(modifier = Modifier.height(5.dp))
            
            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Base)
                    .padding(top = 0.dp, start = 5.dp, end = 5.dp)
            ){

                Box (
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp)
                        .background(
                            Gray, CutCornerShape(topEnd = 16.dp, bottomStart = 16.dp)
                        )
                        .weight(1f)
                        .clickable {
                            camoList.clear()
                            camoList.addAll(gunstats[i].skinsCamo.camo)
                            viewModel.updateReloadTime(gunstats[i].reloadTime)
                            viewModel.updateDamagePerBullet(gunstats[i].damagerPerBullet)
                            viewModel.updateCritDamage(gunstats[i].critDamage)
                            viewModel.updateMagSize(gunstats[i].magSize)
                            viewModel.updateIntList(camoList)
                            viewModel.updateName(gunstats[i].name)
                            viewModel.updateDps(gunstats[i].dps)
                            onNavigate()
                        }
                ){
                    Image(painter = painterResource(id = gunstats[i].skinsCamo.camo[1].camo), contentDescription = gunstats[i].name)
                    Text(text = gunstats[i].name,
                        color = Color.White,
                        style = MaterialTheme.typography.headlineMedium,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .padding(start = 2.dp))
                }

                Spacer(modifier = Modifier.width(5.dp))

                if (i+1 < gunstats.size) {
                    Box (
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp)
                            .background(
                                Gray, CutCornerShape(topEnd = 16.dp, bottomStart = 16.dp)
                            )
                            .weight(1f)
                            .clickable {
                                camoList.clear()
                                camoList.addAll(gunstats[i + 1].skinsCamo.camo)
                                viewModel.updateReloadTime(gunstats[i + 1].reloadTime)
                                viewModel.updateDamagePerBullet(gunstats[i + 1].damagerPerBullet)
                                viewModel.updateCritDamage(gunstats[i + 1].critDamage)
                                viewModel.updateMagSize(gunstats[i + 1].magSize)
                                viewModel.updateIntList(camoList)
                                viewModel.updateName(gunstats[i + 1].name)
                                viewModel.updateDps(gunstats[i + 1].dps)
                                onNavigate()
                            }
                    ){
                        Image(painter = painterResource(id = gunstats[i+1].skinsCamo.camo[1].camo), contentDescription = gunstats[i+1].name)
                        Text(text = gunstats[i+1].name,
                            color = Color.White,
                            style = MaterialTheme.typography.headlineMedium,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier
                                .padding(start = 2.dp))
                    }

                } else {
                    Box (
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp)
                            .background(
                                Color.Transparent,
                                CutCornerShape(topEnd = 16.dp, bottomStart = 16.dp)
                            )
                            .weight(1f)
                            .clickable {
                            }
                    )

                }
            }
        }
    }



}