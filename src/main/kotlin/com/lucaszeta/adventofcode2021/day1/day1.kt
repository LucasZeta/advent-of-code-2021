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

fun countThreeMeasurementIncreases(depthMeasurements: List<Int>): Int {
    var timesDepthIncreased = 0

    depthMeasurements.forEachIndexed { index, currentDepth ->
        if (index < 3) return@forEachIndexed

        val currentMeasurement = currentDepth + depthMeasurements[index - 1] + depthMeasurements[index - 2]
        val lastMeasurement = depthMeasurements[index - 1] + depthMeasurements[index - 2] + depthMeasurements[index - 3]

        if (currentMeasurement > lastMeasurement) {
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
    println("Times a 3-measurement window increased: ${countThreeMeasurementIncreases(input)}")
}
