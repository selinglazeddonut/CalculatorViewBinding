package com.example.viewbindingsamples

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.viewbindingsamples.databinding.ActivityMainBinding
import net.objecthunter.exp4j.ExpressionBuilder


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        // Hide the status bar.
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
// Remember that you should never show the action bar if the
// status bar is hidden, so hide that too if necessary.
        actionBar?.hide()
        setContentView(view)

        val numberButtons = arrayOf(
            binding.num0,
            binding.num1,
            binding.num2,
            binding.num3,
            binding.num4,
            binding.num5,
            binding.num6,
            binding.num7,
            binding.num8,
            binding.num9
        )

        val operatorButtons = arrayOf(
            binding.startBracket,
            binding.closeBracket,
            binding.actionDivide,
            binding.actionMultiply,
            binding.actionMinus,
            binding.actionAdd,
            binding.actionBack,
            binding.numDot
        )

        val equalsButton = binding.actionEquals
        val clearButton = binding.clear

        numberButtons.forEach { button ->
            button.setOnClickListener {
                binding.answer.append((it as TextView).text)
            }

            operatorButtons.forEach { button ->
                button.setOnClickListener {
                    binding.answer.append(" ${(it as TextView).text} ")
                }
                equalsButton.setOnClickListener {
                    val expression = ExpressionBuilder(binding.answer.text.toString()).build()
                    binding.answer.text = expression.evaluate().toString()
                }
                clearButton.setOnClickListener {
                    binding.answer.text = ""
                }


            }

        }


    }
}

