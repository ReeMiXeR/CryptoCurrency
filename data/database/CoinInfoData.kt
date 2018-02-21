package com.sandbox.vs.tick.data.database

import com.google.gson.annotations.SerializedName

data class CoinInfoData(
        @SerializedName("DISPLAY") val data: CoinInfo = CoinInfo()
)