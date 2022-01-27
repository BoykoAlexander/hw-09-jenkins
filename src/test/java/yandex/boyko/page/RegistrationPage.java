package yandex.boyko.page;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import yandex.boyko.page.components.CalendarComponents;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {

  public CalendarComponents calendarComponent = new CalendarComponents();

  SelenideElement
          firstNameInput = $("#firstName"),
          lastNameInput = $("#lastName"),
          emailInput = $("#userEmail"),


  phoneNumberInput = $("#userNumber"),
          subjectsInput = $("#subjectsInput"),
          checkResultForm = $(".table-responsive"),
          uploadFile = $("input#uploadPicture"),
          currentAdressInput = $("#currentAddress"),
          selectState = $("#react-select-3-input"),
          selectCity = $("#react-select-4-input"),
          clickButton = $("#submit");

  @Step("Открываем главную страницу")
  public RegistrationPage openPage() {
    open("https://demoqa.com/automation-practice-form");

    return this;
  }

  @Step("Ввод имени")
  public RegistrationPage inputFirstName(String firstName) {
    firstNameInput.setValue(firstName);

    return this;
  }

  @Step("Ввод фамилии")
  public RegistrationPage inputLastName(String lastName) {
    lastNameInput.setValue(lastName);

    return this;
  }

  @Step("Ввод почты")
  public RegistrationPage inputEmeil(String email) {
    emailInput.setValue(email);

    return this;
  }

  @Step("Выбор пола")
  public RegistrationPage putGender(String gender) {

    $(byText(gender)).click();
    return this;
  }

  @Step("Ввод контактного номера")
  public RegistrationPage inputPhoneNumber(String phoneNumber) {
    phoneNumberInput.setValue(phoneNumber);

    return this;
  }

  @Step("Ввод предмета")
  public RegistrationPage inputSubjects(String Subject) {
    subjectsInput.setValue(Subject).pressEnter();

    return this;
  }

  @Step("Выбор хобби")
  public RegistrationPage selectHobbies(String hobbies) {
    $(byText(hobbies)).click();

    return this;
  }

  @Step("Загрузка файла")
  public RegistrationPage uploadFileFromForm(String fileName) {
    uploadFile.uploadFromClasspath(fileName);

    return this;
  }

  @Step("Ввод текущего адреса")
  public RegistrationPage inputCurrentAdress(String currentAddress) {
    currentAdressInput.setValue(currentAddress);

    return this;
  }

  @Step("Выбор штата")
  public RegistrationPage selectStateInCheckbox(String selectState) {
    this.selectState.setValue(selectState).pressEnter();

    return this;
  }

  @Step("Выбор города")
  public RegistrationPage selectCityInCheckbox(String selectCity) {
    this.selectCity.setValue(selectCity).pressEnter();

    return this;
  }

  @Step("Нажатие отправки формы")
  public RegistrationPage clickButtonSubmit() {
    clickButton.click();
    return this;
  }

  @Step("Assert проверка")
  public RegistrationPage checkResultTable(String key, String value) {
    checkResultForm.$(byText(key)).parent().shouldHave(text(value));

    return this;
  }
}
