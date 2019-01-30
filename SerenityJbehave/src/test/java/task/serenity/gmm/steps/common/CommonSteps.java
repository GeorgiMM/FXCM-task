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
	public void addItemToBasket(String item) {
		commonPage.addItemToBasket(item);
	}

	@Step
	public void checkoutOrder(String item) {
		commonPage.getPrice(item);
		commonPage.openBasket();
		commonPage.proceedCheckOut();
		commonPage.enterUserDetails();
		assertTrue("Price and total amount are not equal", commonPage.comparePrice(item));
		commonPage.finishOrder();
		assertTrue("Order not finished", commonPage.isOrderFinished());
		System.out.println("Item bought: " + item);
	}
	
	@Step
	public void removeItemFromBasket(String item) {
		commonPage.removeItemFromBasket(item);
	}
	
	@Step
	public void returnToHome() {
		commonPage.returnToHome();
		
	}
	
	@Step
	public void addAllItemToBasket() {
		commonPage.addAllItemsToBasket();

	}
	
	@Step
	public void checkoutOrderAllItems() {
		commonPage.getPriceAllItems();
		commonPage.openBasket();
		commonPage.proceedCheckOut();
		commonPage.enterUserDetails();
		assertTrue("Price and total amount are not equal", commonPage.compareSum());
		commonPage.finishOrder();
		assertTrue("Order not finished", commonPage.isOrderFinished());
		System.out.println("All item bought");
	}

	@Step
	public void cancelCheckoutOrder(String item) {
		commonPage.getPrice(item);
		commonPage.openBasket();
		commonPage.proceedCheckOut();
		commonPage.enterUserDetails();
		assertTrue("Price and total amount are not equal", commonPage.comparePrice(item));
		commonPage.returnToHome();
	}

	@Step
	public void checkIsItemInBasket(String item) {
		commonPage.openBasket();
		assertTrue("Item: " + item + " is not in basket", commonPage.isItemInBasket());
	}

	@Step
	public void resetAppState() {
		commonPage.resetAppState();
	}

	@Step
	public void logout() {
		commonPage.logout();
	}

}
