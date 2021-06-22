package apiTests;

import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.withNoArgs;
import static org.hamcrest.Matchers.*;

public class testaPet {

    // Padrão
    // Given = Dado
    // When = Quando
    // Then = Então

    // Função de Apoio
    public String lerJason(String caminhoJson) throws IOException {
        return new String(Files.readAllBytes(Paths.get(caminhoJson)));
    }

        @Test
    public void incluirPet() throws IOException { // Create - Post

            String jsonBody = lerJason("src/test/resources/data/pet.json");

            given()                                 // Dado
                .contentType("application/json")    // Tipo de conteúdo
                    // "text/xml" para web services sincronos - ex: Correios
                    // "application/json" para web services assincronos - ex: iFood
                .log().all()                        // Registrar tudo do envio
                .body(jsonBody)
            .when()                                                 // Quando
                .post("https://petstore.swagger.io/v2/pet")     // Comando + endpoint
            .then()                                 // Então
                .log().all()                        // Registrar tudo da volta
                .statusCode(200)                    // Código do Estado
                .body("id", is(1012))    // Valida o Id do animal
                .body("name", is("Kiara"))    // Valida o Nome do animal
                .body("category.name", is("dog"))    // Valida a categoria do animal
                //.body("tags.name", hasItem("vermifugado"))    // Valida se contem a palavra chave
                //.body("tags.name", contains("vacinas em dia"))    // Valida se contem a palavra chave
            ;

    }

    @Test
    public void consultarPet()  {

        String petId = "1012"; // Id do animal

        given()
                .contentType("application/json")
                .log().all()
                .when()
                .get("https://petstore.swagger.io/v2/pet/" + petId)   // Get == Consultar
                .then()
                .log().all()
                .statusCode(200)
                .body("name", is("Kiara"))
                .body("status", is("available"))
        ;
    }
}
