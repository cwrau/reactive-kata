package de.smartsquare.dojo.reactive.live

import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test
import reactor.core.publisher.Mono
import java.time.Duration

@Tag("Example")
internal class ErrorHandlingOperatorsExample {

    @Test
    fun retry() {
        Mono.fromCallable { throw RuntimeException("Boom!").also { println("Callable") } }
                .retry(3)
                .log()
                .subscribe()
    }

    @Test
    fun timeout() {
        Mono.fromCallable { Thread.sleep(50).let { "Data" } }
                .timeout(Duration.ofMillis(100), Mono.just("Cached Data"))
                .log()
                .subscribe(::println)
    }
}
