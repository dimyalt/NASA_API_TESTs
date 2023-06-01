import io.qameta.allure.junit4.DisplayName;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import org.junit.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.hasItems;

public class TestPresenceOfAsteroidInTheList {
    @Test
    @DisplayName("Проверка API получения общего набора данных об астероидах и поиск конкретного астероида")
    public void checkBrowseDataSetAndSearchAsteroid(){
        DataForTest testData = new DataForTest();
        RestAssured.baseURI = testData.getBASE_URL();
        given()
                .filter(new AllureRestAssured())
                .get("/browse?api_key="+testData.getAPI_KEY())
                .then()
                //.log().all()
                .assertThat()
                .statusCode(200)
                .and()
                .body(("near_earth_objects.id"), hasItems(testData.getAsteroidId()))
                .and()
                .body(("near_earth_objects.name_limited"), hasItems(testData.getAsteroidName()));
    }

}
