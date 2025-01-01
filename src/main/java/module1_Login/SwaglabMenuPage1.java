package module1_Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwaglabMenuPage1 
{
	@FindBy(xpath = "//a[text()='Logout']")  private WebElement Logout;
	WebDriver driver;
	public SwaglabMenuPage1(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickSwagLabMenuPageLogoutBtn()
	{
		Logout.click();
	}

}
