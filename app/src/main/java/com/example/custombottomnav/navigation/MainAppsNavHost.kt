package com.example.custombottomnav.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.custombottomnav.custom_bottom_nav.CustomBottomBar
import com.example.custombottomnav.custom_bottom_nav.HomeSections

@Composable
fun MainAppsNavHost() {
    val nav = rememberNavController()
    val curretTab = remember {
        mutableStateOf(nav.currentDestination?: HomeSections.FEED.route)
    }
    Scaffold(
        bottomBar = {
            CustomBottomBar(tabs = HomeSections.values(), currentRoute = curretTab.value as String, navigateToRoute = {
                curretTab.value = it
            } )
        }
    ) {
        it
        NavHost(navController = nav, startDestination = HomeSections.SEARCH.route) {
            composable(HomeSections.FEED.route) {
                Screens(text = "Feed")
            }
            composable(HomeSections.SEARCH.route) {
                Screens(text = "Search")
            }
            composable(HomeSections.CART.route) {
                Screens(text = "Test")
            }
            composable(HomeSections.PROFILE.route) {
                Screens(text = "asdfjka")
            }
        }
    }

}


@Composable
fun Screens(text:String = "none") {
    Box(modifier = Modifier.fillMaxSize()){
        Text(text = text , fontSize = 35.sp)
    }
}