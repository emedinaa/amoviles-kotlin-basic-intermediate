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
fun showMessage2(message: String){
    println(message)
}
```

```kotlin
fun showMessage(message:String, param:String="Parameter"){
    println("message : $message param : $param")
}
```

```kotlin
fun area(base:Int, height:Int):Int{
    return base*height
}
```

```kotlin
fun perimeter(base:Int, height:Int)=2*base+ 2*height
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


# References 

- Getting Started with IntelliJ IDEA https://kotlinlang.org/docs/tutorials/getting-started.html
