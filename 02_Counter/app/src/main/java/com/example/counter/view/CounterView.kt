package com.example.counter.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.counter.viewmodel.CounterViewModel

@Composable
fun CounterView(
    counterViewModel: CounterViewModel,
) {
    val number = counterViewModel.numberState
    val isMinusTapped = counterViewModel.isMinusTappedState
    val isPlusTapped = counterViewModel.isPlusTappedState

    when (number.value) {
        0 -> {
            isMinusTapped.value = false
            isPlusTapped.value = true
        }
        10 -> {
            isMinusTapped.value = true
            isPlusTapped.value = false
        }
        else -> {
            isMinusTapped.value = true
            isPlusTapped.value = true
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly

        ) {
            OutlinedButton(
                onClick = {
                    number.value--
                },
                enabled = isMinusTapped.value
            ) {
                Text(
                    text = "-",
                    fontSize = 32.sp
                )
            }

            Box(
                modifier = Modifier
                    .size(100.dp)
                    .background(Color.Gray, CircleShape)
                    .padding(16.dp),
                contentAlignment = Alignment.Center
            ) {
                Box(
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = number.value.toString(),
                        color = Color.White,
                        fontSize = 32.sp,
                        textAlign = TextAlign.Center
                    )
                }
            }

            OutlinedButton(
                onClick = {
                    number.value++
                },
                enabled = isPlusTapped.value
            ) {
                Text(
                    text = "+",
                    fontSize = 32.sp)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCounterView() = CounterView(counterViewModel = CounterViewModel())