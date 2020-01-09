import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.File;
import java.io.IOException;
import java.util.Date;

public class CapturingScreenShot {
    public static void main(String[] args) throws IOException {
        Date d = new Date();
        String date1 = d.toString();
        System.out.println(date1);
        String date2 = date1.replaceAll(":", "_");
        System.out.println(date2);
        System.setProperty("webdriver.chrome.driver","chromedriver");
        WebDriver driver=new ChromeDriver();
        driver.get("https://scotch.io/tutorials/test-a-node-restful-api-with-mocha-and-chai");
        TakesScreenshot ts = (TakesScreenshot) driver;
        File srcFile = ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcFile, new File("/home/admin265/IdeaProjects/TestNGUpCasting/src/" +
                "test/resources/screenshot/image2.jpg"));
        driver.close();

    }
}
