package com.example.portrait_of_a_cat

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.portrait_of_a_cat.ui.theme.Portrait_of_a_catTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Portrait_of_a_catTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    PortraitApp("Android")
                }
            }
        }
    }
}

@Composable
fun PortraitApp(name: String) {
    var currentStep by remember { mutableStateOf(1) }
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        when (currentStep) {
            1 -> {
                PortraitAndButton(
                    painterResource = R.drawable.portrait_1,
                    contentDescriptionResource = R.string.image_1,
                    onImageClick = {
                        currentStep = 2
                    }
                )
            }
            2 -> {
                PortraitAndButton(
                    painterResource = R.drawable.portrait_2,
                    contentDescriptionResource = R.string.image_2,
                    onImageClick = {
                        currentStep = 3
                    }
                )
            }
        }
    }
}


@Composable
fun PortraitAndButton(
    painterResource: Int,
    contentDescriptionResource: Int,
    onImageClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(painterResource),
            contentDescription = stringResource(contentDescriptionResource),
            modifier = Modifier
                .wrapContentSize()
                .clickable(
                    onClick = onImageClick
                )
                .border(
                    BorderStroke(3.dp, Color(105, 255, 100))
                )
                .padding(16.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { }) {
            Text(stringResource(R.string.next_button), fontSize = 24.sp)
        }
        Button(onClick = { }) {
            Text(stringResource(R.string.previous_button), fontSize = 24.sp)
        }
    }

}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Portrait_of_a_catTheme {
        PortraitApp("Android")
    }
}

