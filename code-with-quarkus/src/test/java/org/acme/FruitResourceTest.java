package org.acme;

import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.assertFalse;

@QuarkusTest
public class FruitResourceTest {

    @Inject
    FruitService fruitService;

    @Test
    public void testHelloEndpoint() {
        given()
                .when().get("/fruit")
                .then()
                .statusCode(200)
                .body(is("[{\"id\":1,\"name\":\"litter\",\"qtde\":2},{\"id\":2,\"name\":\"strawberry\",\"qtde\":10}]"));
    }

    @Test
    public void testHelloEndpoint2() {
        List<Fruit> fruitList = fruitService.listFruit();
        assertFalse(fruitList.isEmpty());
    }
}