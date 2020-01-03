import io.appium.java_client.windows.WindowsDriver;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

public class CalculatorTest {
  private static WindowsDriver CalculatorSession = null;
  private static WebElement CalculatorResult = null;

  @BeforeClass
  public static void SetUp(){
    try{
      DesiredCapabilities capabilities = new DesiredCapabilities();
      capabilities.setCapability("app", "Microsoft.WindowsCalculator_8wekyb3d8bbwe!App");
      CalculatorSession = new WindowsDriver(new URL("http://127.0.0.1:4724"), capabilities);
      CalculatorSession.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);

      CalculatorResult = CalculatorSession.findElementByAccessibilityId("CalculatorResults"); //AutomationId in the inspector
      Assert.assertNotNull(CalculatorResult);
    }catch(MalformedURLException e) {
      e.printStackTrace();
    }
  }

  @Before
  public void Clear(){
    CalculatorSession.findElementByAccessibilityId("clearButton").click();
    Assert.assertEquals("0", getResult());
  }


  @Test
  public void AdditionTest(){
    CalculatorSession.findElementByAccessibilityId("num1Button").click();
    CalculatorSession.findElementByAccessibilityId("plusButton").click();
    CalculatorSession.findElementByAccessibilityId("num7Button").click();
    CalculatorSession.findElementByAccessibilityId("equalButton").click();
    Assert.assertEquals("8", getResult());
  }



  @AfterClass
  public static void TearDown(){
   CalculatorSession.closeApp();
  }

  private String getResult() {
    return CalculatorSession.findElementByAccessibilityId("CalculatorResults").getText().replace("Display is", "").trim();
  }

}
