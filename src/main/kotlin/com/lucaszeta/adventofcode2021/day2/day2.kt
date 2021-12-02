package com.lucaszeta.adventofcode2021.day2

import com.lucaszeta.adventofcode2021.ext.getResourceAsText

fun main() {
    val commandList = getResourceAsText("/day2/course.txt")
        .split("\n")
        .map {
            val (command, distance) = it.split(" ")
            Command.fromInput(command) to distance.toInt()
        }

    val basicNavigation = SubmarineNavigation(0, 0)
    commandList.forEach(basicNavigation::navigate)

    println("Horizontal position: ${basicNavigation.horizontalPosition}")
    println("Depth: ${basicNavigation.depth}")
    println("Product: ${basicNavigation.horizontalPosition * basicNavigation.depth}")

    val aimedNavigation = ImprovedSubmarineNavigation(0, 0, 0)
    commandList.forEach(aimedNavigation::navigate)

    println("Horizontal position: ${aimedNavigation.horizontalPosition}")
    println("Depth: ${aimedNavigation.depth}")
    println("Product: ${aimedNavigation.horizontalPosition * aimedNavigation.depth}")
}
