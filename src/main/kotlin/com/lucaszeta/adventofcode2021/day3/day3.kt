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
}

fun findGammaRate(input: List<List<String>>): String {
    val bitSize = input[0].size
    var gammaRate = ""

    (0 until bitSize).forEach { index ->
        gammaRate += findMostCommonBit(input.map { it[index] })
    }

    return gammaRate
}

fun findMostCommonBit(bits: List<String>): String {
    val zeroes = bits.count { it == "0" }
    val ones = bits.size - zeroes

    return if (zeroes > ones) "0" else "1"
}

fun findEpsilonRate(gammaRate: String) = gammaRate
    .chunked(1).
    joinToString("") { if (it == "1") "0" else "1" }

fun calculatePowerConsumption(gammaRate: String, epsilonRate: String) =
    Integer.parseInt(gammaRate, 2) * Integer.parseInt(epsilonRate, 2)
