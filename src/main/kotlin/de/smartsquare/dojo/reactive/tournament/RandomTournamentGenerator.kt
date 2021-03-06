package de.smartsquare.dojo.reactive.tournament

import reactor.core.publisher.Flux
import java.time.Duration
import java.util.Random

/**
 * This class is a generator for randomly composed games.
 */
class RandomTournamentGenerator : Tournament {

    /**
     * @return a flux with a new random game every 100 milliseconds.
     */
    override fun fetch() = Flux.interval(Duration.ofMillis(100)).map { generate() }

    private fun generate(): Game {
        val leftTeam = listOf("saschar", "deen", "drs", "alex", "alexr").shuffled().takeLast(2)
        val rightTeam = listOf("ruby", "danielr", "skonair", "jens").shuffled().takeLast(2)
        val goals = IntRange(1, 10)
                .flatMap { leftTeam or rightTeam.shuffled().takeLast(1) }

        return Game(leftTeam, rightTeam, goals)
    }

    @Suppress("NOTHING_TO_INLINE", "FunctionMinLength")
    private inline infix fun List<String>.or(other: List<String>) = if (Random().nextInt() % 2 == 0) this else other
}
