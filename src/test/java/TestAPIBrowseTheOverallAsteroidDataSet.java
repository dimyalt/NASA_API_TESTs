import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.notNullValue;

public class TestAPIBrowseTheOverallAsteroidDataSet {
    @Before
    public void setUp(){
        RestAssured.baseURI = "https://api.nasa.gov/neo/rest/v1/neo";
    }

    @Test
    @DisplayName("Проверка API получения общего набора данных об астероидах")
    public void checkBrowseDataSet(){
        given()
                .get("/browse?api_key=ZCfZmZffzHjlNxLPPU2go6Y7YdRR2Dt9QR1V9KCC")
                .then()
                .assertThat()
                .statusCode(200)
                .and()
                .body("near_earth_objects", notNullValue());

    }
}
