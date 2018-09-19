package de.smartsquare.dojo.reactive.tournament

import org.junit.jupiter.api.Test
import reactor.test.StepVerifier

internal class SmartsquareTournamentSpecification {

    @Test
    fun `goal scorer are random member of the left team`() {
        StepVerifier.create(SmartsquareTournament().fetch(), 100)
                .expectNextMatches {
                    it.leftTeam.contains(it.goals[0])
                }
                .thenCancel()
                .verify()
    }

    @Test
    fun `no duplicate player in left team`() {
        StepVerifier.create(SmartsquareTournament().fetch(), 100)
                .expectNextMatches {
                    it.leftTeam[0] != it.leftTeam[1]
                }
                .thenCancel()
                .verify()
    }

    @Test
    fun `no duplicate player in right team`() {
        StepVerifier.create(SmartsquareTournament().fetch(), 100)
                .expectNextMatches {
                    it.rightTeam[0] != it.rightTeam[1]
                }
                .thenCancel()
                .verify()
    }
}