package com.example.myapplication.javakotlinpractical

//abstract class
abstract class Employee(val name: String,val experience: Int) { // Non-Abstract

    abstract var salary: Double

    abstract fun dateOfBirth(date:String)

    // Non-Abstract Method
    fun employeeDetails() {
        println("Name of the employee: $name")
        println("Experience in years: $experience")
        println("Annual Salary: $salary")
    }
}
// derived class
class Engineer(name: String,experience: Int) : Employee(name,experience) {
    override var salary = 500000.00
    override fun dateOfBirth(date:String){
        println("Date of Birth is: $date")
    }
}
fun main(args: Array<String>) {
    val eng = Engineer("Praveen",2)
    eng.employeeDetails()
    eng.dateOfBirth("02 December 1994")
}

//interface started
interface Vehicle {
    fun start()
    fun stop()
}

class Car : Vehicle {
    override fun start() {
        println("Car started")
    }

    override fun stop() {
        println("Car stopped")
    }
}

fun main() {
    val obj = Car()
    obj.start()
    obj.stop()
}
