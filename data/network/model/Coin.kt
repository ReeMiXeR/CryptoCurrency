package com.sandbox.vs.tick.data.network.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity(tableName = "coins")
class Coin(
        @PrimaryKey(autoGenerate = false)
        @Expose
        @SerializedName("Id")
        val id: Int, //3808

        @Expose
        @SerializedName("Url")
        @ColumnInfo(name = "url")
        val url: String, ///coins/ltc/overview

        @Expose
        @SerializedName("ImageUrl")
        @ColumnInfo(name = "image_url")
        val imageUrl: String, ///media/19782/ltc.png

        @Expose
        @SerializedName("Name")
        @ColumnInfo(name = "name")
        val name: String, //LTC

        @Expose
        @SerializedName("CoinName")
        @ColumnInfo(name = "coin_name")
        val coinName: String, //Litecoin

        @Expose
        @SerializedName("FullName")
        @ColumnInfo(name = "full_name")
        val fullName: String, //Litecoin (LTC)

        @Expose
        @SerializedName("Algorithm")
        @ColumnInfo(name = "algorithm")
        val algorithm: String, //Scrypt

        @Expose
        @SerializedName("ProofType")
        @ColumnInfo(name = "proof_type")
        val proofType: String, //PoW

        @Expose
        @SerializedName("SortOrder")
        @ColumnInfo(name = "sort_order")
        val sortOrder: Int //2
) : Comparable<Coin> {
    override fun compareTo(other: Coin) = comparator.compare(this, other)

    companion object {
        // using the method reference syntax as an alternative to lambdas
        val comparator = compareBy(Coin::sortOrder)
    }
}