package module1_Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwagLabHomePage 
{
	@FindBy(xpath = "//button[text()='Open Menu']") private WebElement Menu;
	@FindBy(xpath = "(//button[text()='Add to cart'])[1]") private WebElement Product1;
	@FindBy(xpath = "//a[@class='shopping_cart_link']") private WebElement CartLogo;
	WebDriver driver;
	public SwagLabHomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public String verifySwagLabHomePageTitle()
	{
		String actTitle = driver.getTitle();
		
		return actTitle;
		
//		String actTitle=driver.getTitle();
//		if(actTitle.equals(expTitle))
//		{
//			System.out.println("TC Pass");
//		}else
//		{
//			System.out.println("TC Fail");
//		}
	}
	
	public void clickSwagLabHomePageMenuBtn()
	{
		Menu.click();
	}
	
	public void clickSwagLabHomePageProduct1()
	{
		Product1.click();
	}
	public void clickSwagLabHomePageCartLogo()
	{
		CartLogo.click();
	}
}
