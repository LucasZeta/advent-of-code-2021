package com.lucaszeta.adventofcode2021.day2

class ImprovedSubmarineNavigation(
    var horizontalPosition: Int,
    var depth: Int,
    var aim: Int
) {

    fun navigate(input: String) {
        val (command, distance) = input.split(" ")

        when (command) {
            FORWARD -> {
                horizontalPosition += distance.toInt()
                depth += aim * distance.toInt()
            }
            UP -> aim -= distance.toInt()
            DOWN -> aim += distance.toInt()
        }
    }

    companion object {
        const val FORWARD = "forward"
        const val UP = "up"
        const val DOWN = "down"
    }
}
