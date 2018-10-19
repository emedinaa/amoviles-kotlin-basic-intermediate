# amoviles-kotlin-basic-intermediate
Curso de Aplicaciones Android con Kotlin (Básico - Intermedio) - Academia Móviles

# Instructor
Eduardo José Medina Alfaro

emedinaa@gmail.com

https://github.com/emedinaa

# Kotlin Language

- Hello World

```kotlin
fun main(args:Array<String>){
    println("Hello Kotlin !")
}
```

output
```
Hello Kotlin !
```

- Functions

```kotlin
fun showMessage(message: String): Unit {                               // 1
    println(message)
}
```

```kotlin
fun showMessage2(message: String){                                    // 2
    println(message)
}
```

```kotlin
fun showMessage(message:String, param:String="Parameter"){            // 3
    println("message : $message param : $param")
}
```

```kotlin
fun area(base:Int, height:Int):Int{                                   // 4
    return base*height
}
```

```kotlin
fun perimeter(base:Int, height:Int)=2*base+ 2*height                  // 5
```

```kotlin
fun main(args:Array<String>){
    showMessage("Hello Kotlin") //1
    showMessage2("Hello Kotlin") //2
    showMessage("Hello Kotlin","Leave Java")//3
    println(area(10,20)) //4
    println(perimeter(10,20)) //5

}
```

output
```
Hello Kotlin
Hello Kotlin
message : Hello Kotlin param : Leave Java
200
60
```

- Functions / vararg parameters

```kotlin
   printWithArgs("Java", "Kotlin", "Scala", "Groovy",
            "Clojure")
   printWithArgs("Java", "Kotlin", "C++", param = "Android")
```

output
```
Java
Kotlin
Scala
Groovy
Clojure
Android : Java
Android : Kotlin
Android : C++
```

- Variables

```kotlin
fun main(args:Array<String>){
    var language:String= "Java"

    println(language)

    language="Kotlin"

    println(language)

    val age:Int = 18

    println("Age : $age")

    val message="Kotlin for Android Developers"

    println("Message : $message")

    //message="Java for Android Developers"
}
```

output
```
Java
Kotlin
Age : 18
Message : Kotlin for Android Developers
```


# References 

- Getting Started with IntelliJ IDEA https://kotlinlang.org/docs/tutorials/getting-started.html
