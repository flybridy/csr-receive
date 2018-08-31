package com.csr.receive.model;

/**
 * User: cdp
 * Date: 2018/7/3
 * Time: 15:57
 */
public class LabDisplayParamter
{
    private Integer id;
    private String inputProbeNumber;
    private String disProbeNumber;
    private String createdOn;
    private Double disTemperature;
    private Double disHumidity;
    private String displayTableName;

    public String getDisplayTableName()
    {
        return this.displayTableName;
    }

    public void setDisplayTableName(String displayTableName)
    {
        this.displayTableName = displayTableName;
    }

    public Integer getId()
    {
        return this.id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public String getInputProbeNumber()
    {
        return this.inputProbeNumber;
    }

    public void setInputProbeNumber(String inputProbeNumber)
    {
        this.inputProbeNumber = inputProbeNumber;
    }

    public String getDisProbeNumber()
    {
        return this.disProbeNumber;
    }

    public void setDisProbeNumber(String disProbeNumber)
    {
        this.disProbeNumber = disProbeNumber;
    }

    public String getCreatedOn()
    {
        return this.createdOn;
    }

    public void setCreatedOn(String createdOn)
    {
        this.createdOn = createdOn;
    }

    public Double getDisTemperature()
    {
        return this.disTemperature;
    }

    public void setDisTemperature(Double disTemperature)
    {
        this.disTemperature = disTemperature;
    }

    public Double getDisHumidity()
    {
        return this.disHumidity;
    }

    public void setDisHumidity(Double disHumidity)
    {
        this.disHumidity = disHumidity;
    }

    public String toString()
    {
        return "LabDisplayParamter [inputProbeNumber=" + this.inputProbeNumber + ", disProbeNumber=" + this.disProbeNumber + ", createdOn=" + this.createdOn + ", disTemperature=" + this.disTemperature + ", disHumidity=" + this.disHumidity + "]";
    }

    public LabDisplayParamter(String inputProbeNumber, String disProbeNumber, String createdOn, Double disTemperature, Double disHumidity)
    {
        this.inputProbeNumber = inputProbeNumber;
        this.disProbeNumber = disProbeNumber;
        this.createdOn = createdOn;
        this.disTemperature = disTemperature;
        this.disHumidity = disHumidity;
    }

    public LabDisplayParamter(String inputProbeNumber, String disProbeNumber, String createdOn, Double disTemperature, Double disHumidity, String displayTableName)
    {
        this.inputProbeNumber = inputProbeNumber;
        this.disProbeNumber = disProbeNumber;
        this.createdOn = createdOn;
        this.disTemperature = disTemperature;
        this.disHumidity = disHumidity;
        this.displayTableName = displayTableName;
    }

    public LabDisplayParamter() {}
}
