package com.csr.receive.comm;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * User: cdp
 * Date: 2018/6/29
 * Time: 14:42
 */
public class GlobalParam {
    private static String configFile="config.properties";

    //db param
    public static String DB_ADDRESS=getParam(configFile,"db_address");
    public static String DB_USER=getParam(configFile,"db_user");
    public static String DB_PWD=getParam(configFile,"db_pwd");
    public static String DB_DRIVER=getParam(configFile,"db_driver");

    //task for data
    public static String preMinute=getParam(configFile,"preMinute");
    public static String from_table=getParam(configFile,"from_table");
    public static String to_table=getParam(configFile,"to_table");
    public static String total_table=getParam(configFile,"total_table");

    //udp
    public static int upd_port=Integer.parseInt(getParam(configFile,"upd_port"));

    private  static String getParam(String fileName, String key) {
        Properties properties = new Properties();
        if (!fileName.startsWith("/")) {
            fileName = "/" + fileName;
        }

        InputStream is = GlobalParam.class.getResourceAsStream(fileName);

        try {
            properties.load(is);
            return properties.getProperty(key);
        } catch (IOException var5) {
            var5.printStackTrace();
            return null;
        }
    }
}
