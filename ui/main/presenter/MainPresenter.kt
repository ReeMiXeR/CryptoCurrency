package com.sandbox.vs.tick.ui.main.presenter

import com.sandbox.vs.tick.ui.base.presenter.BasePresenter
import com.sandbox.vs.tick.ui.main.interactor.MainMVPInteractor
import com.sandbox.vs.tick.ui.main.view.CurrencyItem
import com.sandbox.vs.tick.ui.main.view.MainMVPView
import com.sandbox.vs.tick.util.SchedulerProvider
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class MainPresenter<V : MainMVPView, I : MainMVPInteractor>
@Inject internal constructor(interactor: I, schedulerProvider: SchedulerProvider,
                             disposable: CompositeDisposable) : BasePresenter<V, I>(interactor = interactor, schedulerProvider = schedulerProvider, compositeDisposable = disposable),
        MainMVPPresenter<V, I> {

    val limit = 100
    var position = 0

    override fun onAttach(view: V?) {
        super.onAttach(view)
        getCurrencyList(limit, position)
//        getUserData()
//        getCurrencyItems()
    }


    private fun getCurrencyList(position: Int, limit: Int) {
        interactor?.let {
            compositeDisposable.add(
                    it.getCurrencyList(position, limit)
                            .compose(schedulerProvider.ioToMainObservableScheduler())
                            .subscribe({ currencyArray ->
                                getView()?.let {
                                    if (currencyArray.isEmpty()) return@subscribe
                                    else
                                        this.position += currencyArray.size
                                    it.displayCurrencyItems(currencyArray)
                                }
                            }, { err -> println(err) }))
        }
    }

    override fun getCurrencyList() {
        getCurrencyList(limit, position)
    }

    override fun getCoinInfo(text: String) {
        interactor?.let {
            compositeDisposable.add(
                    it.getCoinInfo(text)
                            .compose(schedulerProvider.ioToMainSingleScheduler())
                            .subscribe({ coinInfo ->
                                getView()?.let {
                                    //                                    if (coinInfo.isEmpty()) return@subscribe
//                                    else
                                    it.displayCoinInfo(coinInfo)
                                }
                            }, { err -> println(err) }))
        }
    }

    override fun displayCurrencyItems(currencyArray: Array<CurrencyItem>) {
        getView()?.displayCurrencyItems(currencyArray)
    }

//    override fun refreshQuestionCards() = getCurrencyItems()

//    private fun getCurrencyItems() = interactor?.let {
//        compositeDisposable.add(it.getCoinList()
//                .compose(schedulerProvider.ioToMainSingleScheduler())
//                .subscribe({ questionCard ->
//                    getView()?.let {
//                        if (questionCard.isEmpty()) return@subscribe
//                        else it.displayCurrencyItems(questionCard)
//                    }
//                }, { err -> println(err) }))
//    }

    //    private fun getUserData() = interactor?.let {
//        val userData = it.getUserDetails()
//        getView()?.inflateUserDetails(userData)
//    }

}