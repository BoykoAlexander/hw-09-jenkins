package yandex.boyko.page.components;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TestBase {
  @BeforeAll
  static void beforeAll() {
    SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

    String login = System.getProperty("login","user1");
    String password = System.getProperty("password", "1234");
    String remote_url = System.getProperty("remote_url", "selenoid.autotests.cloud/wd/hub");

    Configuration.browserSize = "1920x1080";
    Configuration.browser = System.getProperty("browser", "chrome");
    Configuration.browserVersion = System.getProperty("browserVersion", "92");

    Configuration.remote = "https://" + login + ":" + password + "@" + remote_url;
    //Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";

    DesiredCapabilities capabilities = new DesiredCapabilities();
    capabilities.setCapability("enableVNC", true);
    capabilities.setCapability("enableVideo", true);
    Configuration.browserCapabilities = capabilities;

  }

  @AfterEach
  void Attachments() {
    Attach.screenshotAs("Last screenshot");
    Attach.pageSource();
    Attach.browserConsoleLogs();
    Attach.addVideo();
    Selenide.closeWebDriver();
  }
}
