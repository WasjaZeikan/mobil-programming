package com.example.mobil_programming

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.tooling.preview.Preview
import com.example.mobil_programming.ui.theme.MobilprogrammingTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MobilprogrammingTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
    val label = mutableStateOf("Вітаю у лабораторній 1")
    @Composable
    fun Greeting(modifier: Modifier = Modifier) {
        var painter = painterResource(R.drawable.images)
        var text by label
        var context = LocalContext.current
        Column (verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally) {
            Image(painter = painter, contentDescription = "Кіт",
                modifier = Modifier.clickable { label.value = "Кіт"})
            ClickableText(text = AnnotatedString(text),
                onClick = {
                    if (text == "Кіт") {
                        var intent = Intent(context, MainActivity2().javaClass)
                        context.startActivity(intent)
                    } else {
                        label.value = "Спочатку натисніть на картинку а потім на цей текст"
                    }
                })
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        MobilprogrammingTheme {
            Column {
                Text(text = "Cat")
                Greeting()
            }
        }
    }
}

