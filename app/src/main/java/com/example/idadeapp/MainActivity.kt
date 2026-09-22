package com.example.idadeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme {
                TelaIdade()
            }
        }
    }
}

@Composable
fun TelaIdade() {

    var idade by remember {
        mutableStateOf(17)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),

        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "Qual é a sua idade?",
            fontSize = 30.sp,
            fontWeight = FontWeight.Medium
        )

        Spacer(
            modifier = Modifier.height(8.dp)
        )

        Text(
            text = "Aperte os botões para informar a sua idade",
            fontSize = 16.sp,
            textAlign = TextAlign.Center
        )

        Spacer(
            modifier = Modifier.height(32.dp)
        )

        Text(
            text = idade.toString(),
            fontSize = 42.sp
        )

        Spacer(
            modifier = Modifier.height(24.dp)
        )

        Row(
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            // BOTÃO -
            Button(
                onClick = {

                    if (idade > 0) {
                        idade--
                    }

                }
            ) {

                Text(
                    text = "-",
                    fontSize = 30.sp
                )
            }

            // BOTÃO +
            Button(
                onClick = {

                    if (idade < 180) {
                        idade++
                    }

                }
            ) {

                Text(
                    text = "+",
                    fontSize = 30.sp
                )
            }
        }

        Spacer(
            modifier = Modifier.height(32.dp)
        )

        if (idade >= 18) {

            Text(
                text = "Você é MAIOR de idade",
                fontSize = 26.sp,
                fontWeight = FontWeight.Medium,
                textAlign = TextAlign.Center
            )

        } else {

            Text(
                text = "Você é MENOR de idade",
                fontSize = 26.sp,
                fontWeight = FontWeight.Medium,
                textAlign = TextAlign.Center
            )
        }
    }
}