import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.SourceType;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.concurrent.TimeUnit;

/**
 * Created by Alex on 2/25/2018.
 */
public class MainClass {
    public static void main(String[] args) {// создали метод чтобы инициализировать драйвер GecoDriver для FF
        System.setProperty("webdriver.gecko.driver", "D:\\QA\\testselenium\\drivers\\geckodriver.exe");// указали путь к драйверу
        WebDriver driver = new FirefoxDriver();// инициализировали наш драйвер (FF драйвер)

        /*метод для увеличения ожидания загрузки елемента(в секундах). Используем вначале програмы*/
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        /*методы для управления размером окна браузера*/
        driver.manage().window().maximize();// метод открывает в максимальном размере окно браузера

        /*РАБОТА С ТЕКСТОВЫМИ ПОЛЯМИ. КАК ЗАПОЛНЯТЬ И ОТОБРАЖАТЬ ТЕКСТ В ТЕКСТОВЫХ ПОЛЯХ*/

        /*driver.get("https://ru.wikipedia.org");//открываем сайт википедии
        driver.findElement(By.xpath("//*[@id=\"searchInput\"]")).sendKeys("car");// method .sendKeys вставляе текст в текстове поле
        driver.findElement(By.xpath("//*[@id=\"searchButton\"]")).click();//находим елемент поиск и кликаем
        driver.findElement(By.xpath("//*[@id=\"searchButton\"]")).click();//находим елемент поиск и кликаем
        System.out.println(driver.findElement(By.xpath("//*[@id=\"searchText\"]")).getAttribute("value"));
        driver.findElement(By.xpath("//*[@id=\"ooui-php-1\"]")).clear();// .clear очищает поле ввода*/

        // Попробуем поиграть с другим ресурсом

        driver.get("https://github.com/");// открываем сайт
        driver.findElement(By.xpath("//*[@id=\"user[login]\"]")).sendKeys("Test User Name"); //находим елемент и указываем юзернейм
        driver.findElement(By.xpath("//*[@id=\"user[email]\"]")).sendKeys("testEmail@gmail.com");// находим и указываем емайл
        driver.findElement(By.xpath("//*[@id=\"user[password]\"]")).sendKeys("3837847");
        driver.findElement(By.xpath("/html/body/div[4]/div[1]/div/div/div[2]/div/form/button")).submit();


        //driver.quit();// обязательно указывать вконце теста даный метод для завершения работы драйвера
    }
}