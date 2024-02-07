package com.example.firebase_auth.ui.theme.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.firebase_auth.data.Productviewmodel
import com.example.firebase_auth.navigation.ROUTE_ADD_PRODUCTS
import com.example.firebase_auth.navigation.ROUTE_UPDATE_PRODUCTS
import com.example.firebase_auth.navigation.ROUTE_VIEW_PRODUCTS

@Composable
fun Homescreen(navController: NavHostController){
    var context = LocalContext.current
    var productdata = Productviewmodel(navController,context)
    Column (
        modifier= Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        Text(text = "Welcome to home page")

        Button(onClick = {navController.navigate(ROUTE_ADD_PRODUCTS)}) {
            Text(text = "add products")
        }
        Button(onClick = {navController.navigate(ROUTE_UPDATE_PRODUCTS)}) {
            Text(text = "update products")
        }
        Button(onClick = {navController.navigate(ROUTE_VIEW_PRODUCTS)}) {
            Text(text = "add products")
        }
    }

}
@Preview
@Composable
fun Previewhome(){
    Homescreen(rememberNavController())
}