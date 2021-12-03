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

