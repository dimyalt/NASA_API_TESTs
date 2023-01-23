import io.qameta.allure.junit4.DisplayName;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.notNullValue;

public class TestAPIRetrieveAListOfAsteroidsBasedOnTheirClosestApproachDateToEarth {
    private final String START_DATE_POSITIVE = "2023-01-01";
    private final String START_DATE_NEGATIVE = "2024-01-01";
    private final String END_DATE = "2023-01-02";
    private final String API_KEY = "ZCfZmZffzHjlNxLPPU2go6Y7YdRR2Dt9QR1V9KCC";

    @Before
    public void setUp(){
        RestAssured.baseURI = "https://api.nasa.gov/neo/rest/v1";
    }

    @Test
    @DisplayName("Проверка API списка астероидов")
    public void checkListOfAsteroids(){
        String api_request = "/feed?start_date=" + START_DATE_POSITIVE + "&end_date=" + END_DATE + "&api_key=" + API_KEY;
        given()
                .filter(new AllureRestAssured())
                .get(api_request)
                .then()
                .assertThat()
                .statusCode(200)
                .and()
                .body("element_count", notNullValue());
    }
    @Test
    @DisplayName("Проверка API Получение списка астероидов с ошибочной датой начала фомирования списка")
    public void checkListOfAsteroidsNegativeStartDate(){
        String api_request = "/feed?start_date=" + START_DATE_NEGATIVE + "&end_date=" + END_DATE + "&api_key=" + API_KEY;
        given()
                .filter(new AllureRestAssured())
                .get(api_request)
                .then()
                .assertThat()
                .statusCode(400)
                .and()
                .body("http_error", notNullValue());

    }
}
