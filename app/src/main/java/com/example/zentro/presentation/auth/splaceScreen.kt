package com.example.zentro.presentation.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.background

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import com.example.zentro.R
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.zentro.navigation.Routes
import kotlinx.coroutines.delay

@Composable

fun SplaceScreen(navController: NavController) {
  LaunchedEffect(Unit) {
      delay(3000)
      navController.navigate(Routes.WelcomeScreen)
  }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(R.color.BG_color)),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Image(
            painter = painterResource(R.drawable.zlogo),
            contentDescription = "",
            modifier = Modifier
                .size(150.dp)
                .clip(shape = CircleShape)
        )


    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 30.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ) {
        Text(
            "Design By\n Vishal",
            fontSize = 14.sp,
            textAlign = TextAlign.Center,
            color = colorResource(R.color.Button_color)
        )
    }

}