package com.example.zentro.dataModal
import android.os.Parcelable
import kotlinx.parcelize.Parcelize
@Parcelize
data class CardDataModel(
    val id: Int,
    val itemImage: Int,
    val itemName: String,
    val itemDis: String,
    val itemPrice: String
): Parcelable
