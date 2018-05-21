import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.SQLOutput;
import java.util.concurrent.TimeUnit;

public class IsAvailableElements {

    static WebDriver driver; // для универсальности доступа вынесли драйвер за пределы метода

    //ПЕРЕВІРКА ДОСТУПНОСТІ ЕЛЕМЕНТІВ

    public static void main(String[] args) {// создали метод чтобы инициализировать драйвер GecoDriver для FF

        //System.setProperty("webdriver.gecko.driver", "D:\\workspace\\geckodriver\\geckodriver.exe");// Вказали путь до драйверу для браузеру ФФ
        System.setProperty("webdriver.chrome.driver", "D:\\workspace\\chromedriver\\chromedriver.exe");// Вказали шлях до драйверу браузеру Хром
        driver = new ChromeDriver(); //иніціалізували драйвер для браузеру Хром

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);//вказали неявне очікування

        //driver.manage().window().maximize(); // метод открывает в максимальном размере окно браузера
        driver.manage().window().setSize(new Dimension(1200, 600));


//        //відкриєм ресурс для тестування
//        driver.get("https://www.w3schools.com/js/default.asp");
//
//        WebElement clickDisplayTimeButon = driver.findElement(By.xpath("//*[@id=\"main\"]/div[4]/div/button"));// створимо перемінну для задісейбленої кнопки
//        WebElement homeButton = driver.findElement(By.xpath("//*[@id=\"main\"]/div[2]/a[1]")); //створимо перемінну для кнопки home
//
//        System.out.println("Time button is "+ clickDisplayTimeButon.isEnabled());// метод isEnabled перевіряє стан елементу і виводить булеан
//        System.out.println("Home button is " + homeButton.isEnabled());// метод isEnabled перевіряє стан елементу і виводить булеан. Перевіремо стан кнопки home
//
//        if (clickDisplayTimeButon.isEnabled()) clickDisplayTimeButon.click();// написали умову якщо кнопка активна, то ми її клікнемо
//        if (homeButton.isEnabled()) homeButton.click();// написали умову якщо кнопка активна, то ми її клікнемо

//        //Протестимо інший сайт
//
//        driver.get("http://www.oracle.com/technetwork/java/javaee/downloads/java-ee-sdk-downloads-3908423.html"); //перейдемо на сайт
//
//        WebElement radioButton1 = driver.findElement(By.xpath("//input[@name='agreementjava_ee_sdk-8-oth-JPR'][1]")); // визначимо перемінну для 1 радіобатона
//        WebElement radioButton2 = driver.findElement(By.xpath("//input[@name='agreementjava_ee_sdk-8-oth-JPR'][2]")); //для 2го радіобатона
//
//        System.out.println("radioButton 2 selected: "+ radioButton2.isSelected());// виведемо на екран чи виділений радіобатон 2
//
//        if(!radioButton2.isSelected()) radioButton1.click();//умова: якщо 2 радіобатон НЕ виділений то клікнемо на 1 радіобатон

        // Протестимо ще й Ebay

        driver.get("https://www.ebay.co.uk/b/Electronics/bn_7000259660");// відкриємо ресурс

        WebElement link1 = driver.findElement(By.xpath("//a[contains(text(),\"Video Games & Consoles\")]")); //створимо і ініціалізуємо 1 лінк
        WebElement link2 = driver.findElement(By.xpath("//a[text()=\" Daily Deals\"]")); //2й лінк

        System.out.println(link1.isDisplayed());// даний лінк видно на сторінці
        System.out.println(link2.isDisplayed());

        if (link1.isDisplayed()) link1.click();
        else link2.click();












    }
}
