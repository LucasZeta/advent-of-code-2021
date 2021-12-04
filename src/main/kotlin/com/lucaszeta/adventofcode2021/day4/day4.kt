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
    val boards = input.map(::parseToBingoBoard).toMutableList()

    val scores = mutableListOf<Int>()

    while (numbersDrawn.size > 0 && boards.isNotEmpty()) {
        val currentNumber = numbersDrawn.removeFirst()
        val boardsToRemove = mutableListOf<BingoBoard>()

        boards.forEach { board ->
            board.update(currentNumber)

            if (board.hasWon()) {
                scores.add(board.calculateScore())
                boardsToRemove.add(board)
            }
        }

        boardsToRemove.forEach(boards::remove)
    }

    println("Winning board's score: ${scores.first()}")
    println("Last winning board's score: ${scores.last()}")
}
