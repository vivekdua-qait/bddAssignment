package com.test.vivek.stepdefinitions;

import com.test.vivek.TestSessionInitiator;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.text.ParseException;

public class NewStepdef {

	private TestSessionInitiator test;

	public NewStepdef(TestDependencyInjector testinjector) {
		test = testinjector.test;
	}

	@Given("User is on the shopping site")
	public void verifyUserIsAbleToAccessShoppingSite() {
		test.pages.verifyUserIsOnMyStore();
	}

	@When("User clicks on Sign In tab")
	public void verifySignInButtonIsWorkingFine() {
		test.pages.verifySignInButtonRedirectsUserToSignInPage();
	}

	@When("User enters {string}")
	public void userEntersCredentials(String value) {
		test.pages.userEnterCredentials(value);
	}

	@When("User clicks on Sign In button")
	public void userIsAbleToSignIn() {
		test.pages.userClicksOnSubmitButton();
	}

	@Then("User is logged in successfully")
	public void verifyUserIsLoggedInOnMyStore() {
		test.pages.verifyUserIsLoggedInSuccessfully();
	}

	@When("User clicks on {string} navigation tab")
	public void userGoesToTShirtTab(String tab) {
		test.pages.verifyUserIsAbleToSelectTShirtTab(tab);
	}

	@When("User selects {string} {string} from the catalog")
	public void userSelectsCustomOptionFromCatalog(String option, String value) {
		test.pages.selectCustomOptionsFromCatalog(option, value);
	}

	@When("User selects first item from catalog and adds to cart")
	public void userSelectsFirstItemFromTheCatalogList() {
		test.pages.userSelectsFirstItemFromTheList();
	}

	@When("User clicks on checkout button")
	public void userContinuesCheckoutProcess() {
		test.pages.clickOnCheckoutButton();
	}

	@When("User is on {string} Tab and clicks on {string}")
	public void userIsOnSummaryTabAndContinuesCheckout(String tab, String btn_checkout) {
		test.pages.verifyUserIsOnTab(tab);
		test.pages.userClicksOnProceedToCheckout(btn_checkout);
	}

	@When("User selects I agree checkbox on shipping tab and clicks on {string}")
	public void userClicksOnIAgreeCheckboxAndContinuesCheckout(String btn_checkout) {
		test.pages.userChecksIAgreeBox();
		test.pages.userClicksOnProceedToCheckout(btn_checkout);
	}

	@When("User is on payment tab and selects {string}")
	public void userSelectsPaymentOption(String mode) {
		test.pages.selectPaymentMode(mode);
	}

	@When("User clicks on {string}")
	public void userClickOnIConfirmMyOrder(String btn_checkout) {
		test.pages.userClicksOnProceedToCheckout(btn_checkout);
	}

	@Then("Order is placed successfully")
	public void verifyOrderIsPlacedSuccessfully() {
		test.pages.verifyOrderIsPlacedSuccessfully();
	}

	@Then("Order history shows recent order")
	public void verifyRecentlyPlacedOrderIsPresentInOrderHistory() throws ParseException {
		test.pages.verifyOrderIsPresentUnderMyOrders();
	}

	@When("User clicks on customer account button")
	public void userClicksOnAccountInfoButtonInHeader() {
		test.pages.clickOnMyAccountHeaderButton();
	}

	@When("User clicks on My Personal Information tab")
	public void userClicksOnMyPersonalInformationTab() {
		test.pages.goToPersonalInformationTab();
	}

	@When("User updates first name to {string}")
	public void userUpdatesFirstNameUnderPersonalInfo(String value) {
		test.pages.updatedFirstName(value);
	}

	@When("User enters old password")
	public void userEntersOldPassword() {
		test.pages.enterOldPassword();
	}

	@When("User clicks on Save button")
	public void userClicksOnSaveButton() {
		test.pages.clickOnSaveButton();
	}

	@Then("Account information is updated")
	public void verifyAccuontInformationUpdateIsSuccessfull() {
		test.pages.verifyAccountInformationUpdatesIsSuccessfull();
	}
}