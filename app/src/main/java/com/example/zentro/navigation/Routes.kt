package com.example.zentro.navigation

import kotlinx.serialization.Serializable

sealed class Routes {
@Serializable
data object SplaceScreen: Routes()
    @Serializable
    data object WelcomeScreen: Routes()
    @Serializable
    data object LogInScreen: Routes()
    @Serializable
    data object SignInScreen: Routes()
    @Serializable
    data object HomeScreen: Routes()
    @Serializable
    data object  FavScreen: Routes()
    @Serializable
    data object CartScreen: Routes()
    @Serializable
    data object ProfileScreen: Routes()
    @Serializable
    data class PaymentScreen(val itemId:Int): Routes()
    @Serializable
    data object PaymentDoneScreen: Routes()
}