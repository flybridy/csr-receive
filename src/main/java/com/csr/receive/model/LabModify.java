package com.csr.receive.model;

/**
 * User: cdp
 * Date: 2018/7/3
 * Time: 15:58
 */
public class LabModify
{
    private Integer id;
    private String inputProbeNumber;
    private String disProbeNumber;
    private String modifyOn;
    private String createdOn;
    private String stopEnd;
    private Double modifyTemp;
    private Double modifyHum;
    private String Status;
    private String name;

    public Double getModifyTemp()
    {
        return this.modifyTemp;
    }

    public void setModifyTemp(Double modifyTemp)
    {
        this.modifyTemp = modifyTemp;
    }

    public Double getModifyHum()
    {
        return this.modifyHum;
    }

    public void setModifyHum(Double modifyHum)
    {
        this.modifyHum = modifyHum;
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

    public String getModifyOn()
    {
        return this.modifyOn;
    }

    public void setModifyOn(String modifyOn)
    {
        this.modifyOn = modifyOn;
    }

    public String getCreatedOn()
    {
        return this.createdOn;
    }

    public void setCreatedOn(String createdOn)
    {
        this.createdOn = createdOn;
    }

    public String getStopEnd()
    {
        return this.stopEnd;
    }

    public void setStopEnd(String stopEnd)
    {
        this.stopEnd = stopEnd;
    }

    public String getStatus()
    {
        return this.Status;
    }

    public void setStatus(String status)
    {
        this.Status = status;
    }

    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
}
