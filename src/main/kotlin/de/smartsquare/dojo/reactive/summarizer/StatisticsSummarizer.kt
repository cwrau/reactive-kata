package de.smartsquare.dojo.reactive.summarizer

import de.smartsquare.dojo.reactive.dashboard.Statistics
import de.smartsquare.dojo.reactive.tournament.Tournament
import reactor.core.publisher.Flux

class StatisticsSummarizer(private val tournament: Tournament) {

    fun summarizeGamesOfLastSecond(): Flux<Statistics> = TODO("Analyze games per second and map to statistics object")
}
