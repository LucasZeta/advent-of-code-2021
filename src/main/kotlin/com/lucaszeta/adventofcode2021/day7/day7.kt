package com.lucaszeta.adventofcode2021.day7

import com.lucaszeta.adventofcode2021.ext.getResourceAsText
import kotlin.math.abs

fun main() {
    val input = getResourceAsText("/day7/crabs-position.txt")
        .split(",")
        .map { it.toInt() }

    val cheapestFuelConsumption = findCheapestFuelConsumption(input)

    println("Cheapest Fuel Consumption: $cheapestFuelConsumption")
}

fun findCheapestFuelConsumption(input: List<Int>): Int {
    val minPosition = input.minOrNull()!!
    val maxPosition = input.maxOrNull()!!

    var cheapestFuelConsumption = Integer.MAX_VALUE

    (minPosition..maxPosition).forEach { position ->
        val fuel = calculateFuel(input, position)

        if (fuel < cheapestFuelConsumption) {
            cheapestFuelConsumption = fuel
        }
    }

    return cheapestFuelConsumption
}

fun calculateFuel(input: List<Int>, desiredPosition: Int) = input
    .sumOf { currentPosition -> abs(currentPosition - desiredPosition) }
