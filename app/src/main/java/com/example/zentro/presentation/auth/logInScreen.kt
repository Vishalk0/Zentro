package com.example.zentro.presentation.auth

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.material3.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.zentro.R
import com.example.zentro.navigation.Routes

@Composable

fun LogInScreen(navController: NavController) {
    var email by remember { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Top
    ) {
        Row(
            modifier = Modifier.wrapContentSize(),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.Top
        ) {
            Image(
                painter = painterResource(R.drawable.circle),
                contentDescription = "",
                modifier = Modifier.size(200.dp)
            )
            Spacer(modifier = Modifier.height(20.dp))

        }
        Text(
            "LogIn Page",
            fontSize = 40.sp,
            fontWeight = FontWeight.ExtraBold,
            textAlign = TextAlign.Start,
            modifier = Modifier.padding(horizontal = 10.dp, vertical = 20.dp)
        )


        Spacer(modifier = Modifier.height(70.dp))
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Email") },
                placeholder = { Text("Enter Your Email") },
                singleLine = true,
                leadingIcon = { Icon(Icons.Default.Email, contentDescription = "") },
                modifier = Modifier.fillMaxWidth(0.8f)
            )
            Spacer(modifier = Modifier.height(10.dp))
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text(text = "Password") },
                placeholder = { Text("Password") },
                singleLine = true,
                leadingIcon = { Icon(Icons.Default.Lock, contentDescription = "") },
                modifier = Modifier.fillMaxWidth(0.8f)
            )

            Spacer(modifier = Modifier.height(25.dp))
            Button(
                onClick = { navController.navigate(Routes.HomeScreen) },
                modifier = Modifier.fillMaxWidth(0.5f),
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(colorResource(R.color.Button_color))
            ) {
                Text("Log In", fontSize = 24.sp, fontWeight = FontWeight.Bold, color = Color.White)
            }
            Spacer(modifier = Modifier.height(5.dp))
            Text("OR", fontSize = 20.sp, modifier = Modifier.padding(top = 5.dp))
            HorizontalDivider(
                modifier = Modifier
                    .size(width = 150.dp, height = 0.dp)
                    .align(Alignment.Start)
            )
            HorizontalDivider(
                modifier = Modifier
                    .size(width = 150.dp, height = 0.dp)
                    .align(Alignment.End)
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        Row(modifier = Modifier.fillMaxWidth()) {
            Button(
                onClick = {},
                modifier = Modifier
                    .padding(horizontal = 10.dp)

                    .size(width = 170.dp, height = 50.dp),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(colorResource(R.color.Button_color))
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start
                ) {
                    Icon(
                        painter = painterResource(R.drawable.google),
                        contentDescription = "",
                        modifier = Modifier
                            .size(20.dp)

                    )
                    Text(
                        "Google",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 10.dp)
                    )

                }
            }
            Spacer(modifier = Modifier.width(20.dp))
            Button(
                onClick = {},
                modifier = Modifier

                    .size(width = 170.dp, height = 50.dp),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(colorResource(R.color.Button_color))
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start
                ) {
                    Icon(
                        painter = painterResource(R.drawable.facebook),
                        contentDescription = "",
                        modifier = Modifier
                            .size(24.dp)

                    )
                    Text(
                        "Facebook",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 10.dp)
                    )

                }
            }
        }
        Spacer(modifier = Modifier.height(12.dp))



        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 12.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                "Don't have Account? ",
                fontSize = 12.sp, color = Color.DarkGray,


                )

            Text(
                "Sign In ",
                fontSize = 16.sp,
                fontWeight = FontWeight.ExtraBold, modifier = Modifier.clickable {
                    navController.navigate(Routes.SignInScreen)
                }
            )

        }


    }
}