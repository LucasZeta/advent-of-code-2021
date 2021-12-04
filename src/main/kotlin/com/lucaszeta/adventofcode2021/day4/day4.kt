package com.lucaszeta.adventofcode2021.day4

import com.lucaszeta.adventofcode2021.ext.getResourceAsText

fun parseToDrawnNumbers(input: String) = input
    .split(",")
    .map { it.toInt() }

fun parseToBingoBoard(input: String) = input
    .split("\n")
    .map { line ->
        "\\d+".toRegex()
            .findAll(line)
            .toList()
            .map { it.groupValues.first() }
    }

fun main() {
    val input = getResourceAsText("/day4/bingo-table.txt")
        .split("\n\n")
        .toMutableList()

    val numbersDrawn = parseToDrawnNumbers(input.removeFirst())
    val boards = input.map(::parseToBingoBoard)

    println(numbersDrawn)
    println(boards)
}
