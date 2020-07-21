package base;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;

import java.util.Map;

/** Send requests and parse response
 * @author Nandish Siddaiah
 * @version 1.0
 * @since 1.0
 */
public class RestBase {

    /**
     * Send POST request
     * @param url String
     * @param path String
     * @param headers Map
     * @param body Map
     * @return Response
     */
    public Response POST(String url, String path, Map<String, String> headers, Map<String, Object> body ){
        RestAssured.baseURI = url;
        return RestAssured.given().
                when().headers(headers).
                and().body(body).
                then().post(path).thenReturn();
    }

    /**
     * Send GET request
     * @param url String
     * @param path String
     * @param headers String
     * @return Response
     */
    public Response GET(String url, String path, Map<String, String> headers){
        RestAssured.baseURI = url;
        return RestAssured.given().headers(headers).
                then().get(path).thenReturn();
    }

    /**
     * Overloaded method to send POST request
     * @param url String
     * @param path String
     * @param headers Map
     * @return Response
     */
    public Response POST(String url, String path, Map<String, String> headers){
        RestAssured.baseURI = url;
        return RestAssured.given().
                when().headers(headers).
                and().
                then().post(path).thenReturn();
    }

    /**
     * Overloaded method to send POST request
     * @param url String
     * @param path String
     * @param headers Map
     * @param body String
     * @return Response
     */
    public Response POST(String url, String path, Map<String, String> headers, String body){
        RestAssured.baseURI = url;
        return RestAssured.given().
                when().headers(headers).
                and().body(body).
                then().post(path).thenReturn();
    }

    /**
     * Overloaded method to send POST request
     * @param url String
     * @param path String
     * @param body String
     * @return Response
     */
    public Response POST(String url, String path, String body){
        RestAssured.baseURI = url;
        return RestAssured.given().
                when().body(body).
                then().post(path).thenReturn();
    }

    /**
     * Overloaded method to send POST request
     * @param url String
     * @param path String
     * @param headers Map
     * @param body String
     * @param queryStringParameters Map
     * @return Response
     */
    public Response POST(String url, String path, Map<String, String> headers, String body, Map<String, String> queryStringParameters){
        RestAssured.baseURI = url;
        return RestAssured.given().
                when().headers(headers).and().queryParams(queryStringParameters).
                and().body(body).
                then().post(path).thenReturn();
    }

    /**
     * Overloaded method to send POST request
     * @param url String
     * @param path String
     * @param headers Map
     * @param queryStringParameters Map
     * @return Response
     */
    public Response GET(String url, String path, Map<String, String> headers,  Map<String, String> queryStringParameters){
        RestAssured.baseURI = url;
        return RestAssured.given().when().headers(headers).and().queryParams(queryStringParameters).
                then().get(path).thenReturn();
    }

    /**
     * Overloaded method to send POST request
     * @param url String
     * @param path String
     * @return Response
     */
    public Response GET(String url, String path){
        RestAssured.baseURI = url;
        return RestAssured.given().
                then().get(path).thenReturn();
    }

    /**
     *
     * @param url
     * @param path
     * @param headers
     * @return
     */
    public Response DELETE(String url, String path, Map<String, String> headers){
        RestAssured.baseURI = url;
        return RestAssured.given().headers(headers).
                then().delete(path).thenReturn();
    }

    /**
     * Send DELETE request
     * @param url String
     * @param path String
     * @param headers Map
     * @param queryParameters Map
     * @return Response
     */
    public Response DELETE(String url, String path, Map<String, String> headers, Map<String, String> queryParameters){
        RestAssured.baseURI = url;
        return RestAssured.given().when().headers(headers).and().queryParams(queryParameters).
                then().delete(path).thenReturn();
    }

    /**
     * Send PUT request
     * @param url String
     * @param path String
     * @param headers Map
     * @param body String
     * @return Response
     */
    public Response PUT (String url, String path, Map<String, String> headers, String body){
        RestAssured.baseURI = url;
        return RestAssured.given().
                when().headers(headers).
                and().body(body).
                then().put(path).thenReturn();

    }

    /**
     * Overloaded method to send PUT request
     * @param url
     * @param path
     * @param headers
     * @return
     */
    public Response PUT (String url, String path, Map<String, String> headers){
        RestAssured.baseURI = url;
        return RestAssured.given().
                when().headers(headers).
                and().
                then().put(path).thenReturn();

    }
}