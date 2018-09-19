package de.smartsquare.dojo.reactive.dashboard

import java.util.Random
import java.util.logging.Logger

/**
 * This class is a unstable dashboard which interacts as sink for the statistics
 * and uses the system console as user interface.
 */
class FragileConsoleDashboard : Dashboard {

    val log = Logger.getLogger("Fragile Console Dashboard")

    /**
     * This method could be slow.
     * @throws SomethingWentWrongException sometimes.
     */
    override fun refresh(statistics: Statistics) =
            when {
                Random().nextInt() % 2 == 0 -> Thread.sleep(3000).also { log.warning("Timeout") }
                Random().nextInt() % 3 == 0 -> throw SomethingWentWrongException("Boom!").also { log.warning("Error") }
                else -> print(statistics)
            }

    class SomethingWentWrongException(message: String) : RuntimeException(message)
}
