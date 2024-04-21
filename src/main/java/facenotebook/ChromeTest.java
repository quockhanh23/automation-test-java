package facenotebook;

import common.Constant;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;

public class ChromeTest {

    private ChromeDriver chromeDriver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        chromeDriver = new ChromeDriver();
        System.out.println("initialized ChromeDriver");
    }

    @Test
    public void run() {
        System.out.println("----------------Start running tests------------------");
        chromeDriver.get(Constant.FACE_NOTE_BOOK_WEB);

        // Refresh lại trang web
//        chromeDriver.navigate().refresh();
//        chromeDriver.navigate().back();
//        chromeDriver.navigate().forward();

        chromeDriver.getCurrentUrl();

        // Lấy toàn bộ source code HTML trên trang web
        chromeDriver.getPageSource();

        WebElement element = chromeDriver.findElement(By.id("showLogin"));
        element.click();

        WebElement username = chromeDriver.findElement(By.id("alo"));
        username.sendKeys("khanh");

        WebElement password = chromeDriver.findElement(By.id("my-password"));
        password.sendKeys("123456");

//        WebElement loginButton = chromeDriver.findElement(By.id("loginButton"));
//        loginButton.click();

        List<WebElement> list = chromeDriver.findElements(By.tagName("BUTTON"));
        Collections.reverse(list);
        for (int i = 0; i < list.size(); i++) {
            String text = list.get(i).getText();

            // Nếu kết quả đúng nhưng không vào khối code thì lỗi do biên dịch không đọc được UTF-8
            if ("Đăng nhập".equals(text)) {
                list.get(i).click();
                break;
            }
        }
        System.out.println("----------------Finish running the test------------------");
    }

    @AfterMethod
    public void cleanUp() {
    }
}
