# Lesson 1 - Saturday, October 20
Curso de Aplicaciones Android con Kotlin (Básico - Intermedio) - Academia Móviles

* Kotlin para desarrolladores Android
    * Fundamentos del lenguaje
    * Programación Orientado a Objectos (OOP)
    * Comparación con Java
    * Funciones y Lambdas
    
* Entorno de desarrollo (Android Studio)
    * Crear un proyecto Android con Kotlin

## Kotlin Fundamentals

Slide https://docs.google.com/presentation/d/1AsYR8CfSQprW0SP5S-19kuREeD88_F8yB-quibEo3DM/edit?usp=sharing

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
fun printWithArgs(vararg languages:String){
    for(item in languages){
        println(item)
    }
}
```

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
---

- Control Flow

**Conditional expression**

```kotlin
fun max(a: Int, b: Int) = if (a > b) a else b         // 1
println(max(99, -42))
```
output
```
99
```

**When** 

```kotlin
class MyClass

fun cases(obj: Any) {
    when (obj) {
        1 -> println("One")                          // 1
        "Hello" -> println("Greeting")               // 2
        is Long -> println("Long")                   // 3
        !is String -> println("Not a string")        // 4
        else -> println("Unknown")                   // 5
    }
}

fun main(args:Array<String>) {
    cases("Hello")
    cases(1)
    cases(0L)
    cases(MyClass())
    cases("hello")
}
```

output
```
Greeting
One
Long
Not a string
Unknown
```
- Loops (for, while, do-while)

**For**

```kotlin
fun main(args:Array<String>) {

    //for
    val jvmLanguages = listOf("Kotlin", "Java", "Groovy")
    for (language in jvmLanguages) {                               // 1
        println("Jvm language : $language")
    }
}
```

output
```
Jvm language : Kotlin
Jvm language : Java
Jvm language : Groovy
```
**while**

```kolin
  //while
    var count=0
    while (count<5){
        println("count : $count")
        count++
    }
```

```
count : 0
count : 1
count : 2
count : 3
count : 4
```

**do-while**

```kotlin
    //do - while
    var i = 1
    do{
        println("item : $i")
        i++
    }while (i<5)
```

```
item : 1
item : 2
item : 3
item : 4
```
---

## Crear un proyecto Android con Kotlin

* Estructura de un proyecto Android

 *Revisar el proyecto que se encuentra en la carpeta temmplate/KotlinApp*
 
 ```
    KotlinApp
        - build.gradle
        - app
            - build
            - libs
            - build.gradle
            - src
        - build
        - gradle
 ```  
 
* Revisar el archivo **build.gradle** del proyecto
```groovy
// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {
    ext.kotlin_version = '1.2.61'
    repositories {
        google()
        jcenter()
    }
    dependencies {
        classpath 'com.android.tools.build:gradle:3.1.4'
        classpath "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version"

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

allprojects {
    repositories {
        google()
        jcenter()
    }
}

task clean(type: Delete) {
    delete rootProject.buildDir
}

ext {
    // Sdk and tools
    minSdkVersion = 15
    targetSdkVersion = 28
    compileSdkVersion = 28
    buildToolsVersion = '28.0.0'
    constraintLayoutVersion='1.1.3'

    // App dependencies
    supportLibraryVersion = '28.0.0'
    junitVersion = '4.12'

    //Test
    runnerVersion='1.0.2'
    espressoVersion='3.0.2'
}
```
* Revisar el archivo **build.gradle** de la app 
    
```groovy
apply plugin: 'com.android.application'

apply plugin: 'kotlin-android'

apply plugin: 'kotlin-android-extensions'

android {
    compileSdkVersion rootProject.ext.compileSdkVersion//28
    defaultConfig {
        applicationId "com.kotlin.samples.kotlinapp"
        minSdkVersion rootProject.ext.minSdkVersion//15
        targetSdkVersion rootProject.ext.targetSdkVersion//28
        versionCode 1
        versionName "1.0"
        testInstrumentationRunner "android.support.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            minifyEnabled false
            proguardFiles getDefaultProguardFile('proguard-android.txt'), 'proguard-rules.pro'
        }
    }

    sourceSets {
        main.java.srcDirs += 'src/main/kotlin'
    }
}

dependencies {
    implementation fileTree(dir: 'libs', include: ['*.jar'])
    implementation "org.jetbrains.kotlin:kotlin-stdlib-jdk7:$kotlin_version"
    implementation "com.android.support:appcompat-v7:$rootProject.supportLibraryVersion"
    implementation "com.android.support:recyclerview-v7:$rootProject.supportLibraryVersion"
    implementation "com.android.support:cardview-v7:$rootProject.supportLibraryVersion"
    implementation "com.android.support.constraint:constraint-layout:$rootProject.constraintLayoutVersion"
    implementation 'com.android.support.constraint:constraint-layout:1.1.3'
    testImplementation "junit:junit:$rootProject.junitVersion"
    androidTestImplementation "com.android.support.test:runner:$rootProject.runnerVersion"
    androidTestImplementation "com.android.support.test.espresso:espresso-core:$rootProject.espressoVersion"
}

```
 
 * Creamos una actividad llamada EmptyActivity
 
 ```kotlin
 package com.kotlin.samples.kotlinapp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_empty.*

class EmptyActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_empty)

        imageView.setOnClickListener {
            showMessage()
        }
    }

    private fun showMessage(){
        Toast.makeText(this, "Hello Kotlin!", Toast.LENGTH_LONG).show()
    }
}

 ```
* En su layout "activity_empty.xml" copiamos los siguiente

```xml
<?xml version="1.0" encoding="utf-8"?>
<android.support.constraint.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".EmptyActivity">

    <ImageView
        android:id="@+id/imageView"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:src="@drawable/ic_kotlin_android"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />
</android.support.constraint.ConstraintLayout>
```

<img src="https://raw.githubusercontent.com/learning-android-pe/training-resources/master/kotlin/activity_empty.png"/>

* Actividades

  * Crear un proyecto Android
  * Crear un proyecto Android usando un template
  * Crear una actividad llamada HomeActivity
  * Crear un fragment llamado FragmentActivity
  * Crear una clase java llamada User en src/main/package/model/User.java
  * Agregar un color en res/values/colors.xml
  * Agregar un string en res/values/strings.xml
  * Agregar una dimension en res/values/dimens.xml
  * Agregar una imagen en res/drawable/ic_android.png

# Samples

* KotlinSamples - Contiene los ejemplos sobre el lenguaje Kotlin (IntelliJ IDEA)
* BasicSamples - Contiene ejemplos básicos de Android con Kotlin (Android Studio)
    * GalleryActivity
    * FormActivity
    * CalculatorActivity

# Homework

**Android Studio**

Crear un proyecto en Android Studio , luego realizar los cambios acorde al template entregado en clase (gradle).
  
# References 

- Getting Started with IntelliJ IDEA https://kotlinlang.org/docs/tutorials/getting-started.html
- Develop Android Apps with Kotlin https://developer.android.com/kotlin/
- Getting started with Android and Kotlin https://kotlinlang.org/docs/tutorials/kotlin-android.html
- Android Developers https://developer.android.com/?hl=es-419
- Google codelabs https://codelabs.developers.google.com/


