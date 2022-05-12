package com.example.tp4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.ZeroCornerSize
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.VisualTransformation
import com.example.tp4.ui.theme.TP4Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TP4Theme {
                // A surface container using the 'background' color from the theme
                navigation()
            }
        }
    }
}

@Composable
fun FirstScreen(navController:NavController) {
    val name = "parametre of first screen"
    Column() {
        Text(
            text = "First Screen",
            style = MaterialTheme.typography.subtitle2,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(all = 30.dp)
        )


        Button(onClick = { navController.navigate("second/$name") }, modifier = Modifier.padding(all = 30.dp)) {
            Text("Click me")

        }


    }
}

@Composable
fun SecondScreen(navController:NavController,name:String?) {
    Column() {
        Text(
            name?: "Prametre Vide",
            style = MaterialTheme.typography.subtitle2,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(all = 30.dp)
        )


        Button(onClick = { navController.navigate("first") }, modifier = Modifier.padding(all = 30.dp)) {
            Text("Click me")

        }
    }
}

@Composable
fun navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "first" ){
        composable(route = "first"){
            FirstScreen(navController)
        }
        composable(route = "second/{pname}", arguments = listOf(navArgument("pname"){type= NavType.StringType})){
            Entry->
            SecondScreen(navController,Entry.arguments?.getString("pname"))
        }
    }
}

@Composable
fun Greeting(name: String) {
    navigation()
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TP4Theme {
        navigation()
    }
}