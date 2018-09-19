package de.smartsquare.dojo.reactive.dashboard

import de.smartsquare.dojo.reactive.tournament.Player

data class Statistics(val goalsPerPlayer: Map<Player, Goals>)
