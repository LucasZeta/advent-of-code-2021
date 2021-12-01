package com.lucaszeta.adventofcode2021.ext

fun getResourceAsText(path: String) =
    object {}.javaClass.getResource(path)?.readText() ?: ""
