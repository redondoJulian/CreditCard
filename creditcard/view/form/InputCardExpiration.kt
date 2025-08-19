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
fun InputCardExpiration(cardViewModel: CardViewModel) {

    var cardExpiration by rememberSaveable { mutableStateOf("") }
    cardViewModel.cardExpiration.observe(LocalLifecycleOwner.current) {
        cardExpiration = it
    }

    OutlinedTextField(
        value = cardExpiration,
        onValueChange = { cardViewModel.setCardExpiration(it) },
        modifier = Modifier.fillMaxWidth(fraction = 0.6f),
        placeholder = { Text("00/00") }
    )
}