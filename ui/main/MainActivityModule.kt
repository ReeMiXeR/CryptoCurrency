package com.sandbox.vs.tick.ui.main

import com.sandbox.vs.tick.ui.main.interactor.MainInteractor
import com.sandbox.vs.tick.ui.main.interactor.MainMVPInteractor
import com.sandbox.vs.tick.ui.main.presenter.MainMVPPresenter
import com.sandbox.vs.tick.ui.main.presenter.MainPresenter
import com.sandbox.vs.tick.ui.main.view.MainMVPView
import dagger.Module
import dagger.Provides

@Module
class MainActivityModule {

    @Provides
    internal fun provideMainInteractor(mainInteractor: MainInteractor): MainMVPInteractor = mainInteractor

    @Provides
    internal fun provideMainPresenter(mainPresenter: MainPresenter<MainMVPView, MainMVPInteractor>)
            : MainMVPPresenter<MainMVPView, MainMVPInteractor> = mainPresenter

}