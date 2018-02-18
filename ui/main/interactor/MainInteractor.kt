package com.sandbox.vs.tick.ui.main.interactor


import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.sandbox.vs.tick.data.database.CoinInfo
import com.sandbox.vs.tick.data.database.repository.coins.CoinRepo
import com.sandbox.vs.tick.data.network.ApiHelper
import com.sandbox.vs.tick.data.network.model.Coin
import com.sandbox.vs.tick.data.network.model.CoinListResponse
import com.sandbox.vs.tick.ui.base.interactor.BaseInteractor
import com.sandbox.vs.tick.ui.main.view.CurrencyItem
import io.reactivex.Observable
import io.reactivex.Single
import org.json.JSONObject
import javax.inject.Inject

class MainInteractor @Inject internal constructor(private val coinsRepoHelper: CoinRepo, apiHelper: ApiHelper) : BaseInteractor(apiHelper = apiHelper), MainMVPInteractor {

    override fun getCurrencyList(pos: Int, limit: Int): Observable<Array<CurrencyItem>> =
            coinsRepoHelper.loadCoins(pos, limit)
                    .flatMap {
                        if (it.isEmpty())
                            apiHelper.getCoinList(pos, limit)
                                    .map { coinsRepoHelper.insertCoins(responseToCoin(it)) }
                                    .map { coinToCurrencyItem(it) }
                        else coinsRepoHelper.loadCoins(pos, limit)
                                .map { coinToCurrencyItem(it) }
                    }

    private fun jsonToCoinInfo(it: JSONObject): CoinInfo? = CoinInfo(it.getString(""), it.getString(""),it.getString(""),it.getString(""),it.getString(""),it.getString(""),it.getString(""),it.getString(""),it.getString(""),it.getString(""),it.getString(""),it.getString(""),it.getString(""),it.getString(""),it.getString(""),it.getString(""),it.getString(""),it.getString(""))

    override fun getCoinInfo(text: String): Single<CoinInfo> =
        apiHelper.getCoinInfo(text)
                .map { jsonToCoinInfo(it) }

        inline fun <reified T> Gson.fromJson(json: String) = this.fromJson<T>(json, object : TypeToken<T>() {}.type)

    private fun coinToCurrencyItem(it: Array<Coin>): Array<CurrencyItem>? = Array(it.size, { i -> CurrencyItem(it.elementAt(i)) })

    private fun responseToCoin(it: CoinListResponse): Array<Coin> = Array(it.data.size, { i -> it.data.values.elementAt(i) })
}