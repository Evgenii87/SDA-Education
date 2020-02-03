import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Login {
    String baseUrl = "http://automationpractice.com/index.php?controller=authentication&back=my-account";

    @Test
    public void logIn() throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get(baseUrl);
        driver.findElement(By.id("email")).sendKeys("super.test.sda@gmail.com");
        driver.findElement(By.id("passwd")).sendKeys("Super2020");
        driver.findElement(By.id("SubmitLogin")).click();
        Thread.sleep(3000);
        Assert.assertTrue(driver.findElement(By.className("header_user_info")).getText().equals("Jan Kowalski"));
        driver.quit();
    }    @Test
    public void incorrectData() throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.get(baseUrl);
        driver.findElement(By.id("email")).sendKeys("super.test.sda@gmail.com");
        driver.findElement(By.id("passwd")).sendKeys("Super2021");
        driver.findElement(By.id("SubmitLogin")).click();
        //Thread.sleep(3000);
        Assert.assertTrue(driver.findElement(By.className("alert")).getText().isEmpty());
        //driver.quit();
    }
}
