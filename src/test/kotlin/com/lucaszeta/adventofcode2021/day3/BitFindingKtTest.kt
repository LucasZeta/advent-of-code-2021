package com.lucaszeta.adventofcode2021.day3

import com.google.common.truth.Truth.assertThat
import org.junit.jupiter.api.Test

class BitFindingKtTest {

    @Test
    fun `should find most common bit`() {
        assertThat(findMostCommonBit(listOf("0", "0", "1", "0", "1"))).isEqualTo("0")
        assertThat(findMostCommonBit(listOf("0", "1", "1", "0", "1"))).isEqualTo("1")
    }

    @Test
    fun `should find least common bit`() {
        assertThat(findLeastCommonBit(listOf("0", "0", "1", "0", "1"))).isEqualTo("1")
        assertThat(findLeastCommonBit(listOf("0", "1", "1", "0", "1"))).isEqualTo("0")
    }
}
