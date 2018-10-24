package de.smartsquare.dojo.reactive.summarizer

import de.smartsquare.dojo.reactive.dashboard.Dashboard
import de.smartsquare.dojo.reactive.dashboard.FragileConsoleDashboard
import de.smartsquare.dojo.reactive.summarizer.Adapter.Companion.connect
import de.smartsquare.dojo.reactive.tournament.RandomTournamentGenerator
import java.lang.Thread.sleep

fun main(args: Array<String>) {
    val tournament = RandomTournamentGenerator()
    val summarizer = StatisticsSummarizer(tournament)
    val dashboard = FragileConsoleDashboard()

    connect(source = summarizer, sink = dashboard)
    sleep(10000)
}

class Adapter private constructor() {

    companion object {

        fun connect(source: StatisticsSummarizer, sink: Dashboard): Nothing =
                TODO("Forward statistics to the dashboard and mind possible timeouts")
    }
}
