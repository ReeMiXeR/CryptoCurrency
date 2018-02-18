package com.sandbox.vs.tick.data.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.mindorks.framework.mvp.data.database.repository.questions.CoinDao
import com.sandbox.vs.tick.data.network.model.Coin

@Database(entities = [(Coin::class)], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun coinDao(): CoinDao

}