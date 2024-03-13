package app.misaghpour.news

import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import app.misaghpour.news.ui.screens.SplashScreen
import app.misaghpour.news.ui.screens.home.HomeScreen

enum class AppScreen(@StringRes val title: Int) {
    Splash(title = R.string.splash),
    Home(title = R.string.home)
}

@Composable
fun NewsApp(
    navController: NavHostController = rememberNavController(),
) {
    NavHost(navController = navController, startDestination = AppScreen.Splash.name) {
        composable(route = AppScreen.Splash.name) {
            SplashScreen(navigateToNextScreen = {
                navController.navigate(AppScreen.Home.name) {
                    popUpTo(AppScreen.Splash.name) {
                        inclusive = true
                    }
                }
            })
        }

        composable(route = AppScreen.Home.name){
            HomeScreen()
        }
    }
}