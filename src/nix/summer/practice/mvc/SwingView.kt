package src.nix.summer.practice.mvc

import java.awt.FlowLayout
import java.awt.GridLayout
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import java.awt.event.WindowAdapter
import java.awt.event.WindowEvent
import javax.swing.JButton
import javax.swing.JFrame
import javax.swing.JLabel
import javax.swing.JPanel
import javax.swing.JTextField
import kotlin.system.exitProcess


class SwingView(private var controller: Controller) : JFrame(), View {

    private lateinit var mainFrame: JFrame
    private lateinit var infoLabel: JLabel

    private lateinit var controlPanel: JPanel
    private lateinit var fillPanel: JPanel
    private lateinit var numInput: JTextField

    init {
        createUI()
    }

    private fun createUI() {
        infoLabel = JLabel("", JLabel.CENTER)

        controlPanel = JPanel().apply { layout = FlowLayout() }
        fillPanel = JPanel().apply { layout = FlowLayout() }
        numInput = JTextField().apply { layout = FlowLayout() }

        mainFrame = JFrame("Coffee Machine").apply {
            setSize(900,700)
            layout = GridLayout(4,1)
            addWindowListener(object: WindowAdapter() {
                override fun windowClosing(windowEvent: WindowEvent?) {
                    exitProcess(0)
                }
            })

            add(controlPanel)
            add(fillPanel)
            add(infoLabel)
            add(numInput)

            isVisible = true
        }
    }

    private fun createControlPanel() {

        val espressoButton = JButton("Espresso").apply {
            actionCommand = "espresso"
            addActionListener(ButtonClick())
        }
        controlPanel.add(espressoButton)

        val latteButton = JButton("Latte").apply {
            actionCommand = "latte"
            addActionListener(ButtonClick())
        }
        controlPanel.add(latteButton)

        val cappuccinoButton = JButton("Cappuccino").apply {
            actionCommand = "cappuccino"
            addActionListener(ButtonClick())
        }
        controlPanel.add(cappuccinoButton)
    }




    private fun createFillPanel() {
        val waterLabel = JLabel("Write how many ml of water do you want to add:", JLabel.LEFT).apply {
            setSize(350, 100)
        }
        fillPanel.add(waterLabel)

        val waterField = JTextField("1000", 10)
        fillPanel.add(waterField)

        val milkLabel = JLabel("Write how many ml of milk do you want to add:", JLabel.LEFT).apply {
            setSize(350, 100)
        }
        fillPanel.add(milkLabel)

        val milkField = JTextField("0", 10)
        fillPanel.add(milkField)

        val coffeeBeansLabel = JLabel("Write how many grams of coffee beans do you want to add:", JLabel.LEFT).apply {
            setSize(350, 100)
        }
        fillPanel.add(coffeeBeansLabel)

        val coffeeBeansField = JTextField("0", 10)
        fillPanel.add(coffeeBeansField)

        val cupLabel = JLabel("Write how many disposable cups of coffee do you want to add:", JLabel.LEFT).apply {
            setSize(350, 100)
        }
        fillPanel.add(cupLabel)

        val cupField = JTextField("0", 10)

        fillPanel.add(cupField)

        val fillButton = JButton("Fill").apply {
            actionCommand = "fill"
            addActionListener {
                val information = controller.fillResources(Resources(gotWater = waterField.text.toInt(),
                    gotMilk = milkField.text.toInt(),
                    gotCoffeeBeans = coffeeBeansField.text.toInt(),
                    gotCups = cupField.text.toInt()))
                infoLabel.text = information.feedback
            }
        }
        fillPanel.add(fillButton)
    }

    inner class ButtonClick : ActionListener {
        override fun actionPerformed(e: ActionEvent?) {
            if (e != null) {
                infoLabel.text = when(e.actionCommand) {
                    "take" -> controller.take().feedback
                    "espresso" -> controller.buy(Order("Espresso")).feedback
                    "latte" -> controller.buy(Order("Latte")).feedback
                    "cappuccino" -> controller.buy(Order("Cappuccino")).feedback
                    else -> "nothing"
                }
            }
        }
    }

    internal fun showEventDemo() {
        createControlPanel()
        createFillPanel()
        createTakePannel()

        mainFrame.isVisible = true
    }

    private fun createTakePannel() {
        val takeButton = JButton("Take money").apply {
            actionCommand = "take"
            addActionListener(ButtonClick())
        }
        numInput.add(takeButton)
    }

    override fun start(info: String) {
        infoLabel.text = info
    }
}