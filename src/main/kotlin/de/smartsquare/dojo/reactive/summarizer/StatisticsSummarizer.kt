package de.smartsquare.dojo.reactive.summarizer

import de.smartsquare.dojo.reactive.dashboard.Statistics
import de.smartsquare.dojo.reactive.tournament.Tournament
import reactor.core.publisher.Flux

class StatisticsSummarizer(private val tournament: Tournament) {

    fun summarize(): Flux<Statistics> = TODO("Summarize the tournament information for every second")
}
