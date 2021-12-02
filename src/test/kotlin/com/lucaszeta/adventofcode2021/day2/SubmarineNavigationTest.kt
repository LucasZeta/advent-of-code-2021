package com.lucaszeta.adventofcode2021.day2

import com.google.common.truth.Truth.assertThat
import org.junit.jupiter.api.Test

class SubmarineNavigationTest {

    @Test
    fun `should go horizontal when receiving FORWARD command`() {
        val submarine = SubmarineNavigation(0, 0)
        submarine.navigate("forward 3")

        assertThat(submarine.horizontalPosition).isEqualTo(3)
    }

    @Test
    fun `should increase depth when receiving DOWN command`() {
        val submarine = SubmarineNavigation(0, 0)
        submarine.navigate("down 3")

        assertThat(submarine.depth).isEqualTo(3)
    }

    @Test
    fun `should decrease depth when receiving UP command`() {
        val submarine = SubmarineNavigation(0, 10)
        submarine.navigate("up 3")

        assertThat(submarine.depth).isEqualTo(7)
    }

    @Test
    fun `should concatenate commands`() {
        val submarine = SubmarineNavigation(0, 0).apply {
            navigate("forward 5")
            navigate("down 5")
            navigate("forward 8")
            navigate("up 3")
            navigate("down 8")
            navigate("forward 2")
        }

        assertThat(submarine.horizontalPosition).isEqualTo(15)
        assertThat(submarine.depth).isEqualTo(10)
    }

    @Test
    fun `should not move when receiving invalid command`() {
        val submarine = SubmarineNavigation(0, 0)
        submarine.navigate("invalid 10")

        assertThat(submarine.horizontalPosition).isEqualTo(0)
        assertThat(submarine.depth).isEqualTo(0)
    }
}
