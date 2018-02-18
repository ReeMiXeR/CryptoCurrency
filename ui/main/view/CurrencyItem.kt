package com.sandbox.vs.tick.ui.main.view

import android.widget.ImageView
import android.widget.TextView
import com.mindorks.placeholderview.annotations.Layout
import com.mindorks.placeholderview.annotations.NonReusable
import com.mindorks.placeholderview.annotations.Resolve
import com.mindorks.placeholderview.annotations.View
import com.sandbox.vs.tick.R
import com.sandbox.vs.tick.data.network.model.Coin
import com.sandbox.vs.tick.util.extension.loadImage

@NonReusable
@Layout(R.layout.currency_item)
class CurrencyItem(private val coin: Coin) {

    @View(R.id.name)
    private lateinit var nameTV: TextView
    @View(R.id.symbol)
    private lateinit var symbolTV: TextView
    @View(R.id.price_usd)
    private lateinit var priceUsdTV: TextView
    @View(R.id.logo)
    private lateinit var logoIV: ImageView

    @Resolve
    private fun onResolved() {
        logoIV.loadImage("https://www.cryptocompare.com" + coin.imageUrl)
        nameTV.text = coin.coinName
        symbolTV.text = coin.fullName
        priceUsdTV.text = coin.proofType
    }
}