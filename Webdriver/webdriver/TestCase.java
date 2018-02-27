package webdriver;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestCase {

	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
//		System.setProperty("webdriver.chrome.driver", "E:\\Study_Test\\Automation_study\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	public static int randomData() {
		Random random = new Random();
		int number = random.nextInt(900000) + 1;
		return number;
	}

	static String email = "daotrinh" + randomData() + "@gmail.com";
	static String password = "Ab123456";

	/*
	 * Test Script 01: Verify URL and title Step 01 - Truy cập vào
	 * trang: http://live.guru99.com/ Step 02 - Kiểm tra title của page là: Home
	 * page Step 03 - Tới trang đăng
	 * nhập: http://live.guru99.com/index.php/customer/account/ Step 04 - Tới
	 * trang đăng kí tài
	 * khoản: http://live.guru99.com/index.php/customer/account/create/ Step 05
	 * - Back lại trang đăng nhập Step 06 - Kiểm tra url của page đăng nhập
	 * là: http://live.guru99.com/index.php/customer/account/ Step 07 - Forward
	 * tới trang tạo tài khoản Step 08 - Kiểm tra url của page tạo tài khoản
	 * là: http://live.guru99.com/index.php/customer/account/create/
	 */
	@Test(enabled = false)
	public void TC_01() {
		// Step 01
		driver.get("http://live.guru99.com/");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		// step 02
		Assert.assertEquals("Home page", driver.getTitle());
		// Step 03
		driver.get("http://live.guru99.com/index.php/customer/account/login/");
		// step 04
		driver.get("http://live.guru99.com/index.php/customer/account/create/");
		// Step 05
		driver.navigate().back();
		// Step 06
		String URL = driver.getCurrentUrl();
		Assert.assertEquals(URL, "http://live.guru99.com/index.php/customer/account/login/");
		// Step 07
		driver.navigate().forward();
		// Step 08
		String URL1 = driver.getCurrentUrl();
		Assert.assertEquals(URL1, "http://live.guru99.com/index.php/customer/account/create/");

	}

	/*
	 * Test Script 02: Login empty Step 01 - Truy cập vào
	 * trang: http://live.guru99.com/ Step 02 - Tới trang đăng
	 * nhập: http://live.guru99.com/index.php/customer/account/ Step 03 - Để
	 * trống Username/ Password Step 04 - Click Login button Step 05 - Verify
	 * error message xuất hiện tại 2 field:  This is a required field.
	 */
	// Step 01: truy cập vào trang http://live.guru99.com/
	@Test(enabled = false)
	public void TC_02() {
		driver.get("http://live.guru99.com/");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		// Step 02: Go to page
		// "http://live.guru99.com/index.php/customer/account/login/"
		driver.get("http://live.guru99.com/index.php/customer/account/login/");
		// Step 03: Để trống username /pass
		// Step04: Click button
		driver.findElement(By.xpath("//*[@id='send2']")).click();
		// Step 05: Verify
		String emailerror = driver.findElement(By.xpath("//*[@id='advice-required-entry-email']")).getText();
		Assert.assertEquals("This is a required field.", emailerror);
		String passworderror = driver.findElement(By.xpath("//*[@id='advice-required-entry-pass']")).getText();
		Assert.assertEquals("This is a required field.", passworderror);
	}

	/*
	 * Test Script 03: Login with Email invalid Step 01 - Truy cập vào
	 * trang: http://live.guru99.com/ Step 02 - Tới trang đăng
	 * nhập: http://live.guru99.com/index.php/customer/account/ Step 03 - Nhập
	 * email invalid: 123434234@12312.123123 Step 04 - Click Login button Step
	 * 05 - Verify error message xuất hiện:  Please enter a valid email address.
	 * For example johndoe@domain.com.
	 */
	@Test(enabled = false)
	public void TC_03() {
		// Step 01
		driver.get("http://live.guru99.com/");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		// Step 02
		driver.get("http://live.guru99.com/index.php/customer/account/");
		// step 03
		driver.findElement(By.id("email")).sendKeys("123434234@12312.123123");
		// Step 04
		driver.findElement(By.id("send2")).click();
		// Step 05\
		String errmessage = driver.findElement(By.id("advice-validate-email-email")).getText();
		Assert.assertEquals("Please enter a valid email address. For example johndoe@domain.com.", errmessage);

	}

	/*
	 * Test Script 04: Login with Password incorrect Step 01 - Truy cập vào
	 * trang: http://live.guru99.com/ Step 02 - Tới trang đăng
	 * nhập: http://live.guru99.com/index.php/customer/account/ Step 03 - Nhập
	 * email correct and password incorrect: automation@gmail.com/ 123 Step 04 -
	 * Click Login button Step 05 - Verify error message xuất hiện: Please enter
	 * 6 or more characters. Leading or trailing spaces will be ignored.
	 */
	@Test(enabled = false)
	public void TC_04() {
		// Step 01
		driver.get("http://live.guru99.com/");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		// Step 02
		driver.get("http://live.guru99.com/index.php/customer/account/");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		// step 03
		driver.findElement(By.id("email")).sendKeys("automation@gmail.com");
		driver.findElement(By.id("pass")).sendKeys("123");
		// Step 04
		driver.findElement(By.id("send2")).click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		// Step 05
		String errmessage1 = driver.findElement(By.id("advice-validate-password-pass")).getText();
		Assert.assertEquals("Please enter 6 or more characters without leading or trailing spaces.", errmessage1);

	}

	/*
	 * Test Script 05: Create an account Step 01 - Truy cập vào
	 * trang: http://live.guru99.com/ Step 02 - Vào trang đăng
	 * nhập: http://live.guru99.com/index.php/customer/account/ Click MY ACCOUNT
	 * link Step 03 - Click CREATE AN ACCOUNT button Step 04 - Nhập thông tin
	 * hợp lệ vào tất cả các field: First Name/ Last Name/ Email Address/
	 * Password/ Confirm Password (Lưu ý: Tạo random cho dữ liệu tại field Email
	 * Address) Step 05 - Verify message xuất hiện khi đăng kí thành công: Thank
	 * you for registering with Main Website Store. Step 06 - Logout khỏi hệ
	 * thống
	 * 
	 */
	@Test
	public void TC_05() {
		// Step 01
		driver.get("http://live.guru99.com/");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		// Step 02
		driver.findElement(By.xpath("//*[@class='footer']//*[text()='My Account']")).click();
		// Step 03
		driver.findElement(By.xpath("//span[text()='Create an Account']")).click();
		// Step 04
		driver.findElement(By.id("firstname")).sendKeys("FIRST_NAME");
		driver.findElement(By.id("middlename")).sendKeys("MIDDLE NAME");
		driver.findElement(By.id("lastname")).sendKeys("LAST NAME");
		driver.findElement(By.id("email_address")).sendKeys(email);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("confirmation")).sendKeys(password);

		// Click button Register
		driver.findElement(By.xpath("//button[@title='Register']")).click();
		// Step 05
		String messagesuccess = driver.findElement(By.xpath("//span[contains(.,'Thank you for registering with Main Website Store.')]")).getText();
		Assert.assertEquals("Thank you for registering with Main Website Store.", messagesuccess);
		// Step 06
		driver.findElement(By.xpath("//*[@id='header']//*[text()='Account']")).click();
		WebElement logoutlink = driver.findElement(By.xpath("//a[@title='Log Out']"));
		if (logoutlink.isDisplayed()) {
			logoutlink.click();
		}

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
