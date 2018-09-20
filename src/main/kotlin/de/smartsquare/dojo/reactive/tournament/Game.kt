@file:Suppress("NOTHING_TO_INLINE")

package de.smartsquare.dojo.reactive.tournament

/**
 * This class is the database for the summarizer.
 */
data class Game(val leftTeam: List<Player>, val rightTeam: List<Player>, val goals: List<Player>)

inline fun List<Player>.secondPlayer() = this[1]
inline fun List<Player>.firstPlayer() = this[0]
