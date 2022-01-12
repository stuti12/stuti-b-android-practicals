package com.example.myapplication.javakotlinpractical

// An example for immutable list
fun main(args: Array<String>) {
    val immutableList = listOf("Mahipal","Nikhil","Rahul")
    // gives compile time error
    // immutableList.add = "Praveen"
    for(item in immutableList){
        println(item)
    }

    // Set but output with no repeatition
    var immutableSet = setOf(6,9,9,0,0,"Mahipal","Nikhil")
    // gives compile time error
    // immutableSet.add(7)
    for(item in immutableSet){
        println(item)
    }

    var mutableSet = mutableSetOf<Int>(6,10)
    // adding elements in set
    mutableSet.add(2)
    mutableSet.add(5)
    for(item in mutableSet){
        println(item)
    }

    var mutableMap = mutableMapOf<Int,String>(1 to "Mahipal",2 to "Nikhil",3 to "Rahul")
    // we can modify the element
    mutableMap.put(1,"Praveen")
    // add one more element in the list
    mutableMap.put(4,"Abhi")
    for(item in mutableMap.values){
        println(item)
    }
}

