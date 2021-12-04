package com.lucaszeta.adventofcode2021.day4

import com.google.common.truth.Truth.assertThat
import org.junit.jupiter.api.Test

class BingoBoardTest {

    @Test
    fun `should win when scored numbers form a row`() {
        val board = BingoBoard(
            listOf(
                listOf(22, 13, 17, 11, 0),
                listOf(8, 2, 23, 4, 24),
                listOf(21, 9, 14, 16, 7),
                listOf(6, 10, 3, 18, 5),
                listOf(1, 12, 20, 15, 19)
            )
        ).apply {
            update(8)
            update(2)
            update(23)
            update(4)
        }

        assertThat(board.hasWon()).isFalse()

        board.update(24)

        assertThat(board.hasWon()).isTrue()
    }

    @Test
    fun `should win when scored numbers form a column`() {
        val board = BingoBoard(
            listOf(
                listOf(22, 13, 17, 11, 0),
                listOf(8, 2, 23, 4, 24),
                listOf(21, 9, 14, 16, 7),
                listOf(6, 10, 3, 18, 5),
                listOf(1, 12, 20, 15, 19)
            )
        ).apply {
            update(13)
            update(2)
            update(9)
            update(10)
        }

        assertThat(board.hasWon()).isFalse()

        board.update(12)

        assertThat(board.hasWon()).isTrue()
    }

    @Test
    fun `should calculate score based on last scored number and unmarked numbers`() {
        val board = BingoBoard(
            listOf(
                listOf(14, 21, 17, 24, 4),
                listOf(10, 16, 15, 9, 19),
                listOf(18, 8, 23, 26, 20),
                listOf(22, 11, 13, 6, 5),
                listOf(2, 0, 12, 3, 7),
            )
        ).apply {
            listOf(7, 4, 9, 5, 11, 17, 23, 2, 0, 14, 21, 24)
                .forEach(::update)
        }

        assertThat(board.calculateScore()).isEqualTo(4512)
    }
}
