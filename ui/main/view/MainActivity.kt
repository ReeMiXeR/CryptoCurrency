package com.sandbox.vs.tick.ui.main.view

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import com.sandbox.vs.tick.R
import com.sandbox.vs.tick.data.database.CoinInfo
import com.sandbox.vs.tick.ui.base.view.BaseActivity
import com.sandbox.vs.tick.ui.main.interactor.MainMVPInteractor
import com.sandbox.vs.tick.ui.main.presenter.MainMVPPresenter
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import junit.framework.Test
import kotlinx.android.synthetic.main.activity_main.*
import timber.log.Timber
import java.util.logging.Logger
import javax.inject.Inject


class MainActivity : BaseActivity(), MainMVPView, HasSupportFragmentInjector {
//class MainActivity : AppCompatActivity() {

    @Inject
    internal lateinit var presenter: MainMVPPresenter<MainMVPView, MainMVPInteractor>
    @Inject
    internal lateinit var fragmentDispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    private val loadingView = LoadingView()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Timber.e(this::class.java.toString() + " OnCreate")
        presenter.onAttach(this)

        galleryView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView?, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
//                if (!recyclerView!!.canScrollVertically(1))
                val layoutManager = LinearLayoutManager::class.java.cast(recyclerView!!.layoutManager)
                val totalItemCount = layoutManager.itemCount
                val lastVisible = layoutManager.findLastVisibleItemPosition()

                val endHasBeenReached = lastVisible + 1 >= totalItemCount
                if (totalItemCount > 0 && endHasBeenReached) {
                    if (!galleryView.allViewResolvers.contains(loadingView)) {
                        presenter.getCurrencyList()
                        galleryView.post({galleryView.addView(loadingView)})

                    }
                }
            }
        })

        button.setOnClickListener({presenter.getCoinInfo(edit_text.text.toString())})

    }

    override fun onFragmentAttached() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onFragmentDetached(tag: String) {
    }

    override fun supportFragmentInjector() = fragmentDispatchingAndroidInjector

//    override fun showProgress() {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//    }

    override fun displayCoinInfo(coinInfo: CoinInfo) {
        text.text = coinInfo.toString()
    }

    override fun displayCurrencyItems(currencyArray: Array<CurrencyItem>) {
        Logger.getLogger(Test::class.java.name).warning("displayCurrencyItems size - " + currencyArray.size)
        if (galleryView.allViewResolvers.contains(loadingView)) galleryView.removeView(loadingView)

        for (item in currencyArray) galleryView.addView(item)
    }

    override fun hideProgress() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

//    inline fun <reified T> Gson.fromJson(json: String) = this.fromJson<T>(json, object : TypeToken<T>() {}.type)
//
//    fun getGlobalInfo(): Observable<Array<CoinListResponse>> =
//            Rx2AndroidNetworking.get("https://api.coinmarketcap.com/v1/ticker/?limit=10")
//                    .build()
//                    .getObjectObservable(Array<CoinListResponse>::class.java)

    //    fun getCoinList() {
//        AndroidNetworking.get("https://api.coinmarketcap.com/v1/ticker/?")
//                .setPriority(Priority.LOW)
//                .addQueryParameter("start", itemsLoaded.toString())
//                .addQueryParameter("limit", limit.toString())
//                .build()
//                .getAsJSONArray(object : JSONArrayRequestListener {
//                    override fun onResponse(response: JSONArray) {
//                        // do anything with response
//
//                        if (!galleryView.allViewResolvers.contains(loadingView))
//                            galleryView.removeView(loadingView)
//
//                        itemsLoaded += response.length()
//                        val resp = Gson().fromJson<List<CoinListResponse>>(response.toString())
//
//                        for (item: CoinListResponse in resp) {
////                            val tvDynamic = TextView(this@MainActivity)
////                            tvDynamic.textSize = 12f
////                            tvDynamic.text = item.name
//                            galleryView.addView(CurrencyItem(item))
//                        }
//                    }
//
//                    override fun onError(error: ANError) {
//                        // handle error
//                        Timber.e("error response")
//                    }
//                })
//    }
}
