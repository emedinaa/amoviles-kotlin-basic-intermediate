
fun main(args:Array<String>){
    println("Null Safety!")

    var byeNull: String = "No puede ser null"
    //byeNull= null

    var nullable: String?="Puede ser null"
    nullable= null

    var neverNull= "No puede ser null"
    //neverNull= null

    println("byeNull : $byeNull")
    println("nullable : $nullable")
    println("neverNull : $neverNull")

    //working with null

    //nullable="Esta variable no es null"

    if(nullable!=null){
        println("Not null (if) : $nullable")
    }

    println("Not null length (?) : ${ nullable?.length }")

    nullable?.let {
        println("Not null length (let) :${nullable?.length}")
    }?: run {
        println("Not null length (run) : 0")
    }
}