package com.example.kotlincomposetutorial.ui.image

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.kotlincomposetutorial.R
import com.example.kotlincomposetutorial.ui.theme.KotlinComposeTutorialTheme

class ImageActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KotlinComposeTutorialTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting2("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting2(name: String, modifier: Modifier = Modifier) {

    val context = LocalContext.current
    var buttonText by remember { mutableStateOf("Buttton") }

    Column(
        verticalArrangement = Arrangement.Top,
        modifier = Modifier
            .fillMaxSize()
            .padding(50.dp)
            .wrapContentHeight()


    ) {
        Image(painter = painterResource(id = R.drawable.ic_launcher_foreground) ,
            contentDescription = "Test Image",
            modifier = Modifier
                .padding(10.dp),)

        AsyncImage(
            model = "https://images.pexels.com/photos/56866/garden-rose-red-pink-56866.jpeg?auto=compress&cs=tinysrgb&w=1200",
            contentDescription = "Translated description of what the image contains",
            modifier = Modifier
                .padding(10.dp),
        )

        Icon(
            painter = painterResource(androidx.core.R.drawable.ic_call_answer),
            contentDescription = stringResource(id = R.string.app_name),
            modifier = Modifier
                .padding(10.dp),
        )

        Image(
            painter = painterResource(id = R.drawable.test),
            contentDescription = "test",
            contentScale = ContentScale.Crop,
            modifier = Modifier.size(150.dp).clip(
                RoundedCornerShape(16.dp)))
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    KotlinComposeTutorialTheme {
        Greeting2("Android")
    }
}