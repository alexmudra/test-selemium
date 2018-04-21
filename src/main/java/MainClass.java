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

        System.setProperty("webdriver.gecko.driver", "D:\\workspace\\geckodriver\\geckodriver.exe");// указали путь к драйверу
        driver = new FirefoxDriver();// инициализировали наш драйвер (FF драйвер)

        /*метод для увеличения ожидания загрузки елемента(в секундах). Используем вначале програмы*/
        //WebDriver.Timeouts = driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);// неявное ожидание загрузки страницы
        //driver.manage().timeouts().setScriptTimeout(20, TimeUnit.SECONDS);//неявное ожидание отработки скриптов
        /*методы для управления размером окна браузера*/
        //driver.manage().window().maximize(); // метод открывает в максимальном размере окно браузера
        driver.manage().window().setSize(new Dimension(1300, 700));

        //РОБОТА З ТАБЛИЦЯМИ

        driver.get("https://www.w3schools.com/html/html_tables.asp");//відкриваємо ресурс з таблицею
        //обявим та присвоїм перемінній tableElement ікспас таблиці з ресурсу
        WebElement tableElement = driver.findElement(By.xpath("//div[@class=\"w3-example\"]//table[@id=\"customers\"]"));
        //Напишем окремий клас Table з методами для роботи з таблицями (див. клас окремо в ІДЕ)

        Table table = new Table(tableElement, driver);//створюємо об'єкт классу Table з назвою table

        System.out.println("Rows number is " + table.getRows().size());//виведемо к-сть рядків використовуючи методи з таблиці Table (class Table)

        System.out.println(table.getValueFromCell(2, 3));
        System.out.println(table.getValueFromCell(4, 1));//виведемо інфо із 4 рядка і 1 заголовку

        System.out.println(table.getValueFromCell(2, "Company"));//виведемо значення по номеру 2 рядка і імені заголовка "Company"
        System.out.println(table.getValueFromCell(2, 3));
        System.out.println(table.getValueFromCell(1, "Country"));//виведемо інфо із 4 рядка і 1 заголовку

        System.out.println(table.getValueFromCell(2, "Contact"));//виведемо значення по номеру 2 рядка і імені заголовка "Company"



        driver.quit();// обязательно указывать вконце теста даны й метод для завершения работы драйвера

    }

}