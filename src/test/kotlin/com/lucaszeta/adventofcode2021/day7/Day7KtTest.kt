package com.lucaszeta.adventofcode2021.day7

import com.google.common.truth.Truth.assertThat
import org.junit.jupiter.api.Test

class Day7KtTest {

    @Test
    fun `should calculate fuel`() {
        val crabsPosition = listOf(16, 1, 2, 0, 4, 2, 7, 1, 2, 14)

        assertThat(calculateFuel(crabsPosition, 2)).isEqualTo(37)
        assertThat(calculateFuel(crabsPosition, 1)).isEqualTo(41)
        assertThat(calculateFuel(crabsPosition, 3)).isEqualTo(39)
        assertThat(calculateFuel(crabsPosition, 10)).isEqualTo(71)
    }

    @Test
    fun `should calculate fuel considering distance cost`() {
        val crabsPosition = listOf(16, 1, 2, 0, 4, 2, 7, 1, 2, 14)

        assertThat(calculateFuelConsideringDistance(crabsPosition, 5)).isEqualTo(168)
        assertThat(calculateFuelConsideringDistance(crabsPosition, 2)).isEqualTo(206)
    }
}
