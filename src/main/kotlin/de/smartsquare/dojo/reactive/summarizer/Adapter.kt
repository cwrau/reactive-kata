package de.smartsquare.dojo.reactive.summarizer

import de.smartsquare.dojo.reactive.dashboard.Dashboard

class Adapter private constructor() {

    companion object {

        fun connect(source: StatisticsSummarizer, sink: Dashboard): Nothing =
                TODO("Forward statistics to the dashboard and mind possible timeouts")
    }
}
