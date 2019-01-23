package hellocucumber;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import static org.junit.Assert.*;

class IsItFriday {
    static String isItFriday(String today) {
        if (today.equals("Friday")) {
            return "TGIF";
        }
        return "Nope";
    }
}

public class Stepdefs {
    private String today;
    private String actualAnswer;

    @Given("^today is Sunday$")
    public void today_is_Sunday() {
        today = "Sunday";
    }

    @Given("^today is \"([^\"]*)\"$")
    public void today_is(String day) throws Exception {
        // Write code here that turns the phrase above into concrete actions
        today=day;
    }

    @When("^I ask whether it's Friday yet$")
    public void i_ask_whether_is_s_Friday_yet() {
        actualAnswer = IsItFriday.isItFriday(today);
    }

    @Given("^today is Friday$")
    public void today_is_Friday() throws Exception {
        // Write code here that turns the phrase above into concrete actions
        today = "Friday";
    }

    @Then("^I should be told \"([^\"]*)\"$")
    public void i_should_be_told(String expectedAnswer) {
        System.out.println("qqqqqqqqqqqqqqqqqqqexpectedAnswer : " + expectedAnswer);
        assertEquals(expectedAnswer, actualAnswer);
    }
}