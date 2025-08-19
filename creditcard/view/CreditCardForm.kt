package com.example.creditcard.creditcard.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.creditcard.creditcard.view.form.InputCardExpiration
import com.example.creditcard.creditcard.view.form.InputCardHolder
import com.example.creditcard.creditcard.view.form.InputCardNumber
import com.example.creditcard.creditcard.viewmodel.CardViewModel

@Composable
fun CreditCardForm(cardViewModel: CardViewModel) {
    Box(
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .fillMaxWidth()
    ) {
        Column {
            InputCardNumber(cardViewModel)
            Spacer(Modifier.height(8.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                InputCardHolder(cardViewModel)
                InputCardExpiration(cardViewModel)
            }
        }
    }
}