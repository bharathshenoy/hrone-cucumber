package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ApplicationFileReader {

    private final Properties applicationProperties;

    public ApplicationFileReader()  {
        applicationProperties = new Properties();
        try {
            FileInputStream fileInputStream = new FileInputStream("src/main/resources/application.properties");
            applicationProperties.load(fileInputStream);
            fileInputStream.close();
        }
        catch (Exception ignored){

        }
    }

    public String getUsername(){
        return applicationProperties.getProperty("username");
    }

    public String getPassword(){
        return applicationProperties.getProperty("password");
    }

    public String getBrowser(){
        return applicationProperties.getProperty("browser");
    }

    public String getLoginLink(){
        return applicationProperties.getProperty("loginLink");
    }

    public String getHomePageLink(){
        return applicationProperties.getProperty("homePageLink");
    }
}
