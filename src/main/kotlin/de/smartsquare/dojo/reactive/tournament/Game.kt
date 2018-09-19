package de.smartsquare.dojo.reactive.tournament

/**
 * This class is the database for the summarizer.
 */
data class Game(val leftTeam: List<String>, val rightTeam: List<String>, val goals: List<String>)