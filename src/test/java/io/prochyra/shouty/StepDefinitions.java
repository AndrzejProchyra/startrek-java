package io.prochyra.shouty;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.assertj.core.api.Assertions.assertThat;

public class StepDefinitions {

    private Person lucy;
    private Person sean;
    private String messageFromSean;

    @Given("Lucy is located {int} metres from Sean")
    public void lucy_is_located_metres_from_sean(Integer distance) {
        lucy = new Person();
        sean = new Person();
        lucy.moveTo(distance);
    }

    @When("Sean shouts {string}")
    public void sean_shouts(String message) {
        sean.shout(message);
        messageFromSean = message;
    }

    @Then("Lucy hears Sean's message")
    public void lucy_hears_sean_s_message() {
        assertThat(lucy.getMessagesHeard()).containsOnly(messageFromSean);
    }
}
