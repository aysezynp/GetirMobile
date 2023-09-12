package com.getir.step_definitions;

import com.getir.pages.BasketPage;
import com.getir.pages.LoginPage;
import com.getir.utilities.ScrollHelper;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Login_stepDefs {
    LoginPage loginPage = new LoginPage();
    BasketPage basketPage=new BasketPage();

    @When("The user opens app and enters valid credentials {string} and {string}")
    public void the_user_opens_app_and_enters_valid_credentials_and(String username, String password) {
        loginPage.login(username, password);
    }

    @Then("The user login successfully")
    public void the_user_login_successfully() {
        loginPage.waitUntil(loginPage.ldondurma);
        Assert.assertTrue(loginPage.ldondurma.isDisplayed());
    }
    @When("The user clicks basket")
    public void the_user_clicks_basket() {
        basketPage.lbasket.click();
    }
    @When("The user verify that basket is empty and able to see {string} message")
    public void the_user_verify_that_basket_is_empty_and_able_to_see_message(String message) {
        Assert.assertEquals(message,basketPage.lbasketText.getText());
    }
    @When("User navigates to main menu")
    public void user_navigates_to_main_menu() {
        basketPage.lbackBtn.click();
    }
    @Then("The user verify that menu size is {int}")
    public void the_user_verify_that_menu_size_is(int menuSize) {
        System.out.println("basketPage.lmenuList = " + basketPage.lmenuList.size());
        Assert.assertEquals(menuSize,basketPage.lmenuList.size());
    }
    @Then("The User navigates to {string}")
    public void the_user_navigates_to(String categoryName) {
        basketPage.clickCategory(categoryName);
    }
    @Then("The user adds item")
    public void the_user_adds_item() {
        basketPage.laddItem.click();
    }
    @Then("The user navigates item {string}")
    public void the_user_navigates_item(String itemName) {
        new ScrollHelper().scrollVerticalHelper(itemName);
    }

    @Then("The user verify that {string}")
    public void the_user_verify_that(String expectedAmount) {
        Assert.assertEquals(expectedAmount,basketPage.totalAmount.getText());
    }


}