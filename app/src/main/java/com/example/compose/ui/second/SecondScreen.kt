package com.example.compose.ui.second

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel

@Composable
fun SecondScreen(viewModel: SecondViewModel) {
  SecondScreen(number = viewModel.number)

}

@Composable
fun SecondScreen(number: Int) {
    Box(modifier = Modifier.fillMaxSize()){
        Text(
            text = "Numero elementi: $number",
            modifier = Modifier.align(Alignment.Center),
            style = MaterialTheme.typography.h4
        )
    }

}

@Preview(showBackground = true)
@Composable
fun SecondPreview(){
    SecondScreen(2)
}