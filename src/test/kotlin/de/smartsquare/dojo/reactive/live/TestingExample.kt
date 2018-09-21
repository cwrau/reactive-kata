package de.smartsquare.dojo.reactive.live

import de.smartsquare.dojo.reactive.tournament.RandomTournamentGenerator
import de.smartsquare.dojo.reactive.tournament.firstPlayer
import de.smartsquare.dojo.reactive.tournament.secondPlayer
import org.junit.jupiter.api.Test
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.core.publisher.toFlux
import reactor.test.StepVerifier
import java.util.Arrays.asList

internal class TestingExample {

    @Test
    fun `expectation on a flux`() {
        val source = asList("foo", "bar").toFlux()

        StepVerifier.create(
                appendBoomError(source))
                .expectNext("foo")
                .expectNext("bar")
                .expectErrorMessage("boom")
                .verify()
    }

    private fun <T> appendBoomError(source: Flux<T>): Flux<T> =
            source.concatWith(Mono.error(IllegalArgumentException("boom")))

    @Test
    fun `expectation on an infinite flux`() {
        StepVerifier.create(RandomTournamentGenerator().fetch(), 100)
                .expectNextMatches {
                    it.leftTeam.firstPlayer() != it.leftTeam.secondPlayer()
                }
                .thenCancel()
                .verify()
    }
}