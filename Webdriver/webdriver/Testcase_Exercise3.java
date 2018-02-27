package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Testcase_Exercise3 {
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
//		System.setProperty("webdriver.chrome.driver", "E:\\Study_Test\\Automation_study\\chromedriver.exe");
		driver = new ChromeDriver();

	}

	@Test
	public void TC_01() {
		/*
		 * Test Script 01: Kiểm tra phần tử hiển thị trên trang Step 01 - Truy
		 * cập vào trang: http://daominhdam.890m.com/ Step 02 - Kiểm tra các
		 * phần tử sau hiển thị trên trang: Email/ Age (Under 18)/ Education
		 * Step 03 - Nếu có nhập giá trị: Automation Testing vào 2 field Email/
		 * Education và chọn Age = Under 18
		 */
		// Step 01
		driver.get("http://daominhdam.890m.com/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		// Step 02
		WebElement email = driver.findElement(By.id("mail"));
		if (email.isDisplayed()) {
			System.out.println("Element is displayed");
			email.sendKeys("Automation Testing");
		} else {
			System.out.println("Element is not displayed");
		}
		WebElement Age = driver.findElement(By.id("under_18"));
		if (Age.isDisplayed()) {
			System.out.println("Element is displayed");
			Age.click();
		} else {
			System.out.println("Element is not displayed");
		}
		WebElement education = driver.findElement(By.id("edu"));
		if (education.isDisplayed()) {
			System.out.println("Element is displayed");
			education.sendKeys("Automation Testing");
		} else {
			System.out.println("Element is not displayed");
		}
	}

	/*
	 * Test Script 02: Kiểm tra phần tử enable/ disable trên trang Step 01 -
	 * Truy cập vào trang: http://daominhdam.890m.com/ Step 02 - Kiểm tra các
	 * phần tử sau enable trên trang: Email/ Age (Under 18)/ Education/ Job Role
	 * 01/ Interests (Development)/ Slider 01/ Button is enabled Step 03 - Kiểm
	 * tra các phần tử sau disable trên trang: Password / Age (Radiobutton is
	 * disabled)/ Biography/ Job Role 02/ Interests (Checkbox is disabled)/
	 * Slider 02/ Button is disabled Step 04 - Nếu có in ra Element is enabled/
	 * ngược lại Element is disabled
	 */
	@Test
	public void TC_02() {
		driver.get("http://daominhdam.890m.com/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		// element is enabled
		WebElement email = driver.findElement(By.id("mail"));
		if (email.isEnabled()) {
			System.out.println("Element is Enabled");
		} else {
			System.out.println("Element is not Enabled");
		}
		WebElement Age = driver.findElement(By.id("under_18"));
		if (Age.isEnabled()) {
			System.out.println("Element is Enabled");
		} else {
			System.out.println("Element is not Enabled");
		}
		WebElement education = driver.findElement(By.id("edu"));
		if (education.isEnabled()) {
			System.out.println("Element is Enabled");
		} else {
			System.out.println("Element is not Enabled");
		}

		WebElement Jobrole01 = driver.findElement(By.id("job1"));
		if (Jobrole01.isEnabled()) {
			System.out.println("Element is Enabled");
		} else {
			System.out.println("Element is not Enabled");
		}

		WebElement interestdev = driver.findElement(By.id("development"));
		if (interestdev.isEnabled()) {
			System.out.println("Element is Enabled");
		} else {
			System.out.println("Element is not Enabled");
		}

		WebElement slider01 = driver.findElement(By.id("slider-1"));
		if (slider01.isEnabled()) {
			System.out.println("Element is Enabled");
		} else {
			System.out.println("Element is not Enabled");
		}

		WebElement btnenabled = driver.findElement(By.id("button-enabled"));
		if (btnenabled.isEnabled()) {
			System.out.println("Element is Enabled");
		} else {
			System.out.println("Element is not Enabled");
		}

		// element is disabled
		WebElement pwd = driver.findElement(By.id("password"));
		if (!pwd.isEnabled()) {
			System.out.println("Element is Disabled");
		} else {
			System.out.println("Element is  Enabled");
		}
		WebElement age = driver.findElement(By.id("radio-disabled"));
		if (!age.isEnabled()) {
			System.out.println("Element is Disabled");
		} else {
			System.out.println("Element is  Enabled");
		}
		WebElement biography = driver.findElement(By.id("bio"));
		if (!biography.isEnabled()) {
			System.out.println("Element is Disabled");
		} else {
			System.out.println("Element is  Enabled");
		}
		WebElement Jobrole02 = driver.findElement(By.id("job2"));
		if (!Jobrole02.isEnabled()) {
			System.out.println("Element is Disabled");
		} else {
			System.out.println("Element is  Enabled");
		}
		WebElement checkbox = driver.findElement(By.id("check-disbaled"));
		if (!checkbox.isEnabled()) {
			System.out.println("Element is Disabled");
		} else {
			System.out.println("Element is  Enabled");
		}
		WebElement slider02 = driver.findElement(By.id("slider-2"));
		if (!slider02.isEnabled()) {
			System.out.println("Element is Disabled");
		} else {
			System.out.println("Element is  Enabled");
		}
		WebElement btndisabled = driver.findElement(By.id("button-disabled"));
		if (!btndisabled.isEnabled()) {
			System.out.println("Element is Disabled");
		} else {
			System.out.println("Element is  Enabled");
		}
	}

	/*
	 * Test Script 03: Kiểm tra phần tử được chọn trên trang Step 01 - Truy cập
	 * vào trang: http://daominhdam.890m.com/ Step 02 - Click chọn Age (Under
	 * 18)/ Interests (Development) Step 03 - Kiểm tra các phần tử tại Step 02
	 * đã được chọn Step 04 - Nếu chưa được chọn thì cho phép chọn lại 1 lần nữa
	 * Test Script 04: Chạy 3 testscript 1/2/3 trên 3 trình duyệt: Firefox/
	 * Chrome/IE11
	 */
	@Test
	public void TC_03() {
		// step 01
		driver.get("http://daominhdam.890m.com/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		// Step 02
		WebElement Age = driver.findElement(By.id("under_18"));
		if (Age.isDisplayed()) {
			System.out.println("Element is displayed");
			Age.click();
		} else {
			System.out.println("Element is not displayed");
		}
		WebElement interestdev = driver.findElement(By.id("development"));
		if (interestdev.isEnabled()) {
			System.out.println("Element is Enabled");
			interestdev.click();
		} else {
			System.out.println("Element is not Enabled");
		}
		// Step 03
		if (Age.isSelected()) {
			System.out.println("Age is Selected");
		} else {
			System.out.println("Age is not Selected");
		}
		if (interestdev.isSelected()) {
			System.out.println("interest development is selected");
		} else {
			System.out.println("interest development is not selected");

		}
		// Step 04
		if (!Age.isSelected()) {
			Age.click();
		} else {
			System.out.println("Age is Selected");
		}
		if (!interestdev.isSelected()) {
			interestdev.click();
		} else {
			System.out.println("interest development is selected");
		}
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
