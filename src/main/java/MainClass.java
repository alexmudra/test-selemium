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
        driver.manage().window().setSize(new Dimension(1330, 900));//устанавливаем размер окна браузера


        /*метод .get самый популярный метод отрытия вебстраницы*/
        driver.get("https://docs.seleniumhq.org");// указываем драйверу открыть окно ФФ через метод get. И открыть ссылку на сайт Селенеум


        /*методы с navigate*/
        driver.navigate().to("https://www.youtube.com/watch?v=qoIp4g8YVjA");//альтернативный метод для запуска веб странички
        driver.navigate().back();//метод возвращает на предыдущую вебстраницу
        driver.navigate().forward();// метод открывает следующую вебстраницу
        driver.navigate().refresh();// перегрузка вебстраницы

        System.out.println(driver.getTitle());// метод .getTitle выводит в нашу консоль тайтл страницы на которой мы находимся
        System.out.println(driver.getCurrentUrl());//метод .getCurrentUrl выводит url страницы на которой мы находимся в нашу консоль

        driver.get("https://ru.wikipedia.org/wiki");// открываем вебстраницу википедии для теста

        /*для размещения вебелементов в какой то переменной, то мы должны инициализировать переменную класса WebElement
        * с помощью метода findElement мы можем находить различные елементы на вебстранице*/

        WebElement link = driver.findElement(By.linkText("pt-login"));//поиск елемента по ссылке
        WebElement partOfLink = driver.findElement(By.partialLinkText("об ошибке"));//поиск елемента по части ссылки
        WebElement searchField = driver.findElement(By.name("search"));//поиск елемента по имени (присвоили этому
        //елементу имя searchField
        WebElement searchButton = driver.findElement(By.className("searchButton"));// поиск елемента по имени класса, для быстрого поиска инспект. вебстраницы
        WebElement history = driver.findElement(By.id("ca-history"));//поиск елемента по id елемента

        WebElement element = driver.findElement(By.cssSelector("#searchInput")); // поиск елементов по CSS селектору(не очень популярно)
        WebElement elementLogo = driver.findElement(By.xpath("//*[@id='p-logo']/a")); // поиск елемента по X-Path (очень популярно)


        driver.quit();// обязательно указывать вконце теста даный метод для завершения работы драйвера
    }
}