package com.udemy.selenium.docker;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;




public class PhonePage {
	
	private WebDriver driver;
	private WebDriverWait wait;
	
	@FindBy(xpath = "//a[contains(text(),'Your Store')]")
	private WebElement PageName;
	
	@FindBy(xpath = "//a[contains(text(),'MacBook')]//parent::h4//parent::div/p/span//parent::p")
	private WebElement Price;
	
	@FindBy(xpath = "//a[contains(text(),'MacBook')]")
	private WebElement Mac;
	
	@FindBy(xpath = "//input[@id='input-quantity']")
	private WebElement Quantity;
	
	@FindBy(xpath = "//button[@id='button-cart']")
	private WebElement AddToCart;
	
	@FindBy(xpath = "//span[@id='cart-total']")
	private WebElement CartTotalAmount;
	
	
	public PhonePage(WebDriver driver) {
		this.driver=driver;
		this.wait= new WebDriverWait(driver, 30);
		PageFactory.initElements(driver, this);
	}
	//http://tutorialsninja.com/demo/
	public void goTo() {
		this.driver.get("http://tutorialsninja.com/demo/");
		this.wait.until(ExpectedConditions.visibilityOf(this.PageName));
		
	}
	
	double price;
	public void getPrice() {
		String pricetxt = this.Price.getText();
		System.out.println(pricetxt);
		String[] splitpricetxt1 = pricetxt.split("Ex Tax:");
		System.out.println(splitpricetxt1[0]);
		String[] splitpricetxt = splitpricetxt1[0].split("[$]");
		price = Double.parseDouble(splitpricetxt[1].trim());
		//price = Integer.parseInt(splitpricetxt[1].trim());
		System.out.println(price);
	}

	double numofQ; 
	public void NoOfQuantity() {
		String noOfQ = "5";
		this.Mac.click();
		this.Quantity.clear();
		this.Quantity.sendKeys("5");
		this.AddToCart.click();
		numofQ = Double.parseDouble(noOfQ);
		
	}

	public void CheckCartAmount() {
		
		double lastPrice = price*numofQ;
		String cartValue = this.CartTotalAmount.getText();
		String[] Spliprice1 = cartValue.split("[$]");
		
		String[] Spliprice = Spliprice1[1].split("[,]");
		String priceWithoutcoma = Spliprice[0] +Spliprice[1];
		
		double fPrice = Double.parseDouble(priceWithoutcoma.trim());
		System.out.println(fPrice);
		System.out.println(lastPrice);
		
		//Assert.assertEquals(fPrice, lastPrice);
	}
	
	

}
