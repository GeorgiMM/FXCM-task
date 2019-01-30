package task.serenity.gmm.steps.common;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import com.google.inject.name.Named;

import net.thucydides.core.annotations.Steps;

public class CommonStepDefinitions {

	private static String uname;
	private static String pword;
	private static String urlPass;
	@Steps
	CommonSteps commonSteps;
	
	@Given("User opens ulr ($URL) logs in with username (<username>) password ($password)")
	public void loginToShop(@Named("URL") String url, @Named("username") String username, @Named("password") String password) {
	commonSteps.openUrl(url);
	commonSteps.login(username, password);
	commonSteps.resetAppState();
	uname = username;
	pword = password;
	urlPass = url;
	}
	
	@Then("Home page is displayed")
	public void validateHomepage() {
		commonSteps.validateHomepage();
	}
	@When("User adds item ($item) to basket")
	public void addItemToBasket(@Named("item")String item) {
		commonSteps.addItemToBasket(item);
	}
	@Then ("User can checkout the order with item ($item)")
	public void checkoutOrder(@Named("item")String item) {
		commonSteps.checkoutOrder(item);
	}
	@Then ("User cancels checkout the order with item ($item)")
	public void cancelCheckoutOrder(@Named("item")String item) {
		commonSteps.cancelCheckoutOrder(item);
	}
	@When ("User adds all items to basket")
	public void addAllItemToBasket() {
		commonSteps.addAllItemToBasket();

	}
	@Then ("User checkouts the order with all items")
	public void chekcoutOrderAllItems() {
		commonSteps.checkoutOrderAllItems();

	}


	@When ("User returns to homepage")
	public void removeItem() {
		commonSteps.returnToHome();
	}
	
	@Then ("Order ($item) is still in basket")
	public void checkIsItemInBasket(@Named("item")String item) {
		commonSteps.checkIsItemInBasket(item);
	}
	
	@Then ("User logs out")
	public void logout() {
		commonSteps.logout();
	}
	
	@When ("User logs in with same username and password")
	public void login() {
		commonSteps.openUrl(urlPass);
		commonSteps.login(uname, pword);
	}



}
