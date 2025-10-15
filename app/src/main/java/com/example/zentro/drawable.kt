//package com.example.zentro
//
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.rememberScrollState
//import androidx.compose.foundation.verticalScroll
//import androidx.compose.material3.DrawerValue
//import androidx.compose.material3.ExperimentalMaterial3Api
//import androidx.compose.material3.ModalDrawerSheet
//import androidx.compose.material3.ModalNavigationDrawer
//import androidx.compose.material3.rememberDrawerState
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.rememberCoroutineScope
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.unit.dp
//
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun DrawableWithTopBar() {
//    val drawbleState = rememberDrawerState(initialValue = DrawerValue.Closed)
//    val scope = rememberCoroutineScope()
//    ModalNavigationDrawer(
//        drawerState = drawbleState,
//        drawerContent = {
//            ModalDrawerSheet {
//                Column(
//                    modifier = Modifier
//                        .padding(horizontal = 16.dp)
//                        .verticalScroll(
//                            rememberScrollState()
//                        )
//                ) {
//                    Spacer(modifier = Modifier.height(12.dp))
//                        Column(modifier = Modifier.fillMaxSize()) {
//
//                        }
//                }
//            }
//        }
//    )
//}