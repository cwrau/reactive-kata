package de.smartsquare.dojo.reactive.dashboard

/**
 * This data class is for holding the scored goals per player.
 *
 * ```
 * [
 *     "drs": 2,
 *     "deen": 1
 * ]
 * ```
 */
data class Statistics(val goalsPerPlayer: Map<String, Int>)
