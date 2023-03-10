package com.example.firstproject

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var input: TextView
    private lateinit var output: TextView

    private lateinit var btnZero: Button
    private lateinit var btnOne: Button
    private lateinit var btnTwo: Button
    private lateinit var btnThree: Button
    private lateinit var btnFour: Button
    private lateinit var btnFive: Button
    private lateinit var btnSix: Button
    private lateinit var btnSeven: Button
    private lateinit var btnEight: Button
    private lateinit var btnNine: Button

    private lateinit var btnPlus: Button
    private lateinit var btnMinus: Button
    private lateinit var btnMul: Button
    private lateinit var btnDivide: Button
    private lateinit var btnPercent: Button
    private lateinit var btnClear: Button
    private lateinit var btnBackspace: Button
    private lateinit var btnEquals: Button
    private lateinit var btnPi: Button
    private lateinit var btnDot: Button

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()

        btnZero.setOnClickListener {
            addToInputText("0")
        }

        btnOne.setOnClickListener {
            addToInputText("1")
        }

        btnTwo.setOnClickListener {
            addToInputText("2")
        }

        btnThree.setOnClickListener {
            addToInputText("3")
        }

        btnFour.setOnClickListener {
            addToInputText("4")
        }

        btnFive.setOnClickListener {
            addToInputText("5")
        }

        btnSix.setOnClickListener {
            addToInputText("6")
        }

        btnSeven.setOnClickListener {
            addToInputText("7")
        }

        btnEight.setOnClickListener {
            addToInputText("8")
        }

        btnNine.setOnClickListener {
            addToInputText("9")
        }

        btnClear.setOnClickListener {
            input.text = ""
            output.text = ""
        }

        btnPi.setOnClickListener {
            addToInputText("3.14")
        }

        btnBackspace.setOnClickListener {
            val removeLast = input.text.dropLast(1)
            input.text = removeLast
            output.text = ""
        }

        btnPlus.setOnClickListener {
            if (!getLastSymbol(input)) addToInputText("+")
        }

        btnMinus.setOnClickListener {
            if (!getLastSymbol(input)) addToInputText("-")
        }

        btnDivide.setOnClickListener {
            if (!getLastSymbol(input)) addToInputText("/")
        }

        btnMul.setOnClickListener {
            if (!getLastSymbol(input)) addToInputText("*")
        }

        btnDot.setOnClickListener {
            var hasDot = false
            input.text.forEach {
                if (it == '.') hasDot = true
            }
            if (!hasDot) addToInputText(".")
        }

        btnEquals.setOnClickListener {
            if (!getLastSymbol(input)) {
                var operation = ""
                // +++--
                input.text.forEach {
                    if (!it.isDigit()) operation += it
                }
                val text = input.text.toString()
                val numbers = text.split("+", "-", "*", "/").toMutableList()

                var result = 0L
                for (i in operation.indices) {
                    if (i == 0) {
                        result = calculate(numbers[i].toInt(), numbers[1].toInt(), operation[i])
                    } else {
                        result = calculateResult(result.toInt(), numbers[i + 1].toInt(), operation[i])
                    }
                }

                output.text = result.toString()
            }else if (getLastSymbol(input)) Toast.makeText(this, "Error with last symbol", Toast.LENGTH_SHORT).show()
        }
    }

    private fun calculate(number1: Int, number2: Int, operation: Char): Long {
        when (operation) {
            '+' -> {
                return (number1.toDouble() + number2).toLong()
            }
            '-' -> {
                return (number1.toDouble() - number2).toLong()
            }
            '*' -> {
                return (number1.toDouble() * number2).toLong()
            }
            '/' -> {
                return (number1.toDouble() / number2).toLong()
            }
        }
        return 0L
    }

    private fun calculateResult(result: Int, nextNumber: Int, operation: Char): Long {
        when (operation) {
            '+' -> {
                return (result.toDouble() + nextNumber).toLong()
            }
            '-' -> {
                return (result.toDouble() - nextNumber).toLong()
            }
            '*' -> {
                return (result.toDouble() * nextNumber).toLong()
            }
            '/' -> {
                return (result.toDouble() / nextNumber).toLong()
            }
        }
        return 0L
    }

    private fun initView() {
        input = findViewById(R.id.input_console)
        output = findViewById(R.id.result)
        btnZero = findViewById(R.id.btn_zero)
        btnOne = findViewById(R.id.btn_one)
        btnTwo = findViewById(R.id.btn_two)
        btnThree = findViewById(R.id.btn_three)
        btnFour = findViewById(R.id.btn_four)
        btnFive = findViewById(R.id.btn_five)
        btnSix = findViewById(R.id.btn_six)
        btnSeven = findViewById(R.id.btn_seven)
        btnEight = findViewById(R.id.btn_eight)
        btnNine = findViewById(R.id.btn_nine)

        btnPlus = findViewById(R.id.btn_plus)
        btnMinus = findViewById(R.id.btn_minus)
        btnMul = findViewById(R.id.btn_mul)
        btnDivide = findViewById(R.id.btn_devide)
        btnPercent = findViewById(R.id.btn_percent)
        btnClear = findViewById(R.id.btn_ac)
        btnBackspace = findViewById(R.id.btn_backsapce)
        btnEquals = findViewById(R.id.btn_equals)
        btnPi = findViewById(R.id.btn_pi)
        btnDot = findViewById(R.id.btn_dot)
    }

    @SuppressLint("SetTextI18n")
    private fun addToInputText(value: String) {
        input.text = input.text.toString() + value
    }

    private fun getLastSymbol(textView: TextView): Boolean {
        return !textView.text.last().isDigit()
    }

}