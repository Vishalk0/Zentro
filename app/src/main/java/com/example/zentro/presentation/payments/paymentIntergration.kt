package com.example.zentro.presentation.payments

import android.app.Activity
import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.Composable
import com.razorpay.Checkout
import org.json.JSONObject

fun paymentIntergration(context: Context) {
    val checkout = Checkout()
    checkout.setKeyID("rzp_test_RUWWqkuvWEKZNI")
    try {
        val options = JSONObject()
        options.put("Name", "Zentro App")
        options.put("Des", "Trial Payment")
        options.put("currency", "INR")
        options.put("Amount", "100")

        val prefill = JSONObject()
        options.put("email", "vishukushwaha60@gmail.com")
        options.put("contact", "6208479283")
        options.put("prifill", prefill)
        checkout.open(context as Activity, options)

    } catch (e: Exception) {

        Toast.makeText(context, "Error: ${e.message}", Toast.LENGTH_SHORT).show()
    }

}