package com.csr.receive.util;

/**
 * User: cdp
 * Date: 2018/7/11
 * Time: 11:26
 */
public class UpcaseChang {
    public static String change(String type,String s){
        if (type.equals("A")){
            return s.toUpperCase();
        }else if (type.equals("a")){
            return s.toLowerCase();
        }else {
            return null;
        }
    }
}
