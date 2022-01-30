package properties;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class SystemPropertiesTests {

//System.getProperty("key");
//    System.setProperty("key", "value");
  @Test
  @Tag("properties")
  void someTest1() {
    String browser = System.getProperty("browser", "chrome");
    String version = System.getProperty("version", "91");
    String browserSize = System.getProperty("browserSize", "300x300");
  }
}
