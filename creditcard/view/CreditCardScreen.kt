package com.example.creditcard.creditcard.view

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.example.creditcard.creditcard.viewmodel.CardViewModel

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("ViewModelConstructorInComposable")
@Composable
fun CreditCardScreen(){
    Scaffold(

    ) {
        paddingValues ->
        Box(
            modifier = Modifier.padding(paddingValues)
        ) {
            Column {


                val context = LocalContext.current
                val cardViewModel = CardViewModel(context)

                CreditCard(cardViewModel)
                CreditCardForm(cardViewModel)
                ColorOptions(cardViewModel)
            }
        }
    }
}