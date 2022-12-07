package com.example.compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose.ui.theme.ComposeTheme

class MainActivity : ComponentActivity() { //nuova activity da estendere quando usiamo compose
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { //non è necessario specificare un xml
            ComposeTheme { //gestisce il tema dell'app da modificare in ui.theme.Theme
                Surface( //container degli elementi ui
                    modifier = Modifier.fillMaxSize(), //aggiungere attributi per modificare elemento ui
                    color = MaterialTheme.colors.background //specifica colore del background della surface
                ) {
                    //inserire elementi della ui
                    //Layout Box,Column,Row
                    //{Recompose}->{Structure}->{Presentation}
                    MainNavHost() //funzione composable che gestisce la navigazione tra composable
                }
            }
        }
    }
}

@Composable
fun MainScreen(
    viewModel: MainViewModel,
    onClickToNavigate: (name: String) -> Unit //funzione con parametro stringa che non ritorna nulla
) {
    MainScreen(
        list = viewModel.list,
        onClickToNavigate = onClickToNavigate,
        onClickToAdd = { viewModel.addElement(it) },
        onClickToDelete = { viewModel.remove(it) })
}


@Composable
private fun MainScreen(
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
        verticalAlignment = CenterVertically
    ) {
        Text(
            text = name,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.h5
        )
        Spacer(modifier = Modifier.weight(1f))
        Button(
            onClick = { onClick(name) },
            modifier = Modifier.align(CenterVertically)
        ) {
            Text(text = "Premi")
        }
    }

}

@Preview(showBackground = true)
@Composable
fun MainScreenPreview() {
    MainScreen(listOf("Primo", "Secondo"), {}, {}, {})
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