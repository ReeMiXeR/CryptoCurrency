package com.sandbox.vs.tick.data.network.model

import com.google.gson.annotations.SerializedName


class CoinListResponse(
        @SerializedName("Response") val response: String = "", //Success
        @SerializedName("Message") val message: String = "", //Coin list succesfully returned!
        @SerializedName("BaseImageUrl") val baseImageUrl: String = "", //https://www.cryptocompare.com
        @SerializedName("BaseLinkUrl") val baseLinkUrl: String = "", //https://www.cryptocompare.com
        @SerializedName("Data") val data: HashMap<String, Coin> = HashMap(),
        @SerializedName("Type") val type: Int = 0 //100
)