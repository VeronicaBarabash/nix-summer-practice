package src.nix.summer.practice.coffeemachine

fun main() {
    println("First stage\n")
    cookingCoffee()
    println("Second stage\n")
    calcIngredients()
    println("Third stage\n")
    checkQuantityOfIngredients()
    println("Fourth and Fifth stage\n")
    val coffeeMachine = CoffeeMachine()
    shop(coffeeMachine)
}
