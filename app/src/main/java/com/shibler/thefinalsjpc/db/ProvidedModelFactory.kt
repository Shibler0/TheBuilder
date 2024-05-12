package com.shibler.thefinalsjpc.db

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.platform.LocalContext

val LocalViewModelFactory = staticCompositionLocalOf<MyViewModelFactory> {
    error("No ViewModelFactory provided")
}

@Composable
fun ProvideViewModelFactory(content: @Composable () -> Unit) {
    val itemsDao = MyDatabase.getInstance(context = LocalContext.current).buildDAO
    val viewModelFactory = MyViewModelFactory(Repository(LocalSourceDAO(itemsDao)))
    CompositionLocalProvider(LocalViewModelFactory provides viewModelFactory) {
        content()
    }
}