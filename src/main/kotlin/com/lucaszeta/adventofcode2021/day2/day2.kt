package com.lucaszeta.adventofcode2021.day2

import com.lucaszeta.adventofcode2021.ext.getResourceAsText

fun main() {
    val commandList = getResourceAsText("/day2/course.txt")
        .split("\n")

    val submarine = SubmarineNavigation(0, 0)
    commandList.forEach(submarine::navigate)

    println("Horizontal position: ${submarine.horizontalPosition}")
    println("Depth: ${submarine.depth}")
    println("Product: ${submarine.horizontalPosition * submarine.depth}")
}
