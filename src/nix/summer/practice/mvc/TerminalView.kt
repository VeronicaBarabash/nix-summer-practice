package src.nix.summer.practice.mvc

class Terminal(private var controller: Controller) : View {

    override fun start(info: String) {
        println(info)
    }

    private fun whatToFill(controller: Controller) {
        println("\nWrite how many ml of water you want to add:")
        val gotWater = readLine().toString().toInt()
        println("Write how many ml of milk you want to add:")
        val gotMilk = readLine().toString().toInt()
        println("Write how many grams of coffee beans you want to add:")
        val gotCofeeBeans = readLine().toString().toInt()
        println("Write how many disposable coffee cups you want to add:")
        val gotCups = readLine().toString().toInt()
        val order = controller.fillResources(Resources(gotWater, gotMilk, gotCofeeBeans, gotCups))
        println(order.feedback)

    }

    private fun whatToBuy(controller: Controller) : String {
        println("What do you want to buy?" +
                " 1 - espresso, 2 - latte, 3 - cappuccino, back – to main menu:")
        val drink = readLine()

        val order = when (drink) {
            "1" -> Order("Espresso")
            "2" -> Order("Latte")
            else -> Order("Cappuccino")
        }
        val information = controller.buy(order)
        return information.feedback
    }

    fun shop(controller: Controller) {
        println("\nWrite action (buy, fill, take, remaining, exit):")
        var choise: String? = readLine()

        while (true) {
            when(choise) {
                "exit" -> System.exit(0)
                "buy" -> {
                    println((whatToBuy(controller)))
                    shop(controller)
                }
                "fill" -> {
                    whatToFill(controller)
                    shop( controller)
                }
                "remaining" ->{
                    val information = controller.remaining()
                    println(information.feedback)
                    shop(controller)
                }
                else -> {
                    val information = controller.take()
                    println(information.feedback)
                    shop(controller)
                }
            }

        }
    }
}