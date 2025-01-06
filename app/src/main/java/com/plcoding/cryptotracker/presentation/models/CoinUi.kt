package com.plcoding.cryptotracker.presentation.models

import android.icu.number.NumberFormatter
import androidx.annotation.DrawableRes
import com.plcoding.cryptotracker.domain.Coin
import com.plcoding.cryptotracker.util.getDrawableIdForCoin
import java.text.NumberFormat
import java.util.Locale

data class CoinUi(
    val id: String,
    val rank: String,
    val name: String,
    val symbol: String,
    val marketCapUsd: DisplayableNumber,
    val priceUsd: DisplayableNumber,
    val changePercent24H: DisplayableNumber,
    @DrawableRes val iconRes: Int

)

// The Data Type for the marketCapUsd , priceUsd , changePercentUsd
data class DisplayableNumber(
    val value: Double,
    val formated: String
)

// Extension Function
fun Coin.toCoinUi(): CoinUi {
    return CoinUi(
        id = id,
        name = name,
        rank = rank,
        symbol = symbol,
        marketCapUsd = marketCapUsd.toDisplayableNumber(),
        changePercent24H = changePercent24H.toDisplayableNumber(),
        priceUsd = priceUsd.toDisplayableNumber(),
        iconRes = getDrawableIdForCoin(symbol)
    )
}

fun Double.toDisplayableNumber(): DisplayableNumber {
    val formatter = NumberFormat.getNumberInstance(Locale.getDefault()).apply {
        minimumFractionDigits = 2
        maximumFractionDigits = 2
    }
    return DisplayableNumber(value = this, formated = formatter.format(this))
}