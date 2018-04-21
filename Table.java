import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Alex on 4/15/2018.
 */

    //РОБОТА З ТАБЛИЦЯМИ


public class Table {
    private WebElement tableElement; //нашу таблицю з класу Main ми будемо передавати сюди
    private WebDriver driver;//створюємо перемінну драйвер

    //Створимо конструктор даного класу
    public Table (WebElement tableElement, WebDriver driver){//перерахували 2 перемінні з якими будемо працювати
        //формуємо конструктор
        this.tableElement = tableElement;//передаємо значення в клас мейн
        this.driver = driver;//передаємо значення в клас мейн

    }

    //напишемо методи для роботи з таблицями
    public List<WebElement> getRows (){
        List<WebElement> rows = tableElement.findElements(By.xpath(".//tr")); //отримаєм всі рядки з таблиці
        rows.remove(0); // видалимо 1 рядок з заголовками за допомогою метода remove
        return rows; //метод поверне ліст(список) з вебелементів

    }
    //напишемо метод для роботи з заголовками таблиці
    public List<WebElement> getHeadings(){
        WebElement headingRow = tableElement.findElement(By.xpath(".//tr[1]")); //створимо перемінну для рядка з заголовком
        List<WebElement> headingColumns = headingRow.findElements(By.xpath(".//th"));//знайдемо заголовки по тегу th
        return headingColumns;//метод який ми можемо використовувати щоб знайти наші заголовки
    }

    //розіб'ємо всі наші рядки на колонки

    public List<List<WebElement>> getRowsWithColomns(){
        List<WebElement> rows = getRows();//отримаємо всі рядки
        List<List<WebElement>> rowsWithColumns = new ArrayList<List<WebElement>>();//створили нову перемінну яка буде мати арейліст всіх вебелементів
        //створюємо цикл щоб пробігтися по всим рядкам таблиці
        for (WebElement row :rows){
            List<WebElement> rowWithColumns = row.findElements(By.xpath(".//td")); //кожеш список стопчиків в одному рядку записуєм в перемінну rowWithColumns
            rowsWithColumns.add(rowWithColumns);//тепер додаємо стрічку яка розбита на стопички в новий ліст
        }
        return rowsWithColumns;//повертаємо новий список нових рядків з стопчиками
    }

    public List<Map<String, WebElement>> getRowsWhithColumnsByHeadings(){ //ми створили ліст де кожен рядок це map
        // де string - заголовок, а WebElement конкретна ячейка

        List<List<WebElement>> rowsWithColumns = getRowsWithColomns();//отримаємо список всіх рядків розбитих на заголовки
        List<Map<String, WebElement>> rowsWithColumnsByHeadings =new ArrayList<Map<String, WebElement>>(); //метод буде повертати арей-ліст
        Map<String, WebElement> rowByHeadings; //це один рядок розбитий на стопчикики по заголовкам
        List<WebElement> headingColumns = getHeadings();//отримаєм наші заголовки

        for (List<WebElement> row : rowsWithColumns){//робимо цикл щоб пробігатися по всім заголовкам
            rowByHeadings = new HashMap<String, WebElement>();
            for (int i = 0; i < headingColumns.size(); i++){//цим циклом перебираємо всі колонки всередині заголовків, для того щоб отримати текст
                //заголову і привязати його до конкретної колонки
                String heading = headingColumns.get(i).getText();
                WebElement cell = row.get(i);//створюємо перемінну cell і присвоюємо їй ячейку в рядку
                rowByHeadings.put(heading, cell);//поміщаємо заголовок і ячейку в вже створену мапу, тобто прив'язуємо їх щоб вони були рядком
                //так буде працювати для кожного рядка
            }
            rowsWithColumnsByHeadings.add(rowByHeadings);//коли виходимо кожного разу із циклу, то додаємо новий рядок в нову мапу(стрінка)
            //доки ми не пройдемося по всім рядкам. Ми отримаєм ліст із мапів
        }
        return rowsWithColumnsByHeadings;//повертаємо мапу


    }

    public String getValueFromCell(int rowNumber, int columnNumber){//метод який буде приймати номер рядка та номер стопчика
        //тобто по номеру рядка або стопчика ми можемо звертатися до елементу таблиці і отримувати її значенняи
        List<List<WebElement>> rowsWithColumns = getRowsWithColomns(); //створили перемінну і використали готовий метод, щоб отримати список списку стопчиків
        WebElement cell = rowsWithColumns.get(rowNumber - 1).get(columnNumber -1);//створюємо перемінну cell щоб записати туди номер рядка і стопчика
        return cell.getText();//повертаємо методом get.Text текст в котонці

    }
    public String getValueFromCell(int rowNumber, String columnName) {//метод який буде приймати номер рядка та номер стопчика
        //тобто по номеру рядка або стопчика ми можемо звертатися до елементу таблиці і отримувати її значенняи
        List<Map<String, WebElement>> rowsWhithColumnsByHeadings = getRowsWhithColumnsByHeadings();//отримаємо всі строки із стопчиками з
        //прив'язаними до них заголовками
        return rowsWhithColumnsByHeadings.get(rowNumber - 1).get(columnName).getText();


    }

}
