import org.apache.tools.ant.util.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import sun.net.www.content.image.png;

import javax.sound.midi.Soundbank;
import java.io.File;
import java.io.IOException;
import java.security.Key;
import java.sql.SQLOutput;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


import java.util.concurrent.TimeUnit;


public class DownloadFile {

    static WebDriver driver; // для универсальности доступа вынесли драйвер за пределы метода

    //РОБОТА З завантаженням файлів

    public static void main(String[] args) {// создали метод чтобы инициализировать драйвер GecoDriver для FF

        //System.setProperty("webdriver.gecko.driver", "D:\\workspace\\geckodriver\\geckodriver.exe");// Вказали путь до драйверу для браузеру ФФ
        System.setProperty("webdriver.chrome.driver", "D:\\workspace\\chromedriver\\chromedriver.exe");// Вказали шлях до драйверу браузеру Хром
        driver = new ChromeDriver(); //иніціалізували драйвер для браузеру Хром

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);//вказали неявне очікування

        //driver.manage().window().maximize(); // метод открывает в максимальном размере окно браузера
        driver.manage().window().setSize(new Dimension(1200, 600));

        driver.get("https://www.google.com.ua/imghp?hl=ru&authuser=0");// відкриємо сайт Гугл пошук по картинці
        driver.findElement(By.xpath("//a[@aria-label=\"Поиск по картинке\"]")).click();//знайшли х-пас для елементу який відкриває вікно браузеру для завантаж файлів
        driver.findElement(By.xpath("//a[text()=\"Загрузить файл\"]")).click();//знайдемо х-пас для кнопки Завантажити файл

        //якщо ми бачимо кнопку чи поле з input tipe=file то можна без проблем звертатися до нього за допомогою метода .sendKeys

        driver.findElement(By.xpath("//input[@type=\"file\"]")).sendKeys("D:\\c.png");//методу sendKeys передамо шлях до картинки яку ми завантажимо
        //в Гугл

    }
}
