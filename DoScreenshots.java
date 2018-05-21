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

import static org.apache.tools.ant.util.FileUtils.*;

public class DoScreenshots {
    static WebDriver driver; // для универсальности доступа вынесли драйвер за пределы метода

    //РОБОТА З СКРІНШОТАМИ ПРИ ТЕСТАХ

    public static void main(String[] args) {// создали метод чтобы инициализировать драйвер GecoDriver для FF

        //System.setProperty("webdriver.gecko.driver", "D:\\workspace\\geckodriver\\geckodriver.exe");// Вказали путь до драйверу для браузеру ФФ
        System.setProperty("webdriver.chrome.driver", "D:\\workspace\\chromedriver\\chromedriver.exe");// Вказали шлях до драйверу браузеру Хром
        driver = new ChromeDriver(); //иніціалізували драйвер для браузеру Хром

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);//вказали неявне очікування

        //driver.manage().window().maximize(); // метод открывает в максимальном размере окно браузера
        driver.manage().window().setSize(new Dimension(1200, 600));

        driver.get("https://uk.wikipedia.org/wiki/%D0%93%D0%BE%D0%BB%D0%BE%D0%B2%D0%BD%D0%B0_%D1%81%D1%82%D0%BE%D1%80%D1%96%D0%BD%D0%BA%D0%B0");// відкриємо сайт Browser Stack

        WebElement searchInput = driver.findElement(By.xpath("//input[@id=\"searchInput\"]"));//присвоїли текстовому полю пеермінну

        searchInput.sendKeys("text");//в перемінній searchInput визвемо метод sendKeya і передами значення текст
        //searchInput.sendKeys(Keys.ENTER);//використаємо класу Keys.Enter щоб нажати клавішу ентер

        //Нажмемо комбінацію клавіш

        //1) приклад

        //створимо перемінні для виділення, вирізання та вставляння тексту
        String select = Keys.chord(Keys.CONTROL, "a");//нажмем комбінацію щоб виділити текст
        String cut = Keys.chord(Keys.CONTROL, "x");//нажмем CTR+x щоб вирізати текст
        String paste = Keys.chord(Keys.CONTROL, "v");// вставимо текст комбінацією ctr+v

        //Використаємо перемінні
        searchInput.sendKeys("omama mia");
        searchInput.sendKeys(select);
        searchInput.sendKeys(cut);
        searchInput.sendKeys(paste);
        searchInput.sendKeys(Keys.ENTER);

        //створимо перемінну щоб динамічно називати файли скріншотів
        Date dateNow = new Date();//
        SimpleDateFormat format = new SimpleDateFormat("hh_min_sec"); //переведемо дату в стрінгу, щоб було зручніше називати файл з скріншотом
        //"hh_min_sec" це ми для прикладу вказали патерн для системи
        String fileName = format. format(dateNow)+ ".png";//зробили перемінну щоб називати скріншот

        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);//в перемінну screenshot вкладемо конструкцію для того щоб робити скріни

        //тепер збережемо на жорсткий диск FILE з скріншотом в якусь директорію
        /*try {
            FileUtils.copyFile(screenshot, new File("D:\\Screenshots" + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        */


        driver.quit();
    }
}