package gl.testing.tests;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeClass;

public class BasicSteps {

  @BeforeClass
  public void setUpChromeConfiguration() {
    Configuration.startMaximized=true;
  }

}
