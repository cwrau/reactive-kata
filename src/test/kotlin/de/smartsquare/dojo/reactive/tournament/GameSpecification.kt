package de.smartsquare.dojo.reactive.tournament

import org.amshove.kluent.shouldContain
import org.junit.jupiter.api.Test

internal class GameSpecification {

    @Test
    fun `game generates ten random goals`() {
        val game = Game(leftTeam = listOf("saschar"), rightTeam = listOf("ruby"))

        listOf("saschar", "ruby") shouldContain (game scorerOfGoal 1)
    }
}