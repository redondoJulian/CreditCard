package com.example.creditcard.creditcard.view

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.LocalLifecycleOwner
import com.example.creditcard.creditcard.viewmodel.CardViewModel

@Composable
fun ColorOptions(cardViewModel: CardViewModel) {

    var selectedColor by rememberSaveable {
        mutableStateOf<String>("red")
    }
    cardViewModel.cardColor.observe(LocalLifecycleOwner.current) {
        selectedColor = it
    }

    Box(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .background(Color.Red)
                    .size(54.dp)
                    .clickable{
                        cardViewModel.setCardColor("red")
                    },
                contentAlignment = Alignment.Center
            ){
                if(selectedColor == "red") {
                    Icon(
                        imageVector = Icons.Default.Check,
                        contentDescription = "Selected",
                        tint = Color.White
                    )
                }
            }

            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .background(Color.Blue)
                    .size(54.dp)
                    .clickable{
                        cardViewModel.setCardColor("blue")
                    },
                contentAlignment = Alignment.Center
            ){
                if(selectedColor == "blue") {
                    Icon(
                        imageVector = Icons.Default.Check,
                        contentDescription = "Selected",
                        tint = Color.White
                    )
                }
            }

            Box(
                modifier = Modifier
                    .clip(CircleShape)
                    .background(Color.Green)
                    .size(54.dp)
                    .clickable{
                        cardViewModel.setCardColor("green")
                    },
                contentAlignment = Alignment.Center
            ){
                if(selectedColor == "green") {
                    Icon(
                        imageVector = Icons.Default.Check,
                        contentDescription = "Selected",
                        tint = Color.White
                    )
                }
            }
        }
    }
}