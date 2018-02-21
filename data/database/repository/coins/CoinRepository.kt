package com.sandbox.vs.tick.data.database.repository.coins

import com.mindorks.framework.mvp.data.database.repository.questions.CoinDao
import com.sandbox.vs.tick.data.network.model.Coin
import io.reactivex.Observable
import javax.inject.Inject

class CoinRepository @Inject internal constructor(private val coinDao: CoinDao) : CoinRepo {

    override fun isCoinRepoEmpty(): Observable<Boolean> = Observable.fromCallable({ coinDao.loadAll().isEmpty() })

    override fun insertCoins(coins: Array<Coin>): Array<Coin> {
//        coinDao.insertAll(coins)
        return coins
    }

    override fun loadCoins(position: Int, limit: Int): Observable<Array<Coin>> = Observable.fromCallable({ coinDao.loadAll() })

//    override fun insertCoins(questions: List<Question>): Observable<Boolean> {
//        coinDao.insertAll(questions)
//        return Observable.just(true)
//    }
}