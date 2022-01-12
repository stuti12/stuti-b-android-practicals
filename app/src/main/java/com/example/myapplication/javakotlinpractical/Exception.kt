package com.example.myapplication.javakotlinpractical

fun main (args: Array<String>){
    try {
        var int = 10 / 0
        println(int)
    } catch (e: ArithmeticException) {
        println(e)
    } finally {
        println("This block always executes")
    }

    var amount = 600

    try {
        validateMinAmount(amount)
    } catch (e : Exception){
        println(e.message)
    }

}

fun validateMinAmount(amount : Int){
    throw Exception("Your balance $amount is less than minimum balance 1000.")
}
