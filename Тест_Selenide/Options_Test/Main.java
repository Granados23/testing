package Options_Test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;

import static com.codeborne.selenide.Selenide.open;

 abstract public class Main {

     /**
      * Прописываем базовые настройки
      */
    @Before
    public void options() {
        WebDriverManager.chromedriver().setup();
        Configuration.browser = "chrome";
        Configuration.driverManagerEnabled = true;
        Configuration.browserSize = "1280x720";
        Configuration.timeout = 10000;
        Configuration.headless = false;

    }

    @After
     public void exit(){
        Selenide.closeWebDriver();
    }


}
