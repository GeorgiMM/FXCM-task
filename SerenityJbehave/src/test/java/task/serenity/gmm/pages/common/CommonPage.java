package task.serenity.gmm.pages.common;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import net.serenitybdd.core.pages.PageObject;

public class CommonPage extends PageObject{
	private static double price = 0;
	private static double sumPrices = 0;
	private static double sumTotal = 0;
	private static double total = 0;

	public void openURL(String url) {
		getDriver().get("https://www." + url);
		
	}

	public void enterUsername(String username) {
		getDriver().findElement(By.xpath("//*[@id='user-name']")).sendKeys(username);	
	}

	public void enterPassword(String password) {
		getDriver().findElement(By.xpath("//*[@id='password']")).sendKeys(password);
	}

	public void submitLogin() {
		getDriver().findElement(By.className("login-button")).click();
	}

	public boolean isHomeLoaded() {
		boolean result = false;
		List <WebElement> images = getDriver().findElements(By.xpath("//img[@class='inventory_item_img']"));
		for(WebElement img : images) {
			result = img.isDisplayed();
		}
		return result;
	}

	public void addItemToBasket(String item) {
		getDriver().findElement(By.xpath("//*[(contains(text(),\"" + item + "\"))]/ancestor::div[2]//button[@class='add-to-cart-button']")).click();
	}

	public double trimStringToDouble(String sumsAsString) {
		double result = 0.0;
		StringBuilder temp = new StringBuilder();
	    for(int i = 0; i < sumsAsString.length(); i++){
	        char c = sumsAsString.charAt(i);
	        if(c > 47 && c < 58){
	        	for(int j = i; j < sumsAsString.length(); j++) {
	        		c = sumsAsString.charAt(j);
	        		temp.append(c);
	        	}
	        	break;
	        }
	    }
	    result = Double.parseDouble(temp.toString());
		return result;
	}
	
	public void getPrice(String item) {
		String priceStr = getDriver().findElement(By.xpath("//*[(contains(text(),\"" + item + "\"))]/ancestor::div[2]//*[@class='inventory_item_price']")).getText();
		price = trimStringToDouble(priceStr);
	}

	public void openBasket() {
		getDriver().findElement(By.xpath("//*[@class='svg-inline--fa fa-shopping-cart fa-w-18 fa-3x ']")).click();
	}

	public void proceedCheckOut() {
		getDriver().findElement(By.xpath("//*[@class='cart_checkout_link']")).click();
		
	}

	public void enterUserDetails() {
		getDriver().findElement(By.xpath("//*[@placeholder='First Name']")).sendKeys("Georgi");
		getDriver().findElement(By.xpath("//*[@placeholder='Last Name']")).sendKeys("Metodiev");
		getDriver().findElement(By.xpath("//*[@placeholder='Zip/Postal Code']")).sendKeys("1632");
		getDriver().findElement(By.xpath("//*[@class='cart_checkout_link']")).click();		
	}

	public boolean comparePrice(String item) {
		waitABit(500);
		String totalStr = getDriver().findElement(By.xpath("//*[@class='summary_subtotal_label']")).getText();
		total = trimStringToDouble(totalStr);
		return total==price;
	}

	public void finishOrder() {
		getDriver().findElement(By.xpath("//*[@class='cart_checkout_link']")).click();
	}

	public boolean isOrderFinished() {
		return getDriver().findElement(By.xpath("//*[contains(text(), 'Checkout: Complete!')]")).isDisplayed();
	}

	public void removeItemFromBasket(String item) {
		getDriver().findElement(By.xpath("//*[(contains(text(),\"" + item + "\"))]/ancestor::div[2]//button[@class='add-to-cart-button']")).click();
		
	}

	public void returnToHome() {
		waitABit(500);
		getDriver().findElement(By.xpath("//*[contains(text(), 'Open Menu')]")).click();
		waitABit(500);
		getDriver().findElement(By.xpath("//*[contains(text(), 'All Items')]")).click();
	}

	public void addAllItemsToBasket() {
		List <WebElement> buttons= getDriver().findElements(By.xpath("//*[contains(text(), 'ADD TO CART')]"));
		for(WebElement button : buttons) {
			button.click();
		}
	}

	public void getPriceAllItems() {
		List<WebElement> prices = getDriver().findElements(By.xpath("//*[@class='inventory_item_price']"));
		for(WebElement price : prices) {
			String priceStr = price.getText();
			sumPrices += trimStringToDouble(priceStr);
		}
	}

	public boolean compareSum() {
		waitABit(500);
		String totalStr = getDriver().findElement(By.xpath("//*[@class='summary_subtotal_label']")).getText();
		sumTotal = trimStringToDouble(totalStr);
		return sumTotal==sumPrices;
	}

	public boolean isItemInBasket() {
		waitABit(500);
		return getDriver().findElement(By.xpath("//*[contains(text(), 'Sauce Labs Backpack')]")).isDisplayed();
	}

	public void resetAppState() {
		waitABit(500);
		getDriver().findElement(By.xpath("//*[contains(text(), 'Open Menu')]")).click();
		waitABit(500);
		getDriver().findElement(By.xpath("//*[contains(text(), 'Reset App State')]")).click();
		getDriver().navigate().refresh();
	}

	public void logout() {
		waitABit(500);
		getDriver().findElement(By.xpath("//*[contains(text(), 'Open Menu')]")).click();
		waitABit(500);
		getDriver().findElement(By.xpath("//*[contains(text(), 'Logout')]")).click();
	}
	
	
}
