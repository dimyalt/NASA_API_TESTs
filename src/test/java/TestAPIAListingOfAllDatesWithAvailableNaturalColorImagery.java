import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.notNullValue;

public class TestAPIAListingOfAllDatesWithAvailableNaturalColorImagery {
    private final String API_KEY = "ZCfZmZffzHjlNxLPPU2go6Y7YdRR2Dt9QR1V9KCC";
    private final String API_KEY_NEGATIVE = "D1E2M3A4P5I6K7E8Y9";
    @Before
    public void setUp(){
        RestAssured.baseURI = "https://api.nasa.gov/EPIC/api/natural";
    }
    @Test
    @DisplayName("Проверка API получения списка всех дат с доступными цветными снимками")
    public void checkListingOfData(){
        String api_request = "/all?api_key=" + API_KEY;
        given()
                .get(api_request)
                .then()
                .assertThat()
                .statusCode(200)
                .and()
                .body("date", notNullValue());
    }
    @Test
    @DisplayName("Проверка API получения списка всех дат с доступными цветными снимками при неправильном API_KEY")
    public void checkListingOfDataNegativeAPIKey(){
        String api_request = "/all?api_key=" + API_KEY_NEGATIVE;
        given()
                .get(api_request)
                .then()
                .assertThat()
                .statusCode(403)
                .and()
                .body("error", notNullValue());
    }
}
