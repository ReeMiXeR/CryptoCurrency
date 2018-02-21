package com.sandbox.vs.tick.ui.main.interactor

import com.sandbox.vs.tick.data.database.CoinInfo
import com.sandbox.vs.tick.ui.base.interactor.MVPInteractor
import com.sandbox.vs.tick.ui.main.view.CurrencyItem
import io.reactivex.Observable
import io.reactivex.Single

interface MainMVPInteractor : MVPInteractor {
    fun getCurrencyList(pos: Int, limit: Int): Observable<Array<CurrencyItem>>
    fun getCoinInfo(text: String): Single<CoinInfo>
}