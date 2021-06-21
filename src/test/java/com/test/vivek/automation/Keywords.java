package com.test.vivek.automation;

import com.test.vivek.utils.YamlReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class Keywords extends GetPage {

	public Keywords(WebDriver driver) {
		super(driver, "pages");
	}

	public void launchURL(String url) {
		driver.get(YamlReader.getYamlValue(url));
		wait.waitForPageToLoadCompletely();
		logMessage("info", "User has launched URL: " + driver.getCurrentUrl());
	}

	public void verifyUserIsOnMyStore() {
		launchURL("url");
		Assert.assertTrue(YamlReader.getYamlValue("title.home").equalsIgnoreCase("My Store"),
				"[Assert Failed]: User is not on My Store site");
		logMessage("pass", " User is on My Store");
	}

	public void verifySignInButtonRedirectsUserToSignInPage() {
		wait.waitForElementToBeVisible(element("btn_signin", ""));
		element("btn_signin", "").click();
		logMessage("info", "User has clicked on Sign In button");
		wait.waitForPageTitleToContain(YamlReader.getYamlValue("title.login"));
		Assert.assertTrue(YamlReader.getYamlValue("title.login").equalsIgnoreCase(driver.getTitle()),
				"[Assert Failed]: User is not on Sign in page");
		logMessage("pass", " User is on Sign in page");
	}

	public void userEnterCredentials(String value) {
		element(value, "").sendKeys(YamlReader.getYamlValue(value));
		logMessage("info", "User has entered Email address");
	}

	public void userClicksOnSubmitButton() {
		element("btn_submit", "").click();
		logMessage("info", "User has clicked on Submit button");
	}

	public void verifyUserIsLoggedInSuccessfully() {
		Boolean flag1 = false;
		wait.waitForPageToLoadCompletely();
		wait.waitForPageTitleToContain(YamlReader.getYamlValue("title.account"));
		if (YamlReader.getYamlValue("title.account").equalsIgnoreCase("My account - My Store"))
			flag1 = true;
		Assert.assertTrue(flag1, "[Assert Failed]: User is not Signed in");
		logMessage("pass", "User is Signed in successfully!");
	}

	public void verifyUserIsAbleToSelectTShirtTab(String tab) {
		element("nav_tab", tab).click();
		logMessage("info", "User has clicked on " + tab + " navigation tab");
		wait.waitForPageTitleToContain(YamlReader.getYamlValue("title.tshirt"));
		Assert.assertTrue(YamlReader.getYamlValue("title.tshirt").equalsIgnoreCase(driver.getTitle()),
				"[Assert Failed]: User is not on T-Shirt tab");
		logMessage("pass", "User is on T-Shirt tab");
	}

	public void selectCustomOptionsFromCatalog(String option, String value) {
		element("custom_options", option, value).click();
		logMessage("info", "User has Selected " + option + " " + value);
	}

	public void userSelectsFirstItemFromTheList() {
		wait.waitForPageToLoadCompletely();
		logMessage("info", "User is clicking on first product");
		scrollDown(element("product"));
		hover(element("product", ""));
		element("btn_addtocart", "").click();
		logMessage("info", "User has clicked on first product");
	}

	public void clickOnCheckoutButton() {
		element("btn_proceed", "").click();
		logMessage("info", "User has clicked on Proceed to checkout button");
		wait.waitForPageTitleToContain(YamlReader.getYamlValue("title.order"));
		Assert.assertTrue(YamlReader.getYamlValue("title.order").equalsIgnoreCase(driver.getTitle()),
				"[Assert Failed]: User is not on Checkout process");
		logMessage("pass", "User is on Checkout process");
	}

	public void verifyUserIsOnTab(String tab) {
		String color = element("checkout_steps", "").getCssValue("border-top-color");
		String hex = Color.fromString(color).asHex();
		Assert.assertTrue(hex.equalsIgnoreCase("#73ca77"), "[Assert Failed]: User is not on " + tab + " tab");
		logMessage("pass", "User is on " + tab + " tab");
	}

	public void userClicksOnProceedToCheckout(String text) {
		element("btn_checkout", text).click();
		logMessage("info", "User has clicked on Proceed to checkout button");
	}

	public void userChecksIAgreeBox() {
		verifyUserIsOnTab("Shipping");
		logMessage("info", "User is clicking on I Agree button");
		element("i_agree", "").click();
		logMessage("info", "User has clicked on I Agree button");
	}

	public void selectPaymentMode(String mode) {
		logMessage("info", "User is selecting payment mode: " + mode);
		element("payment", mode).click();
		logMessage("info", "User has selected payment mode: " + mode);
	}

	public void verifyOrderIsPlacedSuccessfully() {
		verifyUserIsOnTab("Payment");

		Assert.assertTrue(
				element("txtConfirm").getText().equalsIgnoreCase(YamlReader.getYamlValue("confirmation_text")),
				"[Assert Failed]: Order is not placed");
		logMessage("pass", "Order is placed successfully");

	}

	public void verifyOrderIsPresentUnderMyOrders() throws ParseException {
		goToMyOrders();
		clickOnOrderHistoryAndDetails();
		verifyRecentlyPacedOrderIsPresentInOrderHistory();
	}

	public void goToMyOrders() {
		clickOnMyAccountHeaderButton();
	}

	public void goToPersonalInformationTab() {
		wait.waitForElementToBeVisible(element("personal_info", ""));
		element("personal_info", "").click();
		logMessage("info", "User has clicked on My Personal Information button");
		wait.waitForPageTitleToContain(YamlReader.getYamlValue("title.identity"));
		Assert.assertTrue(YamlReader.getYamlValue("title.identity").equalsIgnoreCase(driver.getTitle()),
				"[Assert Failed]: User is not on My Personal Information page");
		logMessage("pass", "User is on My Personal Information page");
	}

	public void clickOnMyAccountHeaderButton() {
		wait.waitForElementToBeVisible(element("account_name", ""));
		element("account_name", "").click();
		logMessage("info", "User has clicked on Account info button");
		wait.waitForPageTitleToContain(YamlReader.getYamlValue("title.account"));
		Assert.assertTrue(YamlReader.getYamlValue("title.account").equalsIgnoreCase(driver.getTitle()),
				"[Assert Failed]: User is not on My Account page");
		logMessage("pass", "User is on My Account page");
	}

	public void clickOnOrderHistoryAndDetails() {
		wait.waitForElementToBeVisible(element("btn_myorders", ""));
		element("btn_myorders", "").click();
		logMessage("info", "User has clicked on Orders History and Details button");
		wait.waitForPageTitleToContain(YamlReader.getYamlValue("title.history"));
		Assert.assertTrue(YamlReader.getYamlValue("title.history").equalsIgnoreCase(driver.getTitle()),
				"[Assert Failed]: User is not on Order History page");
		logMessage("pass", "User is on Order History page");
	}

	public void verifyRecentlyPacedOrderIsPresentInOrderHistory() throws ParseException {
		String date = element("order_date").getText().trim();
		logMessage(date);
		TimeZone.setDefault(TimeZone.getTimeZone("EST"));
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		Date date2 = new Date();
		logMessage(formatter.format(date2));
		Assert.assertTrue(date.equalsIgnoreCase(formatter.format(date2)),
				"Assertion Failed: Recent order is not visible in Order History");
		logMessage("Assertion Passed: Recent Order is present in Order History");
	}

	public void updatedFirstName(String firstName) {
		element("txt_firstname", "").clear();
		element("txt_firstname", "").sendKeys(firstName);
		logMessage("User has entered first name "+firstName);
	}

	public void enterOldPassword() {
		element("old_passwd", "").sendKeys(YamlReader.getYamlValue("password"));
		logMessage("info", "User has entered Old password");
	}

	public void clickOnSaveButton() {
		element("btn_save", "").click();
		logMessage("info", "User has clicked on save button");
	}

	public void verifyAccountInformationUpdatesIsSuccessfull() {
		Assert.assertTrue(
				element("success").isDisplayed()
						&& element("success").getText().equalsIgnoreCase(YamlReader.getYamlValue("update_confirm")),
				"[Assert Failed]: User is not able to update account information successfully");
		logMessage("pass", " Account Information Updated Successfully");
	}
}
