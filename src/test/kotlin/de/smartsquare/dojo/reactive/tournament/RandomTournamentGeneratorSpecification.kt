package de.smartsquare.dojo.reactive.tournament

import org.junit.jupiter.api.Test
import reactor.test.StepVerifier

internal class RandomTournamentGeneratorSpecification {

    @Test
    fun `no duplicate player in left team`() {
        StepVerifier.create(RandomTournamentGenerator().fetch(), 100)
                .expectNextMatches {
                    it.leftTeam.firstPlayer() != it.leftTeam.secondPlayer()
                }
                .thenCancel()
                .verify()
    }

    @Test
    fun `no duplicate player in right team`() {
        StepVerifier.create(RandomTournamentGenerator().fetch(), 100)
                .expectNextMatches {
                    it.rightTeam.firstPlayer() != it.rightTeam.secondPlayer()
                }
                .thenCancel()
                .verify()
    }
}