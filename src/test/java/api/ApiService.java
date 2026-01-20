package api;

import io.restassured.response.Response;
import utils.ConfigReader;

public class ApiService
{
    public static Response getCarList(String endpoint)
    {
        String baseUrl = ConfigReader.getProperty("api.baseUrl");
        //String endpoint = ConfigReader.getProperty("api.get");
        return ApiClient.get(baseUrl+endpoint);
    }
}
