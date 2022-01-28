import kotlin.text.*
import java.util.*

fun main(args: Array<String>) {

    val originalMap = mapOf("key1" to 1, "key2" to 2, "key3" to 3)

    val filteredMap = originalMap.filter { it.value < 2 }

    println(filteredMap) // {key1=1}
// original map has not changed
    println(originalMap) // {key1=1, key2=2, key3=3}

    val nonMatchingPredicate: ((Map.Entry<String, Int>)) -> Boolean = { it.value == 0 }
    val emptyMap = originalMap.filter(nonMatchingPredicate)
    println(emptyMap) // {}

}