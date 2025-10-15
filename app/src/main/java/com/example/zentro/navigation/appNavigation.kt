package com.example.zentro.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.zentro.presentation.screens.HomeScreen
import com.example.zentro.presentation.auth.LogInScreen
import com.example.zentro.presentation.auth.SignIn
import com.example.zentro.presentation.auth.SplaceScreen
import com.example.zentro.presentation.auth.WelcomeScreen
import com.example.zentro.presentation.payments.PaymentScreen
import com.example.zentro.presentation.screens.CartScreen
import com.example.zentro.presentation.screens.FavScreen
import com.example.zentro.presentation.screens.ProfileScreen
import com.example.zentro.viewModal.CardViewModal

@Composable
fun appNavigation() {
    val cardViewModel: CardViewModal= viewModel()
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Routes.SplaceScreen) {
        composable<Routes.SplaceScreen> {
            SplaceScreen(navController)
        }
        composable<Routes.WelcomeScreen> {
            WelcomeScreen(navController)
        }
        composable <Routes.LogInScreen>{
            LogInScreen(navController)
        }
        composable <Routes.SignInScreen>{
            SignIn(navController)
        }
        composable <Routes.HomeScreen>{
            HomeScreen(navController,cardViewModel)
        }
        composable<Routes.FavScreen> {
            FavScreen(navController,cardViewModel)
        }
        composable<Routes.CartScreen>{
            CartScreen(navController,cardViewModel)
        }
        composable<Routes.ProfileScreen>{
            ProfileScreen(navController)
        }
        composable<Routes.PaymentScreen> {
            val args=it.toRoute<Routes.PaymentScreen>()
            val item=cardViewModel.getItemById(args.itemId)
            item?.let { PaymentScreen(it) }
        }

    }
}