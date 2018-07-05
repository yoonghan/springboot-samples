package com.walcron.sample.bdd;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Ignore;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

@Ignore
public class CustomerTest extends ApplicationIntegrationTest {
    @When("^the client calls /(.*)$")
    public void the_client_issues_GET_version(String url) throws Throwable {
        executeGet("/" + url);
    }

    @When("^the client posts /(.*) with (.*)$")
    public void the_client_issues_POST_version(String url, String input) throws Throwable {
        executePOST("/" + url, input);
    }

    @Then("^the client receives status code of (\\d+)$")
    public void the_client_receives_status_code_of(int statusCode) throws Throwable {
        latestResult.andExpect(status().is(statusCode));
    }

    @And("^the client receives body of (.+)$")
    public void the_client_receives_body(String responseText) throws Throwable {
        latestResult.andExpect(content().string(responseText));
    }

    @And("^the client receives response with json (.+)$")
    public void the_client_receives_body_with_count_of(String jsonResponse) throws Throwable {
        latestResult.andExpect(content().json(jsonResponse));
    }
}
