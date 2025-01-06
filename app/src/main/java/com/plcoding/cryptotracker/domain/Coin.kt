package com.plcoding.cryptotracker.domain

data class Coin(
    val id: String,
    val rank: String,
    val name: String,
    val symbol: String,
    val marketCapUsd: Double,
    val priceUsd: Double,
    val changePercent24H: Double
)
