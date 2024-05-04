package pages;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class TestBase extends Util {
	
	public void takeScreenshot(WebDriver driver) {

		 TakesScreenshot ts = (TakesScreenshot) driver;
		 File sourcefile = ts.getScreenshotAs(OutputType.FILE);
		 SimpleDateFormat formatter = new SimpleDateFormat("MMddyy_HHmmss"); 
		 Date date =  new Date();
		 
		 String label = formatter.format(date);
		 
		 
		 try {
			FileUtils.copyFile(sourcefile, new File(System.getProperty("user.dir")+ "/screenshot/" +label+ ".png"));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}


}
