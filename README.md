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
- Null Safety

```kotlin
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
}
```

output
```
Null Safety!
byeNull : No puede ser null
nullable : null
neverNull : No puede ser null
```

- Working with nulls

```kotlin
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
```

output
```
Null Safety!
byeNull : No puede ser null
nullable : null
neverNull : No puede ser null
Not null length (?) : null
Not null length (run) : 0
```

```
Null Safety!
byeNull : No puede ser null
nullable : null
neverNull : No puede ser null
Not null (if) : Esta variable no es null
Not null length (?) : 24
Not null length (let) :24

```

- Classes

```kotlin

class Language()

class JVMLanguage(val id:Int, val name:String)

class JavaLanguage(val id:Int , var nullable:Boolean)

fun main(args:Array<String>) {
    println("Classes!")

    val language= Language()
    println("language $language")

    val jvmLanguage= JVMLanguage(0,"Kotlin")

    println("jvmLanguage $jvmLanguage")
    println("jvmLanguage ${jvmLanguage.id}  & ${jvmLanguage.name}")

    //jvmLanguage.id=1
    //jvmLanguage.name="Java"

    val javaLanguage= JavaLanguage(1,false)
    println("javaLanguage ${javaLanguage.id}  & ${javaLanguage.nullable}")
    javaLanguage.nullable=true

    println("javaLanguage ${javaLanguage.id}  & ${javaLanguage.nullable}")

}
```

output
```
Classes!
language Language@5e2de80c
jvmLanguage JVMLanguage@1d44bcfa
jvmLanguage 0  & Kotlin
javaLanguage 1  & false
javaLanguage 1  & true
```

- Inheritance

```kotlin
open class ObsoleteLanguage(){
    open fun sayHello() {       // 2
        println("I'm bored...")
    }
}

open class AwesomeLanguage(val message:String){
    open fun showMessage(){
        println(message)
    }
}


class JavaOLanguage:ObsoleteLanguage(){
    override fun sayHello() {
        println("I'm an obsolete language")
    }
}

class KotlinAwesomeLanguage(message:String):AwesomeLanguage(message)

fun main(args:Array<String>) {
    val obsoleteLanguage: ObsoleteLanguage = JavaOLanguage()
    obsoleteLanguage.sayHello()

    val awesomeLanguage:AwesomeLanguage= KotlinAwesomeLanguage("Kotlin is a cool language!")
    awesomeLanguage.showMessage()
}
```

output
```
I'm an obsolete language
Kotlin is a cool language!
```



# References 

- Getting Started with IntelliJ IDEA https://kotlinlang.org/docs/tutorials/getting-started.html
