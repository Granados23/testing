package Options_Test;

import Page.Basket;
import Page.Kit_Page;
import Page.Main_Page;
import org.junit.Test;

public class Start_Test extends Main{
    @Test
    public void start() throws InterruptedException {
        // Запускаем страницу с поиском
        Main_Page mainPage = new Main_Page();
        mainPage.search();
        // Добавляем товары в корзину
    Thread.sleep(10000);
        Kit_Page kitPage = new Kit_Page();
        kitPage.kit();
        // Выполняем задание 5,6,7
        Thread.sleep(10000);
        Basket basket = new Basket();
        basket.checking_books().check_volume().Order_amount_check();
    }
}
