
class Company() {
    lateinit var name: String
    lateinit var objective: String
    lateinit var founder: String
}

fun main() {
    var a: Int? = null
    // using let function
    a?.let {
        print(it)
    }
    a = 2
    println("Let keyword-It executes the block only with the non-null value.")
    a?.let {
        print(a)
    }

    println("\n\napply-It can be used to operate on members of the receiver object mostly to initialize members.")
    val gfg = Company().apply {
        name = "Stuti Bhavsar"
        objective = "A computer science portal"
        founder = "Sandeep Jain"
    }

    println("\nWith keyword- Recommended use of ‘with’ for calling functions on context objects without providing the lambda result.")
    // with function
    with(gfg) {
        "abc"
        println("Company name:$name ")
        // similar to println( "${this.name}" )
    }

    //run keyword
    println("\nRun keyword= Let + With")
    println("Company Name : ")
    var company: Company? = null
    company?.run {
        print(name)
    }
    print("Company Name : ")
    // re-initialize company
    company = Company().apply {
        name = "Stuti bhavsar"

    }

    //also keyword
    println("Also keyword")
    company?.also {
        it.name="Bansi"
        print("\n"+it.name)
    }
}





