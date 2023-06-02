package utils;

import java.io.*;
import java.util.Properties;

public class PropertyFileHandler {
    private String filePath;

    @Deprecated
    public PropertyFileHandler(){}

    public PropertyFileHandler(String filePath) throws IOException {
        this.filePath = filePath;
        loadPropertiesFile();
    }

    public void loadPropertiesFile() throws IOException {
        Properties properties = System.getProperties();

        try {
            properties.load(new FileInputStream(new File(filePath)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void setFilePath(String filePath){
        this.filePath = filePath;
    }

}
