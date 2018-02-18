package com.sandbox.vs.tick.data.database

import com.google.gson.annotations.SerializedName

data class CoinInfo (
        @SerializedName("FROMSYMBOL")  //        "Ƀ",
        val fromSymbol: String,
        @SerializedName("TOSYMBOL")  //        "$",
        val toSymbol: String,
        @SerializedName("MARKET")  //        "CUSTOMAGG",
        val market: String,
        @SerializedName("PRICE")  //        "$ 8,612.28",
        val price: String,
        @SerializedName("LASTUPDATE")  //        "Just now",
        val lastUpdate: String,
        @SerializedName("LASTVOLUME")  //        "Ƀ 0.06954",
        val lastVolume: String,
        @SerializedName("LASTVOLUMETO")  //        "$ 598.51",
        val lastVolumeTo: String,
        @SerializedName("LASTTRADEID")  //        "194907003",
        val lastTradeId: String,
        @SerializedName("VOLUME24HOUR")  //        "Ƀ 55,534.5",
        val volume24hour: String,
        @SerializedName("VOLUME24HOURTO")  //        "$ 480,200,793.8",
        val volume24hourTo: String,
        @SerializedName("OPEN24HOUR")  //        "$ 8,836.82",
        val open24hour: String,
        @SerializedName("HIGH24HOUR")  //        "$ 9,000.00",
        val hight24hour: String,
        @SerializedName("LOW24HOUR")  //        "$ 8,313.52",
        val low24hour: String,
        @SerializedName("LASTMARKET")  //        "Bitfinex",
        val lastMarket: String,
        @SerializedName("CHANGE24HOUR")  //        "$ -224.54",
        val change24hour: String,
        @SerializedName("CHANGEPCT24HOUR")  //        "-2.54",
        val changePct24hour: String,
        @SerializedName("CHANGEDAY")       //        "$ 0",
        val changeDay: String,
        @SerializedName("CHANGEPCTDAY")
        val changePtcDay: String                 //        "0"
)