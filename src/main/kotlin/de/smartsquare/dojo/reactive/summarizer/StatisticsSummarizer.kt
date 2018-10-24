package de.smartsquare.dojo.reactive.summarizer

import de.smartsquare.dojo.reactive.dashboard.Statistics
import de.smartsquare.dojo.reactive.tournament.Tournament
import java.time.Duration

class StatisticsSummarizer(private val tournament: Tournament) {

    fun summarizeGamesOfLastSecond() = tournament.fetch()
        .buffer(Duration.ofSeconds(1))
        .map { gameList ->
            gameList.map { game ->
                game.goalsPerPlayer.toStatistic()
            }.reduce { stats, stats2 ->
                stats + stats2
            }
        }
}

private operator fun Statistics.plus(statistics: Statistics) =
    Statistics(goalsPerPlayer.toMutableMap().apply {
        statistics.goalsPerPlayer.entries.forEach {
            merge(it.key, it.value, Int::plus)
        }
    })

private fun Map<String, Int>.toStatistic() = Statistics(this)
