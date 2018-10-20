
fun main(args:Array<String>) {

    //for
    val jvmLanguages = listOf("Kotlin", "Java", "Groovy")
    for (language in jvmLanguages) {                               // 1
        println("Jvm language : $language")
    }

    //while

    var count=0
    while (count<5){
        println("count : $count")
        count++
    }
    //do - while

    var i = 1
    do{
        println("item : $i")
        i++
    }while (i<5)
}