package Assignment;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Adidas2 
{
	
	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();		
		driver.get("https://www.demoblaze.com/index.html");
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Laptops")));
		driver.findElement(By.linkText("Laptops")).click();

		WebDriverWait wait2 = new WebDriverWait(driver,30);
		wait2.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Sony vaio i5")));
		driver.findElement(By.linkText("Sony vaio i5")).click();

		WebDriverWait wait3 = new WebDriverWait(driver,30);
		wait3.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Add to cart")));
		driver.findElement(By.linkText("Add to cart")).click();

		WebDriverWait wait4 = new WebDriverWait(driver,30);
		wait4.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
		
		driver.findElement(By.id("nava")).click();
		
		WebDriverWait wait5 = new WebDriverWait(driver,30);
		wait5.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Laptops")));
		driver.findElement(By.linkText("Laptops")).click();

		WebDriverWait wait6 = new WebDriverWait(driver,30);
		wait6.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Dell i7 8gb")));
		driver.findElement(By.linkText("Dell i7 8gb")).click();

		WebDriverWait wait7 = new WebDriverWait(driver,30);
		wait7.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Add to cart")));
		driver.findElement(By.linkText("Add to cart")).click();
		
		WebDriverWait wait8 = new WebDriverWait(driver,30);
		wait8.until(ExpectedConditions.alertIsPresent());
		driver.switchTo().alert().accept();
		
		driver.findElement(By.linkText("Cart")).click();
		
		WebDriverWait wait9 = new WebDriverWait(driver,30);
		wait9.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table/*[@id='tbodyid']/tr[2]/td[4]")));
		
		
		WebElement Table = driver.findElement(By.xpath("//table/*[@id='tbodyid']/tr[2]/td[2]"));
		String value = Table.getText();
		if (value.equals("Dell i7 8gb"))
		{
		WebElement Table1 = driver.findElement(By.xpath("//table/*[@id='tbodyid']/tr[2]/td[4]"));	
		Table1.findElement(By.linkText("Delete")).click();
		Thread.sleep(5000);
		
		}
		else
		{
			WebElement table2 = driver.findElement(By.xpath("//table/*[@id='tbodyid']/tr[1]/td[4]"));
			table2.findElement(By.linkText("Delete")).click();
			Thread.sleep(5000);	
		}
		 
		
		String winHandleBefore = driver.getWindowHandle();
		driver.findElement(By.xpath("//*[@id='page-wrapper']/div/div[2]/button")).click();
		
		
		 for (String winHandle : driver.getWindowHandles())
		{
		    driver.switchTo().window(winHandle);
		     Thread.sleep(10000);
		    	    
		      driver.findElement(By.id("name")).sendKeys("Shikhar");
		      driver.findElement(By.id("country")).sendKeys("India");
		      driver.findElement(By.id("card")).sendKeys("1234567");
		      driver.findElement(By.id("city")).sendKeys("Delhi");
		      driver.findElement(By.id("month")).sendKeys("January");
		      driver.findElement(By.id("year")).sendKeys("2021");
		      driver.findElement(By.xpath("//*[@id='orderModal']/div/div/div[3]/button[2]")).click();
		      
		      File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		        
		        //Copy the file to a location and use try catch block to handle exception
		        try {
		        	FileHandler.copy(screenshot, new File("D:\\Selenium\\homePageScreenshot.png"));
		        } catch (IOException e) {
		            System.out.println(e.getMessage());
		        }
		        
		        driver.findElement(By.xpath("/html/body/div[10]/div[7]/div/button")).click();
		 
		}

		
		driver.switchTo().window(winHandleBefore);
		
		
		driver.quit();
	}
}
