//1 - Pacote
package webTests;

//2 - Bibliotecas

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;


//3 - Classe
public class seleniumSimples {
    // 3.1 - Atributos

    WebDriver driver;           // declarar o objeto do Selenium Webdriver

    // 3.2 - Métodos e Funções

    @Test
    public void  consultarCurso(){

        // A - Inicio
        // Aponta para onde esta o driver do Chrome
        System.setProperty("webdriver.chrome.driver", "drivers/chrome/91/chromedriver.exe");
        // Instanciar o objeto driver como um controlador do Chrome
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60000, TimeUnit.MILLISECONDS);

        //B - Realizar o teste
        driver.get("https://www.iterasys.com.br");                                  // Abre o site da iterasys
        driver.findElement(By.id("searchtext")).click();                            // Clica no campo de pesquisa
        driver.findElement(By.id("searchtext")).clear();                            // Limpa o campo de pesquisa
        driver.findElement(By.id("searchtext")).sendKeys("mantis");      // Escreve "mantis" no campo de pesquisa

        driver.findElement(By.id("btn_form_search")).click();                       // Clique na lupa

        //assertEquals(driver.findElement(By.xpath("/html/body/main/div[1]/div[1]/div[1]/h3")).getText(), "Cursos › \"mantis\"");
        assertThat(driver.findElement(By.cssSelector("h3")).getText(), is("Cursos › \"mantis\""));
        //assertThat(driver.findElement(By.xpath("1")).getText(), is("Cursos › \\\"mantis\\\""));
        //assertEquals(driver.findElement(By.cssSelector("h3:nth-child(1)")).getText(), "Cursos › \"mantis\"");

        driver.findElement(By.cssSelector("span.comprar")).click();
        assertEquals(driver.findElement(By.cssSelector("span.item-title")).getText(), "Mantis");
        assertEquals(driver.findElement(By.cssSelector("span.new-price")).getText(), "R$ 49,99");

        driver.quit(); //Objeto encerra a pagina


    }

}
