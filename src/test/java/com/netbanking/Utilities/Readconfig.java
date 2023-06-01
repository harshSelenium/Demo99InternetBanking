package com.netbanking.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class Readconfig {
    Properties prop;

    public Readconfig(){
        File configfile = new File("C:\\Users\\new user\\IdeaProjects\\Internetbankingdemo99\\src\\Configurations\\config.properties");
        try{
            FileInputStream fis= new FileInputStream(configfile);
            prop = new Properties();
            prop.load(fis);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public String getUrl(){
        String baseurl=prop.getProperty("baseURL");
        return baseurl;
    }
    public String getUserName(){
        return prop.getProperty("userName");
    }
    public String getPassword(){
        return prop.getProperty("Password");
    }
    public String getBrowser(){
        return prop.getProperty("Browser");
    }
}
