package com.udemy.selenium.docker;
import org.testng.annotations.Test;


import Test.BaseTest;





public class Runner extends BaseTest {

	
	@Test
	public void PlaceOrder() throws InterruptedException {
		PhonePage phonePage = new PhonePage(driver);
		phonePage.goTo();
		Thread.sleep(2000);
		phonePage.getPrice();
		Thread.sleep(2000);
		phonePage.NoOfQuantity();
		Thread.sleep(2000);
		phonePage.CheckCartAmount();
		Thread.sleep(2000);
	}

}
