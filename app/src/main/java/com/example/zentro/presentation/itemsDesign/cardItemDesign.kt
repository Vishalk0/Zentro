package com.example.zentro.presentation.itemsDesign

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.zentro.R
import com.example.zentro.dataModal.CardDataModel

@Composable

fun CardItemDesign(cardDataModel: CardDataModel, onAddClick: (CardDataModel) -> Unit,
                   onFavClick:(CardDataModel)-> Unit) {

    Card(
        onClick = {},
        modifier = Modifier
            .size(width = 150.dp, height = 220.dp)
            .padding(top = 10.dp, bottom = 8.dp)
            .border(
                2.dp,
                color = colorResource(R.color.Button_color),
                shape = RoundedCornerShape(12.dp)
            ),
        colors = CardDefaults.cardColors(
            Color.White
        ), shape = RoundedCornerShape(12.dp)
    ) {
        Icon(
            Icons.Default.FavoriteBorder,
            contentDescription = "FavButton",
            modifier = Modifier
                .align(Alignment.End)
                .padding(end = 10.dp, top = 5.dp)
                .clickable(onClick = {onFavClick(cardDataModel)})
        )
        Image(
            painter = painterResource(cardDataModel.itemImage),
            contentDescription = "Banana",
            modifier = Modifier
                .size(90.dp)
                .align(Alignment.CenterHorizontally)
        )
        Text(
            cardDataModel.itemName,
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(start = 6.dp)
        )
        Text(
            cardDataModel.itemDis,
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(start = 6.dp), color = Color.Gray
        )
        Spacer(modifier = Modifier.height(5.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 10.dp, bottom = 5.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                cardDataModel.itemPrice,
                fontSize = 17.sp,
                modifier = Modifier.padding(start = 10.dp)
            )
            IconButton(
                onClick = {onAddClick(cardDataModel)},
                modifier = Modifier
                    .size(30.dp)
                    .clip(RoundedCornerShape(6.dp))
                    .background(colorResource(R.color.Button_color))

            ) {
                Icon(
                    Icons.Default.Add, contentDescription = "Add Button",
                    modifier = Modifier
                        .size(20.dp)
                        .padding(bottom = 5.dp),
                    tint = Color.Black
                )
            }


        }

    }


}

