package com.lucaszeta.adventofcode2021.day3

import com.lucaszeta.adventofcode2021.ext.getResourceAsText

fun main() {
    val input = getResourceAsText("/day3/diagnostic-report.txt")
        .split("\n")
        .map { it.chunked(1) }

    val gammaRate = findGammaRate(input)
    val epsilonRate = findEpsilonRate(gammaRate)
    val powerConsumption = calculatePowerConsumption(gammaRate, epsilonRate)

    println("Gamma Rate: $gammaRate")
    println("Epsilon Rate: $epsilonRate")
    println("Power consumption: $powerConsumption")

    val oxygenGeneratorRating = findOxygenGeneratorRating(input)
    val co2ScrubberRating = findCO2ScrubberRating(input)
    val lifeSupportRating = calculateLifeSupportRating(oxygenGeneratorRating, co2ScrubberRating)

    println("Oxygen Generator Rating: $oxygenGeneratorRating")
    println("CO2 Scrubber Rating: $co2ScrubberRating")
    println("Life Support Rating: $lifeSupportRating")
}

fun calculateLifeSupportRating(oxygenGeneratorRating: String, co2ScrubberRating: String) =
    Integer.parseInt(oxygenGeneratorRating, 2) * Integer.parseInt(co2ScrubberRating, 2)

fun findGammaRate(input: List<List<String>>): String {
    val bitSize = input[0].size
    var gammaRate = ""

    (0 until bitSize).forEach { index ->
        gammaRate += findMostCommonBit(input.map { it[index] })
    }

    return gammaRate
}

fun findOxygenGeneratorRating(input: List<List<String>>): String {
    val candidates = input.toMutableList()
    var index = 0

    while (candidates.size > 1) {
        val mostCommonBit = findMostCommonBit(candidates.map { it[index] })

        candidates.removeIf { it[index] != mostCommonBit }

        ++index
    }

    return candidates.first().joinToString("")
}

fun findCO2ScrubberRating(input: List<List<String>>): String {
    val candidates = input.toMutableList()
    var index = 0

    while (candidates.size > 1) {
        val mostCommonBit = findLeastCommonBit(candidates.map { it[index] })

        candidates.removeIf { it[index] != mostCommonBit }

        ++index
    }

    return candidates.first().joinToString("")
}

fun findEpsilonRate(gammaRate: String) = gammaRate
    .chunked(1).
    joinToString("") { if (it == "1") "0" else "1" }

fun calculatePowerConsumption(gammaRate: String, epsilonRate: String) =
    Integer.parseInt(gammaRate, 2) * Integer.parseInt(epsilonRate, 2)
