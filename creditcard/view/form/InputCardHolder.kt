package com.example.creditcard.creditcard.view.form

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.LocalLifecycleOwner
import com.example.creditcard.creditcard.viewmodel.CardViewModel

@Composable
fun InputCardHolder(cardViewModel: CardViewModel) {

    var cardHolder by rememberSaveable { mutableStateOf("") }
    cardViewModel.cardHolder.observe(LocalLifecycleOwner.current) {
        cardHolder = it
    }

    OutlinedTextField(
        value = cardHolder,
        onValueChange = { cardViewModel.setCardHolder(it) },
        modifier = Modifier.fillMaxWidth(fraction = 0.6f),
        placeholder = { Text("Nombre del titular") }
    )
}