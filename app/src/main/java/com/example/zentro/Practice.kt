package com.example.zentro

import androidx.lifecycle.Lifecycle.Event.Companion.downTo
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main ()= runBlocking {
    val start=user(name=String(), profession = String())
    launch {
        delay(2000L)
        println(start)
    }
    println("Hello Vikash")
}
fun user(name: String, profession: String): Unit{
  val    name="Vishal"
   val  profession="Student"
}