package Start;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import testing.Gwindows;


public class Main {

        protected WebDriver driver;
@Test
    public void Windows() throws InterruptedException {


    driver = new ChromeDriver();
        driver.manage().window().maximize();

    driver.get("http://85.192.34.140:8081/");
    Start.setDriver(driver);

    Gwindows mm = new Gwindows();
    mm.ticker().build().Check_Box();



    }


    @After
    public void quite(){
        driver.quit();
    }

}
