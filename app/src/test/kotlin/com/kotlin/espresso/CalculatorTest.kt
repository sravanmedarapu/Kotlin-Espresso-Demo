package com.kotlin.espreeo

import com.kotlin.expresso.MainActivity
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.not
import org.junit.Assert.assertThat
import org.junit.Test
import java.math.BigDecimal

class CalculatorTest {

    @Test
    fun figureTest() {
        assertThat(MainActivity.Figure.ADD.calc(BigDecimal(130), BigDecimal(180)),
                `is`(BigDecimal(310)))
        assertThat(MainActivity.Figure.SUB.calc(BigDecimal(20), BigDecimal(4)),
                `is`(not(BigDecimal(5))))
        assertThat(MainActivity.Figure.MULTI.calc(BigDecimal(10), BigDecimal(10)),
                `is`(BigDecimal(100)))
        assertThat(MainActivity.Figure.DIV.calc(BigDecimal(22), BigDecimal(11)),
                `is`(not(BigDecimal(3))))
    }
}