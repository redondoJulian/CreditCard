package com.example.creditcard.creditcard.view.form

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.lifecycle.compose.LocalLifecycleOwner
import com.example.creditcard.creditcard.viewmodel.CardViewModel

@Composable
fun InputCardNumber(cardViewModel: CardViewModel) {

    var cardNumber by rememberSaveable { mutableStateOf("") }
    cardViewModel.cardNumber.observe(LocalLifecycleOwner.current) {
        cardNumber = it
    }

    OutlinedTextField(
        value = cardNumber,
        onValueChange = { cardViewModel.setCardNumber(it) },
        modifier = Modifier.fillMaxWidth(),
        placeholder = { Text("0000-0000-0000-0000") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
    )
}