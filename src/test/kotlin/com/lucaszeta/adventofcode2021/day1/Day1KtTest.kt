package com.lucaszeta.adventofcode2021.day1

import com.google.common.truth.Truth.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class Day1KtTest {

    @Nested
    inner class CountDepthIncreases {

        @Test
        fun `should count increases in depth`() {
            val output = countDepthIncreases(
                listOf(
                    199,
                    200,
                    208,
                    210,
                    200,
                    207,
                    240,
                    269,
                    260,
                    263
                )
            )

            assertThat(output).isEqualTo(7)
        }

        @Test
        fun `should return 0 when there are no increases`() {
            val output = countDepthIncreases(
                listOf(
                    210,
                    208,
                    200,
                    199
                )
            )

            assertThat(output).isEqualTo(0)
        }
    }

    @Nested
    @DisplayName("Count 3-measurement increases")
    inner class CountThreeMeasurementIncreases {

        @Test
        fun `should count increases in groups of 3`() {
            val output = countThreeMeasurementIncreases(
                listOf(
                    199,
                    200,
                    208,
                    210,
                    200,
                    207,
                    240,
                    269,
                    260,
                    263
                )
            )

            assertThat(output).isEqualTo(5)
        }

        @Test
        fun `should return 0 when there are no increases`() {
            val output = countThreeMeasurementIncreases(
                listOf(
                    210,
                    208,
                    200,
                    199,
                    198,
                    190,
                    189,
                )
            )

            assertThat(output).isEqualTo(0)
        }
    }
}
