import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class Driver {
  private static Driver instance;
  private WebDriver driver;
  private WebDriverWait wait;
  private String URL;
  
  private final long WAIT_TIME_SECONDS = 10;
  
  private Driver(String URL) {
    // Set the driver path
    System.setProperty("webdriver.edge.driver", "D://edgedriver//msedgedriver.exe");

    this.driver = new EdgeDriver();
    this.URL = URL;
  }

  public static Driver getInstance(String URL) {
    if (instance == null)
      instance = new Driver(URL);
    return instance;
  } 

  public void get(){
    driver.get(URL);
    wait = new WebDriverWait(driver, WAIT_TIME_SECONDS);
  }

  public void quit(){
    driver.quit();
  }

  public WebElement findElementByCssSelector(String cssSelector) {
    return wait.until(presenceOfElementLocated(By.cssSelector(cssSelector)));
  }

  public WebElement findElementByClassName(String className) {
    return wait.until(presenceOfElementLocated(By.className(className)));
  }

}