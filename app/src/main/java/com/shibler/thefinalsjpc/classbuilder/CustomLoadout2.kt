package com.shibler.thefinalsjpc.classbuilder

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.shibler.thefinalsjpc.db.DatabaseViewModel
import com.shibler.thefinalsjpc.db.ItemData
import com.shibler.thefinalsjpc.db.LocalViewModelFactory
import com.shibler.thefinalsjpc.ui.theme.backgroundColor
import kotlinx.coroutines.launch

@SuppressLint("UnusedBoxWithConstraintsScope")
@Composable
fun CustomLoadout2(images : List<ItemData?>?) {

    val selectedImages = remember { mutableStateListOf<ItemData>() }


    val coroutineScope = rememberCoroutineScope()

    val viewModelFactory = LocalViewModelFactory.current

    val viewModel: DatabaseViewModel = viewModelFactory.create(DatabaseViewModel::class.java)

    val sorted = images?.sortedBy { when(it?.type) {
        0 -> 1
        1 -> 2
        2 -> 3
        else -> 4
    } }


    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 30.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(modifier = Modifier.height(10.dp))

        Column(
            verticalArrangement = Arrangement.Bottom
        ) {

            Text(text = "Your build :", color = Color.White)

            Row (
                verticalAlignment = Alignment.Bottom
            ){

                LazyRow(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(backgroundColor)
                        .height(100.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    items(selectedImages) { item ->

                        Spacer(modifier = Modifier.width(4.dp))

                        Item(itemData = item) {
                            coroutineScope.launch {
                                item.text?.let { viewModel.delete(it) }
                            }
                            selectedImages.remove(item)
                        }
                        

                    }

                }

            }

        }
        
        Spacer(modifier = Modifier
            .height(10.dp)
            .background(backgroundColor))


        Box(
            modifier = Modifier
                .background(backgroundColor)
                .padding(0.dp)
                .fillMaxSize(),
        ) {

            Column (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp, bottom = 10.dp)
                    .verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.CenterHorizontally

            ) {

                if(sorted != null) {
                    RowOfItems(items = sorted, startIndex = 0, endIndex = 4,selectedImages = selectedImages, onItemClick = {})
                    Spacer(modifier = Modifier.height(4.dp))
                    RowOfItems(items = sorted, startIndex = 4, endIndex = 8,selectedImages = selectedImages, onItemClick = {})
                    Spacer(modifier = Modifier.height(4.dp))
                    RowOfItems(items = sorted, startIndex = 8, endIndex = 12,selectedImages = selectedImages, onItemClick = {})
                    Spacer(modifier = Modifier.height(4.dp))
                    RowOfItems(items = sorted, startIndex = 12, endIndex = 16,selectedImages = selectedImages, onItemClick = {})
                    Spacer(modifier = Modifier.height(4.dp))
                    RowOfItems(items = sorted, startIndex = 16, endIndex = 20,selectedImages = selectedImages, onItemClick = {})
                    Spacer(modifier = Modifier.height(4.dp))
                    RowOfItems(items = sorted, startIndex = 20, endIndex = 22,selectedImages = selectedImages, onItemClick = {})
                }

            }



        }


    }

}