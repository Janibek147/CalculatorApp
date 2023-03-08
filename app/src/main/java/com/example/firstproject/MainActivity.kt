package com.example.firstproject

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
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


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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

        val btnPlus = findViewById<Button>(R.id.btn_plus)
        val btnMinus = findViewById<Button>(R.id.btn_minus)
        val btnMul = findViewById<Button>(R.id.btn_mul)
        val btnDevide = findViewById<Button>(R.id.btn_devide)
        val btnPercent = findViewById<Button>(R.id.btn_percent)
        val btnClear = findViewById<Button>(R.id.btn_ac)
        val btnBackspace = findViewById<Button>(R.id.btn_backsapce)
        val btnEquals = findViewById<Button>(R.id.btn_equals)



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

        btnBackspace.setOnClickListener {
            val removeLast = input.text.dropLast(1)
            input.text = removeLast
        }

    }

    @SuppressLint("SetTextI18n")
    private fun addToInputText(value: String) {
        input.setText(value + input.text.toString())
    }
}