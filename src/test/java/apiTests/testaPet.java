package apiTests;

import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.withNoArgs;
import static org.hamcrest.Matchers.*;

public class testaPet {

    String uri = "https://petstore.swagger.io/v2/pet";
    int petId = 1012;
    String appjson = "application/json";

    // Padrão
    // Given = Dado
    // When = Quando
    // Then = Então

    // Função de Apoio
    public String lerJason(String caminhoJson) throws IOException {
        return new String(Files.readAllBytes(Paths.get(caminhoJson)));
    }

        @Test (priority = 0)
    public void incluirPet() throws IOException { // Create - Post

            String jsonBody = lerJason("src/test/resources/data/pet.json");

            given()                                 // Dado
                .contentType(appjson)    // Tipo de conteúdo
                    // "text/xml" para web services sincronos - ex: Correios
                    // "application/json" para web services assincronos - ex: iFood
                .log().all()                        // Registrar tudo do envio
                .body(jsonBody)
            .when()                                                 // Quando
                .post(uri)     // Comando + endpoint
            .then()                                 // Então
                .log().all()                        // Registrar tudo da volta
                .statusCode(200)                    // Código do Estado
                .body("id", is(petId))    // Valida o Id do animal
                .body("name", is("Kiara"))    // Valida o Nome do animal
                .body("category.name", is("dog"))    // Valida a categoria do animal
                .body("tags.id[0]", is(0))
                .body("tags.name[0]", stringContainsInOrder("primeira semana"))
                .body("tags.id[1]", is(1))
                .body("tags.name[1]", stringContainsInOrder("segunda semana"))
            ;

    }

    @Test (priority = 1, dependsOnMethods = {"incluirPet"})
    public void consultarPet()  {

        String petId = "1012"; // Id do animal

        given()
                .contentType(appjson)
                .log().all()
                .when()
                .get(uri + "/" + petId)   // Get == Consultar
                .then()
                .log().all()
                .statusCode(200)
                .body("name", is("Kiara"))
                .body("status", is("available"))
        ;
    }

    @Test (priority = 2, dependsOnMethods = {"consultarPet"})
    public void alterarPet() throws IOException {

        String jsonBody = lerJason("src/test/resources/data/newpet.json");

        given()
            .contentType("")
            .contentType(appjson)
            .log().all()
            .body(jsonBody)
        .when()
            .put(uri)
        .then()
            .log().all()
            .statusCode(200)
            .body("status", is("sold"))
        ;
    }

    @Test (priority = 3, dependsOnMethods = {"incluirPet"})
    public void excluirPet(){

        given()
                .contentType(appjson)
                .log().all()
        .when()
                .delete(uri + "/" + petId)
        .then()
                .log().all()
                .statusCode(200)
                .body("code", is(200))
                .body("type", is("unknown"))
                .body("message", is("1012"))
        ;

    }



}
