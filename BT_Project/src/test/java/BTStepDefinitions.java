import static org.junit.Assert.assertTrue; // Import necessary assertion

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BTStepDefinitions<btKeywords> {
    private btKeywords btKeywords = new btKeywords();

    @Given("I launch the application URL {string}")
    public void i_launch_the_application_URL(String url) {
        btKeywords.launchApplication(url);
    }

    @And("I close the accept Cookie pop-up if it appears")
    public void i_close_the_accept_Cookie_pop_up_if_it_appears() {
        btKeywords.closeCookiePopup();
    }

    @When("I hover to the Mobile menu")
    public void i_hover_to_the_Mobile_menu() {
        btKeywords.hoverToMobileMenu();
    }

    @And("I select Mobile phones from the mobile menu")
    public void i_select_Mobile_phones_from_the_mobile_menu() {
        btKeywords.selectMobilePhones();
    }

    @Then("the number of banners below {string} should not be less than {int}")
    public void the_number_of_banners_should_not_be_less_than(String bannerText, int minCount) {
        assertTrue(btKeywords.verifyBannerCount(bannerText, minCount));
    }

    @And("I scroll down and click View SIM only deals")
    public void i_scroll_down_and_click_View_SIM_only_deals() {
        btKeywords.scrollAndClickSimDeals();
    }

    @Then("validate the title for the new page")
    public void validate_the_title_for_the_new_page() {
        assertTrue(btKeywords.validateTitle());
    }

    @And("validate {string} for {string}, was £{double} £{double} per month")
    public void validate_for_was_£_£_per_month(String promotion, String plan, double oldPrice, double newPrice) {
        assertTrue(btKeywords.validatePromotionDetails(promotion, plan, oldPrice, newPrice));
    }

    @And("I close the browser & exit")
    public void i_close_the_browser_exit() {
        btKeywords.closeBrowser();
    }
}
