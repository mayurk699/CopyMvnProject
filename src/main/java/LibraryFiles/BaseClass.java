package LibraryFiles;

import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class BaseClass {

	protected WebDriver driver;

	public void initializeBrowser() throws IOException {

		        String browser = System.getProperty("Browser", "chrome").toLowerCase();

		        switch (browser) {
		        case "chrome":
		            driver = new ChromeDriver(getChromeOptions());
		            break;

		        case "edge":
		            driver = new EdgeDriver(getEdgeOptions());
		            break;

		        case "firefox":
		            driver = new FirefoxDriver(getFirefoxOptions());
		            break;

		        default:
		            throw new IllegalArgumentException("Unsupported browser: " + browser);
		        }

		        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		        driver.manage().window().maximize();
		        driver.get(UtilityClass.getTestDataFromPropertyFiles("URL"));
		    }

		    // ================= CHROME =================
//		    private ChromeOptions getChromeOptions() {
//		        ChromeOptions options = new ChromeOptions();
//
//		        Map<String, Object> prefs = new HashMap<>();
//		        prefs.put("credentials_enable_service", false);
//		        prefs.put("profile.password_manager_enabled", false);
//		        prefs.put("profile.default_content_setting_values.notifications", 2);
//
//		        options.setExperimentalOption("prefs", prefs);
//
//		        options.addArguments(
//		                "--disable-notifications",
//		                "--disable-infobars",
//		                "--disable-extensions",
//		                "--disable-popup-blocking",
//		                "--disable-features=PasswordManagerEnableCheck,PasswordLeakDetection",
//		                "--remote-allow-origins=*"
//		        );
//        return options;
	
	private ChromeOptions getChromeOptions() {

	    ChromeOptions options = new ChromeOptions();

	    // ===== Use fresh profile (MOST IMPORTANT) =====
	    options.addArguments("--guest");   // OR use user-data-dir (see below)

	    // ===== Disable password manager =====
	    Map<String, Object> prefs = new HashMap<>();
	    prefs.put("credentials_enable_service", false);
	    prefs.put("profile.password_manager_enabled", false);

	    // ===== Disable password leak detection =====
	    prefs.put("safebrowsing.enabled", false);
	    prefs.put("safebrowsing.disable_download_protection", true);

	    options.setExperimentalOption("prefs", prefs);

	    // ===== Disable automation detection =====
	    options.setExperimentalOption(
	            "excludeSwitches", Arrays.asList("enable-automation"));
	    options.setExperimentalOption("useAutomationExtension", false);

	    // ===== Extra safety flags =====
	    options.addArguments("--disable-save-password-bubble");
	    options.addArguments("--disable-notifications");
	    options.addArguments("--disable-infobars");
	    options.addArguments("--disable-extensions");
	    options.addArguments("--no-default-browser-check");
	    options.addArguments("--no-first-run");

	    return options;
	}

		    

		    // ================= EDGE =================
		    private EdgeOptions getEdgeOptions() {
		        EdgeOptions options = new EdgeOptions();

		        Map<String, Object> prefs = new HashMap<>();
		        prefs.put("credentials_enable_service", false);
		        prefs.put("profile.password_manager_enabled", false);
		        prefs.put("profile.default_content_setting_values.notifications", 2);

		        options.setExperimentalOption("prefs", prefs);

		        options.addArguments(
		                "--disable-notifications",
		                "--disable-infobars",
		                "--disable-extensions",
		                "--disable-popup-blocking"
		        );

		        return options;
		    }

		    // ================= FIREFOX =================
		    private FirefoxOptions getFirefoxOptions() {
		        FirefoxOptions options = new FirefoxOptions();

		        options.addPreference("dom.webnotifications.enabled", false);
		        options.addPreference("dom.push.enabled", false);
		        options.addPreference("signon.rememberSignons", false);
		        options.addPreference("browser.download.panel.shown", false);

		        return options;
		    }

		    @AfterClass
		    public void closeBrowser() {
		        if (driver != null) {
		            driver.quit();
		        }
		    }
		

//
//	    ChromeOptions options = new ChromeOptions();
//
//	    Map<String, Object> prefs = new HashMap<>();
//	    prefs.put("credentials_enable_service", false);
//	    prefs.put("profile.password_manager_enabled", false);
//	    prefs.put("profile.password_manager_leak_detection", false);
//
//	    options.setExperimentalOption("prefs", prefs);
//	    options.addArguments(
//	        "--disable-features=PasswordManagerEnableCheck,PasswordLeakDetection,PasswordProtectionWarningTrigger");
//
//	    options.addArguments("--disable-notifications");
//	    options.addArguments("--disable-infobars");
//
//	    // 🔥 THIS IS CRITICAL
//	    options.addArguments(
//	        "--user-data-dir=" + System.getProperty("java.io.tmpdir") + "/selenium-profile"
//	    );
//
//		driver=new ChromeDriver(options);
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		driver.manage().window().maximize();
//		driver.get(UtilityClass.getTestDataFromPropertyFiles("URL"));
//		
	}



