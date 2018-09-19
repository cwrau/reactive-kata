package de.smartsquare.dojo.reactive.tournament

import reactor.core.publisher.Flux
import java.time.Duration

/**
 * This class is a generator for randomly composed games.
 */
class SmartsquareTournament : Tournament {

    companion object {
        private const val GAME_INTERVAL = 10L
    }

    /**
     * @return a flux with a new random game every 10 milliseconds.
     */
    override fun fetch() = Flux.interval(Duration.ofMillis(GAME_INTERVAL)).map { generate() }

    private fun generate() = Game(
            leftTeam = listOf("saschar", "deen", "drs", "alex", "alexr").shuffled().takeLast(2),
            rightTeam = listOf("ruby", "danielr", "skonair", "jens").shuffled().takeLast(2)
    )
}
