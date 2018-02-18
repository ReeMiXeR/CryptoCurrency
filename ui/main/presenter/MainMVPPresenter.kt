package com.sandbox.vs.tick.ui.main.presenter

import com.sandbox.vs.tick.ui.base.presenter.MVPPresenter
import com.sandbox.vs.tick.ui.main.interactor.MainMVPInteractor
import com.sandbox.vs.tick.ui.main.view.CurrencyItem
import com.sandbox.vs.tick.ui.main.view.MainMVPView

interface MainMVPPresenter<V : MainMVPView, I : MainMVPInteractor> : MVPPresenter<V, I> {
    fun displayCurrencyItems(currencyArray: Array<CurrencyItem>)
    fun getCurrencyList()
    fun getCoinInfo(text: String)
}