package com.lucaszeta.adventofcode2021.day1

import com.lucaszeta.adventofcode2021.ext.getResourceAsText

fun countDepthIncreases(depthMeasurements: List<Int>): Int {
    var timesDepthIncreased = 0

    depthMeasurements.forEachIndexed { index, currentDepth ->
        if (index != 0 && currentDepth > depthMeasurements[index - 1]) {
            timesDepthIncreased++
        }
    }

    return timesDepthIncreased
}

fun main() {
    val input = getResourceAsText("/day1/sweep-report.txt")
        .split("\n")
        .map { it.toInt() }

    println("Times measurements increased: ${countDepthIncreases(input)}")
}
