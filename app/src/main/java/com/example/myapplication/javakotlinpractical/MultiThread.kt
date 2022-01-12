package com.example.myapplication.javakotlinpractical

class SimpleThread: Thread() {
    public override fun run() {
        println("${Thread.currentThread()} has run.")
    }
}
// Implementing the Runnable interface to implement threads.
class SimpleRunnable: Runnable {
    public override fun run() {
        println("${Thread.currentThread()} has run.")
    }
}
fun main(args: Array<String>) {
    val thread = SimpleThread()
    thread.start() // Will output: Thread[Thread-0,5,main] has run.
    val runnable = SimpleRunnable()
    val thread1 = Thread(runnable)
    thread1.start() // Will output: Thread[Thread-1,5,main] has run
}

/*import kotlinx.coroutines.*

fun main() = runBlocking {
    doWorld()
    println("Done")
}

// Concurrently executes both sections
suspend fun doWorld() = coroutineScope { // this: CoroutineScope
    launch {
        delay(2000L)
        println("World 2")
    }
    launch {
        delay(1000L)
        println("World 1")
    }
    println("Hello")
}*/
