package src.nix.summer.practice.coffeemachine

fun calcIngredients() {
    println("Write how many cups of coffee you will need:")
    val cup = readLine().toString().toInt()
    println("For $cup cups of coffee you will need:\n")
    var water = cup * 200
    var milk = cup * 50
    var coffeeBeans = cup * 15
    println("$water ml of water")
    println("$milk ml of milk")
    println("$coffeeBeans g of coffee beans\n")
}
