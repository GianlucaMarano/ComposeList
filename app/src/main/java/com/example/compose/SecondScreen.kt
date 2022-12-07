package com.example.compose

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun SecondScreen(name: String) {
    Box(modifier = Modifier.fillMaxSize()){
        Text(
            text = "Ciao $name",
            modifier = Modifier.align(Alignment.Center),
            style = MaterialTheme.typography.h3
        )
    }

}

@Preview(showBackground = true)
@Composable
fun SecondPreview(){
    SecondScreen(name = "a Tutti")
}