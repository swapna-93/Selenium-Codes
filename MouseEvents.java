// To this project comments were added additionally
package firstProject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseEvents {
	public static void main(String []args) throws InterruptedException{
		System.setProperty("webdriver.chrome.driver","D:\\Projects\\Selenium Grid Letzanv Docs\\Selenium Softwares\\New Seelnium WebDriver Softwares\\Chrome Diriver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		String URL="http://jqueryui.com";
		driver.get(URL);
		Thread.sleep(1000);
		System.out.println(driver.getTitle());
		driver.findElement(By.xpath("//div[@id='sidebar']/aside/ul/li[2]/a[text()='Droppable']")).click();
		//*[@id='sidebar']/aside[1]/ul/li[2]/a[contains(text(),Droppable)]
		Actions act=new Actions(driver);
		Thread.sleep(3000);
		//To enter into frame
		//act.keyDown(driver.findElement(By.xpath("//input[@name='s']")),Keys.ENTER).build().perform();
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
		WebElement src1=driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement target1=driver.findElement(By.xpath("//div[@id='droppable']"));	
		act.dragAndDrop(src1, target1).build().perform();
		//act.click(target1);
		//act.clickAndHold(src1);
		//To come out of iframe
		driver.switchTo().defaultContent();
		System.out.println("Came out of loop");
		act.moveToElement(driver.findElement(By.linkText("Contribute"))).build().perform();
		driver.findElement(By.linkText("Style Guides")).click();
		driver.navigate().to(URL);
		driver.manage().timeouts().implicitlyWait(2,TimeUnit.SECONDS);
		WebElement drag=driver.findElement(By.xpath("//div[@id='sidebar']/aside[1]/ul/li[1]/a[text()='Draggable']"));
		System.out.println(drag.isDisplayed());
		drag.click();	
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
		WebElement src=driver.findElement(By.xpath("//body/div[@id='draggable']"));
		act.clickAndHold(src).moveToElement(src, 241,85).release(src).build().perform();
		driver.switchTo().defaultContent();
		driver.navigate().back();
		WebElement src3=driver.findElement(By.xpath("//div/a[@title='Support the jQuery Foundation']"));
		src3.click();
		driver.navigate().refresh();
		WebElement src2=driver.findElement(By.xpath("//ul[@id='menu-top']/li[6]/a[contains(text(),'Support')]"));
		act.contextClick(src2).build().perform();
		driver.quit();
		
		
	}

}
