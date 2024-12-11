package com.example.cursoudemy.twit

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale

import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cursoudemy.R


@Preview
@Composable
fun BodyTwit() {
    val perfil = Perfil(
        name = "Jorge",
        username = "jorge"
    )

    val lista = listOf(
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit sed do eiusmod tempor incididunt ut labore et dolore magna aliqua."
    )

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        items(lista.size) { index ->
            Twit(text = lista[index], perfil = perfil)
            HorizontalDivider()
        }
    }

}


@Composable
fun Twit(text: String, perfil: Perfil) {

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .border(
                BorderStroke(
                    width = 1.dp,
                    color = Color.Gray
                ),
            )
            .height(210.dp)
    ) {
        Row(
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier
                .fillMaxSize()
                .padding(5.dp)
        ) {

            PerfilTwit(perfil = perfil)
            Column(
                modifier = Modifier
                    .padding(5.dp)
                    .weight(0.8f)
            ) {
                HeaderTwit(perfil = perfil)
                Text(text = text, fontSize = 20.sp)

                RowAccion()


            }
        }


    }

}

@Composable
fun PerfilTwit(perfil: Perfil) {

    Image(
        painter = painterResource(id = perfil.image),
        contentDescription = null,
        modifier = Modifier
            .size(50.dp)
            .padding(top = 5.dp)
            .clip(CircleShape),
        contentScale = ContentScale.Crop
    )

}

@Composable
fun HeaderTwit(perfil: Perfil) {
    Row(
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .height(30.dp)
    ) {
        Row {
            Text(text = perfil.name, fontWeight = FontWeight.Bold, fontSize = 20.sp)
            Spacer(modifier = Modifier.size(10.dp))
            Text(
                text = "@${perfil.username}", fontSize = 20.sp, color = Color.Black.copy(
                    alpha = 0.5f
                )
            )
               Spacer(modifier = Modifier.size(10.dp))
             Text(
                text = "4h", fontSize = 20.sp, color = Color.Black.copy(
                    alpha = 0.5f
                )
            )
        }
        Icon(
            modifier = Modifier.size(20.dp),
            painter = painterResource(id = R.drawable.ic_dots),
            contentDescription = null
        )

        

    }
}

@Preview
@Composable
fun RowAccion() {
    var selectedLike by rememberSaveable { mutableStateOf(false) }
    var selectedRetwit by rememberSaveable { mutableStateOf(false) }
    var selectedComment by rememberSaveable { mutableStateOf(false) }
    var countLike by rememberSaveable { mutableIntStateOf(5) }
    var countRetwit by rememberSaveable { mutableIntStateOf(4) }
    var countComment by rememberSaveable { mutableIntStateOf(3) }
    val modifier = Modifier.padding(end = 50.dp)
    fun clickableAction(name: String, selected: Boolean) {
        when (name) {
            "Like" -> {

                selectedLike = !selected
                countLike = if (selected) countLike - 1 else countLike + 1

            }

            "Retwit" -> {
                selectedRetwit = !selected
                countRetwit = if (selected) countRetwit - 1 else countRetwit + 1
            }

            "Comment" -> {
                selectedComment = !selected
                countComment = if (selected) countComment - 1 else countComment + 1

            }
        }
    }


    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                vertical = 20.dp,
            ), horizontalArrangement = Arrangement.Absolute.Left
    ) {


        Row(modifier) {
            Icon(

                modifier = Modifier
                    .size(20.dp)

                    .clickable { clickableAction("Comment", selectedComment) },
                tint = if (selectedComment) Color.Blue else Color.Gray,
                painter = painterResource(id = R.drawable.ic_chat_filled),

                contentDescription = null
            )
            Spacer(modifier = Modifier.size(5.dp))
            Text(text = countComment.toString(), fontSize = 20.sp)
        }

        Row(modifier) {
            Icon(
                modifier = Modifier
                    .size(20.dp)

                    .clickable { clickableAction("Retwit", selectedRetwit) },
                painter = painterResource(id = R.drawable.ic_rt),
                contentDescription = null,
                tint = if (selectedRetwit) Color.Green else Color.Gray
            )
            Spacer(modifier = Modifier.size(5.dp))
            Text(text = countRetwit.toString(), fontSize = 20.sp)
        }



        Row(modifier) {
            Icon(
                modifier = Modifier
                    .size(20.dp)

                    .clickable { clickableAction("Like", selectedLike) },

                tint = if (selectedLike) Color.Red else Color.Gray,
                imageVector = if (selectedLike) Icons.Filled.Favorite else Icons.Filled.Favorite,
                contentDescription = null
            )
            Spacer(modifier = Modifier.size(5.dp))
            Text(text = countLike.toString(), fontSize = 20.sp)
        }


    }
}

data class Perfil(
    val name: String,
    val username: String,
    val image: Int = R.drawable.profile
)