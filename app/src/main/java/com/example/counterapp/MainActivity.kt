package com.example.counterapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.counterapp.ui.theme.CounterAppTheme
import androidx.lifecycle.viewmodel.compose.viewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val viewModel : CounterViewModel = viewModel()
            CounterAppTheme {
                Scaffold (modifier = Modifier.fillMaxSize()) { innerPadding->
                    //innerPadding -> to provide default padding
                    TheCounterApp(innerPadding, viewModel)
                }
            }
        }
    }
}

@Composable
fun TheCounterApp(
    //innerPadding -> inbuilt attribute
    //PaddingValues -> stores default values

    innerPadding : PaddingValues,
    viewModel: CounterViewModel
) {

    fun increment () {
        viewModel.count.value++;
    }
    
    fun decrement () {
        viewModel.count.value--;
    }
    //column -> vertical arrangement
    Column (
        modifier = Modifier.fillMaxSize(), 
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // $ -> to fetch value
        Text(text = "Count : ${viewModel.count.value}",
            fontSize = 24.sp, 
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(16.dp))
        //Row -> horizontal arrangement
        Row {
            Button(onClick = { increment() }) {
                Text(text = "Increment")
            }

            Button(onClick = { decrement() }) {
                Text(text = "Decrement")
            }
        }
    }
}