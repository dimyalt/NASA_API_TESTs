import io.qameta.allure.junit4.DisplayName;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.notNullValue;

public class TestAPIMarsWeatherService {
    private final String API_KEY = "ZCfZmZffzHjlNxLPPU2go6Y7YdRR2Dt9QR1V9KCC";
    private final String FEED = "json&ver=1.0";

    @Before
    public void setUp(){
        RestAssured.baseURI = "https://api.nasa.gov/insight_weather";
    }
    @Test
    @DisplayName("Проверка API погоды на Марсе")
    public void checkMarsWeather(){
        String api_request = "/?api_key=" + API_KEY + "&feedtype=" + FEED;
        given()
                .filter(new AllureRestAssured())
                .get(api_request)
                .then()
                .assertThat()
                .statusCode(200)
                .and()
                .body("validity_checks", notNullValue());
    }
}
