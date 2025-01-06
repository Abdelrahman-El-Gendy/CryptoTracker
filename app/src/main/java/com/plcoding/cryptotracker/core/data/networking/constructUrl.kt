package com.plcoding.cryptotracker.core.data.networking

import com.plcoding.cryptotracker.BuildConfig


fun constructUrl(url: String): String {
    return when {
        url.contains(BuildConfig.BASE_URL) -> url
        // /asset
        url.startsWith('/') -> BuildConfig.BASE_URL + url.drop(1)
        // asset
        else -> BuildConfig.BASE_URL + url
    }
}