import io.qameta.allure.junit4.DisplayName;
import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.notNullValue;

public class TestAPIMarsPhoto {
    private final String API_KEY = "ZCfZmZffzHjlNxLPPU2go6Y7YdRR2Dt9QR1V9KCC";
    private final String DATE = "2023-1-1";

    @Before
    public void setUp(){
        RestAssured.baseURI = "https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity";
    }
    @Test
    @DisplayName("Проверка API получения фото с Марса")
    public void photoFromMars(){
        String api_request = "/photos?earth_date=" + DATE + "&api_key=" + API_KEY;
        given()
                .get(api_request)
                .then()
                .assertThat()
                .statusCode(200)
                .and()
                .body("photos.img_src", notNullValue());
    }

}
