package com.lucaszeta.adventofcode2021.day4

import com.google.common.truth.Truth.assertThat
import org.junit.jupiter.api.Test

class Day4KtTest {

    @Test
    fun `should parse to BingBoard with correct table`() {
        val board = parseToBingoBoard(
            "" +
                "22 13 17 11  0\n" +
                " 8  2 23  4 24\n" +
                "21  9 14 16  7\n" +
                " 6 10  3 18  5\n" +
                " 1 12 20 15 19"
        )

        assertThat(board.table).hasSize(5)
        assertThat(board.table.first()).containsExactly(22, 13, 17, 11, 0)
        assertThat(board.table.last()).containsExactly(1, 12, 20, 15, 19)
    }
}
