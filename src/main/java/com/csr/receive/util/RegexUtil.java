package com.csr.receive.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * User: cdp
 * Date: 2018/7/3
 * Time: 15:54
 */
public class RegexUtil {

    private static Logger LOG= LoggerFactory.getLogger(RegexUtil.class);
    public static void main(String[] args) {
        LOG.info("Start");
        String str = "+YAV:0005AABB,000 000 000 007 001 ,000 000 000 007 001 ,007 001 007 000 000 ,009 001 008 000 000 ,000 000 004 000 000 ,004 000 008 001 003 ,001 005 004 000 002 ,008 00C 00B 008 008 ,0 0,0 0,0 0 0 0,00,FF0203FF,V V V V V V V V,8AD00001,X,EEFF";

        getParams(str);
        LOG.info("boardNumber: " + getBoardNumber(str));
        LOG.info(getParams(str));
    }

    public static String getParams(String str) {
        Map<String, Double> paramsMap = new TreeMap();
        Double[] params = new Double[8];
        String pattern = ",[0-9A-F]{3}\\s";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(str);
        int index = 0;

        String[] probeNum = {"01", "02", "03", "04"};
        String boardNumber = getBoardNumber(str);
        StringBuffer paramStr = new StringBuffer();
        while (m.find()) {
            if (index == 0) {
                paramStr.append(boardNumber + probeNum[0] + ":" +
                        getTemperatureByVol(getVoltagesParam(hex2Decimal(m.group().substring(1, 4)))));
            } else if (index == 1) {
                paramStr.append(":" + getHumidityByVol(getVoltagesParam(hex2Decimal(m.group().substring(1, 4)))) + ";");
            } else if (index == 2) {
                paramStr.append(boardNumber + probeNum[1] + ":" +
                        getTemperatureByVol(getVoltagesParam(hex2Decimal(m.group().substring(1, 4)))));
            } else if (index == 3) {
                paramStr.append(":" + getHumidityByVol(getVoltagesParam(hex2Decimal(m.group().substring(1, 4)))) + ";");
            } else if (index == 4) {
                paramStr.append(boardNumber + probeNum[2] + ":" +
                        getTemperatureByVol(getVoltagesParam(hex2Decimal(m.group().substring(1, 4)))));
            } else if (index == 5) {
                paramStr.append(":" + getHumidityByVol(getVoltagesParam(hex2Decimal(m.group().substring(1, 4)))) + ";");
            } else if (index == 6) {
                paramStr.append(boardNumber + probeNum[3] + ":" +
                        getTemperatureByVol(getVoltagesParam(hex2Decimal(m.group().substring(1, 4)))));
            } else if (index == 7) {
                paramStr.append(":" + getHumidityByVol(getVoltagesParam(hex2Decimal(m.group().substring(1, 4)))) + ";");
            }
            index++;
        }
        return paramStr.toString();
    }

    public static String getBoardNumber(String str) {
        String strings = "";
        String pattern = "8AD[0-9]{5}";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(str);
        if (m.find()) {
            strings = m.group().toString();
        }
        return strings;
    }

    public static Double hex2Decimal(String str) {
        Integer num = Integer.valueOf(0);
        num = Integer.valueOf(Integer.parseInt(str, 16));
        return Double.valueOf(num.doubleValue());
    }

    public static Double getVoltagesParam(Double params) {
        double vol = params.doubleValue() * 10.0D / 4095.0D;
        DecimalFormat df = new DecimalFormat("0.000");
        Double.parseDouble(df.format(vol));

        return Double.valueOf(Double.parseDouble(df.format(vol)));
    }

    public static Double getHumidityByVol(Double param) {
        BigDecimal k = new BigDecimal(10);
        BigDecimal x = new BigDecimal(Double.toString(param.doubleValue()));
        return Double.valueOf(x.multiply(k).doubleValue());
    }

    public static Double getTemperatureByVol(Double param) {
        BigDecimal k = new BigDecimal(10);
        BigDecimal b = new BigDecimal(20);
        BigDecimal x = new BigDecimal(Double.toString(param.doubleValue()));
        return Double.valueOf(x.multiply(k).subtract(b).doubleValue());
    }
}