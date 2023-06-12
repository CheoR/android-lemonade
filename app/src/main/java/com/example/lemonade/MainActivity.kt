package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.expandHorizontally
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
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
    when (currentStep) {
        1 -> {
            Column (
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxSize()
            ){
                Text(text = stringResource(R.string.lemon_tree))
                Spacer(modifier = Modifier.height(32.dp))
                Image(
                    painter = painterResource(R.drawable.lemon_tree),
                    contentDescription = stringResource(R.string.lemon_tree),
                    modifier = Modifier
                        .wrapContentSize()
                        .clickable {
                            currentStep = 2
                        }
                )
            }
        }
        2 -> {
            Column (
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxSize()
            ){
                Text(text = stringResource(R.string.squeeze_lemon))
                Spacer(modifier = Modifier.height(32
                    .dp))
                Image(
                    painter = painterResource(R.drawable.lemon_squeeze),
                    contentDescription = stringResource(R.string.squeeze_lemon),
                    modifier = Modifier.wrapContentSize()
                )
            }
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



//Increase the font size of the text so that it's larger than the default font size (such as 18sp).
//Add additional space in between the text label and the image below it, so they're not too close to each other (such as 16dp).
//Give the button an accent color and slightly rounded corners to let the users know that they can tap the image.


//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContent {
//            DiceRollerTheme {
//                DiceRollerApp()
//            }
//        }
//    }
//}
//
//@Preview
//@Composable
//fun DiceRollerApp() {
//    DiceWithButtonAndImage()
//}
//
//@Composable
//fun DiceWithButtonAndImage(
//    modifier: Modifier = Modifier
//        .fillMaxSize()
//        .wrapContentSize(Alignment.Center),
//) {
//    // mutableStateOf - rerender on state change
//    // remember - composable
//    var result by remember { mutableStateOf(1) }
//
//    val imageResource = when (result) {
//        1 -> R.drawable.dice_1
//        2 -> R.drawable.dice_2
//        3 -> R.drawable.dice_3
//        4 -> R.drawable.dice_4
//        5 -> R.drawable.dice_5
//        else -> R.drawable.dice_6
//    }
//
//    Column(
//        modifier=modifier,
//        horizontalAlignment = Alignment.CenterHorizontally,
//    ) {
//
//        Image(
//            painter = painterResource(id = imageResource),
//            contentDescription = result.toString()
//        )
//
//        Spacer(modifier = Modifier.height(16.dp))
//
//        Button(onClick = { result = (1..6).random()  }) {
//            Text(stringResource(R.string.roll))
//        }
//
//    }
//
//}
