package com.lucaszeta.adventofcode2021.day3

import com.google.common.truth.Truth.assertThat
import org.junit.jupiter.api.DynamicTest.dynamicTest
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestFactory

class LifeSupportRatingKtTest {

    @Nested
    inner class OxygenGeneratorRating {

        @Test
        fun `should filter readings that contain most common bits`() {
            val output = findOxygenGeneratorRating(
                listOf(
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
                )
            )

            assertThat(output).isEqualTo("10111")
        }
    }

    @Nested
    inner class CO2ScrubberRating {

        @Test
        fun `should filter readings that contain least common bits`() {
            val output = findCO2ScrubberRating(
                listOf(
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
                )
            )

            assertThat(output).isEqualTo("01010")
        }
    }

    @TestFactory
    fun `power consumption calculation`() = listOf(
        ("10111" to "01010") to 230,
        ("111" to "000") to 0,
        ("101" to "010") to 10
    ).map { (input, expectedOutput) ->
        dynamicTest(
            "should multiply oxygen generator rating (${input.first}) by CO2 scrubber rating (${input.second})"
        ) {
            val (oxygenGeneratorRating, co2ScrubberRating) = input
            val output = calculateLifeSupportRating(oxygenGeneratorRating, co2ScrubberRating)

            assertThat(output).isEqualTo(expectedOutput)
        }
    }
}
