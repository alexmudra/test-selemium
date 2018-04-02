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
    public static void main(String[] args) {// создали метод чтобы инициализировать драйвер GecoDriver для FF
        System.setProperty("webdriver.gecko.driver", "D:\\QA\\testselenium\\drivers\\geckodriver.exe");// указали путь к драйверу
        WebDriver driver = new FirefoxDriver();// инициализировали наш драйвер (FF драйвер)

        /*метод для увеличения ожидания загрузки елемента(в секундах). Используем вначале програмы*/
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        /*методы для управления размером окна браузера*/
        //driver.manage().window().maximize(); // метод открывает в максимальном размере окно браузера
        driver.manage().window().setSize(new Dimension(1330, 900));

        /*РАБОТА С ТЕКСТОВЫМИ ПОЛЯМИ. КАК ЗАПОЛНЯТЬ И ОТОБРАЖАТЬ ТЕКСТ В ТЕКСТОВЫХ ПОЛЯХ*/

        /*driver.get("https://ru.wikipedia.org");//открываем сайт википедии
        driver.findElement(By.xpath("//*[@id=\"searchInput\"]")).sendKeys("car");// method .sendKeys вставляе текст в текстове поле
        driver.findElement(By.xpath("//*[@id=\"searchButton\"]")).click();//находим елемент поиск и кликаем
        driver.findElement(By.xpath("//*[@id=\"searchButton\"]")).click();//находим елемент поиск и кликаем
        System.out.println(driver.findElement(By.xpath("//*[@id=\"searchText\"]")).getAttribute("value"));
        driver.findElement(By.xpath("//*[@id=\"ooui-php-1\"]")).clear();// .clear очищает поле ввода*/

        // Попробуем передать значения в другой ресурс (Гитхаб)

        /*driver.get("https://github.com/");// открываем сайт
        driver.findElement(By.xpath("//*[@id=\"user[login]\"]")).sendKeys("Test User Name"); //находим елемент и указываем юзернейм
        driver.findElement(By.xpath("//*[@id=\"user[email]\"]")).sendKeys("testEmail@gmail.com");// находим и указываем емайл
        driver.findElement(By.xpath("//*[@id=\"user[password]\"]")).sendKeys("3837847");
        driver.findElement(By.xpath("/html/body/div[4]/div[1]/div/div/div[2]/div/form/button")).submit();
        */

        /*РАБОТА СО ССЫЛКАМИ*/

        /*
        driver.get("https://ru.wikipedia.org");//открываем сайт википедии
        WebElement link = driver.findElement(By.xpath("//*[@id=\"p-wikibase-otherprojects\"]/div/ul/li[1]/a"));// присваемаем переменной link
        //значение длайвера ссылки
        System.out.println(link.getText());// выводим на екран текст ссылки переменной link
        link.click();//методом клік клікаємо по лінку

        driver.get("https://github.com");//відкрити сайт гітхаба
        driver.findElement(By.xpath("/html/body/div[1]/header/div/div[2]/nav/ul/li[1]/a")).click();//знаходимо лінк по ікспасу і клікаємо

        driver.close();// закрить попап вікно
        driver.quit();// обязательно указывать вконце теста даный метод для завершения работы драйвера
        */

        /*РАБОТА С КНОПКАМИ*/

        /*driver.get("https://ru.wikipedia.org");//открываем сайт википедии
        driver.findElement(By.xpath("//input[@id='searchButton']")).click();//находим елемент поиск и кликаем

        driver.get("https://www.spreadshirt.co.uk");//открываем сайт
        driver.findElement(By.xpath("//*[@id='basketButton']/div[1]")).click();//кликаем по елементу корзина

        //driver.quit();// обязательно указывать вконце теста даный метод для завершения работы драйвера

        driver.manage().window().maximize();// метод открывает в максимальном размере окно браузера*/

        /*РАБОТА С КНОПКАМИ*/

        /*driver.get("https://ru.wikipedia.org");//открываем сайт википедии
        driver.findElement(By.xpath("//input[@id='searchButton']")).click();//находим елемент поиск и кликаем

        driver.get("https://www.spreadshirt.co.uk");//открываем сайт
        driver.findElement(By.xpath("//*[@id='basketButton']/div[1]")).click();//кликаем по елементу корзина

        driver.get("https://github.com");// открыли сайт гитхаб
        WebElement button2 = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div/div/div[2]/div/form/button"));// присвоили
        // вебелементу класса вебелемент значение
        //кнопки
            if (button2.getText().equals("Sign up for GitHub")){
                System.out.println("Button test is " + button2.getText());
        }
            else System.out.println("The btn text is not correct");

        //button.submit();//вызываем метод submit для елемента button
        driver.findElement(By.xpath("/html/body/div[4]/div[1]/div/div/div[2]/div/form/button")).click();

        //driver.quit();// обязательно указывать вконце теста даный метод для завершения работы драйвера
        */

        /*РАБОТА С РАДИОБАТТОНАМИ И ЧЕКБОКСАМИ*/

        driver.get("https://rozetka.com.ua");// открыли сайт прайс юа

        driver.findElement(By.xpath("//*[@id=\"2416\"]/a")).click();// открыли подкатегорию Ноутбуки и компьютеры
        driver.findElement(By.xpath("//*[@id=\"content-inner-block\"]/div[2]/div/div/div[2]/div/div[1]/div[1]/div/div[3]/div/div/div[1]/div/div[1]/div[1]/div/p/a")).click(); //Ноутбуки
        driver.findElement(By.xpath("//*[@id=\"menu_categories_left\"]/li[2]/ul/li[1]/a")).click();// открываем категорию Асер
        driver.findElement(By.xpath("//*[@id=\"filter_processor_23653\"]/label/a/span/i")).click();// через метод клик ставим галочку на AMDA4

        //Проексперементируем с методом isSelected и условиями
        if (!driver.findElement(By.xpath("//*[@id=\"filter_processor_13288\"]/label/a/span/i[1]")).isSelected());/*если isSelected
        вернет фолс, то мы кликнем на чекбокс. "!driver..." - мы проверили отрицание поставив "!"*/
        driver.findElement(By.xpath("//*[@id=\"filter_processor_13288\"]/label/a/span/i[1]")).click();//это мы кликаем на чекбокс если он не выделен

        /*Проверяем выделеи или не выделен елемент с помощью метода .isSelected (метод возвражает булеан значиение)
        * Если мы применили етот метод к чекбоксу то false значит что чекбокс НЕ выделен
        * */
        System.out.println(driver.findElement(By.xpath("//*[@id=\"filter_processor_13288\"]/label/a/span/i[1]")).isSelected()); //проверяем тру или фолс
        driver.findElement(By.xpath("//*[@id=\"filter_processor_13288\"]/label/a/span/i[1]")).click();// ставим галочку на етом же чекбоксе
        System.out.println(driver.findElement(By.xpath("//*[@id=\"filter_processor_13288\"]/label/a/span/i[1]")).isSelected()); //проверяем тру или

        driver.close();// закрить попап вікно
        driver.quit();// обязательно указывать вконце теста даный метод для завершения работы драйвера
    }
}