
fun main(args:Array<String>) {
    println("Null Safety!")
    var output: String
    //output = null   // Compilation error


    val name: String? = null    // Nullable type
    //println(name.length())      // Compilation error

    /*fun calculateTotal(obj: Any) {
        if (obj is Invoice)
            obj.calculateTotal()
    }*/
}