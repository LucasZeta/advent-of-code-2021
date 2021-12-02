package com.lucaszeta.adventofcode2021.day2

class SubmarineNavigation(
    var horizontalPosition: Int,
    var depth: Int
) {

    fun navigate(input: Pair<Command, Int>) {
        val (command, distance) = input

        when (command) {
            Command.FORWARD -> horizontalPosition += distance
            Command.UP -> depth -= distance
            Command.DOWN -> depth += distance
        }
    }
}
