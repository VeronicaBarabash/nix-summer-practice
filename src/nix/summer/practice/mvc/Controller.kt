package src.nix.summer.practice.mvc


class Controller(private val model: Model) {

    private lateinit var view: View

    fun attachView(_view: View) {
        view = _view
    }

    fun buy(order: Order) : Response {
        return model.buy(order)
    }

    fun take() : Response {
        return model.take()
    }

    fun remaining() : Response {
        return Response(model.remaining())
    }

    fun fillResources(resources: Resources): Response {
        return model.fill(resources)
    }

}
