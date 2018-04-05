import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.SourceType;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Created by Alex on 2/25/2018.
 */


public class MainClass {

    static WebDriver driver; // для универсальности доступа вынесли драйвер за пределы метода


    public static void main(String[] args) {// создали метод чтобы инициализировать драйвер GecoDriver для FF

        System.setProperty("webdriver.gecko.driver", "D:\\QA\\testselenium\\drivers\\geckodriver.exe");// указали путь к драйверу
        driver = new FirefoxDriver();// инициализировали наш драйвер (FF драйвер)

        /*метод для увеличения ожидания загрузки елемента(в секундах). Используем вначале програмы*/
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        /*методы для управления размером окна браузера*/
        //driver.manage().window().maximize(); // метод открывает в максимальном размере окно браузера
        driver.manage().window().setSize(new Dimension(1330, 800));


        //РАБОТА С ЛИСТ-БОКСАМИ ИЛИ ВЫПАДАЮЩИМИ СПИСКАМИ

        //открываем форму регистрации на гугл
        driver.get("https://accounts.google.com/SignUp?continue=https%3A%2F%2Fwww.google.com.ua%2F_%2Fchrome%2Fnewtab%3Fei%3DWGHGWvfsCcfv6QSllafIAw%26yv%3D2&hl=ru");

        //Вызовем новый метод selectOption и передадим имена и значения листбоксов. Метод запустит и выберет то что нужно со списков

        selectOption("Пол", "Мужской");
        selectOption("Страна","Италия (Italia)");


     /*   driver.findElement(By.xpath("(//strong[text()='Пол']/following-sibling::div/div[@role='listbox'])[1]")).click();//нашли и кликнули на листбокс с Пол
        driver.findElement(By.xpath("(//div[text()='Мужской']/parent::div[@role='option'])")).click();//кликаем по опции "Мужской" в листбоксе ПОЛ

        //выберем еще значения с листбокса Страна
        driver.findElement(By.xpath("(//strong[text()='Страна']/following-sibling::div/div[@role='listbox'])[1]")).click();//нашли и кликнули на листбокс с Страна
        driver.findElement(By.xpath("(//div[text()='Аруба (Aruba)']/parent::div[@role='option'])")).click();//кликаем по опции "Аруба" в листбоксе Страна
    */
        //Напишем отдельный метод для выбора листбоксов и значений в листбоксах

        //driver.close();// закрить попап вікно
        //driver.quit();// обязательно указывать вконце теста даный метод для завершения работы драйвера
    }
        //Поскольку у нас много повторяющегося кода для чекбоксов и радиботонов-мы напишем отдельный метод для их обработки

        //Напишем отдельный метод для выбора листбоксов и значений в листбоксах
    public static void selectOption(String listName, String option ) { //создали метод который будет принимать 2 стринговых значения

        //сосдадим 2 локатора чтобы не привязиваться к жестким условиям метода

        //мы заменили опцию Страна на '%s' и использовали метод .format и присвоили значение переменной listName
        String listXpath = String.format("(//strong[text()='%s']/following-sibling::div/div[@role='listbox'])[1]",listName );

        //вместо опции Аруба (Aruba) мы заменили на '$s'использовали метод .format и присвоили значение переменной option
        String optionXpath = String.format("(//div[text()='%s']/parent::div[@role='option'])", option);

        //используем переменные/локаторы listName and option в методе findElement
        driver.findElement(By.xpath(listXpath)).click();//передаем новый икспас listXpath в метод
        driver.findElement(By.xpath(optionXpath)).click();//передаем новый икспас optionXpath в метод


        driver.close();// закрить попап вікно
        driver.quit();// обязательно указывать вконце теста даный метод для завершения работы драйвера
    }

}