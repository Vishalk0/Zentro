package com.example.zentro.presentation

import android.R.attr.contentDescription
import android.graphics.drawable.Icon
import android.graphics.drawable.VectorDrawable
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.zentro.R
import com.example.zentro.navigation.Routes

@Composable

fun BottomNav(
    navHostController: NavHostController,
onClick:(index: Int)-> Unit,
selectedItem: Int
) {
    val items = listOf(
        NavigationIcon("Home", Icons.Default.Home, Routes.HomeScreen),
        NavigationIcon("Fav", Icons.Default.Favorite, Routes.FavScreen),
        NavigationIcon("Cart", Icons.Default.ShoppingCart,Routes.CartScreen),
        NavigationIcon("Profile", Icons.Default.Person,Routes.ProfileScreen),
    )
    NavigationBar(
        containerColor = colorResource(R.color.Button_color),
        modifier = Modifier.height(70.dp)
    ) {
items.forEachIndexed {
index,item->
    NavigationBarItem(
        modifier = Modifier.padding(top = 15.dp),
        selected = selectedItem==index,
        onClick={onClick(index)},
        label ={Text(item.name)},
        icon = { Icon(item.icon, contentDescription = item.name)}
    )
}
    }
}

data class NavigationIcon(val name: String, val icon: ImageVector,val routes: Routes)