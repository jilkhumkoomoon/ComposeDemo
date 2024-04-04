package com.moon.composedemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //PreviewMessageCard()
            //SimpleFilledTextFieldScreen()
            OutlinedTextFieldScreen()
        }
    }
}

@Composable
fun SimpleFilledTextFieldScreen() {
    var text by remember {
        mutableStateOf("")
    }
    TextField(
        value = text,
        onValueChange = {
            text = it
        }
    )
}

@Composable
fun OutlinedTextFieldScreen() {
    var text by remember {
        mutableStateOf("")
    }
    OutlinedTextField(
        value = text,
        onValueChange = {
            text = it
        },
        label = {Text("label")}

    )
}

//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//    Text(
//        text = "Hello $name!",
//        modifier = modifier
//    )
//}

//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    ComposeDemoTheme {
//        Greeting("Android")
//    }
//}

data class Message(val author: String, val body: String)

@Preview
@Composable
fun PreviewMessageCard() {
    MessageCard(
        msg = Message("Hello Compose ", "I am lovelychubby")
    )
}

@Composable
fun MessageCard(msg: Message) {
    var isExpanded by remember { mutableStateOf(false) }
    Row(
        // 在我们的 Card 周围添加 padding、圆角、阴影
        modifier = Modifier
            .padding(all = 2.dp)
            .clip(RoundedCornerShape(10.dp))
            .shadow(1.dp)
            .clickable { isExpanded = !isExpanded }
    ) {
        Image(
            painterResource(id = R.drawable.dog),
            contentDescription = "profile picture",
            modifier = Modifier
                .size(50.dp) // 改变 Image 元素的大小
                .clip(CircleShape) // 将图片裁剪成圆形
                .align(alignment = Alignment.CenterVertically)// 对齐方式垂直居中
        )
        // 添加一个空的控件用来填充水平间距，设置 padding 为 8.dp
        Spacer(Modifier.padding(horizontal = 8.dp))
        Column {
            Text(text = msg.author)
            Spacer(Modifier.padding(vertical = 4.dp))
            Text(maxLines = if (isExpanded) Int.MAX_VALUE else 1,
                modifier = Modifier.animateContentSize(),
                text = msg.body)
        }
    }
}