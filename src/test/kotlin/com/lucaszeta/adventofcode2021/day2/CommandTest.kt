package com.lucaszeta.adventofcode2021.day2

import com.google.common.truth.Truth.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class CommandTest {

    @Test
    fun `should parse valid input`() {
        assertThat(Command.fromInput("up")).isEqualTo(Command.UP)
        assertThat(Command.fromInput("down")).isEqualTo(Command.DOWN)
        assertThat(Command.fromInput("forward")).isEqualTo(Command.FORWARD)
    }

    @Test
    fun `should throw error when receiving invalid input`() {
        assertThrows<IllegalArgumentException> {
            Command.fromInput("invalid")
        }
    }
}
