package stepDefinations;

import java.io.File;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class YahooL {
	WebDriver driver;
	
	@Given("^user should enter correct username and passord$")
	public void user_should_enter_correct_username_and_passord() throws Exception  {
	System.setProperty("webdriver.chrome.driver","C:\\Users\\GB\\eclipse-workspace\\downloadss\\chromedriver.exe");
	driver= new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	driver.get("https://login.yahoo.com/?.src=ym&.lang=en-US&.intl=us&.done=https%3A%2F%2Fmail.yahoo.com%2Fd");
	String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
	File scr=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(scr, new File("C:\\Users\\GB\\Desktop\\images\\homepage" + timestamp + ".png"));
	}
	
	@When("^user enter correct username$")
	public void user_enter_correct_username() {
	driver.findElement(By.name("username")).sendKeys("favour.amughoro@yahoo.com");
	driver.findElement(By.id("login-signin")).click();
	
	}
	
	@And("^user enter correct password$")
	public void user_enter_correct_password() {
	
	driver.findElement(By.id("login-passwd")).sendKeys("austine247");
	
	}
	@Then("^user yahoo inbox display$")
	public void user_yahoo_inbox_display() throws Exception {
	driver.findElement(By.id("login-signin")).click();
	File scr1=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
	FileUtils.copyFile(scr1, new File("C:\\Users\\GB\\Desktop\\images\\inbox" + timestamp + ".jpg"));
	driver.close();
	}
}
