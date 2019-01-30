package task.serenity.gmm.steps.common;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import com.google.inject.name.Named;

import net.thucydides.core.annotations.Steps;

public class CommonStepDefinitions {

	@Steps
	CommonSteps commonSteps;
	
	@Given("User opens ulr ($URL) logs in with username (<username>) password ($password)")
	public void loginToShop(@Named("URL") String url, @Named("username") String username, @Named("password") String password) {
	commonSteps.openUrl(url);
	commonSteps.login(username, password);
	}
	@Then("Home page is displayed")
	public void validateHomepage() {
		commonSteps.validateHomepage();
	}
	@When("User adds item ($item) to basket")
	public void addItemToBasket(@Named("item")String item) {
		commonSteps.addItemToBascet(item);
	}
	@Then ("User can checkout the order with item ($item)")
	public void checkoutOrder(@Named("item")String item) {
		commonSteps.checkoutOrder(item);
	}

}
