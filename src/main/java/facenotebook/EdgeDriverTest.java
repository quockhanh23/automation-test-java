package facenotebook;

import common.Constant;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EdgeDriverTest {

    private EdgeDriver edgeDriver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.edgedriver().setup();
        edgeDriver = new EdgeDriver();
        System.out.println("initialized EdgeDriver");
    }

    @Test
    public void run() {
        System.out.println("----------------Start running tests------------------");
        edgeDriver.get(Constant.FACE_NOTE_BOOK_WEB);
        System.out.println("----------------Finish running the test------------------");
    }

    @AfterMethod
    public void cleanUp() {
    }
}
