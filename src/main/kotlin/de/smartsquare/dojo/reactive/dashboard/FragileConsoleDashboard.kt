package de.smartsquare.dojo.reactive.dashboard

import java.lang.RuntimeException
import java.util.Random

/**
 * This class is a unstable dashboard which interacts as sink for the statistics
 * and uses the system console as user interface.
 */
class FragileConsoleDashboard : Dashboard {

    /**
     * This method could be slow.
     * @throws RuntimeException sometimes.
     */
    override fun refresh(statistics: Statistics) =
            when {
                Random().nextInt() % 2 == 0 -> Thread.sleep(3000)
                Random().nextInt() % 3 == 0 -> throw SomethingWentWrongException("Boom!")
                else -> print(statistics)
            }

    class SomethingWentWrongException(message: String) : RuntimeException(message)
}
