package com.example.creditcard.creditcard.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.LocalLifecycleOwner
import com.example.creditcard.R
import com.example.creditcard.creditcard.viewmodel.CardViewModel
import java.util.Locale

@Composable
fun CreditCard(cardViewModel: CardViewModel) {

    //Card number
    var localCardNumber by rememberSaveable { mutableStateOf("0000 0000 0000 0000") }
    cardViewModel.cardNumber.observe(LocalLifecycleOwner.current) {
        localCardNumber = cardNumberFormatting(it)
    }

    //Holder
    var cardHolder by rememberSaveable { mutableStateOf("") }
    cardViewModel.cardHolder.observe(LocalLifecycleOwner.current) {
        cardHolder = cardHolderFormatting(it)
    }

    //Expiration
    var cardExpiration by rememberSaveable { mutableStateOf("") }
    cardViewModel.cardExpiration.observe(LocalLifecycleOwner.current) {
        cardExpiration = cardExpirationFormatting(it)
    }



    Box(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        Box(
            modifier = Modifier


                .clip(RoundedCornerShape(8.dp))
                .background(color = Color.Red)
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Column {
                Text(
                    text = "Credit card",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp
                )
                Image(
                    painter = painterResource(id = R.drawable.chip),
                    contentDescription = "Chip",
                    modifier = Modifier.size(60.dp)
                )

                Spacer(Modifier.height(8.dp))

                Text(
                    text = localCardNumber,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 22.sp
                )

                Spacer(Modifier.height(8.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = cardHolder,
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                    Text(
                        text = cardExpiration,
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )
                }

                Spacer(Modifier.height(8.dp))

                Box(
                    modifier = Modifier.fillMaxWidth(),
                    contentAlignment = Alignment.CenterEnd
                ) {
                    Text(
                        text = "170",
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp
                    )
                }

            }
        }
    }
}

fun cardNumberFormatting(number: String): String {
    var newNumberFormatted: String = ""

    if(number.isEmpty()){
        newNumberFormatted = "0000 0000 0000 0000"
    }

    for((index, character) in number.withIndex()){
        newNumberFormatted += character

        if((index + 1) % 4 == 0){ newNumberFormatted += " " }
    }
    return newNumberFormatted
}

fun cardHolderFormatting(name: String) : String {
    return name.uppercase()
}

fun cardExpirationFormatting(number: String) : String{
    var newNumberFormatted: String = ""

    if(number.isEmpty()){
        newNumberFormatted = "00/00"
    }

    for(character in number){


        if(newNumberFormatted.length == 2){ newNumberFormatted += "/" }

        newNumberFormatted += character
    }
    return newNumberFormatted
}