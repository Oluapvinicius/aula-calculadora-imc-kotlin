    package com.example.calculadoradeimc

    import android.media.Image
    import android.os.Bundle
    import androidx.activity.ComponentActivity
    import androidx.activity.compose.setContent
    import androidx.activity.enableEdgeToEdge
    import androidx.compose.foundation.background
    import androidx.compose.foundation.layout.Arrangement
    import androidx.compose.foundation.layout.Column
    import androidx.compose.foundation.layout.Row
    import androidx.compose.foundation.layout.Spacer
    import androidx.compose.foundation.layout.fillMaxHeight
    import androidx.compose.foundation.layout.fillMaxSize
    import androidx.compose.foundation.layout.fillMaxWidth
    import androidx.compose.foundation.layout.height
    import androidx.compose.foundation.layout.offset
    import androidx.compose.foundation.layout.padding
    import androidx.compose.foundation.layout.size
    import androidx.compose.foundation.shape.RoundedCornerShape
    import androidx.compose.foundation.text.KeyboardOptions
    import androidx.compose.material3.Button
    import androidx.compose.material3.ButtonDefaults
    import androidx.compose.material3.Card
    import androidx.compose.material3.CardDefaults
    import androidx.compose.material3.CardElevation
    import androidx.compose.material3.OutlinedButton
    import androidx.compose.material3.OutlinedTextField
    import androidx.compose.material3.Scaffold
    import androidx.compose.material3.Text
    import androidx.compose.material3.TextField
    import androidx.compose.runtime.Composable
    import androidx.compose.runtime.getValue
    import androidx.compose.runtime.mutableStateOf
    import androidx.compose.runtime.remember
    import androidx.compose.runtime.setValue
    import androidx.compose.ui.Alignment
    import androidx.compose.ui.Modifier
    import androidx.compose.ui.graphics.Color
    import androidx.compose.ui.res.colorResource
    import androidx.compose.ui.res.painterResource
    import androidx.compose.ui.text.font.Font
    import androidx.compose.ui.text.font.FontWeight
    import androidx.compose.ui.text.input.KeyboardType
    import androidx.compose.ui.text.rememberTextMeasurer
    import androidx.compose.ui.tooling.preview.Preview
    import androidx.compose.ui.unit.dp
    import androidx.compose.ui.unit.sp
    import androidx.core.graphics.toColorInt
    import com.example.calculadoradeimc.ui.theme.CalculadoraDeIMCTheme

    class MainActivity : ComponentActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)

            setContent {
                CalculadoraDeIMCTheme {
                    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                      CalculadoraIMCScreen(Modifier.padding(innerPadding)
                        )
                    }
                }
            }
        }
    }

    @Composable
    fun CalculadoraIMCScreen(modifier: Modifier = Modifier) {

        var altura by remember { mutableStateOf("") }
        var peso by remember { mutableStateOf("") }
        val pesoD = peso.toDoubleOrNull() ?: 0.0
        val alturaD = altura.toDoubleOrNull() ?: 0.0

        var estadoCalcular by remember { mutableStateOf(0.0) }

        val medirPeso = if (estadoCalcular < 18.5) {
            "Abaixo do peso"
        } else if (estadoCalcular < 25.0) {
            "Peso ideal"
        } else if (estadoCalcular < 30.0) {
            "Levemente acima do peso"
        } else if (estadoCalcular < 35.0) {
            "Obesidade de grau I"
        } else if (estadoCalcular < 40.0) {
            "Obesidade de grau II"
        } else {
            "Obesidade de grau III"
        }





        Column(modifier = Modifier.fillMaxSize()){
            // - header
            Column(modifier = Modifier
                .fillMaxWidth()
                .height(160.dp)
                .background(color = colorResource(R.color.cor_app)),
                horizontalAlignment = Alignment.CenterHorizontally
            )
            {
                androidx.compose.foundation.Image(

                    painter = painterResource(R.drawable.bm2),
                    contentDescription = "Img",
                    modifier = modifier.size(80.dp).padding(vertical = 16.dp)
                )

                Text(
                    text = "Calculadora IMC",
                    fontSize = 24.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                    )
            }


            Column(modifier = Modifier.fillMaxWidth()
                .padding(horizontal = 32.dp)) {
            // -- form
                Card(modifier = Modifier.fillMaxWidth()
                    .height(300.dp)
                    .offset(y =30.dp),
                    colors = CardDefaults.cardColors(
                        containerColor =  Color(0xFFF9F6F6)
                    ),
                    elevation = CardDefaults.cardElevation(4.dp)
                ) {

                Column(modifier = Modifier.padding(20.dp)) {
                    Spacer(modifier = Modifier.height(12.dp))
                    Text(
                        modifier = Modifier
                            .align (Alignment.CenterHorizontally),
                        text = "Seus Dados",
                        fontSize = 19.sp,
                        color = colorResource(R.color.cor_app)

                    )
                    Spacer(modifier = Modifier.height(10.dp))

                    OutlinedTextField(
                        value = altura,
                        onValueChange = {newAltura ->
                            altura = newAltura},
                        label = { Text("altura") },
                        shape = RoundedCornerShape(20.dp),
                        modifier = Modifier.fillMaxWidth(),


                    )
                    Spacer(modifier = Modifier.height(10.dp))


                    OutlinedTextField(
                        value = peso,
                        onValueChange = {newText ->
                            peso = newText},
                        label = { Text("Peso") },
                        shape = RoundedCornerShape(20.dp),
                        modifier = Modifier.fillMaxWidth()
                    )

                    Spacer(modifier = Modifier.height(10.dp))
                    OutlinedButton(onClick = {
                     estadoCalcular = pesoD / (alturaD * alturaD)
                    },
                        modifier = Modifier.padding(8.dp)
                            .align (Alignment.CenterHorizontally)
                            .fillMaxWidth()
                            .height(50.dp),
                        enabled = true,
                        shape = RoundedCornerShape(20.dp),
                        colors = ButtonDefaults.buttonColors(colorResource(R.color.cor_app)))
                    {
            Text(text = "CALCULAR")
                    }

                }

                }
            // -- result
                Spacer(modifier = Modifier.height(40.dp))
                Card(modifier = Modifier.fillMaxWidth()
                    .padding(10.dp)
                    .height(72.dp),
                    colors = CardDefaults.cardColors(Color.DarkGray
                    )

                )
                {
                    Row(modifier = Modifier.fillMaxWidth().fillMaxHeight().padding(16.dp)
                       ,
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                        )
                    { Text(text = "%.2f".format(estadoCalcular),
                        color = Color.White,
                        fontSize = 28.sp,
                        modifier = Modifier

                    )
                    Text(text = medirPeso,
                        color = Color.White,
                        fontSize = 18.sp)}
                }
            }
        }
    }

