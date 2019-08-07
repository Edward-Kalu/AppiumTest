package testcases;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class Whatsapp {
	
	public static AndroidDriver<MobileElement> driver;

public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		
		AppiumDriverLocalService service = AppiumDriverLocalService.buildService(
				new AppiumServiceBuilder().usingDriverExecutable(new File("C:\\Program Files\\nodejs\\node.exe"))
				.withAppiumJS(new File("C:\\Users\\EdwardKalu\\AppData\\Local\\Programs\\Appium\\resources\\app\\node_modules\\appium\\build\\lib\\main.js"))
				.withLogFile(new File(System.getProperty("user.dir")+"\\src\\test\\resources\\logs\\whatsappLog.txt"))
				.withArgument(GeneralServerFlag.LOCAL_TIMEZONE));
		
		service.start();
		
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		
//		Device
		
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,  "Android");
		capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,  "com.gbwhatsapp");
		capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,  ".HomeActivity");
		
		driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElements(By.id("com.gbwhatsapp:id/conversations_row_contact_name_holder")).get(1).click();
		
		Thread.sleep(5000);
		driver.quit();
		
		service.stop();

	}

}
