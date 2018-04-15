import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.SourceType;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Created by Alex on 2/25/2018.
 */


public class MainClass {

    static WebDriver driver; // для универсальности доступа вынесли драйвер за пределы метода


    public static void main(String[] args) {// создали метод чтобы инициализировать драйвер GecoDriver для FF

        System.setProperty("webdriver.gecko.driver", "D:\\QA\\testselenium\\drivers\\geckodriver.exe");// указали путь к драйверу
        driver = new FirefoxDriver();// инициализировали наш драйвер (FF драйвер)

        /*метод для увеличения ожидания загрузки елемента(в секундах). Используем вначале програмы*/
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);// неявное ожидание загрузки страницы
        //driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);//неявное ожидание отработки скриптов
        /*методы для управления размером окна браузера*/
        //driver.manage().window().maximize(); // метод открывает в максимальном размере окно браузера
        driver.manage().window().setSize(new Dimension(1300, 700));

        //РОБОТА З ЧЕКБОКСАМИ ТА ГРУПАМИ ЧЕКБОКСІВ

        driver.get("https://aquamarket.ua/ru/84-voda-i-napitki");//відкрили сайт для тестування

        // Зробимо список всих товарів, ініціалізуємо перемінну checkboxes і присвоюємо їй драйвер з ікспасом чекбоксів
        //використаєм метод findElements щоб створити список з елементів
        List<WebElement> cheсkboxes = driver.findElements(By.xpath("//div[@class=\"categories-filter layered-filter\"]//label[@class=\"control control--checkbox\"]"));

        //chekboxes.get(5).click(); клікнемо на 6 чекбокс із всього списку


        //створимо цикл який буде порівнювати к-сть чекбоксів розділі на напишемо повідомлення результату в термінал
        if (cheсkboxes.size() == 10)
            System.out.println("10 checkboxes it's OK");
            else System.out.println("Less than 10 checkboxes. It's Fail");


        //розглянемо спосіб як виділити всі чекбокси
        for (WebElement checkbox : cheсkboxes){
            checkbox.click();
        }

        driver.quit();// обязательно указывать вконце теста даны й метод для завершения работы драйвера

    }

}