package com.example.calculadora;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Tests para la clase Calculator.
 * Verificamos que las operaciones funcionen correctamente.
 *
 * @author Jordi Navarro
 * @version 2.0
 * @since 01/11/2024
 */

public class CalculatorTest
{
    // Declaramos instancia de la clase Calculator
    Calculator calc = new Calculator();

    /**
     * Verifica la suma de dos numeros.
     */
    @Test
    public void testAdd2Operands()
    {
        int total = calc.calcular("5+3");
        assertEquals("X + Y operations not working correctly", 8, total);
    }

    /**
     * Verifica la suma de tres numeros.
     */
    @Test
    public void testAdd1Operand()
    {
        int total = calc.calcular("4+3+1");
        assertEquals("+X operations not working correctly", 8, total);
    }

    /**
     * Verifica la multiplicación de dos numeros.
     */
    @Test
    public void testMul2Operands()
    {
        int total = calc.calcular("4*2");
        assertEquals("4*X operations not working correctly", 8, total);
    }

    /**
     * Verifica operaciones con multiples numeros.
     */
    @Test
    public void testMuchosOperadores() {
        int total = calc.calcular("1+2+3+4+5");
        assertEquals("1+2+3+4+5 should equal 15", 15, total);
    }

    /**
     * Verifica la operación de multiplicaciun con tres numeros.
     */
    @Test
    public void testConDistintosOperadores() {
        int total = calc.calcular("2*2+3");
        assertEquals("2 * 2 + 3 should equal 7", 7, total);
    }


}
