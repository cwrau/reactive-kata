package de.smartsquare.dojo.reactive.live

import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.core.publisher.toFlux
import reactor.core.publisher.toMono
import reactor.core.scheduler.Schedulers
import java.time.Duration
import java.util.Arrays.asList

@Tag("Example")
internal class FluxAndMonoExample {

    @Test
    fun `creation of a flux`() {
        Flux.just("another", "coding", "dojo").subscribe(::println).also { println() }

        // kotlin support
        asList("another", "coding", "dojo").toFlux().subscribe(::println)
    }

    @Test
    fun `creation of a mono`() {
        Mono.just("astring").subscribe(::print)

        // kotlin support
        "astring".toMono().subscribe(::print)
    }

    @Test
    fun `flux to mono`() {
        Flux.just("another", "coding", "dojo")
                .takeLast(1)
                .toMono()
    }

    @Test
    fun `mono and mono to flux`() {
        "x".toMono().concatWith { "d".toMono() }
    }

    @Test
    fun `infinite flux`() {
        Flux.interval(Duration.ofMillis(10))
                .subscribeOn(Schedulers.elastic())
                .map { "B" }
                .subscribe(::println)

        Thread.sleep(10000)
    }

    @Test
    fun `mono from callable`() {
        Mono.fromCallable { BlockingApi().fetch() }
                .subscribeOn(Schedulers.elastic())
                .subscribe(::println)

        println("Falling asleep for 6 seconds")
        Thread.sleep(6000)
        println("Awakening")
    }

    private class BlockingApi {

        fun fetch() = Thread.sleep(5000).let { "Blocking API Response" }
    }
}
