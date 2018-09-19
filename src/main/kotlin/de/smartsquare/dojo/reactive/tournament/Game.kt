package de.smartsquare.dojo.reactive.tournament

/**
 * This class is the database for the summarizer.
 */
data class Game(val leftTeam: List<Player>, val rightTeam: List<Player>, val goals: List<Player>)
