package org.example;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import services.DashboardServices;
import utils.PropertyFileHandler;

import java.io.IOException;

import static org.junit.Assert.assertTrue;

public class AppTest {

    public PropertyFileHandler propertyFileHandler;

    public void loadPropertiesFile() throws IOException {
        propertyFileHandler = new PropertyFileHandler();
        propertyFileHandler.setFilePath("src/test/java/resources/resources.properties");
        propertyFileHandler.loadPropertiesFile();
    }
    @BeforeClass
    public void init() throws IOException {
        loadPropertiesFile();
    }

    @Test
    public void btngan(){
        DashboardServices dashboardServices = new DashboardServices();
        dashboardServices.ay7aga();
    }
}
