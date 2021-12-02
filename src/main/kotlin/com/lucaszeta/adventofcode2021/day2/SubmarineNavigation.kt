package com.lucaszeta.adventofcode2021.day2

class SubmarineNavigation(
    var horizontalPosition: Int,
    var depth: Int
) {

    fun navigate(input: String) {
        val (command, distance) = input.split(" ")

        when (command) {
            FORWARD -> horizontalPosition += distance.toInt()
            UP -> depth -= distance.toInt()
            DOWN -> depth += distance.toInt()
        }
    }

    companion object {
        const val FORWARD = "forward"
        const val UP = "up"
        const val DOWN = "down"
    }
}
