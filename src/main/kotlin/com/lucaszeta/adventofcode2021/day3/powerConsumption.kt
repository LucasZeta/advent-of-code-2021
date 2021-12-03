package com.lucaszeta.adventofcode2021.day3

fun findGammaRate(input: List<List<String>>): String {
    val bitSize = input[0].size
    var gammaRate = ""

    (0 until bitSize).forEach { index ->
        gammaRate += findMostCommonBit(input.map { it[index] })
    }

    return gammaRate
}

fun findEpsilonRate(gammaRate: String) = gammaRate
    .chunked(1).
    joinToString("") { if (it == "1") "0" else "1" }

fun calculatePowerConsumption(gammaRate: String, epsilonRate: String) =
    Integer.parseInt(gammaRate, 2) * Integer.parseInt(epsilonRate, 2)
