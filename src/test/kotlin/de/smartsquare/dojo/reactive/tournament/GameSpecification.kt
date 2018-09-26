package de.smartsquare.dojo.reactive.tournament

import org.amshove.kluent.shouldContain
import org.amshove.kluent.shouldNotHaveKey
import org.junit.jupiter.api.Test

internal class GameSpecification {

    @Test
    fun `map goals to player`() {
        val game = Game(
                leftTeam = listOf("deen", "drs"),
                rightTeam = listOf("alexn", "danielr"),
                goals = listOf("deen", "drs", "drs", "alexn", "alexn", "alexn")
        )

        game.goalsPerPlayer shouldNotHaveKey "danielr"
        game.goalsPerPlayer shouldContain ("deen" to 1)
        game.goalsPerPlayer shouldContain ("drs" to 2)
        game.goalsPerPlayer shouldContain ("alexn" to 3)
    }
}