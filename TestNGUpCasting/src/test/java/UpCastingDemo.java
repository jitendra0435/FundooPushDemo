import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class UpCastingDemo {
    @Test
    public void testFirefox() {
        System.setProperty("webdriver.gecko.driver","/home/admin265/Documents/Selenium/geckodrive/geckodriver");
        WebDriver driver=new FirefoxDriver();
        driver.get("http://www.google.com");
    }
    @Test
    public void test() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","/home/admin265/Downloads/chromedrive/chromedriver");
        WebDriver driver=new ChromeDriver();
        driver.get("http://www.google.com");
        String title=driver.getTitle();
        System.out.println("Title of page is:"+title);
        String currentPageSource=driver.getPageSource();
        System.out.println("Current source of page:"+currentPageSource);
        String getCurrentUrl=driver.getCurrentUrl();
        System.out.println("Current url og page:"+getCurrentUrl);
        Thread.sleep(2000);
        driver.close();
    }
}
