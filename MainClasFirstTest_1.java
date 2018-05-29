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

public class MainClassFirst_1{

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


            //РОБОТА-обробка З Allert (в основному JAVA SCRIPT) НА САЙТАХ

            //відкриваємо ресурс для тестування
            driver.get("http://www.oracle.com/technetwork/java/javase/documentation/jdk8-doc-downloads-2133158.html");

        driver.findElement(By.xpath("//a[text()=\"jdk-8u171-docs-all.zip\"]")).click();// клікаємо і побачимо JS allert

        //конструкція яка поставить затримку в 3 секунди між виконанням коду findElement і switchTo
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Перейдемо на вікно з алертом за допомогою методу switch to
        driver.switchTo().alert().accept();
        //метод .accept це підтвердити дію (типу ОК чи submit)
        //метод /dismiss це відхилити дію (cancel або no)

        //Попробуємо створити свій алерт на сайті гугл
        driver.get("http://www.google.com");
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("confirm ('Are you sure?');");
        //затримка в 3 секунди
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.switchTo().alert().accept();

        //Спробуємо метод .dismiss
        driver.switchTo().alert().dismiss();//цей метод клікне на кнопці відхилити в

    }
}