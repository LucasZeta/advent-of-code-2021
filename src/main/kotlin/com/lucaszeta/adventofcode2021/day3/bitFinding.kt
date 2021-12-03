package com.lucaszeta.adventofcode2021.day3

fun findMostCommonBit(bits: List<String>) =
    findCommonBit(bits) { zeroes, ones -> zeroes > ones }


fun findLeastCommonBit(bits: List<String>) =
    findCommonBit(bits) { zeroes, ones -> zeroes <= ones }

private fun findCommonBit(
    bits: List<String>,
    decisionFunction: (Int, Int) -> Boolean
): String {
    val zeroes = bits.count { it == "0" }
    val ones = bits.size - zeroes

    return if (decisionFunction(zeroes, ones)) "0" else "1"
}
