package com.carvajal.realidad

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var display: TextView
    private var currentInput = ""
    private var firstOperand = 0.0
    private var operation: String? = null
    private var isNewInput = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        display = findViewById(R.id.tvDisplay)

        // Mapear botones numéricos
        val buttons = mapOf(
            R.id.btn0 to "0", R.id.btn1 to "1", R.id.btn2 to "2",
            R.id.btn3 to "3", R.id.btn4 to "4", R.id.btn5 to "5",
            R.id.btn6 to "6", R.id.btn7 to "7", R.id.btn8 to "8",
            R.id.btn9 to "9"
        )

        buttons.forEach { (id, value) ->
            findViewById<Button>(id).setOnClickListener { appendNumber(value) }
        }

        // Operaciones básicas
        findViewById<Button>(R.id.btnAdd).setOnClickListener { selectOperation("+") }
        findViewById<Button>(R.id.btnSubtract).setOnClickListener { selectOperation("-") }
        findViewById<Button>(R.id.btnMultiply).setOnClickListener { selectOperation("×") }
        findViewById<Button>(R.id.btnDivide).setOnClickListener { selectOperation("/") }
        findViewById<Button>(R.id.btnEqual).setOnClickListener { calculateResult() }
        findViewById<Button>(R.id.btnClear).setOnClickListener { clearDisplay() }

        // Operaciones trigonométricas
        findViewById<Button>(R.id.btnSin).setOnClickListener { calculateTrigFunction("sin") }
        findViewById<Button>(R.id.btnCos).setOnClickListener { calculateTrigFunction("cos") }
        findViewById<Button>(R.id.btnTan).setOnClickListener { calculateTrigFunction("tan") }
    }

    private fun appendNumber(value: String) {
        if (isNewInput) {
            currentInput = ""
            isNewInput = false
        }
        currentInput += value
        updateDisplay(currentInput)
    }

    private fun selectOperation(op: String) {
        if (currentInput.isNotEmpty()) {
            firstOperand = currentInput.toDouble()
            operation = op
            isNewInput = true
        }
    }

    private fun calculateResult() {
        if (currentInput.isNotEmpty() && operation != null) {
            val secondOperand = currentInput.toDouble()
            val result = when (operation) {
                "+" -> firstOperand + secondOperand
                "-" -> firstOperand - secondOperand
                "×" -> firstOperand * secondOperand
                "/" -> if (secondOperand != 0.0) firstOperand / secondOperand else "Error"
                else -> "Error"
            }
            updateDisplay(result.toString())
            currentInput = result.toString()
            operation = null
            isNewInput = true
        }
    }

    private fun calculateTrigFunction(func: String) {
        if (currentInput.isNotEmpty()) {
            val value = Math.toRadians(currentInput.toDouble()) // Convertir a radianes
            val result = when (func) {
                "sin" -> Math.sin(value)
                "cos" -> Math.cos(value)
                "tan" -> if (Math.abs(Math.cos(value)) < 1e-10) {
                    "Error" // Indefinido cuando cos(value) es cercano a 0
                } else {
                    Math.tan(value)
                }
                else -> "Error"
            }
            updateDisplay(result.toString())
            currentInput = result.toString()
            isNewInput = true
        }
    }

    private fun clearDisplay() {
        currentInput = ""
        firstOperand = 0.0
        operation = null
        updateDisplay("0")
    }

    private fun updateDisplay(value: String) {
        display.text = value
    }
}