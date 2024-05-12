package com.shibler.thefinalsjpc.classbuilder

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.shibler.thefinalsjpc.db.BuildEntity
import com.shibler.thefinalsjpc.db.LocalViewModelFactory
import com.shibler.thefinalsjpc.db.DatabaseViewModel
import com.shibler.thefinalsjpc.db.ItemData
import com.shibler.thefinalsjpc.ui.theme.Base
import com.shibler.thefinalsjpc.ui.theme.BaseClear
import com.shibler.thefinalsjpc.ui.theme.backgroundColor
import kotlinx.coroutines.launch

@SuppressLint("UnusedBoxWithConstraintsScope")
@Composable
fun CustomLoadout(images: List<ItemData?>?) {

    var selectedImages:SnapshotStateList<ItemData> = remember { mutableStateListOf() }

    val coroutineScope = rememberCoroutineScope()

    val viewModelFactory = LocalViewModelFactory.current

    val viewModel: DatabaseViewModel = viewModelFactory.create(DatabaseViewModel::class.java)

    val sorted = images?.sortedBy {
        when (it?.type) {
            0 -> 1
            1 -> 2
            2 -> 3
            else -> 4
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 30.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        BuildSaver(selectedImages)

        Spacer(modifier = Modifier.height(10.dp))

        Column(
            verticalArrangement = Arrangement.Bottom
        ) {

            Text(text = "Your build :", color = Color.White)

            Row(
                verticalAlignment = Alignment.Bottom
            ) {

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
                            selectedImages.remove(item)
                            coroutineScope.launch {
                                item.text?.let { viewModel.delete(it) }
                            }
                        }


                    }

                }

            }

        }


        Spacer(
            modifier = Modifier
                .height(10.dp)
                .background(backgroundColor)
        )

        Box(
            modifier = Modifier
                .background(backgroundColor)
                .padding(0.dp)
                .fillMaxSize(),
        ) {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp, bottom = 10.dp)
                    .verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.CenterHorizontally

            ) {

                if (sorted != null) {
                    RowOfItems(items = sorted, startIndex = 0, endIndex = 4,selectedImages = selectedImages, onItemClick = {})
                    Spacer(modifier = Modifier.height(4.dp))
                    RowOfItems(items = sorted, startIndex = 4, endIndex = 8,selectedImages = selectedImages, onItemClick = {})
                    Spacer(modifier = Modifier.height(4.dp))
                    RowOfItems(items = sorted, startIndex = 8, endIndex = 12,selectedImages = selectedImages, onItemClick = {})
                    Spacer(modifier = Modifier.height(4.dp))
                    RowOfItems(items = sorted, startIndex = 12, endIndex = 16,selectedImages = selectedImages, onItemClick = {})
                    Spacer(modifier = Modifier.height(4.dp))
                    RowOfItems(items = sorted, startIndex = 16, endIndex = 18,selectedImages = selectedImages, onItemClick = {})
                }

            }

        }

    }

}

fun limitOfItems (picturesList: List<ItemData>): List<Boolean> {

    val listOfImages: MutableList<Boolean> = mutableListOf()

    val limitSpecializationToOne = picturesList.any { it.type == 0}
    val limitWeaponToOne = picturesList.any { it.type == 1}
    val limitGadgetsToFour = picturesList.count { it.type == 2} == 4

    if(limitSpecializationToOne) {
        listOfImages.add(0, true)
    } else {
        listOfImages.add(0,false)
    }
    if(limitWeaponToOne) {
        listOfImages.add(1, true)
    } else {
        listOfImages.add(1, false)
    }
    if(limitGadgetsToFour) {
        listOfImages.add(2, true)
    } else {
        listOfImages.add(2, false)
    }

    return listOfImages
}

@SuppressLint("MutableCollectionMutableState", "CoroutineCreationDuringComposition")
@Composable
fun RowOfItems(
    items: List<ItemData?>?,
    startIndex: Int,
    endIndex: Int,
    onItemClick: () -> Unit,
    selectedImages:SnapshotStateList<ItemData>
) {

    val coroutineScope = rememberCoroutineScope()

    val viewModelFactory = LocalViewModelFactory.current

    val viewModel: DatabaseViewModel = viewModelFactory.create(DatabaseViewModel::class.java)

    var classNumber = 1


    coroutineScope.launch {
        val v = viewModel.getAllClassNumber()

        if(v.isEmpty()) {
            return@launch
        }
        classNumber = v.size + 1
    }


    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        val limitItemsList = limitOfItems(selectedImages)

        for (i in startIndex until  endIndex) {

            Spacer(modifier = Modifier.width(4.dp))


            val item = items?.getOrNull(i)


            item?.let {
                Item(itemData = item, onClick = {

                    if(selectedImages.contains(item)) {
                        return@Item
                    }

                    if(limitItemsList[0] && item.type == 0) {
                        return@Item
                    }
                    if(limitItemsList[1] && item.type == 1) {
                        return@Item
                    }
                    if(limitItemsList[2] && item.type == 2) {
                        return@Item
                    }



                    if(selectedImages.isEmpty()) {

                        selectedImages.add(item)

                    }else if (selectedImages.size == 1) {

                        when(item.type) {
                            0 -> selectedImages.add(0,item)
                            1 -> selectedImages.add(1, item)
                            2 -> selectedImages.add(selectedImages.size, item)
                        }

                    }else if (selectedImages.size > 1) {

                        when(item.type) {
                            0 -> selectedImages.add(0,item)
                            1 -> selectedImages.add(1, item)
                            2 -> selectedImages.add(selectedImages.size, item)
                        }
                    }

                    if(selectedImages.size == 6) {
                        coroutineScope.launch {
                            item.text?.let { it1 -> BuildEntity(it1, classNumber,selectedImages) }
                                ?.let { it2 -> viewModel.insert(it2) }

                        }
                    }

                    onItemClick()
                })
            }
        }
    }
}

@SuppressLint("UnrememberedMutableState")
@Composable
fun BuildSaver(selectedImages:SnapshotStateList<ItemData>) {

    Row (
        modifier = Modifier
            .fillMaxWidth()
            .background(Base),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ){

        val coroutineScope = rememberCoroutineScope()

        val viewModelFactory = LocalViewModelFactory.current

        val viewModel: DatabaseViewModel = viewModelFactory.create(DatabaseViewModel::class.java)

        val local = LocalContext.current

        var items: List<ItemData>

        for(i in 1 until 6) {

            var isSelected by remember {
                mutableStateOf(false)
            }

            LazyColumn(
                modifier = Modifier
                    .height(40.dp)
                    .width(40.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(
                        if (isSelected) {
                            Color.Yellow
                        } else {
                            BaseClear
                        }
                    )
                    .clickable {
                        coroutineScope.launch {
                            items = viewModel.getListWithClassNumber(i)
                            //selectedImages.clear()
                            //selectedImages.addAll(items)
                            Toast.makeText(local, ""+viewModel.getListWithClassNumber(i), Toast.LENGTH_SHORT).show()
                        }
                        isSelected = !isSelected
                    }
                    .border(width = 2.dp, shape = RoundedCornerShape(10.dp), color = Color.Black),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center

            ) {
                item {
                    Text(text = "$i",
                        color = Color.Black
                    )
                }
            }

        }

    }
}
