package module1_Login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwagLabLoginPage 
{
	@FindBy(xpath = "//input[@id='user-name']") private WebElement UN;
	@FindBy(xpath = "//input[@id='password']") private WebElement PWD;
	@FindBy(xpath = "//input[@id='login-button']") private WebElement Login;
	@FindBy(xpath = "//button[@class='error-button']") private WebElement errorMsg;
	WebDriver driver;
	
	public SwagLabLoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void inpSwagLabLoginPageUN(String userName)
	{
		UN.sendKeys(userName);
	}
	
	public void inpSwagLabLoginPagePWD(String password)
	{
		PWD.sendKeys(password);
	}
	
	public void clickSwagLabLoginPageLoginBtn()
	{
		Login.click();
	}
	
	public void verifySwagLabLoginPageErrorMsg(String expMsg)
	{
		String actErrorMsg=errorMsg.getText();
		if(actErrorMsg.equals(expMsg))
		{
			System.out.println("Error Massage TC Pass");
		}else
		{
			System.out.println("Error Massage Test Case Failed");
		}
	}
}
