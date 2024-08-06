package com.example.mycustomcard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mycustomcard.ui.theme.MyCustomCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyCustomCardTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xFFc7f1c2)
                ) {
                    MyCustomGrid()
                }
            }
        }
    }
}


@Composable
fun MyCustomGrid() {
    Column (
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row {
            Surface(
                color = Color(0xFF092418)
            ) {
                Image(
                    painter = painterResource(R.drawable.android_logo),
                    contentScale = ContentScale.Crop,
                    contentDescription = "Android logotype",
                    alignment = Alignment.Center,
                    modifier = Modifier
                        .size(90.dp)
                        .padding(10.dp),
                )
            }
        }

        MyCustomCard(
            name = stringResource(R.string.custonName),
            role = stringResource(R.string.custonRole)
        )
    }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Row(
            modifier = Modifier
                .padding(bottom = 12.dp, start = 100.dp)
                .fillMaxWidth()
        ) {
           MyCustomIcon(Icons.Filled.Call, "Call icon")
           Spacer(modifier = Modifier.padding(14.dp))
           MyCustomText(stringResource(R.string.customPhone))

        }
        Row(
            modifier = Modifier
                .padding(bottom = 12.dp, start = 100.dp)
                .fillMaxWidth()
        ) {
            MyCustomIcon(Icons.Default.Share, "Share icon")
            Spacer(modifier = Modifier.padding(14.dp))
            MyCustomText(stringResource(R.string.customSocial))
        }
        Row(
            modifier = Modifier
                .padding(bottom = 12.dp, start = 100.dp)
                .fillMaxWidth()
        ) {
            MyCustomIcon(Icons.Default.Email, "Email icon")
            Spacer(modifier = Modifier.padding(14.dp))
            MyCustomText(stringResource(R.string.customEmail))
        }
    }
}

@Composable
fun MyCustomCard(name: String, role: String) {
    Text(
        text = name,
        style = MaterialTheme.typography.headlineLarge
    )
    Text(
        text = role,
        style = MaterialTheme.typography.titleMedium,
        color = Color(0xFF005227)
    )
}

@Composable
fun MyCustomText(txt: String){
    Text(
        text = txt,
        fontSize = 14.sp,
    )
}

@Composable
fun MyCustomIcon(iv: ImageVector, description: String) {
    Icon(
        imageVector = iv,
        contentDescription = description,
        tint = Color(0xFF005227)
    )
}

