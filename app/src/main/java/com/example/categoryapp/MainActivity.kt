package com.example.categoryapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.categoryapp.screen.CategoryScreen
import com.example.categoryapp.screen.DetailScreen
import com.example.categoryapp.ui.theme.CategoryAppTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    //Dagger2  inject 0 to last
    //Hilt
    //Koin
    //MVC model view controller
    //MVP model view presenter
    //MVVM model view viewModel

    //UI screen -> viewMOdel -> repositiry [ -> localdatbase else
    //                                     [->   serverAPI

    //MVI model view intent ->   reduxe -> react native ->  AcycleGraph
    //vipper


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        setContent {
            CategoryAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    // CategoryScreen()
                    // DetailScreen()

                    // mainApp()

                    launchApp()
                }
            }
        }
    }
}

@Composable
fun launchApp() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "categoryScreen") {
        composable(route = "categoryScreen") {
            CategoryScreen {
                navController.navigate("detail/$it")
            }
        }
        composable(route = "detail/{category}", arguments = listOf(
            navArgument(name = "category") {
                type = NavType.StringType
            }
        )) {
            val category = it.arguments?.getString("category")
            DetailScreen(category = category?:"")
        }
    }
}

@Composable
fun mainApp() {

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "Login") {
        composable(route = "Login") {
            Login { name, email ->
                navController.navigate("Registration/$name/$email")
            }
            // DetailScreen()
        }
        composable(
            route = "Registration/{name}/{email}", arguments = listOf(
                navArgument("name") { type = NavType.StringType },
                navArgument("email") { type = NavType.StringType }
            )
        )
        {
            val name = it.arguments?.getString("name")
            val email = it.arguments?.getString("email")
            registartion(name = name ?: "NA", email = email)
        }

    }

}

@Composable
fun Login(modifier: Modifier = Modifier, onclick: (name: String, email: String) -> Unit) {
    Text(
        text = "Login!",
        modifier = modifier.clickable { onclick("Orio", "rahul@gmail.com") }
    )
}

@Composable
fun registartion(modifier: Modifier = Modifier, name: String, email: String?) {
    Text(
        text = "Registration! .. $name .. $email",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CategoryAppTheme {

    }
}