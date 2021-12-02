package com.lucaszeta.adventofcode2021.day2

import com.google.common.truth.Truth.assertThat
import org.junit.jupiter.api.Test

class SubmarineNavigationTest {

    @Test
    fun `should go horizontal when receiving FORWARD command`() {
        val submarine = SubmarineNavigation(0, 0)
        submarine.navigate(Command.FORWARD to 3)

        assertThat(submarine.horizontalPosition).isEqualTo(3)
    }

    @Test
    fun `should increase depth when receiving DOWN command`() {
        val submarine = SubmarineNavigation(0, 0)
        submarine.navigate(Command.DOWN to 3)

        assertThat(submarine.depth).isEqualTo(3)
    }

    @Test
    fun `should decrease depth when receiving UP command`() {
        val submarine = SubmarineNavigation(0, 10)
        submarine.navigate(Command.UP to 3)

        assertThat(submarine.depth).isEqualTo(7)
    }

    @Test
    fun `should concatenate commands`() {
        val submarine = SubmarineNavigation(0, 0).apply {
            navigate(Command.FORWARD to 5)
            navigate(Command.DOWN to 5)
            navigate(Command.FORWARD to 8)
            navigate(Command.UP to 3)
            navigate(Command.DOWN to 8)
            navigate(Command.FORWARD to 2)
        }

        assertThat(submarine.horizontalPosition).isEqualTo(15)
        assertThat(submarine.depth).isEqualTo(10)
    }
}
