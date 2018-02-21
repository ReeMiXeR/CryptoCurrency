package com.sandbox.vs.tick.data.network

import com.rx2androidnetworking.Rx2AndroidNetworking
import com.sandbox.vs.tick.data.database.CoinInfoData
import com.sandbox.vs.tick.data.network.model.CoinListResponse
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject


class AppApiHelper @Inject constructor() : ApiHelper {
    override fun getCoinList(pos: Int, limit: Int): Observable<CoinListResponse> =
            Rx2AndroidNetworking.get("https://min-api.cryptocompare.com/data/all/coinlist")
                    .build()
                    .getObjectObservable(CoinListResponse::class.java)

    override fun getCoinInfo(text: String): Single<CoinInfoData> =
            Rx2AndroidNetworking.get("https://min-api.cryptocompare.com/data/generateAvg?fsym=BTC&tsym=USD&e=Coinbase,Bitfinex")
                    .build()
                    .getObjectSingle(CoinInfoData::class.java)

    //    override fun getCoinList(itemsLoaded: Int, limit: Int): Observable<List<CoinListResponse>>  =
//                Rx2AndroidNetworking.get("https://api.coinmarketcap.com/v1/ticker/?limit=10")
//                    .build()
//                    .getObjectObservable(List<CoinListResponse::class.java)

//    override fun performServerLogin(request: LoginRequest.ServerLoginRequest): Observable<LoginResponse> =
//            Rx2AndroidNetworking.post(ApiEndPoint.ENDPOINT_SERVER_LOGIN)
//                    .addHeaders(apiHeader.publicApiHeader)
//                    .addBodyParameter(request)
//                    .build()
//                    .getObjectObservable(LoginResponse::class.java)


}