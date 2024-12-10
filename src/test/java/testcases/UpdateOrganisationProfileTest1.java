package testcases;


import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import base.BaseTest;
import io.restassured.response.Response;
import utils.SharedData;



public class UpdateOrganisationProfileTest1 extends BaseTest {

    @Test
    public void testUpdateOrganisationProfile() {
        // Define the endpoint
        String endpoint = "/api/auth/update-organisation-profile";

        // Request body
        String requestBody = """
        {
            "companyName": "Test Company"
        }
        """;

        // Execute the request
        Response response = requestSpec
                .header("Authorization", "Bearer " + SharedData.getBearerToken()) // Dynamic Bearer Token
                .header("sec-ch-ua-platform", "macOS")
                .header("Referer", "https://qa.welup.savein.money/")
                .header("sec-ch-ua", "\"Google Chrome\";v=\"131\", \"Chromium\";v=\"131\", \"Not_A Brand\";v=\"24\"")
                .header("sec-ch-ua-mobile", "?0")
                .header("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/131.0.0.0 Safari/537.36")
                .header("Accept", "application/json, text/plain, */*")
                .header("Content-Type", "application/json")
                .body(requestBody)
                .post(endpoint);

        // Log the response
        System.out.println("Response: " + response.getBody().asString());

        // Validate status code
        AssertJUnit.assertEquals(response.getStatusCode(), 200);

        // Further validate the response (optional)
        String updatedCompanyName = response.jsonPath().getString("companyName");
        AssertJUnit.assertEquals(updatedCompanyName, "Test Company", "Company name should match.");
    }
}