package app.misaghpour.news

import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import app.misaghpour.news.ui.screens.SplashScreen

enum class AppScreen(@StringRes val title: Int) {
    Splash(title = R.string.splash)
}

@Composable
fun NewsApp(
    navController: NavHostController = rememberNavController(),
) {
    NavHost(navController = navController, startDestination = AppScreen.Splash.name) {
        composable(route = AppScreen.Splash.name){
            SplashScreen()
        }
    }
}