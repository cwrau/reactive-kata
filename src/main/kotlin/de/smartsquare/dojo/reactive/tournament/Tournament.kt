package de.smartsquare.dojo.reactive.tournament

import reactor.core.publisher.Flux

interface Tournament {

    fun fetch(): Flux<Game>
}
