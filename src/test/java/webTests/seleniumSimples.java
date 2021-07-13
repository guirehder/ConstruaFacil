// 1 - Pacote
package webTests;

// 2 - Bibliotecas

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import utils.Evidencias;


// 3 - Classe
public class seleniumSimples {
    // 3.1 - Atributos

    WebDriver driver;                           // declarar o objeto do Selenium WebDriver
    Evidencias evidencias;
    static String dataHora = new SimpleDateFormat ("yyyy-MM-dd HH-mm").toString();

    // 3.2 - M�todos e Fun��es
    @BeforeMethod
    public void iniciar(){
        // A - In�cio
        // Aponta para onde est� o driver do Chrome
        System.setProperty("webdriver.chrome.driver", "drivers/chrome/91/chromedriver.exe");
        // Instancia o objeto driver como um controlador do Chrome
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60000, TimeUnit.MILLISECONDS);

        evidencias = new Evidencias(); //Instanciar
    }

    @AfterMethod
    public void finalizar(){
        // Parte C - Encerramento

        driver.quit(); // Encerra o objeto do Selenium

    }

    @Test(priority = 1)
    public void consultarCursoMantis() throws IOException {
        String casoDeTeste = "Consultar Curso Mantis";
        // B - Realizar o teste
        driver.get("https://www.iterasys.com.br");                              // Abre o site alvo informado
        evidencias.print(driver,dataHora,casoDeTeste, "Passo 1 - Abriu o site");
        driver.findElement(By.id("searchtext")).click();                        // Clica no campo de pesquisa
        driver.findElement(By.id("searchtext")).clear();                        // Limpa o campo de pesquisa
        driver.findElement(By.id("searchtext")).sendKeys("mantis");  // Escreve "mantis" no campo

        evidencias.print(driver,dataHora,casoDeTeste , "Passo 2 - Digitou Mantis");

        driver.findElement(By.id("btn_form_search")).click();                   // Clique na lupa

        assertEquals(driver.findElement(By.cssSelector("h3")).getText(), "Cursos � \"mantis\"");
        //assertTrue(driver.findElement(By.cssSelector("h3")).getText().contains("mantis"));
        //assertEquals(driver.findElement(By.cssSelector("h3:nth-child(1)")).getText(), "Cursos � \"mantis\"");
        evidencias.print(driver,dataHora,casoDeTeste ,"Passo 3 - Exibiu a lista de cursos");
        driver.findElement(By.cssSelector("span.comprar")).click();             // Clica no bot�o Matricule-se

        assertEquals(driver.findElement(By.cssSelector("span.item-title")).getText(), "Mantis");
        assertEquals(driver.findElement(By.cssSelector("span.new-price")).getText(), "R$ 49,99");
        evidencias.print(driver,dataHora,casoDeTeste ,"Passo 4 - Exibiu o carrinho de compras");
    }

    @Test(priority = 2, dependsOnMethods = {"consultarCursoMantis"})
    public void consultarCursoCTFL() throws IOException {
        String casoDeTeste = "Consultar Curso Preparat�rio CTFL";;
        // B - Realizar o teste
        driver.get("https://www.iterasys.com.br");                              // Abre o site alvo informado
        evidencias.print(driver,dataHora,casoDeTeste ,"Passo 1 - Abriu o site");
        driver.findElement(By.id("searchtext")).click();                        // Clica no campo de pesquisa
        driver.findElement(By.id("searchtext")).clear();                        // Limpa o campo de pesquisa
        driver.findElement(By.id("searchtext")).sendKeys("preparat�rio ctfl");  // Escreve "mantis" no campo
        evidencias.print(driver,dataHora,casoDeTeste , "Passo 2 - Digitou preparat�rio ctfl");
        driver.findElement(By.id("btn_form_search")).click();                   // Clique na lupa

        assertEquals(driver.findElement(By.cssSelector("h3")).getText(), "Cursos � \"preparat�rio ctfl\"");
        //assertTrue(driver.findElement(By.cssSelector("h3")).getText().contains("mantis"));
        //assertEquals(driver.findElement(By.cssSelector("h3:nth-child(1)")).getText(), "Cursos � \"mantis\"");
        evidencias.print(driver,dataHora,casoDeTeste , "Passo 3 - Exibiu a lista de cursos");
        driver.findElement(By.cssSelector("span.comprar")).click();             // Clica no bot�o Matricule-se

        assertEquals(driver.findElement(By.cssSelector("span.item-title")).getText().toUpperCase(), "PREPARAT�RIO CTFL");
        assertEquals(driver.findElement(By.cssSelector("span.new-price")).getText(), "R$ 169,00");
        evidencias.print(driver,dataHora,casoDeTeste , "Passo 4 - Exibiu o carrinho de compras");
    }
}
