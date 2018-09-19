package de.smartsquare.dojo.reactive.tournament

/**
 * This class is the database for the summarizer.
 */
data class Game(val leftTeam: List<String>, val rightTeam: List<String>) {

    companion object {
        private const val FIRST_PLAYER_INDEX = 1
        private const val LAST_PLAYER_INDEX = 10
    }

    val goals = IntRange(FIRST_PLAYER_INDEX, LAST_PLAYER_INDEX)
            .flatMap { leftTeam.shuffled().takeLast(1) }

    /**
     * @param goal is the index of the scored goal starting at 1.
     * @return the name of the scorer.
     */
    infix fun scorerOfGoal(goal: Int) = goals[goal + 1]
}
