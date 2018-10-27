# amoviles-kotlin-basic-intermediate
Lesson 2 - Saturday, October 27

Curso de Aplicaciones Android con Kotlin (Básico - Intermedio) - Academia Móviles

## Kotlin Language

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
Compilador online https://play.kotlinlang.org/

- Ejercicios

  - Pide 2 números y muestra cual es el mayor, el menor, o si son iguales
  - Calcular el mayor de 2 números
  - Calcular el factorial de un número.
  - Dado 10 números , calcular el mayor y menor
  - Dado 10 números , calcular los múltiplos de 3
  - Mostrar la tabla de multiplicar del 1 al 10
  - Realizar un programa que nos pida un número n, y nos diga cuantos números hay entre 1 y n que son
primos. 
  - Calcular el mayor de tres números enteros
  - Pide un número y muestra si es positivo o negativo y si es par o impar
  - Obtener el valor máximo y mínimo de un array de valores.

```kotlin
 //Pide 2 números y muestra cual es el mayor, el menor, o si son iguales
 
fun main(args:Array<String>){
    println("Hello Kotlin !")
    val num1= 5
    val num2= 3
    comparar(num1,num2)
}
fun comparar(v1:Int, v2:Int){
    var message:String=""
    if(v1>v2){
        message= "v1 $v1 > v2 $v2" //
    }else if(v1<v2){
       message= "v1 $v1 < v2 $v2"  
    }else{
        message= "v1 $v1 = v2 $v2"  
    }
    println(message)
}

```

# Componentes de una aplicación Android

- Entorno de desarrollo (Android Studio)
- Activities
- Intents

# Homework
...
  
# References 

- Getting Started with IntelliJ IDEA https://kotlinlang.org/docs/tutorials/getting-started.html
- Develop Android Apps with Kotlin https://developer.android.com/kotlin/
- Getting started with Android and Kotlin https://kotlinlang.org/docs/tutorials/kotlin-android.html
- Android Developers https://developer.android.com/?hl=es-419
- Google codelabs https://codelabs.developers.google.com/
- Android Studio https://developer.android.com/studio/install
- Genymotion https://www.genymotion.com/account/create/
