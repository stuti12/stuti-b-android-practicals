val lazyValue: String by lazy {
    //  println("computed!")
    "Hello"
}
fun main(args: Array<String>) {
    println(lazyValue)
    println(lazyValue)

lateinit var person1:Person

    // initializing variable lately
    person1 = Person("Ted",28)
    print(person1.name + " is " + person1.age.toString())
}

data class Person(var name:String, var age:Int);