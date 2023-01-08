package com.testing.steps;

import com.testing.runners.Runner;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static java.util.Map.entry;

public class CalculatorSteps {

    public ArrayList<WebElement> numButtons = new ArrayList<>(Arrays.asList(
            Runner.calculatorPage.button0, Runner.calculatorPage.button1, Runner.calculatorPage.button2,
            Runner.calculatorPage.button3, Runner.calculatorPage.button4, Runner.calculatorPage.button5, Runner.calculatorPage.button6,
            Runner.calculatorPage.button7, Runner.calculatorPage.button8, Runner.calculatorPage.button9));

    public HashMap<String, WebElement> operations = new HashMap<>(Map.ofEntries(
            entry("%", Runner.calculatorPage.button_modulus),
            entry("/", Runner.calculatorPage.button_divide),
            entry("x", Runner.calculatorPage.button_multiply),
            entry("-", Runner.calculatorPage.button_subtract),
            entry("+", Runner.calculatorPage.button_add)
    ));

    @Then("user clicks all number buttons and decimal button and sees them displayed on bottom screen")
    public void user_clicks_all_number_buttons_and_decimal_button_and_sees_them_displayed_on_bottom_screen() {
        SoftAssert sf = new SoftAssert();
        for(int i = 0; i < numButtons.size(); i++) {
            numButtons.get(i).click();
            sf.assertEquals(Runner.calculatorPage.input.getText().substring(i,i+1), Integer.toString(i));
        }

        Runner.calculatorPage.button_dot.click();
        sf.assertEquals(Runner.calculatorPage.input.getText().substring(numButtons.size()), ".");
        sf.assertAll();
    }

    @When("user clicks a number")
    public void user_clicks_a_number() {

    }
    @When("user clicks clear button")
    public void user_clicks_clear_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("{string} screen should be clear")
    public void screen_should_be_clear(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}
