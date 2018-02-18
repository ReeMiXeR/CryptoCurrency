package com.mindorks.framework.mvp.data.database.repository.questions

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.sandbox.vs.tick.data.network.model.Coin

@Dao
interface CoinDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(coin: Array<Coin>)

    @Query("SELECT * FROM coins")
    fun loadAll(): Array<Coin>
}