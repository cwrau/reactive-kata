package de.smartsquare.dojo.reactive.dashboard

/**
 * This class is a dashboard which interacts as sink for statistics.
 */
class StableConsoleDashboard : Dashboard {

    override fun refresh(statistics: Statistics) = print(statistics)
}
