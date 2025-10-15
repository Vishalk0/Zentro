package com.example.zentro.presentation.itemsDesign

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.zentro.R

@Composable

fun CategoryItem(categoryDataModal: CategoryDataModal) {
    Column(modifier = Modifier.fillMaxSize()) {

        Card(
            modifier = Modifier
                .size(height = 80.dp, width = 80.dp)
                .padding(10.dp)
                .border(2.dp, color = colorResource(R.color.Button_color), CircleShape),
            shape = CircleShape
        ) {
            Image(
                painter = painterResource(categoryDataModal.img),
                contentDescription = "",
                contentScale = ContentScale.Crop, modifier = Modifier.fillMaxSize()
            )
        }

    }
}

data class CategoryDataModal(val img: Int)