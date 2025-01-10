package utils;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.util.List;

import static io.restassured.RestAssured.given;

public class ApiClient {

    public static <T> T getRequest(String endpoint, Class<T> responseType) {
        return given().when().get(endpoint).then().extract().as(responseType);
    }

    public static <T> List<T> getListRequest(String endpoint, String jsonPathParam, Class<T> responseType) {
        Response response = RestAssured.when().get(endpoint);

        JsonPath jsonPath = response.jsonPath();
        return jsonPath.getList(jsonPathParam, responseType);
    }

    public static <T> T postRequest(String endpoint, Object requestBody, Class<T> responseType) {
        return given().body(requestBody).when().post(endpoint).then().extract().as(responseType);
    }

    public static String postRequestNoPojoResponse(String endpoint, Object requestBody, String jsonPathParam) {
        Response response = given().body(requestBody).when().post(endpoint);

        JsonPath jsonPath = response.jsonPath();
        return jsonPath.getString(jsonPathParam);
    }

    public static void deleteRequest(String endpoint) {
        given().when().delete(endpoint).then().assertThat();
    }
}

