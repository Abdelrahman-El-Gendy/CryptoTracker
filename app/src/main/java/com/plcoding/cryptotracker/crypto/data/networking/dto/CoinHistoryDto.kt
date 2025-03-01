package com.plcoding.cryptotracker.crypto.data.networking.dto

import com.plcoding.cryptotracker.crypto.data.CoinPriceDto
import kotlinx.serialization.Serializable

@Serializable
data class CoinHistoryDto(
    val data: List<CoinPriceDto>
)