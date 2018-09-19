package de.smartsquare.dojo.reactive.summarizer

import de.smartsquare.dojo.reactive.dashboard.Dashboard

class StatisticsSummarizerDashboardAdapter(
    private val statisticsSummarizer: StatisticsSummarizer,
    private val dashboard: Dashboard
) {

    fun start(): Nothing = TODO("Forward statistics to the dashboard and mind possible exceptions or timeouts")
}
