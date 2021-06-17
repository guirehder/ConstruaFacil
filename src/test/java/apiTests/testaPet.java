package apiTests;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class testaPet {

        @Test
    public void incluirPet(){

            // Padrão
            // Given = Dado
            // When = Quando
            // Then = Então

            given()
                .contentType("application/json")
                .log().all()

            .when()
                .post("https://petstore.swagger.io/v2/pet")

            .then()
                .log().all()
            ;

        }

}
