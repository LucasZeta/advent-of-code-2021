package com.lucaszeta.adventofcode2021.day2

enum class Command(val input: String) {
    UP("up"),
    DOWN("down"),
    FORWARD("forward");

    companion object {

        fun fromInput(search: String) = values()
            .firstOrNull { it.input == search }
            ?: throw IllegalArgumentException("Command not found")
    }
}
