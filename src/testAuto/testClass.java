package testAuto;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByTagName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class testClass {

	public static void main(String[] args) throws IOException {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\rami\\Desktop\\chromedriver_win64\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("file:///C:/Users/rami/Desktop/screnshoot/Qa-automation-7thmar/index.html");
		Date currentDate = new Date(); // (ِdate)داتا تايب
		String AcurrentDate = currentDate.toString().replace(":", "-");// -- الى نص وتبديل بين(date)تحويل
		driver.manage().window().maximize();
		TakesScreenshot src = ((TakesScreenshot) driver);// مصدر السكرين شوت التي بدي اعمله الي هو (الدرايفر تبعي )
		File SrcFile = src.getScreenshotAs((OutputType.FILE));// احفظ السكرين الي عملته بملف
		File Dest = new File(".//myphoto/" + AcurrentDate + ".png");// السكرين بدي اياه موجود على اللابتوب بمكان و اسم
		FileUtils.copyFile(SrcFile, Dest); // بدي اعمل نسخ لسكرين داخل الملف

		List<WebElement> thestudents = driver.findElements(By.tagName("option"));//دخلت جبت كل الطلاب 
		int thetotalofstudants = thestudents.size();
		System.out.println(thetotalofstudants+"the orginal number");
		// .... I need to remove four items ..
		int HowManyitems = 1;
		System.out.println(HowManyitems+"the number of items removd ");

		
		for (int i = 0; i < HowManyitems; i++) {

			driver.findElement(By.xpath("//*[@id=\"remove\"]")).click();// اعمل حذف ل4 اسماء

			// .... I need to remove all items ..

			// for (int i = 0; i <thestudents.size() ; i++) {

			// driver.findElement(By.xpath("//*[@id=\"remove\"]")).click();// اعمل حذف لكل
			// اسماء

		}
		List<WebElement>thestudentsAfterRemove =driver.findElements(By.tagName("option"));
		int	ActualNumber = thestudentsAfterRemove.size();
		System.out.println(ActualNumber+"the new actualnamber ");

		int expectedItems= thetotalofstudants - HowManyitems;
		System.out.println(expectedItems+"the number expected ");

		Assert.assertEquals(ActualNumber,expectedItems);
		
	}

}
