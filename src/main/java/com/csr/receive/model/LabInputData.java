package com.csr.receive.model;

/**
 * User: cdp
 * Date: 2018/7/3
 * Time: 15:58
 * 源数据入库
 */
public class LabInputData
{
    private Integer id;
    private String inputProbeNumber;
    private String disprobenumber;
    private String createdOn;
    private Double temperature;
    private Double Humidity;
    private String dispalyName;

    public LabInputData(String inputProbeNumber, String createdOn, Double temperature, Double humidity, String dispalyName) {
        this.inputProbeNumber = inputProbeNumber;
        this.createdOn = createdOn;
        this.temperature = temperature;
        Humidity = humidity;
        this.dispalyName = dispalyName;
    }

    public String getInputProbeNumber() {
        return inputProbeNumber;
    }

    public void setInputProbeNumber(String inputProbeNumber) {
        this.inputProbeNumber = inputProbeNumber;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public Double getHumidity() {
        return Humidity;
    }

    public void setHumidity(Double humidity) {
        Humidity = humidity;
    }

    public String getDispalyName() {
        return dispalyName;
    }

    public void setDispalyName(String dispalyName) {
        this.dispalyName = dispalyName;
    }
}
