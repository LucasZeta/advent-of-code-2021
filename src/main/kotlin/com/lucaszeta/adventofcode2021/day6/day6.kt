package com.lucaszeta.adventofcode2021.day6

import com.lucaszeta.adventofcode2021.ext.getResourceAsText

fun main() {
    val input = getResourceAsText("/day6/nearby-lanternfish-ages.txt")
        .split(",")
        .map { it.toInt() }
        .toMutableList()

    repeat(80) {
        var newLanternFish = 0

        input.forEachIndexed { index, age ->
            if (age == 0) {
                input[index] = 6
                newLanternFish++
            } else {
                input[index] -= 1
            }
        }

        repeat(newLanternFish) { input.add(8) }
    }

    println(input.size)
}
