package com.lucaszeta.adventofcode2021.day4

class BingoBoard(
    private val table: List<List<Int>>
) {
    private val scoreIndexes = mutableListOf<Pair<Int, Int>>()

    fun update(numberDrawn: Int) {
        table.forEachIndexed { rowIndex, line ->
            val columnIndex = line.indexOf(numberDrawn)

            if (columnIndex >= 0) {
                scoreIndexes.add(rowIndex to columnIndex)
            }
        }
    }

    fun calculateScore(): Int {
        val lastScoredNumber = table[scoreIndexes.last().first][scoreIndexes.last().second]
        var sumUnmarkedNumbers = 0

        table.forEachIndexed { rowIndex, line ->
            sumUnmarkedNumbers += line.filterIndexed { columnIndex, _ ->
                !scoreIndexes.contains(rowIndex to columnIndex)
            }.sum()
        }

        return sumUnmarkedNumbers * lastScoredNumber
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
