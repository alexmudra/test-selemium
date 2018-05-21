import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AvailabilityElement {
    static WebDriver driver; // для универсальности доступа вынесли драйвер за пределы метода

    //ПЕРЕВІРКА НАЯВНОСТІ ЕЛЕМЕНТІВ

    public static void main(String[] args) {// создали метод чтобы инициализировать драйвер GecoDriver для FF

        //System.setProperty("webdriver.gecko.driver", "D:\\workspace\\geckodriver\\geckodriver.exe");// Вказали путь до драйверу для браузеру ФФ
        System.setProperty("webdriver.chrome.driver", "D:\\workspace\\chromedriver\\chromedriver.exe");// Вказали шлях до драйверу браузеру Хром
        driver = new ChromeDriver(); //иніціалізували драйвер для браузеру Хром

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);//вказали неявне очікування

        //driver.manage().window().maximize(); // метод открывает в максимальном размере окно браузера
        driver.manage().window().setSize(new Dimension(1200, 600));

        driver.get("https://www.browserstack.com/pricing");// відкриємо сайт Browser Stack

        //щоб перевірити наявність елементу на сайті використаєм метод .findElements який поверне список всіх елементів з потрібним х-пасом
        //System.out.println(driver.findElements(By.xpath("//a[text()=\"Free Trial\"]")).size());  // метод .size поверне розмір списку з таким х-пасом
        //можна використовувати для того щоб побачити к-сть елементів або тегів на сторінці

        //спробуємо написати цикл з .findElements для того щоб визначити чи наявний чи не наявний елемент на сторінці

        if (driver.findElements(By.xpath("//a[text()=\"Free Trial\"]")).size() > 0)
            System.out.println("Such elemts is presented");
        else System.out.println("Can not find such element");

    }

}
