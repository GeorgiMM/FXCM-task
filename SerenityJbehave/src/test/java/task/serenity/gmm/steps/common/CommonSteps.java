package task.serenity.gmm.steps.common;

import static org.junit.Assert.assertTrue;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import task.serenity.gmm.pages.common.CommonPage;

@SuppressWarnings("serial")
public class CommonSteps extends ScenarioSteps{
	
CommonPage commonPage;
	@Step
	public void openUrl(String url) {
		commonPage.openURL(url);
	}
	
	@Step
	public void login(String username, String password) {
		commonPage.enterUsername(username);
		commonPage.enterPassword(password);
		commonPage.submitLogin();
	}
	
	@Step
	public void validateHomepage() {
		assertTrue("Not all images are loaded ", commonPage.isHomeLoaded());
		
	}
	
	@Step
	public void addItemToBascet(String item) {
		commonPage.addItemToBasket(item);
	}

	@Step
	public void checkoutOrder(String item) {
		commonPage.getPrice(item);
		commonPage.openBasket();
		commonPage.proceedCheckOut();
		commonPage.enterUserDetails();
		commonPage.comaprePrice(item);
		commonPage.finishOrder();
	}

}
