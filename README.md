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

```kotlin
//Calcular el factorial de un número.
fun main(args:Array<String>){
    println("Hello Kotlin !")
    //factorial 5 5x4x3x2x1 5*(5-1)*(5-2)*(5-3)*(5-4)
   	val num=5
    var factorial= 5
    for(i in 1..(num-1)){// for(val i=1, i<5,i++){
        //factorial = num*(num-i) 
        factorial = factorial*(num-i) 
        println( "$num x ($num - $i) = $num x ${num-i} factorial $factorial")
    }
    println( "factorial $factorial")
        //1 5*(5-1)
        //2 5*(5-2)
        //3 5*(5-3)
        //4 5* ()5-4)
}

```

```kotlin
//Obtener el valor máximo y mínimo de un array de valores.
fun main(args:Array<String>){
    //Obtener el valor máximo y mínimo de un array de valores //[3,5,2,1,7,8] max , min
    println( "Hello kotlin")
    val arr= intArrayOf(3,5,2,1,7,8)
    calcular(arr)
}

fun calcular(arr:IntArray){
    var max=arr[0]
    var min=arr[0]
    // min > it min= it
    arr.forEach{//i->
        println("it $it - min :$min - max : $max")
        if(min>it){ min=it }
        if(max<it){ max= it}
        println("nuevo min :$min / nuevo max : $max")
    }
    println(" min : $min - max : $max") //[3,5,2,1,7,8]
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
- Android Samples https://developer.android.com/samples/

