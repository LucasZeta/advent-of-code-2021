package com.lucaszeta.adventofcode2021.day4

class BingoBoard(
    val table: List<List<Int>>
) {
    val scoreIndexes = mutableListOf<Pair<Int, Int>>()

    fun update(numberDrawn: Int) {
        table.forEachIndexed { rowIndex, line ->
            val columnIndex = line.indexOf(numberDrawn)

            if (columnIndex >= 0) {
                scoreIndexes.add(rowIndex to columnIndex)
            }
        }
    }

    fun calculateScore() {
        // sum of unmarked numbers
        // multiplied by number in last scored index
    }

    fun hasWon(): Boolean {
        val size = table.size

        (0 until size).forEach { x ->
            if (scoreIndexes.count { it.first == x } == size) {
                return true
            }

            if (scoreIndexes.count { it.second == x } == size) {
                return true
            }
        }

        return false
    }
}
