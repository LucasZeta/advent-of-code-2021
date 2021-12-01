package com.lucaszeta.adventofcode2021.ext

import com.google.common.truth.Truth.assertThat
import org.junit.jupiter.api.Test

class FileExtensionsKtTest {

    @Test
    fun `should read resource and return string contents`() {
        val input = getResourceAsText("/some-words.txt").split("\n")

        assertThat(input).hasSize(4)
        assertThat(input).containsExactly("a", "list", "of", "words")
    }

    @Test
    fun `should return empty string when file path is invalid`() {
        val input = getResourceAsText("/non-existent-file.txt")

        assertThat(input).isEmpty()
    }
}
