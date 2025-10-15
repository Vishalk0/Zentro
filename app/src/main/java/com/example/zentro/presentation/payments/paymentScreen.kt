package com.example.zentro.presentation.payments

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Card
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.zentro.R
import com.example.zentro.dataModal.CardDataModel

@Composable

fun PaymentScreen(item: CardDataModel) {

    var expand by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier.fillMaxSize().padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,

    ) {


        Image(
            painter = painterResource(item.itemImage),
            contentDescription = "Item Image",
            modifier = Modifier.size(100.dp)
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(item.itemName, fontSize = 18.sp)
        Spacer(modifier = Modifier.height(10.dp))
        Text(item.itemDis, fontSize = 18.sp)
        Spacer(modifier = Modifier.height(10.dp))
        Text("Item :${item.itemPrice}", fontSize = 18.sp)
        Spacer(modifier = Modifier.height(40.dp))

        // Wrap card and dropdown together in a Box for proper popup anchor
        Box(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp) // space for dropdown below
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp, vertical = 12.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Payment Method",
                        fontSize = 20.sp,
                        textAlign = TextAlign.Start
                    )

                    IconButton(onClick = { expand = !expand }) {
                        Icon(
                            imageVector = Icons.Default.KeyboardArrowDown,
                            contentDescription = "Dropdown Arrow",
                            modifier = Modifier.size(30.dp)
                        )
                    }
                }
            }


            DropdownMenu(
                expanded = expand,
                onDismissRequest = { expand = false },
                modifier = Modifier
                    .fillMaxWidth(0.9f)
            ) {
                DropdownMenuItem(
                    text = { Text("Google Pay") },
                    onClick = { expand = false }
                )
                DropdownMenuItem(
                    text = { Text("Cash on Delivery") },
                    onClick = { expand = false }
                )
                DropdownMenuItem(
                    text = { Text("UPI Payment Method") },
                    onClick = { expand = false }
                )
            }
        }


    }

}