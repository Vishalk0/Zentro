package com.example.zentro.presentation.screens

import android.graphics.Color
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.zentro.R
import com.example.zentro.navigation.Routes
import com.example.zentro.presentation.BottomNav

@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun ProfileScreen(navController: NavHostController) {
    var search by remember { mutableStateOf("") }
    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        topBar = {
            TopAppBar(
                title = { Text("Profile") },
                navigationIcon = {
                    IconButton(onClick = {}) {
                        Icon(
                            Icons.Default.Menu,
                            contentDescription = "",
                            modifier = Modifier.size(24.dp)
                        )
                    }
                },
                modifier = Modifier.padding(),
                colors = TopAppBarDefaults.topAppBarColors(
                    colorResource(R.color.Button_color),
                )

            )
        }, bottomBar = {

            BottomNav(navHostController=navController , selectedItem = 0, onClick = { index ->
                when(index){
                    0->{navController.navigate(Routes.HomeScreen)}
                    1->{navController.navigate(Routes.FavScreen)}
                    2->{navController.navigate(Routes.CartScreen)}
                    3->{navController.navigate(Routes.ProfileScreen )}
                }
            })
        }
    ){
        Column (modifier = Modifier.padding(paddingValues = it).fillMaxSize()){
            Column(modifier = Modifier.fillMaxSize()) {
                Spacer(modifier = Modifier.height(80.dp))
                Box(
                    modifier = Modifier
                        .size(160.dp, 180.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .background(androidx.compose.ui.graphics.Color.Gray)
                        .align(Alignment.CenterHorizontally)
                ) {
                    //
                }

                Spacer(modifier = Modifier.height(40.dp))

                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    TextField(value = "", onValueChange = { "" }, modifier = Modifier.fillMaxWidth(0.8f))
                    Spacer(modifier = Modifier.height(18.dp))
                    TextField(value = "", onValueChange = { "" }, modifier = Modifier.fillMaxWidth(0.8f))
                    Spacer(modifier = Modifier.height(18.dp))
                    TextField(value = "", onValueChange = { "" }, modifier = Modifier.fillMaxWidth(0.8f))
                    Spacer(modifier = Modifier.height(18.dp))
                    TextField(value = "", onValueChange = { "" }, modifier = Modifier.fillMaxWidth(0.8f))
                    Spacer(modifier = Modifier.height(48.dp))
                    Button(
                        onClick = {},
                        modifier = Modifier.fillMaxWidth(0.6f).clip(shape = RoundedCornerShape(10.dp)), shape = RectangleShape,
                        colors = ButtonDefaults.buttonColors(
                            colorResource(
                                R.color.Button_color
                            )
                        )
                    ) {
                        Text("Logout", fontSize = 26.sp, fontWeight = FontWeight.Bold)
                    }
                }


            }
        }
        }
    }


