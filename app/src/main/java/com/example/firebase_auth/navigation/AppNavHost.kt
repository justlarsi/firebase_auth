package com.example.firebase_auth.navigation
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.firebase_auth.ui.theme.products.AddProductsScreen
import com.example.firebase_auth.ui.theme.products.UpdateProductsScreen
import com.example.firebase_auth.ui.theme.products.ViewProductsScreen
import com.example.firebase_auth.ui.theme.screens.about.Aboutscreen
import com.example.firebase_auth.ui.theme.screens.home.Homescreen
import com.example.firebase_auth.ui.theme.screens.login.LoginScreen
import com.example.firebase_auth.ui.theme.screens.register.RegisterScreen
@Composable
fun AppNavHost(modifier: Modifier=Modifier,navController:NavHostController= rememberNavController(),startDestination:String= ROUTE_LOGIN) {
    NavHost(navController = navController, modifier=Modifier, startDestination=startDestination){
        composable(ROUTE_LOGIN){
            LoginScreen(navController)
        }
        composable(ROUTE_REGISTER){
            RegisterScreen(navController)
        }
        composable(ROUTE_ABOUT){
            Aboutscreen(navController)
        }
        composable(ROUTE_HOME) {
            Homescreen(navController)
        }
        composable(ROUTE_ADD_PRODUCTS) {
            AddProductsScreen(navController)
        }
        composable(ROUTE_UPDATE_PRODUCTS) {passedData->
            UpdateProductsScreen(navController,passedData.arguments?.getString("id")!!)
        }
        composable(ROUTE_VIEW_PRODUCTS) {
            ViewProductsScreen(navController)
        }
    }
}