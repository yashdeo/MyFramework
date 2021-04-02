package com.eso.test.framework.Helpers;

import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class BuilderURL {
    FileReader reader;

    private static Properties properties;
    private static RemoteWebDriver webDriver;

}




/*


        Properties prop = BuilderURL.loadPropertiesFile("environment.properties");
        System.out.println(BuilderURL.loadPropertiesFile("environment.properties"));
        String profile = prop.getProperty("profile.path");

        if(profile.contains("dev")){
            properties = BuilderURL.loadPropertiesFile("profile/dev/config.properties");
        }

        if(profile.contains("FireFoxProfile")){
            properties = BuilderURL.loadPropertiesFile("FireFoxProfile/config.properties");
        }
    }
*/



   /* private static Properties loadPropertiesFile(String filePath) {
        Properties prop = new Properties();
        try (InputStream resourceAsStream = BuilderURL.class.getClassLoader().getResourceAsStream(filePath)) {
            prop.load(resourceAsStream);
        } catch (IOException e) {
            System.err.println("Unable to load properties file : " + filePath);
        }

        return prop;

    }
*/

