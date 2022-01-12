package com.example.myapplication.javakotlinpractical

import java.util.*;

fun main(args: Array<String>) {

    // create an object for scanner class
    val reader = Scanner(System.`in`)
    print("Enter any number: ")

    // read the next Integer value
    var num = reader.nextInt()
    var result = if ( num > 0) {
        "$num is positive number"
    }
    else if( num < 0){
        "$num is negative number"
    }
    else{
        "$num is equal to zero"
    }
    println(result)

}

//when
/*fun main(args: Array<String>){
    var number = 4
    var numberProvided = when(number) {
        1 -> "One"
        2 -> "Two"
        3 -> "Three"
        4 -> "Four"
        5 -> "Five"
        else -> "invalid number"
    }
    println("You provide $numberProvided")
}*/

//do while
/* fun main(args: Array<String>){
    var i = 1
    do {
        println(i)
        i++
    }
    while (i<=5);
}*/

//for loop
/*fun main(args : Array<String>) {
    val marks = arrayOf(80,85,60,90,70)
    for(item in marks) {
        println(item)
    }
}
*/

