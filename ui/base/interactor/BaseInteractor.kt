package com.sandbox.vs.tick.ui.base.interactor

import com.sandbox.vs.tick.data.network.ApiHelper

open class BaseInteractor() : MVPInteractor {

//    protected lateinit var preferenceHelper: PreferenceHelper
    protected lateinit var apiHelper: ApiHelper


    constructor(apiHelper: ApiHelper) : this() {
        this.apiHelper = apiHelper
    }

    override fun baseInteractorMethod(): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    //
//    constructor(preferenceHelper: PreferenceHelper, apiHelper: ApiHelper) : this() {
//        this.preferenceHelper = preferenceHelper
//        this.apiHelper = apiHelper
//    }
//
//    override fun isUserLoggedIn() = this.preferenceHelper.getCurrentUserLoggedInMode() != AppConstants.LoggedInMode.LOGGED_IN_MODE_LOGGED_OUT.type
//
//    override fun performUserLogout() = preferenceHelper.let {
//        it.setCurrentUserId(null)
//        it.setAccessToken(null)
//        it.setCurrentUserEmail(null)
//        it.setCurrentUserLoggedInMode(AppConstants.LoggedInMode.LOGGED_IN_MODE_LOGGED_OUT)
//    }

}