package testcases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import base.BaseTest;
import io.restassured.response.Response;


import utils.SharedData;

public class SendSignupOtpTest extends BaseTest {

    @Test
    public void testSendSignupOtp() {
        String endpoint = "/api/auth/send-signup-otp";
        String email = "testklsjdkla342@g.com";
        String password = "testPassword123"; // Replace with actual password
        String requestBody = """
        {
            "name": "Ayush Tiwari API Test",
            "email": "%s",
            "mobile": "4298458904"
        }
        """.formatted(email);

        // Store email and password in SharedData
        SharedData.setEmail(email);
        SharedData.setPassword(password);

        Response response = requestSpec
                .header("Content-Type", "application/json")
                .body(requestBody)
                .post(endpoint);

        AssertJUnit.assertEquals(response.getStatusCode(), 200);
        System.out.println("Response: " + response.getBody().asString());
    }
}
