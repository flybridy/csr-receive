package com.csr.receive.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * User: cdp
 * Date: 2018/7/3
 * Time: 15:52
 */
public class SCMUtil {
    private static Logger LOG= LoggerFactory.getLogger(SCMUtil.class);
    public static String[] getArrayFromSCM(String str) {
        if ((str == null) || (str.length() <= 0)) {
            LOG.info("getArrayListFromSCM is null");
            return null;
        }
        return str.split(";");
    }

    public static String[] getParamterFromArray(String str) {
        if ((str == null) || (str.length() <= 0)) {
            LOG.info("getParamterFromArray is null");
            return null;
        }
        return str.split(":");
    }

    public static String getSimpledDateTime() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(date);
    }

    public String inputStream2String(InputStream inputStream) {
        String line = null;
        StringBuilder stringBuilder = new StringBuilder();
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(System.getProperty("line.separator"));
                stringBuilder.append(line);
            }
            LOG.info(stringBuilder.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }
}
