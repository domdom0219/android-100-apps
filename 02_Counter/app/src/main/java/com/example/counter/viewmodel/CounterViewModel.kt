package com.example.counter.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class CounterViewModel: ViewModel() {
    val numberState = mutableStateOf(0)
    val isMinusTappedState = mutableStateOf(true)
    val isPlusTappedState = mutableStateOf(true)
}