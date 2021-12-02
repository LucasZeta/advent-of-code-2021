package com.lucaszeta.adventofcode2021.day2

class ImprovedSubmarineNavigation(
    var horizontalPosition: Int,
    var depth: Int,
    var aim: Int
) {

    fun navigate(input: Pair<Command, Int>) {
        val (command, distance) = input

        when (command) {
            Command.FORWARD -> {
                horizontalPosition += distance
                depth += aim * distance
            }
            Command.UP -> aim -= distance
            Command.DOWN -> aim += distance
        }
    }
}
