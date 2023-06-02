package services;

import io.restassured.response.Response;
import utils.ServicesUtils;

public class DashboardServices {
    public Response ay7aga(){
        ServicesUtils.resetRequestDashboardBase();
        Response response = ServicesUtils.execute(System.getProperty("base.URL"),ServicesUtils.HttpMethod.GET);
        return response;
    }
}
