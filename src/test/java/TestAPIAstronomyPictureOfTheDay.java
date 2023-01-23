import io.qameta.allure.junit4.DisplayName;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.notNullValue;

public class TestAPIAstronomyPictureOfTheDay {
    @Before
    public void setUp(){
        RestAssured.baseURI = "https://api.nasa.gov/planetary";
    }
    @Test
    @DisplayName("Проверка API получения фотографии дня")
    public void checkAPOD(){
        given()
                .filter(new AllureRestAssured())
                .get("/apod?api_key=ZCfZmZffzHjlNxLPPU2go6Y7YdRR2Dt9QR1V9KCC")
                .then()
                .assertThat()
                .statusCode(200)
                .and()
                .body("hdurl", notNullValue());

    }
}
