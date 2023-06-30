package Page;

import Options_Test.Main;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

public class Main_Page extends Main {
 private final static String URL = "https://www.chitai-gorod.ru";
 private final static String title = "тестирование";

    /**
     * Вводим в строку поиска "тестирование" и осуществляем поиск
     */
 public void search(){
   open(URL);
   $x("//input[@maxlength='150']").sendKeys(title, Keys.ENTER);
 }

}
