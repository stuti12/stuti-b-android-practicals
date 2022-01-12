package com.example.myapplication.javakotlinpractical

import java.util.*;

fun main(args: Array<String>) {

    val time = 22
    if (time < 10) {
        println("Good morning.")
    } else if (time < 20) {
        println("Good day.")
    } else {
        println("Good evening.")
    }

//when similar to switch
    var number = 4
    var numberProvided = when(number) {
        1 -> "One"
        2 -> "Two"
        3 -> "Three"
        4 -> "Four"
        5 -> "Five"
        else -> "invalid number"
    }
    println("\nYou provide $numberProvided")

    //dowhile
    println("Dowhile")
    var i = 1
    do {
        println(i)
        i++
    }
    while (i<=5);
}

//for loop
/*fun main(args : Array<String>) {
    val marks = arrayOf(80,85,60,90,70)
    for(item in marks) {
        println(item)
    }
}
*/

