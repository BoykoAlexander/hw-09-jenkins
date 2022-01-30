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

    String login = System.getProperty("login");
    String password = System.getProperty("password");
    String remote_url = System.getProperty("remote_url");

    Configuration.baseUrl = "https://demoqa.com";
    Configuration.browserSize = "1920x1080";
    Configuration.browser = System.getProperty("browser");
    Configuration.browserVersion = System.getProperty("browserVersion");
    //https://user1:1234@selenoid.autotests.cloud/wd/hub
    Configuration.remote = "https://" + login + ":" + password + "@" + remote_url;

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
