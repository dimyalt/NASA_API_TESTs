public class DataForTest {

    private final String asteroidName = "Icarus";
    private final String asteroidId = "2001566";
    private final String API_KEY = "ZCfZmZffzHjlNxLPPU2go6Y7YdRR2Dt9QR1V9KCC";
    private final String BASE_URL = "https://api.nasa.gov/neo/rest/v1/neo";
    // Idea подсказывает, что переменные можно переместить в геттеры, но мне кажется
    // если надо будет что-то изменить, удобнее найти в списке переменных, чем листать код
    // в поисках нужного геттера
    public DataForTest(){

    }
    public String getAPI_KEY() {
        return API_KEY;
    }
    public String getAsteroidName() {
        return asteroidName;
    }
    public String getAsteroidId() {
        return asteroidId;
    }
    public String getBASE_URL() {
        return BASE_URL;
    }
}
