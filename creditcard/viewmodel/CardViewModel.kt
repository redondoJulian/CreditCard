package com.example.creditcard.creditcard.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.creditcard.creditcard.model.CardModel
import com.example.creditcard.creditcard.view.cardNumberFormatting

class CardViewModel(context: Context) : ViewModel() {

    val cardModel = CardModel(context)

    private var _cardNumber = MutableLiveData<String>(cardModel.getCardNumber())
    var cardNumber: LiveData<String> = _cardNumber

    private var _cardHolder = MutableLiveData<String>(cardModel.getCardHolder())
    var cardHolder: LiveData<String> = _cardHolder

    private var _cardExpiration = MutableLiveData<String>(cardModel.getCardExpiration())
    var cardExpiration: LiveData<String> = _cardExpiration

    fun setCardNumber(number: String){
        if(number.length > 16){return}
        _cardNumber.value = cardModel.changeCardNumber(number)
    }

    fun setCardHolder(name: String){
        _cardHolder.value = cardModel.changeHolder(name)
    }

    fun setCardExpiration(number: String){
        if(number.length > 4){return}
        _cardExpiration.value = cardModel.changeExpirationNumber(number)
    }
}