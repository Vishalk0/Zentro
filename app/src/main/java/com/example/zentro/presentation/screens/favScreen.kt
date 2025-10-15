package com.example.zentro.presentation.screens

import android.graphics.Color
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardElevation
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.zentro.R
import com.example.zentro.navigation.Routes
import com.example.zentro.presentation.BottomNav
import com.example.zentro.viewModal.CardViewModal

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FavScreen(navController: NavHostController, viewModal: CardViewModal = viewModel()) {
    val favItems by viewModal.favItem.collectAsState()

    var search by remember { mutableStateOf("") }
    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        topBar = {
            TopAppBar(
                title = { Text("Fav") },
                navigationIcon = {
                    IconButton(onClick = {}) {
                        Icon(
                            Icons.Default.Menu,
                            contentDescription = "Menu",
                            modifier = Modifier.size(24.dp)
                        )
                    }
                },
                modifier = Modifier
                    .padding(),
                colors = TopAppBarDefaults.topAppBarColors(
                    colorResource(R.color.Button_color),
                )

            )
        }, bottomBar = {

            BottomNav(navHostController = navController, selectedItem = 0, onClick = { index ->
                when (index) {
                    0 -> {
                        navController.navigate(Routes.HomeScreen)
                    }

                    1 -> {
                        navController.navigate(Routes.FavScreen)
                    }

                    2 -> {
                        navController.navigate(Routes.CartScreen)
                    }

                    3 -> {
                        navController.navigate(Routes.ProfileScreen)
                    }
                }
            })
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues = it)
        ) {

            Spacer(modifier = Modifier.height(5.dp))

            if (favItems.isEmpty()) {
                Text("Your Fav section Empty.")
            } else {
                LazyColumn {
                    items(favItems) { item ->
                        Card(modifier = Modifier.padding(10.dp)) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(8.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {

                                Image(
                                    painter = painterResource(item.itemImage),
                                    contentDescription = "", modifier = Modifier.size(80.dp)
                                )
                                Column(modifier = Modifier
                                    .weight(1f)
                                    .padding(start = 15.dp)) {
                                    Text(
                                        item.itemName,
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 18.sp
                                    )
                                    Text(item.itemDis, fontSize = 14.sp)

                                    Text(
                                        item.itemPrice,
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 18.sp
                                    )
                                }
                                Button(
                                    onClick = {},
                                ) {
                                    Text("Buy", fontSize = 16.sp)
                                }

                            }

                        }

                    }
                }
            }


        }
    }
}