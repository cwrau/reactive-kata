package de.smartsquare.dojo.reactive.summarizer

import de.smartsquare.dojo.reactive.dashboard.Statistics
import de.smartsquare.dojo.reactive.tournament.SmartsquareTournament
import reactor.core.publisher.Flux

class StatisticsSummarizer(private val smartsquareTournament: SmartsquareTournament) {

    fun summarize(): Flux<Statistics> = TODO("Summarize the smartsquareTournament information every second")
}
