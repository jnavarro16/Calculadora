package com.example.calculadora

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.calculadora.ui.theme.CalculadoraTheme

class MainActivity : ComponentActivity() {
    // Almacena los números y operadores ingresados
    val entrada = StringBuilder()

    // Variable para el cuadro de texto que mostrará la entrada
    lateinit var textoCuadro: TextView

    // Instancia de la clase Calculator para realizar los cálculos
    val calculator = Calculator()

    // Variables para almacenar el primer número y el operador seleccionado
    // Las inicializamos a null para evitar errores.
    // Cuando sean distintas a null, se sabrá que el usuario ha señeccionado un boton.
    var num1: Int? = null         // Variable que almacena el primer numero antes de seleccionar el operador.
    var num2: Int? = null
    var operador: String? = null   // Variable que almacena el operador seleccionado.


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.calculadora_vertical)

        // Inicializamos el TextView donde se mostrará la entrada
        textoCuadro = findViewById(R.id.textoCuadro)

        // Configuración de los botones numéricos para agregar números a la entrada
        findViewById<Button>(R.id.button0).setOnClickListener { agregarNumero("0") }
        findViewById<Button>(R.id.button1).setOnClickListener { agregarNumero("1") }
        findViewById<Button>(R.id.button2).setOnClickListener { agregarNumero("2") }
        findViewById<Button>(R.id.button3).setOnClickListener { agregarNumero("3") }
        findViewById<Button>(R.id.button4).setOnClickListener { agregarNumero("4") }
        findViewById<Button>(R.id.button5).setOnClickListener { agregarNumero("5") }
        findViewById<Button>(R.id.button6).setOnClickListener { agregarNumero("6") }
        findViewById<Button>(R.id.button7).setOnClickListener { agregarNumero("7") }
        findViewById<Button>(R.id.button8).setOnClickListener { agregarNumero("8") }
        findViewById<Button>(R.id.button9).setOnClickListener { agregarNumero("9") }

        // Configuración de los botones de operación:
        // Botón para la suma
        findViewById<Button>(R.id.buttonSuma).setOnClickListener {
            operador = "+" // Almacena el operador seleccionado
            mostrarOperador()
        }

        // Botón para la resta
        findViewById<Button>(R.id.buttonResta).setOnClickListener {
            operador = "-" // Almacena el operador seleccionado
            mostrarOperador()
        }

        // Botón para la multiplicacion
        findViewById<Button>(R.id.buttonMult).setOnClickListener {
            operador = "*" // Almacena el operador seleccionado
            mostrarOperador()
        }

        // Botón para la division
        findViewById<Button>(R.id.buttonDiv).setOnClickListener {
            operador = "/" // Almacena el operador seleccionado
            mostrarOperador()
        }

        // Botón para limpiar
        findViewById<Button>(R.id.buttonC).setOnClickListener {
            clean() // Limpia la entrada
        }

        // Botón para calcular el resultado
        findViewById<Button>(R.id.buttonIgual).setOnClickListener {
            // Convertimos la entrada en un número y lo almacenamos en num2
            num2 = entrada.toString().toIntOrNull()

                val resultado = calculator.calcular("$num1 $operador $num2")
                textoCuadro.text = resultado.toString() // Mostramos el resultado

        }
    }

    // Método para agregar los numeros o los operadores al cuadro de texto
    fun agregarNumero(numero: String) {
        entrada.append(numero)  // Añadimos el argumento a la entrada
        textoCuadro.text = entrada.toString() // Lo mostramos en el texto

    }

    // Método para limpiar el cuadro de texto
    fun clean() {
        entrada.clear() // Borra la entrada
        textoCuadro.text = "" // Limpia el TextView
        num1 = null // Limpiamos también num1 y num2
        num2 = null
        operador = null
    }

    // Método para almacenar y mostrar el operador
    fun mostrarOperador ()
    {
        num1 = entrada.toString().toInt() // Convertimos la primera entrada a int
        textoCuadro.append(" $operador ") // Mostramos el operador
        entrada.clear() // Limpiamos el texto para el siguiente numero

    }

    /*
    fun calcular(string: String): Int
    {
        if (!string.contains("+")) {
            return string.toInt()
        } else {
            // Divide la cadena
            val parts = string.split("+", limit = 2)
            val string1 = parts[0]
            val string2 = parts[1]
            return calcular(string1) + calcular(string2)
        }
    }
    */


}

