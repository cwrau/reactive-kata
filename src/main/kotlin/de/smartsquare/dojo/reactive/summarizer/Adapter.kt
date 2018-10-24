package de.smartsquare.dojo.reactive.summarizer

import de.smartsquare.dojo.reactive.dashboard.Dashboard
import de.smartsquare.dojo.reactive.dashboard.FragileConsoleDashboard
import de.smartsquare.dojo.reactive.summarizer.Adapter.connect
import de.smartsquare.dojo.reactive.tournament.RandomTournamentGenerator
import reactor.core.publisher.Mono
import java.lang.Thread.sleep
import java.time.Duration

fun main(args: Array<String>) {
    val tournament = RandomTournamentGenerator()
    val summarizer = StatisticsSummarizer(tournament)
    val dashboard = FragileConsoleDashboard()

    connect(source = summarizer, sink = dashboard)
    sleep(10000)
}

object Adapter {
    fun connect(source: StatisticsSummarizer, sink: Dashboard) = source
        .summarizeGamesOfLastSecond()
        .subscribe {
            Mono.fromCallable {
                sink.refresh(it)
            }
                .timeout(Duration.ofSeconds(1))
                .retry()
                .subscribe()
        }
}
