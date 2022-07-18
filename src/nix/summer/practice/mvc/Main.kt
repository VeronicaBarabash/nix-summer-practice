package src.nix.summer.practice.mvc

fun main() {
    val model = Model()
    val controller = Controller(model)
    val view = SwingView(controller)
    //val view = Terminal(controller)
    view.start("Beginning of work!")
    controller.attachView(view)

    //terminalView.start("Beginning of work!")
    //view.shop(controller)
    view.showEventDemo()
}
