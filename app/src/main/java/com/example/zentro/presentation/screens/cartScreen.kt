package com.example.zentro.presentation.screens

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.zentro.R
import com.example.zentro.dataModal.CardDataModel
import com.example.zentro.navigation.Routes
import com.example.zentro.presentation.BottomNav
import com.example.zentro.presentation.itemsDesign.cartScreenList
import com.example.zentro.viewModal.CardViewModal
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun CartScreen(
    navController: NavHostController, cardViewModal: CardViewModal = viewModel()
) {
    val cartItems by cardViewModal.cartItems.collectAsState()
    var search by remember { mutableStateOf("") }
    //used for bottom sheet
    var selectedItem by remember { mutableStateOf<CardDataModel?>(null) }
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
    val coroutineScope = rememberCoroutineScope()
    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        topBar = {
            TopAppBar(
                title = { Text("Cart") },
                navigationIcon = {
                    IconButton(onClick = {}) {
                        Icon(
                            Icons.Default.Menu,
                            contentDescription = "",
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
        Column(modifier = Modifier.padding(paddingValues = it)) {

            if (cartItems.isEmpty()) {
                Text(
                    "Your Cart is Empty.",
                    modifier = Modifier.fillMaxSize(),
                    textAlign = TextAlign.Center
                )
            } else {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(8.dp)
                ) {
                    items(cartItems) { item ->
                        cartScreenList(
                            cardDataModel = item,
                            viewModal = cardViewModal,
                            onBuyClick = { clickedItem ->
                                selectedItem = clickedItem
                                coroutineScope.launch { sheetState.show() }
                            })

                    }
                }
            }

        }
    }

    if (selectedItem != null) {
        ModalBottomSheet(onDismissRequest = {
            coroutineScope.launch { sheetState.hide() }.invokeOnCompletion {
                if (!sheetState.isVisible) selectedItem = null
            }
        }, sheetState = sheetState) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("Product Details", style = MaterialTheme.typography.titleLarge)
                Spacer(modifier = Modifier.height(10.dp))
                Image(
                    painter = painterResource(selectedItem!!.itemImage),
                    contentDescription = "Item Image",
                    modifier = Modifier.size(80.dp)
                )

                Text("Name : ${selectedItem!!.itemName}")
                Text(" ${selectedItem!!.itemDis}")
                Text("Price : ${selectedItem!!.itemPrice}")
                Button(
                    onClick = {
                        selectedItem?.let {item->
                            coroutineScope.launch {
                                sheetState.hide()
                            }
                            navController.navigate(Routes.PaymentScreen(item.id))
                        }
                    },
                    modifier = Modifier.fillMaxWidth(0.9f)
                ) {
                    Text("Proceed to Payment")
                }
            }
        }
    }

}

