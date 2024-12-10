package testcases;

import base.BaseTest;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.SharedData;

public class VerifySignupOtpTest extends BaseTest {

    @Test
    public void testVerifySignupOtp() {
        String endpoint = "/api/auth/verify-signup-otp";

        // Retrieve email from SharedData
        String email = SharedData.getEmail();
        String otp = "111111"; // Replace with the actual OTP received during the test
        
      
        String requestBody = """
        {
            "loginInfo": "%s",
            "otp": "%s",
            "email": "%s"
        }
        """.formatted(email, otp, email);

        Response response = requestSpec
                .header("Content-Type", "application/json")
                .body(requestBody)
                .post(endpoint);
        String bearerToken = response.jsonPath().getString("token");
        System.out.println(bearerToken);
        SharedData.setBearerToken(bearerToken);

        Assert.assertEquals(response.getStatusCode(), 200, "Expected status code is 200.");
        System.out.println("Response: " + response.getBody().asString());
        
    }
}
