import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


public class TestRule {
    static WebDriver driver;
    final private String URL = "https://www.google.com";
    private ITestResult result;

    @BeforeClass
    public static void setupTest(){
        driver = new ChromeDriver();
    }

    @Rule
    public Retry retryRule = new Retry(4);


    @Test
    public void getURLExample() {
        driver.get(URL);
        assertThat(driver.getTitle(), is("Ggle"));
    }
    @AfterClass
    public static void verification(){
        driver.close();
        driver.quit();
    }
}
