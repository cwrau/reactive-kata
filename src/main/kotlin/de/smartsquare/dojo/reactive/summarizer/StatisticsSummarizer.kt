package de.smartsquare.dojo.reactive.summarizer

import de.smartsquare.dojo.reactive.dashboard.Statistics
import de.smartsquare.dojo.reactive.tournament.Tournament
import reactor.core.publisher.Mono

class StatisticsSummarizer(private val tournament: Tournament) {

    fun summarizeGamesOfLastSecond(): Mono<Statistics> = TODO("Analyze games per second and map to statistics object")
}
