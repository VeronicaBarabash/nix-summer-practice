package src.nix.summer.practice.coffeemachine

fun ingridients(need: Int, have: Int) : Int {
    var counter: Int = 0
    var inStock = have
    while (inStock>= need){
        counter +=1
        inStock -= need
    }
    return counter
}

fun findCups(water: Int, milk: Int, coffeeBeans: Int) : Int {
    val array: IntArray = intArrayOf(water, milk, coffeeBeans)
    var cups = array[0]
    for (i in  array) {
        if(cups > i)
            cups = i
    }
    return cups
}

fun numberOfCups(water: Int, milk: Int, coffeeBeans: Int, cupsOfCoffee: Int) {
    val waterNeeded = cupsOfCoffee * 200
    val milkNeeded = cupsOfCoffee * 50
    val coffeeBeansNeeded = cupsOfCoffee * 15
    val waterForCups = ingridients(200, water - waterNeeded)
    val milkForCups = ingridients(50, milk -milkNeeded)
    val coffeeBeansForCups = ingridients(15, coffeeBeans -coffeeBeansNeeded)

    val cup = findCups(waterForCups, milkForCups, coffeeBeansForCups)

    if (cup == 0) return

    if (cupsOfCoffee >= 0)
        print("(and even $cup more than that)\n")
}

fun howManyCups(water: Int, milk: Int, coffeeBeans: Int): Int {
    val waterForCups = ingridients(200, water)
    val milkForCups = ingridients(50, milk)
    val coffeeBeansForCups = ingridients(15, coffeeBeans)
    return findCups(waterForCups, milkForCups, coffeeBeansForCups)
}

fun checkQuantityOfIngredients() {
    println("Write how many ml of water the coffee machine has:")
    val water = readLine().toString().toInt()
    println("Write how many ml of milk the coffee machine has:")
    val milk = readLine().toString().toInt()
    println("Write how many grams of coffee beans the coffee machine has:")
    val coffeeBeans = readLine().toString().toInt()
    println("Write how many cups of coffee you will need:")
    val cup = readLine().toString().toInt()

    if (cup * 200 > water || cup * 50 > milk || cup * 15 > coffeeBeans) {
        println("No, I can make only ${howManyCups(water, milk, coffeeBeans)} cups of coffee\n")
    } else {
        print("Yes, I can make that amount of coffee\n")
        numberOfCups(water, milk, coffeeBeans, cup)
    }
}
