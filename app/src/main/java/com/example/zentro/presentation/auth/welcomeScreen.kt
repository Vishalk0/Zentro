package com.example.zentro.presentation.auth

import androidx.compose.foundation.Image
import com.example.zentro.R
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.zentro.navigation.Routes

@Composable

fun WelcomeScreen(navController: NavController) {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .padding(0.dp),
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.Start
    ) {
        Image(
            painter = painterResource(R.drawable.circle),
            contentDescription = "",
            modifier = Modifier.size(200.dp)
        )
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 30.dp),
        horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center
    ) {

        Text(
            "WELCOME \n TO",
            textAlign = TextAlign.Center,
            fontSize = 40.sp,
            lineHeight = 60.sp,
            fontWeight = FontWeight.ExtraBold
        )

        Image(
            painter = painterResource(R.drawable.zentro),
            contentDescription = "",
            modifier = Modifier
                .size(250.dp)
                .clip(shape = CircleShape)
        )
        Spacer(modifier = Modifier.height(100.dp))
        Button(
            onClick = {navController.navigate(Routes.LogInScreen)},
            modifier = Modifier
                .height(60.dp)
                .width(200.dp),
            colors = ButtonDefaults.buttonColors(
                colorResource(R.color.Button_color)
            ),
            shape = RoundedCornerShape(12.dp)
        ) {
            Text("Next", fontSize = 26.sp)
        }
    }
}