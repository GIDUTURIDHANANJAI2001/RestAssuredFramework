package Utiles;


import com.google.gson.Gson;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

public class utils {

    public static String convertObjectToJson(final Object payload) {
//to print request--->
        Gson gson  = new Gson();
        return gson.toJson(payload);
    }



//    for giving BASEURL

    public static RequestSpecification givenHeader() {
        RequestSpecification returnValue = null;
        try {
            PrintStream log = new PrintStream(new FileOutputStream("logging.txt", true));
            returnValue = new RequestSpecBuilder().setBaseUri(getGlobalValues("baseUrl"))
                    // .addHeader("Authorization", getGlobalValues("authToken"))
                    .addFilter(RequestLoggingFilter.logRequestTo(log))
                    .addFilter(ResponseLoggingFilter.logResponseTo(log)).setContentType(ContentType.JSON).build();
        } catch (IOException ie) {
            ie.printStackTrace();
        }
        return returnValue;
    }
    public static String getGlobalValues(String key) {
        Properties prop = new Properties();
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(
                    System.getProperty("user.dir") + "\\src\\test\\resources\\application.properties");
            prop.load(fis);
        } catch (IOException ie) {
            ie.printStackTrace();
        }
        return prop.getProperty(key);

    }



}
