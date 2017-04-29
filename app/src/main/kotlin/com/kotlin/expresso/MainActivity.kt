package com.kotlin.expresso

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.jakewharton.rxbinding.view.RxView
import com.kotlin.expresso.databinding.ActivityMainBinding
import java.math.BigDecimal
import java.text.DecimalFormat

/**
 * @author So Nakamura, 2015/12/19
 */
class MainActivity : AppCompatActivity() {

    enum class Figure {
        ADD, SUB, MULTI, DIV, NONE;

        fun calc(arg1: BigDecimal, arg2: BigDecimal): BigDecimal {
            when (this) {
                Figure.ADD -> return arg1.plus(arg2)
                Figure.SUB -> return arg1.minus(arg2)
                Figure.MULTI -> return arg1.multiply(arg2)
                Figure.DIV -> return arg1.divide(arg2, 8, BigDecimal.ROUND_HALF_UP)
                Figure.NONE -> return arg2
            }
        }
    }

    private val formatter = DecimalFormat("#,###.#").apply {
        minimumFractionDigits = 0
        maximumFractionDigits = 8
    }

    private var field = BigDecimal.ZERO
    private var stack = BigDecimal.ZERO
    private var currentFigure = Figure.NONE

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        for (button in arrayOf(binding.buttonZero,
                binding.buttonOne, binding.buttonTwo, binding.buttonThree,
                binding.buttonFour, binding.buttonFive, binding.buttonSix,
                binding.buttonSeven, binding.buttonEight, binding.buttonNine)) {
            RxView.clicks(button)
                    .subscribe {
                        field = field.multiply(BigDecimal(10)).plus(BigDecimal(button.tag.toString().toInt()))
                        binding.result.setText(formatter.format(field))
                    }
        }

        for (button in arrayOf(binding.buttonAllClear,
                binding.buttonAdd, binding.buttonSub,
                binding.buttonMulti, binding.buttonDivide)) {
            RxView.clicks(button)
                    .subscribe {
                        currentFigure = Figure.valueOf(button.tag.toString())
                        stack = if (currentFigure != Figure.NONE) {
                            field
                        } else {
                            BigDecimal.ZERO
                        }
                        field = BigDecimal.ZERO
                        if (stack == BigDecimal.ZERO) {
                            binding.result.setText(formatter.format(field))
                        }
                    }
        }

        RxView.clicks(binding.buttonCalc).subscribe {
            field = currentFigure.calc(stack, field)
            binding.result.setText(formatter.format(field))
        }
    }
}