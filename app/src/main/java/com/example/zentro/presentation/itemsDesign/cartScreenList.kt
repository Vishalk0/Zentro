package com.example.zentro.presentation.itemsDesign

import android.graphics.drawable.Icon
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.SegmentedButtonDefaults.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.zentro.R
import com.example.zentro.dataModal.CardDataModel
import com.example.zentro.viewModal.CardViewModal

@Composable

fun cartScreenList(
    cardDataModel: CardDataModel,
    onIncrease: () -> Unit = {},
    onDecrease: () -> Unit = {},
    viewModal: CardViewModal = viewModel(),
    onBuyClick: (CardDataModel) -> Unit
) {
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {

        Card(
            modifier = Modifier
                .fillMaxWidth(0.96f)
                .padding(top = 10.dp)
                .height(140.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp)
            )
            {
                Image(
                    painter = painterResource(cardDataModel.itemImage),
                    contentDescription = "Item Image",
                    modifier = Modifier
                        .size(100.dp)
                        .align(alignment = Alignment.CenterVertically)

                )
                Spacer(modifier = Modifier.width(15.dp))
                Column {
                    Text(
                        cardDataModel.itemName,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(top = 20.dp)
                    )
                    Spacer(modifier = Modifier.height(15.dp))
                    Text(
                        cardDataModel.itemPrice,
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                    )

                }
                Spacer(modifier = Modifier.width(15.dp))
                Column(modifier = Modifier.fillMaxSize()) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp)
                    ) {
                        IconButton(onClick = onDecrease) {
                            Icon(Icons.Default.Add, contentDescription = "Decrease")
                        }
                        Text(
                            "  ",
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier
                        )
                        IconButton(onClick = onIncrease) {
                            Icon(Icons.Default.Add, contentDescription = "Increase")
                        }

                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Button(onClick = { onBuyClick(cardDataModel) }) {
                        Text(
                            " Buy ",
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold, textAlign = TextAlign.Center,


                            )
                    }
                }


            }

        }
    }
}