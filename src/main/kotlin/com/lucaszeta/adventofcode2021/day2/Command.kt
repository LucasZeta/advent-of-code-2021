package com.lucaszeta.adventofcode2021.day2

enum class Command {
    UP,
    DOWN,
    FORWARD;

    companion object {

        fun fromInput(search: String) = values()
            .firstOrNull { it.name.lowercase() == search }
            ?: throw IllegalArgumentException("Command not found")
    }
}
