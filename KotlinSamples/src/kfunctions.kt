fun showMessage(message: String): Unit {                               // 1
    println(message)
}

fun showMessage2(message: String){
    println(message)
}

fun showMessage(message:String, param:String="Parameter"){
    println("message : $message param : $param")
}

fun area(base:Int, height:Int):Int{
    return base*height
}

fun perimeter(base:Int, height:Int)=2*base+ 2*height

//vararg
fun printWithArgs(vararg messages: String){
    for (m in messages) println(m)
}

fun printWithArgs(vararg messages: String,param:String){
    for (m in messages) println("$param : $m")
}

fun main(args:Array<String>){
    showMessage("Hello Kotlin") //1
    showMessage2("Hello Kotlin") //2
    showMessage("Hello Kotlin","Leave Java")//3
    println(area(10,20)) //4
    println(perimeter(10,20)) //5

    printWithArgs("Java", "Kotlin", "Scala", "Groovy",
            "Clojure")

    printWithArgs("Java", "Kotlin", "C++", param = "Android")
}