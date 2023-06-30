package Page;

import Options_Test.Main;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

/**
 * Добавляем книги в список покупок и переходим в корзину.
 */
public class Kit_Page extends Main {
    public static ElementsCollection набор = $$x("//div[@class='button action-button blue']");
    public void kit() throws InterruptedException {
        int index = 0;
        $x("(//div[@class='product-card__price product-card__row'])[1]").scrollIntoView(true); // скролим экран к ценнику
        for (SelenideElement ss : набор) {
            if (index < 3){
                Thread.sleep(1000);
                ss.click();
                index++;
            } else
                break;
        }
            $x("//*[@id=\"__layout\"]/div/header/div/div[2]/a/span[1]").click();


    }
}
