package com.sandbox.vs.tick.ui.base.presenter

import com.sandbox.vs.tick.ui.base.interactor.MVPInteractor
import com.sandbox.vs.tick.ui.base.view.MVPView

interface MVPPresenter<V : MVPView, I : MVPInteractor> {

    fun onAttach(view: V?)

    fun onDetach()

    fun getView(): V?

}