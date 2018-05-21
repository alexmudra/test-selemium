import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;


/* РОБОТА З ВКЛАДКАМИ БРАУЗЕРА */

public class FewBrowserTab {

    static WebDriver driver; // для универсальности доступа вынесли драйвер за пределы метода


    public static void main(String[] args) {// создали метод чтобы инициализировать драйвер GecoDriver для FF

        //System.setProperty("webdriver.gecko.driver", "D:\\workspace\\geckodriver\\geckodriver.exe");// Вказали путь до драйверу для браузеру ФФ
        System.setProperty("webdriver.chrome.driver", "D:\\workspace\\chromedriver\\chromedriver.exe");// Вказали шлях до драйверу браузеру Хром
        driver = new ChromeDriver(); //иніціалізували драйвер для браузеру Хром

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);//вказали неявне очікування

        //driver.manage().window().maximize(); // метод открывает в максимальном размере окно браузера
        driver.manage().window().setSize(new Dimension(1300, 700));


        //відкриєм ресурс для тестування
        driver.get("https://netcat.ru/developers/partprog/");

        //знайдемо лінк по назві і клікнемо
        driver.findElement(By.xpath("//div[@class=\"col i2\"]/a[text()='соглашением об использовании персональных данных']")).click();
        String mainTab = driver.getWindowHandle();//обявимо і присвоїмо перемінній mainTab значення .gerWindowHandle(метод для одного вікна)
        // . Так ми запамятаємо вкладку на яку перейшли

        //.gerWindowHandles(для багатьох вікон) поверне зараз всі наші вкладки
        for (String tab:driver.getWindowHandles()){//цикл for перебирає значення які повертає метод .getWindowHandles
            driver.switchTo().window(tab);//після закінчення циклу ми переключимось на останню вкладку
        }
        driver.findElement(By.xpath("//li/a[text()='Галерея']")).click();//клікнемо на лікн в 2й вкладці
        driver.switchTo().window(mainTab);//переключимося на першу вкладку цього разу без вкладок
        driver.findElement(By.xpath("//*[@id=\"wrap\"]/section[6]/div/form/div[3]/div[2]/div[1]/label/input")).sendKeys("My name is Alex");


    }
}