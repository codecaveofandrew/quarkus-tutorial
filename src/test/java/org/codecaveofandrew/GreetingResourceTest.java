package org.codecaveofandrew;

import static io.restassured.RestAssured.given;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

@QuarkusTest
class GreetingResourceTest {
  @Test
  void testHelloEndpoint() {
    given().when().get("/hello").then().statusCode(401);
  }
}
