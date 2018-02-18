package com.sandbox.vs.tick.ui.main.view

import com.sandbox.vs.tick.data.database.CoinInfo
import com.sandbox.vs.tick.ui.base.view.MVPView

interface MainMVPView : MVPView {

    fun displayCurrencyItems(currencyArray: Array<CurrencyItem>)

    fun displayCoinInfo(coinInfo: CoinInfo)
}