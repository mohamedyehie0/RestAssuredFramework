package utils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import java.util.HashMap;
import static io.restassured.RestAssured.given;

public class ServicesUtils {
    public static RequestSpecification request = given().accept(ContentType.JSON);

    public static HashMap resetRequest(){
        request = null;
        HashMap<String, String> headers = new HashMap<>();
        headers.put("Content-Type","application/json");
        headers.put("Accept","*/*");
        headers.put("Accept-Language","en-us");

        RequestSpecBuilder builder = new RequestSpecBuilder();
        builder.setContentType(ContentType.JSON);

        request = given().spec(builder.build());

        return headers;
    }

    public static void resetRequestDashboardBase(){
        HashMap<String, String> headers;
        headers = resetRequest();
        request.headers(headers);
    }

    public static void setPathParam(String key, String value){
        request.given().pathParam(key, value);
    }
    public static void setQueryParam(String key, String value){request.given().queryParam(key, value);}
    public static void updateHeader(String key, String value){request.headers(key, value);}


    public static RequestSpecification requestBodyBuilder(Object body){
        return request.body(body);
    }

    public enum HttpMethod{
        GET("get"), POST("post"), DELETE("delete"), PUT("put"), PATCH("patch");

        private String method;
        HttpMethod(String method){this.method = method;}
        public String getMethod(){return method;}
    }

    public static Response execute(String endpoint, HttpMethod method){
        Response response = null;
        switch (method){
            case POST: {
                response = request.post(endpoint);
                break;
            }
            case PUT: {
                response = request.put(endpoint);
                break;
            }
            case PATCH: {
                response = request.patch(endpoint);
                break;
            }
            case DELETE: {
                response = request.delete(endpoint);
                break;
            }
            default:
            case GET: {
                response = request.get(endpoint);
                break;
            }
        }
        response.prettyPrint();
        response.getStatusCode();

        return response;
    }
}
