package com.csr.receive.model;

import com.csr.receive.util.UpcaseChang;

import java.util.Date;

/**
 * User: cdp
 * Date: 2018/7/11
 * Time: 11:14
 */
public class LabProbe {
    private String inputprobenumber;
    private String displayprobenumber;
    private Date create_time;
    private String ab_inputname;
    private String tab_displayname;
    private String tab_three;
    private double k_temperature;
    private double b_humidity;
    private double k_humidity;
    private double b_temperature;
    private int is_use;
    private double h_max;
    private double h_min;
    private double t_max;
    private double t_min;

    public LabProbe(String inputprobenumber, String displayprobenumber, Date create_time, String ab_inputname, String tab_displayname, String tab_three, double k_temperature, double b_humidity, double k_humidity, double b_temperature, int is_use, double h_max, double h_min, double t_max, double t_min) {
        this.inputprobenumber = inputprobenumber;
        this.displayprobenumber = displayprobenumber;
        this.create_time = create_time;
        this.ab_inputname = ab_inputname;
        this.tab_displayname = tab_displayname;
        this.tab_three = tab_three;
        this.k_temperature = k_temperature;
        this.b_humidity = b_humidity;
        this.k_humidity = k_humidity;
        this.b_temperature = b_temperature;
        this.is_use = is_use;
        this.h_max = h_max;
        this.h_min = h_min;
        this.t_max = t_max;
        this.t_min = t_min;
    }

    public String getInputprobenumber() {
        return inputprobenumber;
    }

    public void setInputprobenumber(String inputprobenumber) {
        this.inputprobenumber = inputprobenumber;
    }

    public String getDisplayprobenumber() {
        return displayprobenumber;
    }

    public void setDisplayprobenumber(String displayprobenumber) {
        this.displayprobenumber = displayprobenumber;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public String getAb_inputname() {
        return ab_inputname;
    }

    public void setAb_inputname(String ab_inputname) {
        this.ab_inputname = ab_inputname;
    }

    public String getTab_displayname() {
        return tab_displayname;
    }

    public void setTab_displayname(String tab_displayname) {
        this.tab_displayname = tab_displayname;
    }

    public String getTab_three() {
        return tab_three;
    }

    public void setTab_three(String tab_three) {
        this.tab_three = tab_three;
    }

    public double get_temperature() {
        return k_temperature;
    }

    public void set_temperature(double k_temperature) {
        this.k_temperature = k_temperature;
    }

    public double getB_humidity() {
        return b_humidity;
    }

    public void setB_humidity(double b_humidity) {
        this.b_humidity = b_humidity;
    }

    public double getK_humidity() {
        return k_humidity;
    }

    public void setK_humidity(double k_humidity) {
        this.k_humidity = k_humidity;
    }

    public double getB_temperature() {
        return b_temperature;
    }

    public void setB_temperature(double b_temperature) {
        this.b_temperature = b_temperature;
    }

    public int getIs_use() {
        return is_use;
    }

    public void setIs_use(int is_use) {
        this.is_use = is_use;
    }

    public double getH_max() {
        return h_max;
    }

    public void setH_max(double h_max) {
        this.h_max = h_max;
    }

    public double getH_min() {
        return h_min;
    }

    public void setH_min(double h_min) {
        this.h_min = h_min;
    }

    public double getT_max() {
        return t_max;
    }

    public void setT_max(double t_max) {
        this.t_max = t_max;
    }

    public double getT_min() {
        return t_min;
    }

    public void setT_min(double t_min) {
        this.t_min = t_min;
    }

    public static void main(String[] args) {
        System.out.println(UpcaseChang.change("a", "IS_USE"));
    }
}
