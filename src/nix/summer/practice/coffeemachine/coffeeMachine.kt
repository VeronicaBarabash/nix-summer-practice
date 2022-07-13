package src.nix.summer.practice.coffeemachine

enum class Coffee(val needWater: Int,
                  val needMilk: Int,
                  val needCoffeeBeans: Int,
                  val cost: Int) {
    ESPRESSO(250,0,16,4),
    LATTE(350,75,20,7),
    CAPPUCCHINO(200,100,12,6)
}

class CoffeeMachine(private var water: Int = 400,
                    private var milk: Int = 540,
                    private var coffeeBeans: Int = 120,
                    private var cups: Int = 9,
                    private var money: Int = 550){

    private fun calculations(coffee: Coffee) {
        water -= coffee.needWater
        milk -= coffee.needMilk
        coffeeBeans -= coffee.needCoffeeBeans
        money += coffee.cost
        cups -=1
    }

    private fun checkIngredients(coffee: Coffee) {
        if (water < coffee.needWater)
            println("Sorry, not enough water!")
        else if (milk < coffee.needMilk)
            println("Sorry, not enough milk!")
        else if (coffeeBeans < coffee.needCoffeeBeans)
            println("Sorry, not enough coffee beans!")
        else if (cups <= 0) println("Sorry, not enough cups!")
        else {
            println("I have enough resources, making you a coffee!")
            calculations(coffee)
        }
    }

    private fun fill() {
        println("\nWrite how many ml of water you want to add:")
        val gotWater = readLine().toString().toInt()
        println("Write how many ml of milk you want to add:")
        val gotMilk = readLine().toString().toInt()
        println("Write how many grams of coffee beans you want to add:")
        val gotCoffeeBeans = readLine().toString().toInt()
        println("Write how many disposable coffee cups you want to add:")
        val gotCups = readLine().toString().toInt()
        water += gotWater
        milk += gotMilk
        coffeeBeans += gotCoffeeBeans
        cups += gotCups

        remaining()
    }

    private fun buy() {
        println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back – to main menu:")
        val order = readLine()

        when (order){
            "1" -> checkIngredients(Coffee.ESPRESSO)
            "2" -> checkIngredients(Coffee.LATTE)
            "3" -> checkIngredients(Coffee.CAPPUCCHINO)
        }
    }

    private fun take() {
        println("I gave you $money")
        money = 0
    }

    private fun remaining() {
        println("\nThe coffee machine has:\n")
        println("$water of water\n")
        println("$milk of milk\n")
        println("$coffeeBeans of coffee beans\n")
        println("$cups of disposable cups\n")
        println("$money of money\n")
    }
    fun action(choise: String?) {
        when (choise) {
            "buy" -> buy()
            "fill" -> fill()
            "take" -> take()
            "remaining" -> remaining()
        }
    }
}
