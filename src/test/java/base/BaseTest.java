package base;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    protected RequestSpecification requestSpec;

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://qa.api.welup.savein.money"; // Base URI for all requests
        requestSpec = RestAssured.given()
                .header("Content-Type", "application/json")
                .header("Accept", "*/*"); // Add common headers here
    }
}
