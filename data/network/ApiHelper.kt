package com.sandbox.vs.tick.data.network

import com.sandbox.vs.tick.data.database.CoinInfoData
import com.sandbox.vs.tick.data.network.model.CoinListResponse
import io.reactivex.Observable
import io.reactivex.Single
import org.json.JSONArray
import org.json.JSONObject

interface ApiHelper {
    fun getCoinList(pos: Int, limit: Int): Observable<CoinListResponse>
    fun getCoinInfo(text: String): Single<CoinInfoData>
}