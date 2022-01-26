package yandex.boyko.page.components;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponents {
  public void setDate() {
    $("#submit").scrollTo();
    $("#dateOfBirthInput").click();
    $(".react-datepicker__month-select").selectOptionByValue("4");
    $(".react-datepicker__year-select").selectOptionByValue("1994");
    $("[aria-label=\"Choose Monday, May 23rd, 1994\"]").click();
  }
}
