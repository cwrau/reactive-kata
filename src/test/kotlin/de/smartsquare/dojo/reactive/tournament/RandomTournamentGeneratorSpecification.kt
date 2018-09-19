package de.smartsquare.dojo.reactive.tournament

import org.junit.jupiter.api.Test
import reactor.test.StepVerifier

internal class RandomTournamentGeneratorSpecification {

    @Test
    fun `no duplicate player in left team`() {
        StepVerifier.create(RandomTournamentGenerator().fetch(), 100)
                .expectNextMatches {
                    it.leftTeam[0] != it.leftTeam[1]
                }
                .thenCancel()
                .verify()
    }

    @Test
    fun `no duplicate player in right team`() {
        StepVerifier.create(RandomTournamentGenerator().fetch(), 100)
                .expectNextMatches {
                    it.rightTeam[0] != it.rightTeam[1]
                }
                .thenCancel()
                .verify()
    }
}