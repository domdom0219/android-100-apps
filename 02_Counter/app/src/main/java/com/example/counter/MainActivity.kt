package com.example.counter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.ViewModelProvider
import com.example.counter.ui.theme.CounterTheme
import com.example.counter.view.CounterView
import com.example.counter.viewmodel.CounterViewModel

class MainActivity : ComponentActivity() {
    private val viewModel: CounterViewModel by lazy {
        ViewModelProvider(
            this,
            ViewModelProvider.AndroidViewModelFactory(application)
        )[CounterViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CounterTheme {
                // A surface container using the 'background' color from the theme
                setContent {
                    CounterView(viewModel)
                }
            }
        }
    }
}