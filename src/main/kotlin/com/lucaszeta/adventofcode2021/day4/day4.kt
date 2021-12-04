package com.lucaszeta.adventofcode2021.day4

import com.lucaszeta.adventofcode2021.ext.getResourceAsText

fun parseToDrawnNumbers(input: String) = input
    .split(",")
    .map { it.toInt() }
    .toMutableList()

fun parseToBingoBoard(input: String): BingoBoard {
    val table = input
        .split("\n")
        .map { line ->
            "\\d+".toRegex()
                .findAll(line)
                .toList()
                .map { it.groupValues.first().toInt() }
        }

    return BingoBoard(table)
}

fun main() {
    val input = getResourceAsText("/day4/bingo-table.txt")
        .split("\n\n")
        .toMutableList()

    val numbersDrawn = parseToDrawnNumbers(input.removeFirst())
    val boards = input.map(::parseToBingoBoard)

    var winningBoard: BingoBoard? = null

    while (numbersDrawn.size > 0 && winningBoard == null) {
        val currentNumber = numbersDrawn.removeFirst()

        boards.forEach { board ->
            board.update(currentNumber)

            if (board.hasWon()) {
                winningBoard = board
            }
        }
    }

    println("Winning board's score: ${winningBoard?.calculateScore()}")
}
