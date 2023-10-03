import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import java.time.Duration;

public class RegistrationNavigation extends BaseTest{


    public void registrationNavigation(){
        //Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//WHEN I open my url
        String url = "https://qa.koel.app/";
        driver.get(url);
        //AND I click on Registration link
        WebElement registrationBtn = driver.findElement(By.cssSelector("[href='registration']"));
        registrationBtn.click();
        //THEN Register new account/reset your password screen is seen
        Assert.assertEquals(driver.getCurrentUrl(),"https://qa.koel.app/registration");
        driver.quit();
    }
}