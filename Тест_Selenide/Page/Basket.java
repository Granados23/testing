package Page;

import Options_Test.Main;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class Basket extends Main {

    private static long количество_книг = 3;
    private static int price = 1404;

    /**
     * Создаем список книг, которые будет проверять на ОР и ФР
     */
    private static List<String> book = new ArrayList<>();
    static {
        book.add("Тестирование на проникновение с Kali Linux");
        book.add("Малахитовая шкатулка (илл. Власовой) (ШП) Бажов");
        book.add("Проектная деятельность. Оценивание достижений обучающихся. Методическое пособие для 4 класса общеобразовательных организаций");
    }


    /**
     * Ищем элементы по xpath, берем тайтл в формате String и сравниваем его со списком наших книг
     */
    public Basket checking_books(){
        ElementsCollection titlebook = $$x("//div[@class='product-title__head']");
        int index = 0;
        for (SelenideElement check : titlebook){
            if (index <=3){
                Assert.assertEquals(check.getText(), book.get(index));
                index++;
            } else
                break;
        }
        return new Basket();
    }

    /**
     * Проверяем количество книг в корзине на ОР и ФР
     */
    public Basket check_volume(){
        String s = $x("(//div[@class='info-item__title'])[1]").getText().replaceAll("[^0-9]","");
        long ss = Long.valueOf(s);
        Assert.assertEquals(количество_книг, ss);
        return new Basket();
    }

    /**
     * Выполняем задание 5,6,7
     */
    public void Order_amount_check() throws InterruptedException {
        /**
         * Проверяем цену каждой книги по отдельности на ОР и ФР
         */
        int price_book1 = 783; int price_book1_web = Integer.valueOf($x("(//div[@class='product-price__value product-price__value--discount'])[1]").getText().replaceAll("[^0-9]", ""));
        int price_book2 = 224; int price_book2_web = Integer.valueOf($x("(//div[@class='product-price__value product-price__value--discount'])[2]").getText().replaceAll("[^0-9]", ""));
        int price_book3 = 397; int price_book3_web = Integer.valueOf($x(("(//div[@class='product-price__value'])[1]")).getText().replaceAll("[^0-9]", ""));
        Assert.assertEquals(price_book1, price_book1_web);
        Assert.assertEquals(price_book2, price_book2_web);
        Assert.assertEquals(price_book3, price_book3_web);

        /**
         * Проверяем, что итоговая сумма соответствует итоговой сумме с web-страницы.
         */
        int summ = price_book1+price_book2+price_book3;
        int seumm_web = Integer.valueOf($x("(//div[@class='info-item__value'])[3]").getText().replaceAll("[^0-9]", ""));
        Assert.assertEquals(summ,seumm_web);

        /**
         * Удаляем первую книгу из корзины. Книга "Kali Linux"
         */
        $x("(//div[@class='button cart-item__actions-button cart-item__actions-button--delete light-blue'])[1]").click();

                Thread.sleep(10000);
        /**
         * Проверяем, что итоговая цена изменилась на правильную сумму
         */
        int new_sum = price_book2 + price_book3; int new_sum_web = Integer.valueOf($x("(//div[@class='info-item__value'])[3]").getText().replaceAll("[^0-9]", ""));
        Assert.assertEquals(new_sum, new_sum_web);

        /**
         * Повторная проверка на количество товаров после удаления одной книги.
         */
      int new_book_volume = 2; int new_book_volume_web = Integer.valueOf($x("(//div[@class='info-item__title'])[1]").getText().replaceAll("[^0-9]",""));
        Assert.assertEquals(new_book_volume, new_book_volume_web);
    }
}
