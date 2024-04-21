package com.example.kotlincomposetutorial

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCompositionContext
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kotlincomposetutorial.ui.button.ButtonActivity
import com.example.kotlincomposetutorial.ui.image.ImageActivity
import com.example.kotlincomposetutorial.ui.theme.KotlinComposeTutorialTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KotlinComposeTutorialTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppScaffold("Compose Component",
                        content = {ComposePreview()}, activity = this)
                }
            }
        }
    }

    @Composable
    fun ComposeComponents(components: List<String>, modifier: Modifier = Modifier) {
        val context = LocalContext.current

        LazyColumn(
            //  verticalArrangement = Arrangement.spacedBy(40.dp),
            modifier = modifier
                .padding(top = 80.dp, bottom = 20.dp, start = 20.dp, end = 20.dp)
                .fillMaxSize()
        ) {
            items(components) {
                ComponentsRow(component = it, onClick = {
                    when(it) {
                        "Text" -> {
                            Toast.makeText(context, "Under development!!!", Toast.LENGTH_SHORT).show()
                        }
                        "Image" -> {
                            context.startActivity(Intent(context, ImageActivity::class.java))
                        }
                        "Button" -> {
                            context.startActivity(Intent(context, ButtonActivity::class.java))
                        }
                        else -> {
                            Toast.makeText(context, "Under development!!!", Toast.LENGTH_SHORT).show()
                        }
                    }
                })
                Divider(
                    color = Color.Gray,
                    thickness = 1.dp,
                    modifier = Modifier.padding(vertical = 20.dp)
                )
            }
        }
    }

    @Composable
    fun ComponentsRow(
        component: String,
        modifier: Modifier = Modifier,
        onClick: (name: String) -> Unit
    ) {
        Text(
            text = component,
            modifier = modifier
                .fillMaxHeight()
                .fillMaxSize()
                .clickable { onClick(component) }
        )
    }

    @Preview(showBackground = true)
    @Composable
    fun ComposePreview() {
        val components = listOf(
            "Text", "Image", "Button",
            "App Bars", "Scaffold", "Floating action button",
            "Card", "Chip", "Dialog", "Slider", "Switch", "Bottom Sheets",
            "Navigation Drawer", "List and Grids"
        )

        KotlinComposeTutorialTheme {
            ComposeComponents(components)
        }
    }
}