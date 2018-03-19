import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.SourceType;

import javax.swing.plaf.synth.SynthOptionPaneUI;

/**
 * Created by Alex on 2/25/2018.
 */
public class MainClass {
    public static void main(String[] args) {// создали метод чтобы инициализировать драйвер GecoDriver для FF
        System.setProperty("webdriver.gecko.driver", "D:\\QA\\testselenium\\drivers\\geckodriver.exe");// указали путь к драйверу
        WebDriver driver = new FirefoxDriver();// инициализировали наш драйвер (FF драйвер)

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

        driver.quit();// обязательно указывать вконце теста даный метод для завершения работы драйвера
    }
}