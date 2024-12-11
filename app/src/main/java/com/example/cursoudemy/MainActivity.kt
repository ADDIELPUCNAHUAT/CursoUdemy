@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.cursoudemy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.Row


import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Add
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults

import androidx.compose.material3.Checkbox

import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api

import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RangeSlider
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.draw.clip

import androidx.compose.ui.graphics.Brush

import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.cursoudemy.ui.theme.CursoUdemyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CursoUdemyTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                    ) {
                        MyCounter()

                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Composable
fun GreetingPreview() {
    CursoUdemyTheme {
        Greeting("Android")
    }
}


@Composable
fun MyBox(name: String = "Android") {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Box(
            modifier = Modifier
                .size(100.dp)
                .background(
                    Color.Red
                )
                .verticalScroll(rememberScrollState())
        ) {
            Text(text = "Hello $name!", modifier = Modifier.align(Alignment.Center))
        }
    }

}

@Composable
fun MyRow() {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .horizontalScroll(rememberScrollState())
    ) {
        for (i in 1..10) {
            Text(text = "Item $i", modifier = Modifier.padding(16.dp))
        }
    }
}

@Composable
fun MyComplexLayout() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .horizontalScroll(rememberScrollState())
        ) {
            for (i in 1..10) {
                Box(
                    modifier = Modifier
                        .size(100.dp)
                        .background(Color.Red)
                        .padding(16.dp)
                ) {
                    Text(text = "Item $i", modifier = Modifier.align(Alignment.Center))
                }
            }

        }
    }
}


@Composable
fun MyConstraintLayout() {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val (Box1, Box2, Box3, Box4, Box5, Box6, Box7, Box8, Box9) = createRefs()
        Box(
            modifier = Modifier
                .size(100.dp)
                .background(Color.Red)
                .constrainAs(Box1) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    bottom.linkTo(parent.bottom)
                    end.linkTo(parent.end)
                }
        )
        Box(
            modifier = Modifier
                .size(100.dp)
                .background(Color.Green)
                .constrainAs(Box2) {
                    top.linkTo(Box1.bottom)
                    end.linkTo(Box1.start)
                }
        )
        Box(
            modifier = Modifier
                .size(100.dp)
                .background(Color.Blue)
                .constrainAs(Box3) {
                    top.linkTo(Box1.bottom)
                    start.linkTo(Box1.end)
                }
        )
        Box(
            modifier = Modifier
                .size(100.dp)
                .background(Color.Black)
                .constrainAs(Box4) {

                    bottom.linkTo(Box1.top)
                    end.linkTo(Box1.start)
                }
        )
        Box(
            modifier = Modifier
                .size(100.dp)
                .background(Color.White)
                .constrainAs(Box5) {
                    start.linkTo(Box1.end)
                    bottom.linkTo(Box1.top)
                }
        )
        Box(modifier = Modifier
            .size(100.dp)
            .background(Color.Magenta)
            .constrainAs(Box6) {
                bottom.linkTo(Box1.top)
                end.linkTo(Box1.end)
            })
        Box(modifier = Modifier
            .size(100.dp)
            .background(Color.Cyan)
            .constrainAs(Box7) {
                end.linkTo(Box1.start)
                bottom.linkTo(Box1.bottom)

            })
        Box(modifier = Modifier
            .size(100.dp)
            .background(Color.White)
            .constrainAs(Box8) {
                top.linkTo(Box1.bottom)
                end.linkTo(Box1.end)
            })
        Box(modifier = Modifier
            .size(100.dp)
            .background(
                Brush.horizontalGradient(
                    colors = listOf(Color.Red, Color.Green, Color.Blue)
                )
            )
            .constrainAs(Box9) {
                start.linkTo(Box1.end)
                top.linkTo(Box1.top)
            })

    }
}


@Composable
fun ExampleFunConstrainLayout() {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {
        val boxBlue = createRef()
        val topGuide = createGuidelineFromTop(0.1f)
        val startGuide = createGuidelineFromStart(0.5f)
        Box(
            modifier = Modifier
                .size(100.dp)
                .background(
                    Color.Blue.copy(
                        alpha = 0.5f
                    )
                )
                .constrainAs(
                    boxBlue
                ) {
                    top.linkTo(topGuide)
                    start.linkTo(startGuide)
                }
        )

    }
}


@Composable
fun ContrainBarrier() {
    ConstraintLayout(modifier = Modifier.fillMaxSize()) {

        val (boxred, boxgreen, boxWhite) = createRefs()
        val barrer = createEndBarrier(boxred, boxgreen)
        Box(
            modifier = Modifier
                .size(125.dp)
                .background(Color.Red)
                .constrainAs(boxred) {
                    start.linkTo(parent.start, margin = 16.dp)
                }
        )
        Box(
            modifier = Modifier
                .size(200.dp)
                .background(Color.Green)
                .constrainAs(boxgreen) {
                    top.linkTo(boxred.bottom)
                    start.linkTo(parent.start, margin = 32.dp)
                }

        )
        Box(modifier = Modifier
            .size(60.dp)
            .background(Color.White)
            .constrainAs(boxWhite) {
                start.linkTo(barrer)
            })

        createHorizontalChain(
            boxred, boxgreen, boxWhite, chainStyle = ChainStyle.SpreadInside
        )
    }

}

@Composable
fun MyCounter() {
    var counter by rememberSaveable { mutableIntStateOf(0) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier.padding(10.dp), text = "$counter", style = TextStyle(
                fontSize = 150.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
        )
        Button(
            modifier = Modifier
                .height(50.dp)
                .width(100.dp),
            onClick = { counter += 1 }) {
            Icon(imageVector = Icons.Rounded.Add, contentDescription = "Incrementar")
        }
    }
    if (counter > 10) {
        AlertDialog(
            onDismissRequest = { },
            title = { Text(text = "Alerta") },
            text = { Text(text = "El contador es mayor a 10") },
            confirmButton = {
                Button(
                    onClick = {
                        counter = 0
                    }
                ) {
                    Text(text = "Aceptar")
                }
            }
        )
    }
}

@Composable
fun MyText() {
    Text(
        "Addiel", color = Color.Black,
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold, style = TextStyle(
            textDecoration = TextDecoration.combine(
                listOf(
                    TextDecoration.LineThrough,
                    TextDecoration.Underline
                )
            )
        )
    )
}

@Composable
fun MyBotton() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        val eneable = rememberSaveable { mutableStateOf(true) }
        Button(
            onClick = {},
            modifier = Modifier.padding(16.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Red,
                contentColor = Color.White
            ),
            enabled = !eneable.value
        ) {
            Text("Aceptar")
        }
    }
}


@Composable
fun MyTextFilOutline() {
    var text by remember { mutableStateOf("") }

    OutlinedTextField(
        value = text,
        onValueChange = { text = it },
        label = { Text("Nombre") },
        placeholder = { Text("Escribe tu nombre") },
        modifier = Modifier.padding(16.dp),
        colors = TextFieldDefaults.colors(
            disabledTextColor = Color.Red,
            focusedLabelColor = Color.Green,
            focusedIndicatorColor = Color.Blue
        )
    )
}

@Composable
fun MySwith() {
    var checked by remember { mutableStateOf(false) }
    Switch(checked = checked, onCheckedChange = { checked = !checked })
}


@Composable
fun MyCheckBox() {
    var check by remember { mutableStateOf(false) }

    Checkbox(
        colors = CheckboxDefaults.colors(
            checkedColor = Color.Red,
            uncheckedColor = Color.Blue,
            checkmarkColor = Color.Green
        ),
        checked = check, onCheckedChange = { check = !check })
}


@Composable
fun MyCheckBoxComplete() {
    var state by remember { mutableStateOf(false) }

    Row {
        Checkbox(
            checked = state,
            onCheckedChange = { state = it },
            colors = CheckboxDefaults.colors(
                checkedColor = Color.Red,
                uncheckedColor = Color.Blue,
                checkmarkColor = Color.Green
            )
        )
        Text(text = "Aceptar", modifier = Modifier.padding(16.dp))
    }
}

@Composable
fun MyTreeStateCheckBox() {

    var state by remember {
        mutableStateOf(
            ToggleableState(
                value = false
            )
        )
    }

    TriStateCheckbox(
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(),
        state = state,
        onClick = {
            state = when (state) {
                ToggleableState.Off -> ToggleableState.On
                ToggleableState.On -> ToggleableState.Indeterminate
                ToggleableState.Indeterminate -> ToggleableState.Off
            }
        }
    )

}


@Composable
fun MyRadioButton() {
    var state by remember { mutableStateOf("Addiel") }
    Column(modifier = Modifier.fillMaxSize()) {
        Row {
            RadioButton(selected = state == "Addiel", onClick = { state = "Addiel" })
            Text(text = "Addiel", modifier = Modifier.padding(16.dp))
        }
        Row {
            RadioButton(selected = state == "Juan", onClick = { state = "Juan" })
            Text(text = "Juan", modifier = Modifier.padding(16.dp))
        }
        Row {
            RadioButton(selected = state == "Pedro", onClick = { state = "Pedro" })
            Text(text = "Pedro", modifier = Modifier.padding(16.dp))
        }
    }


}


@Composable
fun MyCard(

) {
    BadgedBox(
        modifier = Modifier.padding(16.dp),
        badge = {
            Surface(
                modifier = Modifier.size(20.dp),
                shape = CircleShape,
                color = Color.Red
            ) { }
        }
    ) {
        Card(
            elevation = CardDefaults.cardElevation(
                defaultElevation = 12.dp
            ),
            shape = MaterialTheme.shapes.medium,
            border = BorderStroke(2.dp, Color.Red),
            modifier = Modifier
                .fillMaxSize()
                .padding(5.dp),
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) { }

        }
    }
}


@Composable
fun MyBadgeBox() {
    BadgedBox(
        modifier = Modifier.padding(16.dp),
        badge = {
            Text(text = "1")
        }
    ) {
        Icon(
            imageVector = Icons.Rounded.Add,
            contentDescription = "Add",
        )
    }
}

@Composable
fun DrowDownMenu() {
    var expanded by remember { mutableStateOf(false) }
    var selectedText by remember { mutableStateOf("") }
    val dessers = listOf("Torta", "Galleta", "Helado", "Pastel")
    Column(modifier = Modifier.padding(16.dp)) {
        OutlinedTextField(
            shape = MaterialTheme.shapes.medium,
            value = selectedText,
            onValueChange = { selectedText = it },
            enabled = false,
            readOnly = true,
            modifier = Modifier
                .fillMaxWidth()
                .clickable { expanded = true }
        )

        DropdownMenu(
            expanded = expanded,
            modifier = Modifier.fillMaxWidth(),
            onDismissRequest = { expanded = false }
        ) {
            dessers.forEach { it ->
                DropdownMenuItem(
                    onClick = {
                        expanded = false
                        selectedText = it
                    },
                    text = { Text(text = it) },

                    )

            }
        }
    }
}

@Composable
fun MySlider() {
    var sliderPosition by remember { mutableStateOf(0f) }
    var compleatevalue by remember { mutableStateOf("") }
    Column(
        modifier = Modifier.padding(16.dp), horizontalAlignment =
        Alignment.CenterHorizontally
    ) {
        Slider(
            value = sliderPosition,
            steps = 9,
            valueRange = 0f..10f,
            onValueChangeFinished = { compleatevalue = sliderPosition.toString() },
            onValueChange = { sliderPosition = it },
            colors = SliderDefaults.colors(
                thumbColor = Color.Red,
                activeTrackColor = Color.Green,
                inactiveTrackColor = Color.Blue
            )
        )
        Text(text = compleatevalue)
    }
}

@Composable
fun MySlideRange() {
    var currenRange by
    remember {
        mutableStateOf(25f..75f)
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        RangeSlider(
            modifier = Modifier.fillMaxWidth(),
            enabled = true,
            value = currenRange,
            colors = SliderDefaults.colors(
                thumbColor = Color.Blue,
                activeTrackColor = Color.Black,
                inactiveTrackColor = Color.Transparent
            ),
            valueRange = 0f..100f,
            onValueChange = { currenRange = it },
        )
        Text("Rango: ${currenRange.start} - ${currenRange.endInclusive}")
    }
}


@Composable
fun MyAlertDialogo() {
    var show by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Button(
            onClick = { show = true },
        ) {
            Text(text = "Mostrar Alerta")
        }

        AnimatedVisibility(
            visible = show,

            ) {
            AlertDialog(
                onDismissRequest = {

                },
                icon = { Icon(imageVector = Icons.Rounded.Add, contentDescription = "Alerta") },

                title = { Text(text = "Alerta") },
                text = { Text(text = "Este es un mensaje de alerta") },
                confirmButton = {
                    Button(onClick = { show = false }) {
                        Text(text = "Aceptar")
                    }
                },
                dismissButton = {
                    Button(onClick = { show = false }) {
                        Text(text = "Cancelar")
                    }
                }
            )
        }

    }
}

@Composable
fun CustomDialogo() {
    var show by remember { mutableStateOf(false) }


    Dialog(

        properties = DialogProperties(
            dismissOnBackPress = true,

            dismissOnClickOutside = true
        ),
        onDismissRequest = { show = false }

    ) {
        Column(
            modifier = Modifier
                .background(Color.White)
                .padding(16.dp)
                .clip(RoundedCornerShape(8.dp))
        ) {
            Text(text = "Este es un dialogo personalizado")
            Button(onClick = { show = false }) {
                Text(text = "Aceptar")
            }
        }
    }

}

@Composable
fun CompleteDialogo() {
    var show by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { show = true }) {
            Text(text = "Mostrar Dialogo")
        }
        AnimatedVisibility(
            visible = show,

            ) {
            if (show) {
                Dialog(
                    onDismissRequest = { show = false },
                    properties = DialogProperties(
                        dismissOnBackPress = true,
                        dismissOnClickOutside = true
                    )
                ) {
                    Column(
                        modifier = Modifier
                            .background(Color.White)
                            .padding(16.dp)
                            .verticalScroll(rememberScrollState())
                            .clip(RoundedCornerShape(8.dp))
                    ) {
                        TitleDialogo()
                        CuentaImail(gmail = "addielpuc@gmial.com", color = Color.Black)
                        CuentaImail(gmail = "jesuspuc@gmail.com", color = Color.Black)
                        CuentaImail(gmail = "alexandropuc@gmail.com", color = Color.Black)
                        AddCount()
                    }
                }
            }
        }
    }

}

@Composable
fun TitleDialogo() {
    Text(
        text = "Selecciona una cuenta", style = TextStyle(
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
    )
}

@Composable
fun CuentaImail(gmail: String, color: Color) {
    Row(
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()

            .height(50.dp),
    ) {
        Box(
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .background(color)
                .padding(8.dp),

            ) {
            Text(
                modifier = Modifier.align(Alignment.Center),
                text = gmail.first().toString(),
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
            )
        }

        Text(
            modifier = Modifier.padding(horizontal = 8.dp),
            text = gmail,
            color = Color.Black,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
        )
    }
}

@Composable
fun AddCount() {
    Row(
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()

            .height(50.dp),
    ) {
        Icon(
            modifier = Modifier
                .size(40.dp)
                .padding(8.dp)
                .background(Color.Gray)
                .clip(CircleShape),
            imageVector = Icons.Rounded.Add,
            contentDescription = "Add",
            tint = Color.Black
        )
        Text(
            modifier = Modifier.padding(horizontal = 8.dp),
            text = "Agregar cuenta",
            color = Color.Black,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
        )
    }
}

@Composable
fun MyConfimacionDiagolo() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) { }
}

