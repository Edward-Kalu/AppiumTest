package testcases;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class TestHardwareKeys {
	
	public static AndroidDriver driver;

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		AppiumDriverLocalService service = AppiumDriverLocalService.buildService(
				new AppiumServiceBuilder().usingDriverExecutable(new File("C:\\Program Files\\nodejs\\node.exe"))
				.withAppiumJS(new File("C:\\Users\\EdwardKalu\\AppData\\Local\\Programs\\Appium\\resources\\app\\node_modules\\appium\\build\\lib\\main.js"))
				.withLogFile(new File(System.getProperty("user.dir")+"\\src\\test\\resources\\logs\\log.txt"))
				.withArgument(GeneralServerFlag.LOCAL_TIMEZONE));
		
		service.start();
		
//		File app = new File("C:\\Users\\EdwardKalu\\appiumStuffs\\AppiumTesting\\app\\selendroid-test-app-0.17.0.apk");
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		
//		Device
		
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,  "Android");
		capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,  "io.selendroid.testapp");
		capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,  ".HomeScreenActivity");
//		capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		
		//AppPackage && AppActivity
		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
//		driver.findElement(By.id("io.selendroid.testapp:id/buttonStartWebview")).click();
		driver.findElementByXPath("//android.widget.ImageButton[@content-desc=\"buttonStartWebviewCD\"]").click();
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		Thread.sleep(1000);
		driver.longPressKey(new KeyEvent(AndroidKey.HOME));
		Thread.sleep(3000);
		
		driver.quit();
		service.stop();
	}

}
