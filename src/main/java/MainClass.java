import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Alex on 2/25/2018.
 */
public class MainClass {
    public static void main(String[] args) {// создали метод чтобы инициализировать драйвер GecoDriver для FF
        System.setProperty("webdriver.gecko.driver", "D:\\QA\\testselenium\\drivers\\geckodriver.exe");// указали путь к драйверу
        WebDriver driver = new FirefoxDriver();// инициализировали наш драйвер

        driver.get("https://docs.seleniumhq.org");// указываем драйверу открыть окно ФФ через метод get. И открыть ссылку на сайт Селенеум

    }
}
