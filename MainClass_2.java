
//ПРИКЛАД ТЕСТУВАННЯ ПО ПАТЕРНУ PAGEOBJECT
//КОЖНА СТОРІНКА ВЕБСАЙТУ БУДЕ ОПИСАНА НОВИМ КЛАСОМ І МЕТОДАМИ

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class MainClass_2 {

    static WebDriver driver;//ініціалізували драйвер

    public static void main(String[] args){

        driver = new FirefoxDriver();

        System.setProperty("webdriver.gecko.driver", "D:\\workspace\\geckodriver\\geckodriver.exe");// Вказали путь до драйверу для браузеру ФФ
        //driver = new ChromeDriver(); //иніціалізували драйвер для браузеру Хром

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);//вказали неявне очікування

        //driver.manage().window().maximize(); // метод открывает в максимальном размере окно браузера
        driver.manage().window().setSize(new Dimension(1200, 600));

        driver.get("https://github.com");//переходимо на сторінку ГітХабу
        MainPage mainPage = new MainPage(driver);//створимо в цьому класі об'єкт класу сторінки MainPage і передамо туди драйвер
        mainPage.register("koba", "ksldjf@gmail.com", "394874873");

    }
}
