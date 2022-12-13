package com.example.compose.ui.main

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose.ui.theme.ComposeTheme


@Composable
fun FirstScreen(
    viewModel: FirstViewModel,
    onClickToNavigate: (name: String) -> Unit //funzione con parametro stringa che non ritorna nulla
) {
    FirstScreen(
        list = viewModel.list,
        onClickToNavigate = onClickToNavigate,
        onClickToAdd = { viewModel.addElement(it) },
        onClickToDelete = { viewModel.remove(it) })
}


@Composable
private fun FirstScreen(
    list: List<String>,
    onClickToNavigate: (name: String) -> Unit,
    onClickToAdd: (name: String) -> Unit,
    onClickToDelete: (e: String) -> Unit
) {
    Box(Modifier.fillMaxSize()) {//tutti gli elementi vengono mostrati in colonna
        LazyColumn { //equivalente di recycler view
            items(list) {
                ListElement(name = it, onClick = onClickToDelete)
                Divider()
            }
        }
        FloatingActionButton(
            onClick = {
                onClickToAdd("test")
                //onClickToNavigate("test")
            },
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(15.dp)
        ) {
            Text(text = "+")
        }
    }
}
@Composable
fun ListElement(
    name: String,
    onClick: (e: String) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.padding(12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = name,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.h5
        )
        Spacer(modifier = Modifier.weight(1f))
        Button(
            onClick = { onClick(name) },
            modifier = Modifier.align(Alignment.CenterVertically)
        ) {
            Text(text = "Premi")
        }
    }

}


//funzione che genera l'anteprima
@Preview(showBackground = true) //inserire tra parentesi le caratteristiche della preview
@Composable
fun ListElementPreview() {
    ComposeTheme {
        ListElement( //inserire dati mockup
            name = "world",
            {}
        )
    }
}

@Preview(showBackground = true)
@Composable
fun FirstScreenPreview() {
    FirstScreen(listOf("Primo", "Secondo"), {}, {}, {})
}