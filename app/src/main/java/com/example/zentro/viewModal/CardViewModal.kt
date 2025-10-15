package com.example.zentro.viewModal

import androidx.lifecycle.ViewModel
import com.example.zentro.dataModal.CardDataModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class CardViewModal : ViewModel() {
    private val _cartItems = MutableStateFlow<List<CardDataModel>>(emptyList())
    val cartItems = _cartItems.asStateFlow()


    fun addToCart(item: CardDataModel) {
        _cartItems.value = _cartItems.value + item
    }
    private val _favItems=MutableStateFlow<List<CardDataModel>>(emptyList())
    val favItem=_favItems.asStateFlow()

    fun addToFav(item: CardDataModel) {
        _favItems.value=_favItems.value+item

    }

    fun removeFromCart(item: CardDataModel) {
        _cartItems.value = _cartItems.value - item
    }
    //this function used in payment Screen
    fun getItemById(id:Int): CardDataModel?{
        return _cartItems.value.find { it.id==id }
    }

}