package task.serenity.gmm.pages.common;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import net.serenitybdd.core.pages.PageObject;

public class CommonPage extends PageObject{

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
		boolean result = true;
		List <WebElement> images = getDriver().findElements(By.xpath("//img[@class='inventory_item_img']"));
		for(WebElement img : images) {
			result = img.isDisplayed();
		}
		return result;
	}

	public void addItemToBasket(String item) {
		getDriver().findElement(By.xpath("//*[(contains(text()," + item + "))]/ancestor::div[2]//button[@class='add-to-cart-button']")).click();
	}

	
}
