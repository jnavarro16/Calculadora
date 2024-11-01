package com.example.calculadora;
/**
 * La clase Calculator realiza operaciones matematicas basicas.
 *
 * @author Jordi Navarro
 * @version 2.0
 * @since 01/11/2024
 */
public class Calculator
{
    /**
     * Suma de 2 numeros enteros.
     * @param a El primer numero.
     * @param b El segundo numero.
     * @return La suma de a y b.
     */
    public int suma (int a, int b)
    {
        return a + b;
    }

    /**
     * Resta de 2 numeros enteros.
     * @param a El primer numero.
     * @param b El segundo numero.
     * @return La resta de a y b.
     */
    // Resta dos números enteros.
    public int resta (int a, int b)
    {
        return a - b;
    }

    /**
     * Multiplicacion de 2 numeros enteros.
     * @param a El primer numero.
     * @param b El segundo numero.
     * @return La multiplicacion de a y b.
     */
    // Multiplica dos números enteros.
    public int multiplicacion (int a, int b)
    {
        return a * b;
    }

    /**
     * Division de 2 numeros enteros.
     * @param a El primer numero.
     * @param b El segundo numero.
     * @return EL cociente de la division entre a y b.
     */
    // Divide dos números enteros.
    public double division (int a, int b)
    {
        if (b == 0)
        {
            // Si el segundo número es 0 se lanzará la exception.
            throw new IllegalArgumentException("No se puede dividir entre 0");
        } else {
            return (double) a / b; // Devuelve el cociente.
        }
    }

    /**
     * Metodo para calcular la operacion.
     * @param operacion cadena de la operacion a calcular.
     * @return El resultado de la operacion.
     */
    public int calcular(String operacion)
    {
        // Calculamos segun los operadores
        // Calculamos la Suma
        if (operacion.contains("+"))
        {
            String[] parts = operacion.split("\\+", 2);
            return calcular(parts[0]) + calcular(parts[1]);
        }
        // Si no, Calculamos la resta
        else if (operacion.contains("-"))
        {
            String[] parts = operacion.split("-", 2);
            return calcular(parts[0]) - calcular(parts[1]);
        }
        // Si no, Calculamos la multiplicación
        else if (operacion.contains("*"))
        {
            String[] parts = operacion.split("\\*", 2);
            return calcular(parts[0]) * calcular(parts[1]);
        }
        // Si no, Calculamos la división
        else if (operacion.contains("/"))
        {
            String[] parts = operacion.split("/", 2);
            return calcular(parts[0]) / calcular(parts[1]);
        }

        // Si no hay operaciones, convertimos la cadena a un entero
        return Integer.parseInt(operacion.trim());
    }
}
