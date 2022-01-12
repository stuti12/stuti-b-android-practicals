package com.example.myapplication.javakotlinpractical

import java.util.*;

fun main(args: Array<String>) {
    //ifelse
    println("If else")
    val time = 22
    if (time < 10) {
        println("\nGood morning.")
    } else if (time < 20) {
        println("Good day.")
    } else {
        println("Good evening.")
    }

//when similar to switch
    var number = 4
    println("\nWhen")
    var numberProvided = when(number) {
        1 -> "One"
        2 -> "Two"
        3 -> "Three"
        4 -> "Four"
        5 -> "Five"
        else -> "invalid number"
    }
    println("You provide $numberProvided")

    //dowhile
    println("\nDowhile")
    var i = 1
    do {
        println(i)
        i++
    }
    while (i<=5);

    println("for loop")
    val marks = arrayOf(80,85,60,90,70)
    for(item in marks) {
        println(item)
    }
}









