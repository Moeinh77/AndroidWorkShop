fun main(args: Array<String>) {

/*

    var name = "moein"
    println(name)

    name="moein2"
    println(name)

    val fName="Hasani"
    println(fName)

    fName="Hasani2" //val cannot be reassigned


*/
/*

val name="Moein"
when (name){
    "moein"->{println("plz write it in capital !")}

    "Moein"->{println("Right !")}

    else->{println("Wrong spelling !")}
}

*/

/*

lateinit var name:String
var fName :String = "hasani"

println(name)//Exception in thread "main" kotlin.UninitializedPropertyAccessException: lateinit property name has not been initialized

name="moein"

println(name)

*/

/*

var name:String?="moein"
name=null

println(name)

var fName:String="Hasani"
fName=null//Null cannot be a value of nonNull type !

println(fName)


*/

/* ? if null returns null if not null returns the original value

var name:String? = "moein"
name=null

val length= name?.length //no need to .length() it is now a property
val length2= name!!.length

print("$length" )
print( "$length2")//Exception in thread "main" kotlin.KotlinNullPointerException

*/

/*

fun myPrtFunc(name: String ="moein"):Unit{// Unit actually means it is returning nothing

    println(name)

}

myPrtFunc() //prints moein
myPrtFunc("Someone else") //prints Someone else


*/

/*

val myList= arrayOf(1,2,3,4,5)

    myList.forEach { number->//it

        println(number)//print(it)

    }

*/

/*

fun printMultiple(vararg strings: Int) {

    strings.forEach { println(it) }

}

printMultiple(1,2,3,4,5)

*/
/*

val j = personJava("javaGuy", 40,"Java coder")
val k = personKoltin("kotlinGuy", 20,"Kotlin coder")

println(k.toString())
println(j.toString())

if(personKoltin("moein",20) == personKoltin("moein",20) )
print("equals")

*/

}



