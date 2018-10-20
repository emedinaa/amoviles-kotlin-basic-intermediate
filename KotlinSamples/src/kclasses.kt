
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
