package com.lucaszeta.adventofcode2021.day3

fun findOxygenGeneratorRating(input: List<List<String>>) =
    findReadingBy(input, ::findMostCommonBit)

fun findCO2ScrubberRating(input: List<List<String>>) =
    findReadingBy(input, ::findLeastCommonBit)

fun calculateLifeSupportRating(oxygenGeneratorRating: String, co2ScrubberRating: String) =
    Integer.parseInt(oxygenGeneratorRating, 2) * Integer.parseInt(co2ScrubberRating, 2)

private fun findReadingBy(
    input: List<List<String>>,
    findBitFunction: (List<String>) -> String
): String {
    val candidates = input.toMutableList()
    var index = 0

    while (candidates.size > 1) {
        val commonBit = findBitFunction(candidates.map { it[index] })

        candidates.removeIf { it[index] != commonBit }

        ++index
    }

    return candidates.first().joinToString("")
}
