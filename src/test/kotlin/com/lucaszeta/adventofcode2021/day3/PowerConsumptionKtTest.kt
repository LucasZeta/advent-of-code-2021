package com.lucaszeta.adventofcode2021.day3

import com.google.common.truth.Truth.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.DynamicTest.dynamicTest
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestFactory

class PowerConsumptionKtTest {

    @Nested
    @DisplayName("Gamma Rate")
    inner class GammaRate {

        @Test
        fun `should find most common bits of each reading`() {
            val output = findGammaRate(listOf(
                listOf("0", "0", "1", "0", "0"),
                listOf("1", "1", "1", "1", "0"),
                listOf("1", "0", "1", "1", "0"),
                listOf("1", "0", "1", "1", "1"),
                listOf("1", "0", "1", "0", "1"),
                listOf("0", "1", "1", "1", "1"),
                listOf("0", "0", "1", "1", "1"),
                listOf("1", "1", "1", "0", "0"),
                listOf("1", "0", "0", "0", "0"),
                listOf("1", "1", "0", "0", "1"),
                listOf("0", "0", "0", "1", "0"),
                listOf("0", "1", "0", "1", "0")
            ))

            assertThat(output).isEqualTo("10110")
        }
    }

    @Nested
    @DisplayName("Epsilon Rate")
    inner class EpsilonRate {

        @Test
        fun `should invert gamma rate`() {
            assertThat(findEpsilonRate("10110")).isEqualTo("01001")
            assertThat(findEpsilonRate("11111")).isEqualTo("00000")
            assertThat(findEpsilonRate("00000")).isEqualTo("11111")
        }
    }

    @TestFactory
    fun `power consumption calculation`() = listOf(
        ("10110" to "01001") to 198,
        ("111" to "000") to 0,
        ("101" to "010") to 10
    ).map { (input, expectedOutput) ->
        dynamicTest(
            "should multiply gamma rate (${input.first}) by epsilon rate (${input.second})"
        ) {
            val (gammaRate, epsilonRate) = input
            val output = calculatePowerConsumption(gammaRate, epsilonRate)

            assertThat(output).isEqualTo(expectedOutput)
        }
    }
}
