package com.example.kotlincomposetutorial.ui.button

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kotlincomposetutorial.AppScaffold
import com.example.kotlincomposetutorial.ui.theme.KotlinComposeTutorialTheme

class ButtonActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KotlinComposeTutorialTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppScaffold("Button Component",
                        content = {content("Android") }, activity = this)
                }
            }
        }
    }

    @Composable
    fun content(name: String, modifier: Modifier = Modifier) {
        val context = LocalContext.current
        var buttonText by remember { mutableStateOf("Buttton") }

        Column(
            verticalArrangement = Arrangement.Top,
            modifier = Modifier
                .fillMaxSize()
                .padding(50.dp)
                .wrapContentHeight()


        ) {
            Button(
                onClick = {
                    buttonText = "Hello you clicked me!!"
                    Toast.makeText(context, "Clicked: Normal Button", Toast.LENGTH_SHORT).show()
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),

                elevation = ButtonDefaults.buttonElevation(pressedElevation = 20.dp),
                colors = ButtonDefaults.buttonColors(
                    contentColor = Color.Yellow,
                    containerColor = Color.Black,
                ),
            ) {
                Text(buttonText)
            }
            FilledTonalButton(
                onClick = {
                    Toast.makeText(context, "Clicked: Filled Tonal Button", Toast.LENGTH_SHORT)
                        .show()

                }, modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
            ) {
                Text("FilledTonalButton")
            }

            OutlinedButton(
                onClick = {
                    Toast.makeText(context, "Clicked: Outlined Button", Toast.LENGTH_SHORT).show()
                }, modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
            ) {
                Text("OutlinedButton")
            }

            ElevatedButton(
                onClick = {
                    Toast.makeText(context, "Clicked: Elevated Button", Toast.LENGTH_SHORT).show()

                }, modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
            ) {
                Text("ElevatedButton")
            }

            TextButton(
                onClick = {
                    Toast.makeText(context, "Clicked: Text Button", Toast.LENGTH_SHORT).show()

                }, modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
            ) {
                Text("TextButton")
            }
        }

    }

    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        KotlinComposeTutorialTheme {
            content("Android")
        }
    }
}