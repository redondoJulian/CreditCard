package com.example.creditcard.creditcard.model

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit

class CardModel(private val context: Context) {
    private val _cardNumber = "_cardNumber"
    private val _cardHolder = "_cardHolder"
    private val _cardExpiration = "_cardExpiration"
    private val prefs: SharedPreferences = context.getSharedPreferences("_creditcard_sharedpreferences_",Context.MODE_PRIVATE)

    fun getCardNumber() : String{
        var cardNumber = prefs.getString(_cardNumber,"")
        return cardNumber.toString()
    }
    fun getCardHolder() : String{
        var cardHolder = prefs.getString(_cardHolder,"")
        return cardHolder.toString()
    }
    fun getCardExpiration() : String{
        var cardExpiration = prefs.getString(_cardExpiration,"")
        return cardExpiration.toString()
    }

    fun changeCardNumber(number: String): String{
        prefs.edit { putString(_cardNumber, number) }
        return number
    }

    fun changeHolder(name: String): String{
        prefs.edit { putString(_cardHolder, name) }
        return name
    }

    fun changeExpirationNumber(number: String): String{
        prefs.edit { putString(_cardExpiration, number) }
        return number
    }
}