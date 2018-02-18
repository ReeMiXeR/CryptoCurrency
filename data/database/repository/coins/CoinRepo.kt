package com.sandbox.vs.tick.data.database.repository.coins

import com.sandbox.vs.tick.data.network.model.Coin
import io.reactivex.Observable

interface CoinRepo {

    fun isCoinRepoEmpty(): Observable<Boolean>

    fun insertCoins(coins: Array<Coin>): Array<Coin>

    fun loadCoins(position: Int, limit: Int): Observable<Array<Coin>>
}