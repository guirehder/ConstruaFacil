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


}
