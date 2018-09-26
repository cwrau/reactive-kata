@file:Suppress("NOTHING_TO_INLINE")

package de.smartsquare.dojo.reactive.tournament

/**
 * This class is the database for the summarizer.
 *
 * @property leftTeam name of the players in the left team (1..2)
 * @property rightTeam name of the players in the right team (1..2)
 * @property goals name of the players who scored a goal
 * @property goalsPerPlayer all player who scored at least one goal to the value of scored goals.
 */
data class Game(val leftTeam: List<String>, val rightTeam: List<String>, val goals: List<String>) {

    val goalsPerPlayer get() = goals.groupingBy { it }.eachCount()
}

inline fun List<String>.secondPlayer() = this[1]
inline fun List<String>.firstPlayer() = this[0]
