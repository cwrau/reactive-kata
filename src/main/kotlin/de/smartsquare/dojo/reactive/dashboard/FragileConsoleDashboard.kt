package de.smartsquare.dojo.reactive.dashboard

/**
 * This class is a dashboard which interacts as sink for statistics.
 */
class FragileConsoleDashboard : Dashboard {

    var calls = 0
    private val isThirdCall get() = calls == 2

    /**
     * This method usually needs a few attempts to work properly.
     */
    override fun refresh(statistics: Statistics) = if (isThirdCall) {
        println(statistics)
    } else {
        calls++
        println("Timeout...")
        Thread.sleep(3000)
    }
}
