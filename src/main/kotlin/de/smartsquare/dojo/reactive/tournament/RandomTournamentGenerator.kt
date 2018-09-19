package de.smartsquare.dojo.reactive.tournament

import reactor.core.publisher.Flux
import java.time.Duration
import java.util.Random

/**
 * This class is a generator for randomly composed games.
 */
class RandomTournamentGenerator : Tournament {

    /**
     * @return a flux with a new random game every 10 milliseconds.
     */
    override fun fetch() = Flux.interval(Duration.ofMillis(10)).map { generate() }

    private fun generate(): Game {
        val leftTeam = listOf("saschar", "deen", "drs", "alex", "alexr").shuffled().takeLast(2).map(::Player)
        val rightTeam = listOf("ruby", "danielr", "skonair", "jens").shuffled().takeLast(2).map(::Player)
        val goals = IntRange(1, 10)
                .flatMap { leftTeam or rightTeam.shuffled().takeLast(1) }

        return Game(leftTeam, rightTeam, goals)
    }

    @Suppress("NOTHING_TO_INLINE", "FunctionMinLength")
    private inline infix fun List<Player>.or(other: List<Player>) = if (Random().nextInt() % 2 == 0) this else other
}
