package src.nix.summer.practice.coffeemachine

fun shop(coffee: CoffeeMachine) {
    println("\nWrite action (buy, fill, take, remaining, exit):")
    var choise: String? = readLine()

    while (true) {
        if (choise == "exit") {
            return
        } else {
            coffee.action(choise)
            shop(coffee)
            choise = "exit"
        }
    }
}
