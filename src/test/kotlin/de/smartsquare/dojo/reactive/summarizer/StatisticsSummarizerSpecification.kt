package de.smartsquare.dojo.reactive.summarizer

import de.smartsquare.dojo.reactive.tournament.Game
import de.smartsquare.dojo.reactive.tournament.Tournament
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Test
import reactor.core.publisher.Flux
import reactor.test.StepVerifier
import reactor.test.scheduler.VirtualTimeScheduler
import java.time.Duration

internal class StatisticsSummarizerSpecification {

    val tournament = mockk<Tournament>()
    val summarizer = StatisticsSummarizer(tournament)

    @Test
    fun `create statistic of one game`() {
        every { tournament.fetch() } returns Flux.just(
                Game(
                        leftTeam = listOf("deen", "ruby"),
                        rightTeam = listOf("drs", "danielr"),
                        goals = listOf(
                                "drs", "drs", "drs",
                                "ruby", "ruby", "ruby", "ruby", "ruby", "ruby", "ruby", "ruby", "ruby", "ruby")
                )
        )

        StepVerifier.create(summarizer.summarizeGamesOfLastSecond())
                .expectNextMatches {
                    it.goalsPerPlayer["drs"] == 3
                    it.goalsPerPlayer["ruby"] == 10
                }
                .verifyComplete()
    }

    @Test
    fun `create statistic of two game`() {
        every { tournament.fetch() } returns Flux.just(
                Game(
                        leftTeam = listOf("deen", "ruby"),
                        rightTeam = listOf("drs", "danielr"),
                        goals = listOf(
                                "drs", "drs", "drs",
                                "ruby", "ruby", "ruby", "ruby", "ruby", "ruby", "ruby", "ruby", "ruby", "ruby")
                ),
                Game(
                        leftTeam = listOf("deen", "ruby"),
                        rightTeam = listOf("drs", "danielr"),
                        goals = listOf(
                                "drs", "drs", "drs",
                                "ruby", "ruby", "ruby", "ruby", "ruby", "ruby", "ruby", "ruby", "ruby", "ruby")
                )
        )

        StepVerifier.create(summarizer.summarizeGamesOfLastSecond())
                .expectNextMatches {
                    it.goalsPerPlayer["drs"] == 6
                    it.goalsPerPlayer["ruby"] == 20
                }
                .verifyComplete()
    }

    @Test
    fun `player which does not scored a goal are not part of the statistics`() {
        every { tournament.fetch() } returns Flux.just(
                Game(
                        leftTeam = listOf("deen", "ruby"),
                        rightTeam = listOf("drs", "danielr"),
                        goals = emptyList()
                )
        )

        StepVerifier.create(summarizer.summarizeGamesOfLastSecond())
                .expectNextMatches { it.goalsPerPlayer["deen"] == null }
                .verifyComplete()
    }

    @Test
    fun `capture only one second`() {
        VirtualTimeScheduler.getOrSet()

        every { tournament.fetch() } returns Flux.interval(Duration.ofMillis(100L)).map {
            Game(
                    leftTeam = listOf("deen", "ruby"),
                    rightTeam = listOf("drs", "danielr"),
                    goals = listOf("drs")
            )
        }

        StepVerifier.withVirtualTime { summarizer.summarizeGamesOfLastSecond() }
                .expectSubscription()
                .thenAwait(Duration.ofSeconds(1))
                .expectNextMatches {
                    it.goalsPerPlayer["drs"] == 9
                }
                .thenAwait(Duration.ofMillis(100L))
                .expectNextCount(0)
                .thenCancel()
                .verify()
    }

    @Test
    fun `return infinite stream of statistics`() {
        VirtualTimeScheduler.getOrSet()

        every { tournament.fetch() } returns Flux.interval(Duration.ofMillis(100L)).map {
            Game(
                    leftTeam = listOf("deen", "ruby"),
                    rightTeam = listOf("drs", "danielr"),
                    goals = listOf("drs")
            )
        }

        StepVerifier.withVirtualTime { summarizer.summarizeGamesOfLastSecond() }
                .expectSubscription()
                .thenAwait(Duration.ofSeconds(1))
                .expectNextCount(1)
                .thenAwait(Duration.ofSeconds(1))
                .expectNextCount(1)
                .thenCancel()
                .verify()
    }
}
