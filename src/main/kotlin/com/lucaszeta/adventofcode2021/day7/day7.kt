package com.lucaszeta.adventofcode2021.day7

import com.lucaszeta.adventofcode2021.ext.getResourceAsText
import kotlin.math.abs

fun main() {
    val input = getResourceAsText("/day7/crabs-position.txt")
        .split(",")
        .map { it.toInt() }

    val fuelConsumption = findCheapestFuelConsumption(input, ::calculateFuel)
    val fuelConsumptionWithDistance = findCheapestFuelConsumption(input, ::calculateFuelConsideringDistance)

    println("Cheapest fuel consumption: $fuelConsumption")
    println("Cheapest fuel consumption considering distance cost: $fuelConsumptionWithDistance")
}

fun findCheapestFuelConsumption(
    input: List<Int>,
    calculateFuelFunction: (List<Int>, Int) -> Int
): Int {
    val minPosition = input.minOrNull()!!
    val maxPosition = input.maxOrNull()!!

    var cheapestFuelConsumption = Integer.MAX_VALUE

    (minPosition..maxPosition).forEach { position ->
        val fuel = calculateFuelFunction(input, position)

        if (fuel < cheapestFuelConsumption) {
            cheapestFuelConsumption = fuel
        }
    }

    return cheapestFuelConsumption
}

fun calculateFuel(input: List<Int>, desiredPosition: Int) = input
    .sumOf { currentPosition -> abs(currentPosition - desiredPosition) }

fun calculateFuelConsideringDistance(input: List<Int>, desiredPosition: Int) = input
    .sumOf { currentPosition ->
        val distance = abs(currentPosition - desiredPosition)
        (1..distance).sum()
    }
