package com.sandbox.vs.tick.di.module

import android.app.Application
import android.arch.persistence.room.Room
import android.content.Context
import com.sandbox.vs.tick.data.database.AppDatabase
import com.sandbox.vs.tick.data.database.repository.coins.CoinRepo
import com.sandbox.vs.tick.data.database.repository.coins.CoinRepository
import com.sandbox.vs.tick.data.network.ApiHelper
import com.sandbox.vs.tick.data.network.AppApiHelper
import com.sandbox.vs.tick.util.SchedulerProvider
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    internal fun provideContext(application: Application): Context = application

    @Provides
    internal fun provideSchedulerProvider(): SchedulerProvider = SchedulerProvider()

    @Provides
    @Singleton
    internal fun provideApiHelper(appApiHelper: AppApiHelper): ApiHelper = appApiHelper

    @Provides
    internal fun provideCompositeDisposable(): CompositeDisposable = CompositeDisposable()

    @Provides
    @Singleton
    internal fun provideQuestionRepoHelper(appDatabase: AppDatabase): CoinRepo = CoinRepository(appDatabase.coinDao())

    @Provides
    @Singleton
    internal fun provideAppDatabase(context: Context): AppDatabase =
            Room.databaseBuilder(context, AppDatabase::class.java, "DB_NAME").build()
//
//    @Provides
//    @ApiKeyInfo
//    internal fun provideApiKey(): String = BuildConfig.API_KEY
//
//    @Provides
//    @PreferenceInfo
//    internal fun provideprefFileName(): String = AppConstants.PREF_NAME
//
//    @Provides
//    @Singleton
//    internal fun providePrefHelper(appPreferenceHelper: AppPreferenceHelper): PreferenceHelper = appPreferenceHelper
//
//    @Provides
//    @Singleton
//    internal fun provideProtectedApiHeader(@ApiKeyInfo apiKey: String, preferenceHelper: PreferenceHelper)
//            : ApiHeader.ProtectedApiHeader = ApiHeader.ProtectedApiHeader(apiKey = apiKey,
//            userId = preferenceHelper.getCurrentUserId(),
//            accessToken = preferenceHelper.getAccessToken())
}