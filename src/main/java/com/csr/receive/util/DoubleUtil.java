package com.csr.receive.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

/**
 * User: cdp
 * Date: 2018/7/3
 * Time: 15:55
 */
public class DoubleUtil {
    private static final Integer DEF_DIV_SCALE = Integer.valueOf(2);
private static Logger LOG= LoggerFactory.getLogger(DoubleUtil.class);
    public static void main(String[] args) {
        Double x = Double.valueOf(1.0D);
        Double y = Double.valueOf(3.0D);
        LOG.info(getDoubleToStringValueByBigDecimalDiv(x, y));
        LOG.info((x.doubleValue() + y.doubleValue())+"");

    }

    public static String getDoubleValueByBigDecimalAdd(Double x, Double y) {
        BigDecimal x1 = new BigDecimal(Double.toString(x.doubleValue()));
        BigDecimal y1 = new BigDecimal(Double.toString(y.doubleValue()));
        return x1.add(y1).toString();
    }

    public static String getDoubleToStringValueByBigDecimalSub(Double x, Double y) {
        BigDecimal x1 = new BigDecimal(Double.toString(x.doubleValue()));
        BigDecimal y1 = new BigDecimal(Double.toString(y.doubleValue()));
        return x1.subtract(y1).toString();
    }

    public static String getDoubleToStringValueByBigDecimalMul(Double x, Double y) {
        BigDecimal x1 = new BigDecimal(Double.toString(x.doubleValue()));
        BigDecimal y1 = new BigDecimal(Double.toString(y.doubleValue()));
        return x1.multiply(y1).toString();
    }

    public static String getDoubleToStringValueByBigDecimalDiv(Double x, Double y) {
        BigDecimal x1 = new BigDecimal(Double.toString(x.doubleValue()));
        BigDecimal y1 = new BigDecimal(Double.toString(y.doubleValue()));
        LOG.info(x1.divide(y1)+"");
        return x1.divide(y1, 2, 5).toString();
    }
}

