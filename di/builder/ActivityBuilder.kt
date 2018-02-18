package com.sandbox.vs.tick.di.builder

import com.sandbox.vs.tick.ui.main.MainActivityModule
import com.sandbox.vs.tick.ui.main.view.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {


    @ContributesAndroidInjector(modules = [(MainActivityModule::class)])
    abstract fun bindMainActivity(): MainActivity

//    @ContributesAndroidInjector(modules = [(SplashActivityModule::class)])
//    abstract fun bindSplashActivity(): SplashMVPActivity
//
//    @ContributesAndroidInjector(modules = [(LoginActivityModule::class)])
//    abstract fun bindLoginActivity(): LoginActivity
//
//    @ContributesAndroidInjector(modules = [(BlogFragmentProvider::class), (OpenSourceFragmentProvider::class)])
//    abstract fun bindFeedActivity(): FeedActivity

}