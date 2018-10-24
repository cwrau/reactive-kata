package de.smartsquare.dojo.reactive.live

import de.smartsquare.dojo.reactive.tournament.RandomTournamentGenerator
import de.smartsquare.dojo.reactive.tournament.firstPlayer
import de.smartsquare.dojo.reactive.tournament.secondPlayer
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.core.publisher.toFlux
import reactor.test.StepVerifier
import java.util.Arrays.asList

@Tag("Example")
internal class TestingExample {

    @Test
    fun `expectation on a flux`() {
        val source = asList("foo", "bar").toFlux()

        StepVerifier.create(source)
                .expectNext("foo")
                .expectNext("bar")
                .expectErrorMessage("boom")
                .verify()
    }

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