package fr.nathanrud.calculette

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AffichCalc()
        }
    }
}

@Composable
fun AffichCalc() {
    var nombre by remember { mutableStateOf("0") }
    var premierNombre by remember { mutableStateOf("") }
    var operation by remember { mutableStateOf("") }
    var histo by remember {mutableStateOf(mutableListOf(String()))}


    Text(
        text = "$histo",
        fontSize = 30.sp,
        modifier = Modifier
            .fillMaxWidth()
            ,
        textAlign = TextAlign.End

    )

    Text(
        text = "$nombre",
        fontSize = 100.sp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 100.dp),
        textAlign = TextAlign.Center

    )

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {


        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            Button(
                onClick = { nombre = if (nombre == "0") "7" else nombre + "7" },
                modifier = Modifier.size(80.dp)

            ) {
                Text(text = "7",

                    fontSize = (40.sp))
            }
            Button(
                onClick = { nombre = if (nombre == "0") "8" else nombre + "8" },
                modifier = Modifier.size(80.dp)
            ) {
                Text(text  = "8",

                    fontSize = (40.sp))
            }
            Button(
                onClick = { nombre = if (nombre == "0") "9" else nombre + "9" },
                modifier = Modifier.size(80.dp)
            ) {
                Text(text = "9",

                    fontSize = (40.sp))
            }
            Button(
                onClick = {
                    premierNombre = nombre
                    nombre = "0"
                    operation = "+"
                },
                modifier = Modifier.size(80.dp)
            ) {
                Text(text = "+",

                    fontSize = (40.sp))
            }
        }

        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            Button(
                onClick = { nombre = if (nombre == "0") "4" else nombre + "4" },
                modifier = Modifier.size(80.dp)
            ) {
                Text(text = "4",

                    fontSize = (40.sp))
            }
            Button(
                onClick = { nombre = if (nombre == "0") "5" else nombre + "5" },
                modifier = Modifier.size(80.dp)
            ) {
                Text(text = "5",

                    fontSize = (40.sp))
            }
            Button(
                onClick = { nombre = if (nombre == "0") "6" else nombre + "6" },
                modifier = Modifier.size(80.dp)
            ) {
                Text(text = "6",

                    fontSize = (40.sp))
            }
            Button(
                onClick = {
                    premierNombre = nombre
                    nombre = "0"
                    operation = "-"
                },
                modifier = Modifier.size(80.dp)
            ) {
                Text(text = "-",

                    fontSize = (40.sp))
            }
        }

        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            Button(
                onClick = { nombre = if (nombre == "0") "1" else nombre + "1" },
                modifier = Modifier.size(80.dp)
            ) {
                Text(text = "1",

                    fontSize = (40.sp))
            }
            Button(
                onClick = { nombre = if (nombre == "0") "2" else nombre + "2" },
                modifier = Modifier.size(80.dp)
            ) {
                Text(text = "2",

                    fontSize = (40.sp))
            }
            Button(
                onClick = { nombre = if (nombre == "0") "3" else nombre + "3" },
                modifier = Modifier.size(80.dp)
            ) {
                Text(text = "3",

                    fontSize = (40.sp))
            }
            Button(
                onClick = {
                    premierNombre = nombre
                    nombre = "0"
                    operation = "/"
                },
                modifier = Modifier.size(80.dp)
            ) {
                Text(text = "/",
                        fontSize = (40.sp))
            }
        }

        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            Button(
                onClick = { nombre = if (nombre == "0") "0" else nombre + "0" },
                modifier = Modifier.size(80.dp)
            ) {
                Text(text = "0",

                    fontSize = (40.sp))
            }
            Button(
                onClick = {
                    nombre = "0"
                    premierNombre = ""
                    operation = ""
                },
                modifier = Modifier.size(80.dp)
            ) {
                Text(
                    text = "C",

                    fontSize = (40.sp)
                )
            }
            Button(
                onClick = {
                    premierNombre = nombre
                    nombre = "0"
                    operation = "%"
                },
                modifier = Modifier.size(80.dp)
            ) {
                Text(
                    text = "%",

                    fontSize = (40.sp)
                )
            }
            Button(
                onClick = {
                    val n1 = premierNombre.toInt()
                    val n2 = nombre.toInt()
                    val resultat = when (operation) {
                        "+" -> n1 + n2
                        "-" -> n1 - n2
                        "/" -> n1 / n2
                        "%" -> n1 % n2
                        "*" -> n1 * n2
                        else -> n2
                    }
                    nombre = resultat.toString()
                    premierNombre = ""
                    operation = ""
                    histo.add("$resultat, ")
                },
                modifier = Modifier.size(80.dp)
            ) {
                Text(
                    text = "=",
                    fontSize = (40.sp)
                )
            }
        }
        Button(
            onClick = {
                premierNombre = nombre
                nombre = "0"
                operation = "*"
            },
            modifier = Modifier.size(80.dp)


        ) {
            Text(
                text = "*",

                fontSize = (40.sp)
            )
        }
    }
}
