package unitTests;

import devcalc.Calc;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


public class TestaCalc {
    @Test
    public void testarSomarDoisNumeros(){
        // 1 - Prepara - Configura - Given
        int num1 = 5;
        int num2 = 7;
        int resultadoEsperado = 12;

        // 2 - Executar - When
        int resultadoAtual = Calc.somarDoisNumeros(num1, num2);
        System.out.println("O resultado Esperado foi " + resultadoEsperado + "\n O resultado Atual foi " + resultadoAtual);

        // 3 - Validar - Then
        assertEquals(resultadoEsperado,resultadoAtual);

    }

    @Test (priority = 1)
    public void testarSubtrairDoisNumeros(){
        // 1 - Prepara - Configura - Given
        int num1 = 10;
        int num2 = 7;
        int resultadoEsperado = 3;

        // 2 - Executar - When

        int resultadoAtual = Calc.subtrairDoisNumeros(num1, num2);
        System.out.println("O resultado Esperado foi " + resultadoEsperado + "\n O resultado Atual foi " + resultadoAtual);

        // 3 - Validar - Then
        assertEquals(resultadoEsperado,resultadoAtual);

    }

    @Test
    public void multiplicarDoisNumeros(){
        // 1 - Prepara - Configura - Given
        int num1 = 10;
        int num2 = 7;
        int resultadoEsperado = 70;

        // 2 - Executar - When

        int resultadoAtual = Calc.multiplicarDoisNumeros(num1, num2);
        System.out.println("O resultado Esperado foi " + resultadoEsperado + "\n O resultado Atual foi " + resultadoAtual);

        // 3 - Validar - Then
        assertEquals(resultadoEsperado,resultadoAtual);

    }

    @Test
    public void dividirDoisNumeros(){
        // 1 - Prepara - Configura - Given
        int num1 = 21;
        int num2 = 7;
        int resultadoEsperado = 3;

        // 2 - Executar - When

        int resultadoAtual = Calc.dividirDoisNumeros(num1, num2);
        System.out.println("O resultado Esperado foi " + resultadoEsperado + "\n O resultado Atual foi " + resultadoAtual);

        // 3 - Validar - Then
        assertEquals(resultadoEsperado,resultadoAtual);

    }


}
