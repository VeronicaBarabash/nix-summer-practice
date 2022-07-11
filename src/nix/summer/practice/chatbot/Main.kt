fun main() {
    greeting()
    introduseYourself()
    age()
    count()
    test()
    println("Goodbye, have a nice day!")

}

fun greeting() {
    val botName = "NIXbot"
    val yearOfCreating = "2022"
    println("Hello! My name is ${botName}." )
    println("I was created in ${yearOfCreating}.")
}

fun introduseYourself() {
    println("Please, remind me your name." )
    val yourName = readLine()
    println("What a great name you have, ${yourName}!")
}

fun age() {
    println("Let me guess your age.")
    println("Enter remainders of dividing your age by 3, 5 and 7.")
    val remainder3: Int
    val remainder5: Int
    val remainder7: Int
    remainder3 = readLine().toString().toInt()
    remainder5 = readLine().toString().toInt()
    remainder7 = readLine().toString().toInt()
    val age = (remainder3 * 70 + remainder5 * 21 + remainder7 * 15) % 105
    println("Your age is ${age}; that's a good time to start programming!")
}

fun count(){
    println("I will prove to you that I can count to any number you want:")
    val a = readLine().toString().toInt()
    for(b in 0..a){
        println("$b !")
    }
}

fun test() {
    println("What is the difference between var and val?")
    println("1. var - allows you to set ve to change the value, val - allows you to set the value without changing the value")
    println("2. There are no differences between them")
    println("3. val - allows you to set ve to change the value, var - allows you to set the value without changing it later")
    println("4. val is for creating arrays, var is for creating variables")
    var a = readLine().toString().toInt()
    for (b in 1..4) {
        if (a == 1) {
            println("Great, you right!.")
            break
        } else if (a == 2) {
            println("Please, try again.")
            a = readLine().toString().toInt()
            continue
        } else if (a == 3) {
            println("Please, try again.")
            a = readLine().toString().toInt()
            continue
        } else if (a == 4) {
            println("Please, try again.")
            a = readLine().toString().toInt()
            continue
        }
        }
    }
