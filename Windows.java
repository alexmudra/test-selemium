import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

//РОБОТА З ОКРЕМИМИ ВІКНАМИ. ПЕРЕМІЩЕННЯ І МАНІПУЛЯЦІЇ З ВІКНАМИ

public class Windows {

    static WebDriver driver; // для универсальности доступа вынесли драйвер за пределы метода


    public static void main(String[] args) {// создали метод чтобы инициализировать драйвер GecoDriver для FF

        //System.setProperty("webdriver.gecko.driver", "D:\\workspace\\geckodriver\\geckodriver.exe");// Вказали путь до драйверу для браузеру ФФ
        System.setProperty("webdriver.chrome.driver", "D:\\workspace\\chromedriver\\chromedriver.exe");// Вказали шлях до драйверу браузеру Хром
        //driver = new FirefoxDriver();// инициализировали наш драйвер (FF драйвер)
        driver = new ChromeDriver(); //иніціалізували драйвер для браузеру Хром

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);//вказали неявне очікування

        //driver.manage().window().maximize(); // метод открывает в максимальном размере окно браузера
        driver.manage().window().setSize(new Dimension(1300, 700));


        //відкриєм ресурс для тестування
        driver.get("http://www.oracle.com/technetwork/java/javase/documentation/jdk8-doc-downloads-2133158.html");
        //driver.findElement(By.xpath("//*[@id=\"agreementDivjdk-8u171-apidocs-oth-JPR\"]/form/input[1]")).click();

        //знайдемо лінк по назві і клікнемо
        driver.findElement(By.xpath("//a[text()='Java SE Development Kit 8 Documentation License Agreement']")).click();
        String mainWindow = driver.getWindowHandle();//обявимо і присвоїмо перемінній mainWindow значення .gerWindowHandle

        for (String windowHandle:driver.getWindowHandles()){//цикл for перебирає значення які повертає метод .getWindowHandles
            driver.switchTo().window(windowHandle);//переключимось на//*[@id="Wrapper_FixedWidth_Centercontent"]/div[1]/div[3]/div/table[1]/tbody/tr[1]/th/a останнє вікно за допомогою .switchTi().window(вказати ім'я вікна)
        }
        driver.findElement(By.xpath("//*[@id=\"tabsample0\"]/li[3]/a")).click();
        driver.findElement(By.xpath("//span[text()=\"Documentation\"]")).click();

        driver.switchTo().window(mainWindow);//переключаємось на попереднє вікно

        driver.findElement(By.xpath("//*[@id=\"tabsample0\"]/li[6]/a/span")).click();
        

        /* Для того щоб переключатися між вікнами за допомогою цикла див. код внизу


        for (String windowHandle:driver.getWindowHandles()){//цикл for перебирає значення які повертає метод .getWindowHandles
            driver.switchTo().window(windowHandle);//переключимось на//*[@id="Wrapper_FixedWidth_Centercontent"]/div[1]/div[3]/div/table[1]/tbody/tr[1]/th/a останнє вікно за допомогою .switchTi().window(вказати ім'я вікна)
        }
        */


    }
}
