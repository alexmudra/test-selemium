import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.SourceType;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import javax.swing.plaf.synth.SynthOptionPaneUI;
import javax.swing.text.html.Option;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class MainClass {

    static WebDriver driver; // для универсальности доступа вынесли драйвер за пределы метода

    //static WebDriverWait wait;

    //WebDriverWait wait = (new WebDriverWait(driver, 5);// напишемо примусове/ЯВНЕ очікування

    //використовуємо вбудований клас WebDriverWait, створимо екземпляр класу з назвою wait, передамо туди наш драйвер і вкажимо очікування
    // вебелементу 5 секунд
    //static WebDriverWait wait = new WebDriverWait(driver, 5);//ми цей метод потім будемо використовувати всередині методів

    public static void main(String[] args) {// создали метод чтобы инициализировать драйвер GecoDriver для FF

        //System.setProperty("webdriver.gecko.driver", "D:\\workspace\\geckodriver\\geckodriver.exe");// Вказали путь до драйверу для браузеру ФФ
        System.setProperty("webdriver.chrome.driver", "D:\\workspace\\chromedriver\\chromedriver.exe");// Вказали шлях до драйверу браузеру Хром
        //driver = new FirefoxDriver();// инициализировали наш драйвер (FF драйвер)
        driver = new ChromeDriver(); //иніціалізували драйвер для браузеру Хром

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);//вказали неявне очікування

        //driver.manage().window().maximize(); // метод открывает в максимальном размере окно браузера
        driver.manage().window().setSize(new Dimension(1300, 700));


        //РОБОТА З ВИКОНАННЯМ JAVA SCRIPT КОДУ НА САЙТІ

        driver.get("https://pz.25h8.auction/tenders/index");//відкриваємо ресурс для тестування

        JavascriptExecutor jse = (JavascriptExecutor)driver;//ініціалізуємо JS екзекутор
        //jse.executeScript("alert('Omh. So cool JS code');");//пишемо код в форматі JS

        //Попробуєм поскролити сторінку вниз за допомогою JS
        jse.executeScript("window.scrollBy(0, 2000)", ""); //скролимо сторінку вниз на 1000 пікселів
        jse.executeScript("window.scrollBy(0, -500)", "");//скролимо сторінку вверх на 500 пікселів


    }
}