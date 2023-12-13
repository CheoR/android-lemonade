package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.expandHorizontally
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Screen()
                }
            }
        }
    }
}

@Composable
fun Screen(modifier: Modifier = Modifier) {
    var currentStep by remember { mutableStateOf(1) }
    var squeezeCount by remember { mutableStateOf(0) }
    when (currentStep) {
        1 -> {
            LemonTextAndImage(
                textLabelResourceId = R.string.select_lemon,
                drawableResourceId = R.drawable.lemon_tree,
                contentDescriptionResourceId = R.string.select_lemon,
                onImageClick = {
                    currentStep = 2
                    squeezeCount = (2..4).random()
                }
            )
        }
        2 -> {
            LemonTextAndImage(
                textLabelResourceId = R.string.squeeze_lemon,
                drawableResourceId = R.drawable.lemon_squeeze,
                contentDescriptionResourceId = R.string.squeeze_lemon,
                onImageClick = {
                    squeezeCount--
                    if (squeezeCount == 0) {
                        currentStep = 3
                    }
                }
            )
        }

        3 -> {
            LemonTextAndImage(
                textLabelResourceId = R.string.drink_lemonade,
                drawableResourceId = R.drawable.lemon_drink,
                contentDescriptionResourceId = R.string.drink_lemonade,
                onImageClick = {
                    currentStep = 4
                }
            )
        }
        4 -> {
            LemonTextAndImage(
                textLabelResourceId = R.string.empty_glass,
                drawableResourceId = R.drawable.lemon_restart,
                contentDescriptionResourceId = R.string.empty_glass,
                onImageClick = {
                    currentStep = 1
                }
            )
        }
    }

}

@Composable
fun LemonTextAndImage(
    textLabelResourceId: Int,
    drawableResourceId: Int,
    contentDescriptionResourceId: Int,
    onImageClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .background(Color.Red)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize().background(Color.LightGray)
        ) {
            Button(
                onClick = onImageClick,
                shape = RoundedCornerShape(40.dp),
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.tertiaryContainer)
            ) {
                Image(
                    painter = painterResource(drawableResourceId),
                    contentDescription = stringResource(contentDescriptionResourceId),
                    modifier = Modifier
                        .width(128.dp)
                        .height(160.dp)
                        .padding(24.dp)
                )
            }
            Spacer(modifier = Modifier.height(32.dp))
            Text(
                text = stringResource(textLabelResourceId),
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}


@Composable
fun Heading(
    modifier: Modifier = Modifier
        .background(color = Color.Yellow)
        .padding(8.dp),
    ) {
    Text(
        text = "Lemonade",
        modifier = modifier
    )
}

@Composable
fun ImageAndText(
    modifier: Modifier = Modifier
        .background(color = Color.Red)
        .padding(
            16.dp
        ),
) {
    var image = painterResource(R.drawable.lemon_tree)

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween,
    ) {
        Image(
            painter = image,
            contentDescription = "tree",
        )
        Spacer(
            modifier = Modifier
                .height(16.dp),
        )
        Text(
            text = stringResource(R.string.lemon_tree),
            fontSize = 32.sp,
        )
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview(modifier: Modifier = Modifier) {
    LemonadeTheme {
        Screen()
    }
}
