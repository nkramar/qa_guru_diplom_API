package api.tests;

import api.specs.Specifications;
import api.testdata.*;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static helpers.RestAssuredListener.withCustomTemplates;
import static io.restassured.RestAssured.given;

public class ReqresInApiTest {

  private final static String baseURL = "https://reqres.in/";

  @Tag("API")
  @Test
  @Owner("nkramar")
  @Feature("Аватар и email")
  @Story("Аватары с правильным id и окончание email пользователей")
  @Description("Получение списка со 2й страницы, проверка того, что имена файлов-аватаров содержат правильные id и " +
          "что email пользователей содержит окончание '@reqres.in'")
  @DisplayName("Проверка аватара на содержание правильного id и окончания email")
  public void checkAvatarAndIdTest() {

    Specifications.installSpecification(Specifications.requestSpec(baseURL), Specifications.responseSpec200());

    List<UserData> users = given()
            .filter(withCustomTemplates())
            .when()
            .get("api/users?page=2")
            .then().log().all()
            .extract().body().jsonPath().getList("data", UserData.class);

    users.forEach(x -> Assertions.assertTrue(x.getAvatar().contains(x.getId().toString())));
    Assertions.assertTrue(users.stream().allMatch(x -> x.getEmail().endsWith("@reqres.in")));

    List<String> avatars = users.stream().map(UserData::getAvatar).collect(Collectors.toList());
    List<String> ids = users.stream().map(x -> x.getId().toString()).collect(Collectors.toList());
  }
  @Tag("API")
  @Test
  @Owner("nkramar")
  @Feature("Регистрация пользователя")
  @Story("Успешная регистрания пользователя")
  @DisplayName("Проверка успешной регистрации пользователя")
  public void successfulRegistrationTest() {
    Specifications.installSpecification(Specifications.requestSpec(baseURL), Specifications.responseSpec200());

    Integer id = 4;
    String token = "QpwL5tke4Pnpja7X4";

    RegisterData user = new RegisterData("eve.holt@reqres.in", "pistol");
    SuccessfulRegData successfulReg = given()
            .filter(withCustomTemplates())
            .body(user)
            .when()
            .post("api/register")
            .then().log().all()
            .extract().as(SuccessfulRegData.class);
    Assertions.assertNotNull(successfulReg.getId());
    Assertions.assertNotNull(successfulReg.getToken());
    Assertions.assertEquals(id, successfulReg.getId());
    Assertions.assertEquals(token, successfulReg.getToken());
  }
  @Tag("API")
  @Test
  @Owner("nkramar")
  @Feature("Регистрация пользователя")
  @Story("Неуспешная регистрания пользователя")
  @DisplayName("Проверка неуспешной регистрации пользователя")
  public void unSuccessfulRegistrationTest() {
    Specifications.installSpecification(Specifications.requestSpec(baseURL), Specifications.responseSpecError400());

    RegisterData user = new RegisterData("sydney@fife", "");
    UnSuccessfulRegData unSuccessfulReg = given()
            .filter(withCustomTemplates())
            .body(user)
            .post("api/register")
            .then().log().all()
            .extract().as(UnSuccessfulRegData.class);
    Assertions.assertEquals("Missing password", unSuccessfulReg.getError());
  }
  @Tag("API")
  @Test
  @Owner("nkramar")
  @Feature("Сортировка возвращаемых данных")
  @Story("Операция LIST<RESOURCE> с сортировкой по годам")
  @Description("Проверка того, что операция LIST<RESOURCE> возвращает данные отсортированные по годам")
  @DisplayName("Проверка сортировки данных по годам")
  public void sortedYearsTest() {
    Specifications.installSpecification(Specifications.requestSpec(baseURL), Specifications.responseSpec200());
    List<ColorsData> colors = given()
            .filter(withCustomTemplates())
            .when()
            .get("api/unknown")
            .then().log().all()
            .extract().body().jsonPath().getList("data", ColorsData.class);
    List<Integer> years = colors.stream().map(ColorsData::getYear).collect(Collectors.toList());
    List<Integer> sortedYears = years.stream().sorted().collect(Collectors.toList());
    Assertions.assertEquals(sortedYears, years);
    System.out.println(years);
    System.out.println(sortedYears);
  }
  @Tag("API")
  @Test
  @Owner("nkramar")
  @Feature("Удаление пользователя")
  @Story("Успешное удаление пользователя")
  @DisplayName("Проверка удаления пользователя")
  public void deleteUserTest() {
    Specifications.installSpecification(Specifications.requestSpec(baseURL), Specifications.responseSpecUnique(204));
    given()
            .filter(withCustomTemplates())
            .when()
            .delete("api/users/2")
            .then().log().all();
  }

}

