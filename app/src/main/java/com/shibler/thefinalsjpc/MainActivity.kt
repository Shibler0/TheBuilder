package com.shibler.thefinalsjpc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import androidx.room.Room
import com.shibler.thefinalsjpc.classbuilder.CustomLoadout
import com.shibler.thefinalsjpc.classbuilder.CustomLoadout2
import com.shibler.thefinalsjpc.classbuilder.CustomLoadout3
import com.shibler.thefinalsjpc.db.DatabaseViewModel
import com.shibler.thefinalsjpc.db.MyDatabase
import com.shibler.thefinalsjpc.db.ProvideViewModelFactory
import com.shibler.thefinalsjpc.itemswiki.AllItems
import com.shibler.thefinalsjpc.itemswiki.SharedViewModel
import com.shibler.thefinalsjpc.itemswiki.itemInfos
import com.shibler.thefinalsjpc.navigationbar.BottomNavigationView
import com.shibler.thefinalsjpc.navigationbar.TopNavigation
import com.shibler.thefinalsjpc.ui.theme.Base
import com.shibler.thefinalsjpc.ui.theme.TheFinalsJPCTheme

class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen().apply {
            setKeepOnScreenCondition {
                !viewModel.isReady.value
            }

        }
        setContent {
            Room.databaseBuilder(
                applicationContext,
                MyDatabase::class.java, "my_database"
            ).build()


            TheFinalsJPCTheme {

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    Greeting(viewModel)
                }
            }
        }
    }
}

@Composable
fun Greeting(viewModel: MainViewModel) {

    ProvideViewModelFactory {

        val imagesListHeavy by viewModel.imageResourceHeavy.collectAsState()
        val imagesListMedium by viewModel.imageResourceMedium.collectAsState()
        val imagesListLight by viewModel.imageResourceLight.collectAsState()
        val imageListWeapons by viewModel.imageResourceWeapon.collectAsState()
        val weaponStats by viewModel.weaponStats.collectAsState()

        val navController = rememberNavController()

        val topBarState = rememberSaveable {
            (mutableStateOf(false))
        }

        val navBackStackEntry by navController.currentBackStackEntryAsState()

        when(navBackStackEntry?.destination?.route) {
            "Loadout" -> {
                topBarState.value = true
            }
            "Loadout2" -> {
                topBarState.value = true
            }
            "Loadout3" -> {
                topBarState.value = true
            }
            else -> topBarState.value = false
        }


        Scaffold (
            bottomBar = { BottomNavigationView(navController) },
            topBar = {
                TopNavigation(
                    navController = navController,
                    topBarState = topBarState
                )
            }
        ) { padding ->

            Column (
                modifier = Modifier
                    .padding(padding)
            ) {

                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Base)
                ) {

                    NavHost(navController = navController, startDestination = "Loadout") {
                        composable("Loadout") { CustomLoadout(imagesListHeavy) }


                        composable("Loadout2") {
                            CustomLoadout2(imagesListMedium)
                        }
                        composable("Loadout3") {
                            CustomLoadout3(imagesListLight)
                        }
                        composable("Shop") {
                            Shop()
                        }
                        composable("Settings") {
                            PatchNote()
                        }

                        navigation(
                            startDestination = "Items",
                            route = "Allitems"
                        ){
                            composable("Items") {
                                    entry ->

                                val viewModelShared = entry.sharedViewModel<SharedViewModel>(navController)


                                AllItems(
                                    onNavigate = {
                                        navController.navigate("ItemsInfos")
                                    },
                                    viewModel = viewModelShared,
                                    gunstats = weaponStats
                                )
                            }
                            composable("ItemsInfos") {
                                    entry ->

                                val viewModels = entry.sharedViewModel<SharedViewModel>(navController)
                                val skinsList by viewModels.intList.collectAsState()
                                val weaponName by viewModels.stringName.collectAsState()
                                val dps by viewModels.intDps.collectAsState()
                                val magSize: Int by viewModels.intMagSize.collectAsState()
                                val critDamage by viewModels.intCritDamage.collectAsState()
                                val damagePerBullet by viewModels.intDamagePerBullet.collectAsState()
                                val reloadTime by viewModels.doubleReloadTime.collectAsState()

                                itemInfos(
                                    camos = skinsList,
                                    weaponName = weaponName,
                                    dps = dps,
                                    navController = navController,
                                    magSize = magSize,
                                    critDamage = critDamage,
                                    damagePerBullet = damagePerBullet,
                                    reloadTime = reloadTime
                                )
                            }
                        }


                    }
                }

            }

        }
    }


}

@Composable
inline fun <reified T : ViewModel> NavBackStackEntry.sharedViewModel(navController: NavController,): T {

    val navGraphRoute = destination.parent?.route ?: return viewModel()
    val parentEntry = remember(this) {
        navController.getBackStackEntry(navGraphRoute)
    }
    return viewModel(parentEntry)
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TheFinalsJPCTheme {
        Greeting(MainViewModel())
    }
}