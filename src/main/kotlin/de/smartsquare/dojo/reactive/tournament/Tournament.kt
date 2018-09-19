package de.smartsquare.dojo.reactive.tournament

import reactor.core.publisher.Flux

/**
 * This is the interface to various IoT foosball tables.
 */
interface Tournament {

    /**
     * @return an infinite stream of played foosball games.
     */
    fun fetch(): Flux<Game>
}
