package testing;

import Start.Main;
import Start.Start;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Gwindows extends Start {


    public Gwindows ticker() {

        driver.findElement(By.xpath("(//div[@class='avatar mx-auto white'])[1]")).click();
        driver.findElement(By.id("item-0")).click();
        return this;
        

    }

    public Gwindows build() {

        driver.findElement(By.xpath("(//input[@autocomplete='off'])[1]")).sendKeys("Максим");
        driver.findElement(By.xpath("(//input[@autocomplete='off'])[2]")).sendKeys("max@example.com");
        driver.findElement(By.xpath("(//div[@class='col-md-9 col-sm-12'])[3]/textarea")).sendKeys("Мой адресс хз где находится");
        driver.findElement(By.xpath("(//div[@class='col-md-9 col-sm-12'])[4]/textarea")).sendKeys("Это перманентный адрес");
        driver.findElement(By.xpath("(//div[@class='text-right col-md-2 col-sm-12'])/button")).click();
        return this;
    }

    public Main Check_Box() throws InterruptedException {
        driver.findElement(By.id("item-1")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//li[@class='rct-node rct-node-parent rct-node-collapsed']//button")).click();


        List<WebElement> mm = driver.findElements(By.xpath("//li[@class='rct-node rct-node-parent rct-node-expanded']//button"));
        for (int i = 1; i < mm.size(); i++){
            Thread.sleep(3000);
            mm.get(i).click();
        }

        mm = driver.findElements(By.xpath("//span[@class='rct-checkbox']"));

        for (WebElement kk: mm){
            Thread.sleep(3000);
            kk.click();
        }

        return new Main();

    }

}
