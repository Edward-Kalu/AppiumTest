package testcases;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class TestNativeApp {
	
	public static AndroidDriver driver;

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
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
		
		Thread.sleep(3000);
		
		driver.quit();
	}

}
