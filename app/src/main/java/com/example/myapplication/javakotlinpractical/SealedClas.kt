
//provide type safty-also restrict hirerchy within file not anywhere in project like abstract. sealed class it can either contain netsed subclass or classes with in same file and classes known always compile time
sealed class Demo {
    class A : Demo() {
        fun display()
        {
            println("Subclass A of sealed class Demo")
        }
    }
    class B : Demo() {
        fun display()
        {
            println("Subclass B of sealed class Demo")
        }
    }
}
fun main() {
    val obj = Demo.B()
    obj.display()

    val obj1 = Demo.A()
    obj1.display()
}


/* // A sealed class with a string property
sealed class Fruit
	(val x: String)
{
	// Two subclasses of sealed class defined within
	class Apple : Fruit("Apple")
	class Mango : Fruit("Mango")
}

fun display(fruit: Fruit){
	when(fruit)
	{
		is Fruit.Apple -> println("${fruit.x} is good for iron")
		is Fruit.Mango -> println("${fruit.x} is delicious")
		is Pomegranate -> println("${fruit.x} is good for vitamin d")
	}
}
fun main()
{
	// Objects of different subclasses created
	val obj = Fruit.Apple()
	val obj1 = Fruit.Mango()
	val obj2 = Pomegranate()

	// Function called with different objects
	display(obj)
	display(obj1)
	display(obj2)
}
*/