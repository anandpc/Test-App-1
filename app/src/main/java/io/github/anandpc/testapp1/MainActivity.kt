package io.github.anandpc.testapp1

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import io.github.anandpc.mathopslib.MathOps
import io.github.anandpc.mathopslib.MathOpsImpl

class MainActivity : AppCompatActivity() {

    lateinit var btnAdd: Button
    lateinit var btnSub: Button
    lateinit var tvResult: TextView
    var num1 = 0
    var num2 = 0
    var doAddition: Boolean = false
    private val mathOps: MathOps = MathOpsImpl()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvResult = findViewById(R.id.tv_result)
        btnAdd = findViewById(R.id.btn_add)
        btnSub = findViewById(R.id.btn_sub)

        btnAdd.setOnClickListener {
            performOperation(true)
        }

        btnSub.setOnClickListener {
            performOperation(false)
        }
    }

    private fun performOperation(doAddition: Boolean) {
        try {
            num1 =
                Integer.parseInt(findViewById<EditText>(R.id.editTextNumber1).text.toString())
            num2 =
                Integer.parseInt(findViewById<EditText>(R.id.editTextNumber2).text.toString())
        } catch (e: NumberFormatException) {
            Toast.makeText(this, "Enter a valid number", Toast.LENGTH_SHORT).show()
        }
        val bundle = Bundle()
        bundle.putInt("NUM_1", num1)
        bundle.putInt("NUM_2", num2)
        bundle.putBoolean("DO_ADDITION", doAddition)
        this.doAddition = doAddition
        mathOps.launchTestApp2(this, bundle)
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when (requestCode) {
            100 -> {
                // set the result back to text view
                val result: String? = tvResult.text.toString() + "\nInput one - $num1 \nInput two - $num2 \n" +
                            "Action - ${if (doAddition) "Addition" else "Subtraction"} \n" +
                            "Output is - " + data?.getStringExtra("RESULT")

                tvResult.text = result
            }
        }
    }
}