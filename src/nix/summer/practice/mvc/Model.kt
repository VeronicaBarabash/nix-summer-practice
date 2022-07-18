package src.nix.summer.practice.mvc

data class Response(var feedback: String)

data class Order(var typeOfCoffee: String)

data class Resources(var gotWater : Int, var gotMilk : Int,
                     var gotCoffeeBeans : Int, var gotCups : Int)

enum class Coffee(val needWater: Int,
                  val needMilk: Int,
                  val needCoffeeBeans: Int,
                  val cost: Int) {
    ESPRESSO(250,0,16,4),
    LATTE(350,75,20,7),
    CAPPUCCINO(200,100,12,6)

}


class Model(private var water: Int = 400,
            private var milk: Int = 540,
            private var coffeeBeans: Int = 120,
            private var cups: Int = 9,
            private var money: Int = 550) {

    private fun calculations(coffee: Coffee) {
        water -= coffee.needWater
        milk -= coffee.needMilk
        coffeeBeans -= coffee.needCoffeeBeans
        money += coffee.cost
        cups -= 1
    }

    private fun checkIngredients(coffee: Coffee) : String {
        if (water < coffee.needWater) {
            return ("Sorry, not enough water! \n")
        }else if (milk < coffee.needMilk) {
            return ("Sorry, not enough milk! \n")
        }else if (coffeeBeans < coffee.needCoffeeBeans) {
            return ("Sorry, not enough coffee beans! \n")
        }else if (cups <= 0){
            return ("Sorry, not enough cups! \n")
        } else {
            calculations(coffee)
            return ("I have enough resources, making you a coffee! \n")

        }
    }

    fun buy(coffee: Order) : Response {
        val coffeee = when (coffee.typeOfCoffee){
            "Espresso" -> Response(checkIngredients(Coffee.ESPRESSO) + remaining())
            "Latte" -> Response(checkIngredients(Coffee.LATTE) + remaining())
            else -> Response(checkIngredients(Coffee.CAPPUCCINO) + remaining())
        }
        return coffeee
    }

    fun take() : Response {
        val cash = money
        money = 0
        return Response("I gave you $cash")
    }

    fun remaining() :String {
        return "The coffee machine has: \n" +
                "$water of water. \n" +
                "$milk of milk. \n" +
                "$coffeeBeans of coffee beans. \n" +
                "$cups of disposable cups. \n" +
                "$money of money."

    }

    fun fill(resources: Resources) : Response {
        water += resources.gotWater
        milk += resources.gotMilk
        coffeeBeans += resources.gotCoffeeBeans
        cups += resources.gotCups

        return Response(remaining())
    }
}
