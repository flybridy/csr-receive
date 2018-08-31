package com.csr.receive.model;

/**
 * User: cdp
 * Date: 2018/7/3
 * Time: 15:57
 */
public class LabDisprobeNumber
{
    private Integer id;
    private String inputProbeNumber;
    private String displayProbeNumber;
    private String create_time;
    private String tab_InputName;
    private String tabDisplayName;

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

    public String getDisplayProbeNumber()
    {
        return this.displayProbeNumber;
    }

    public void setDisplayProbeNumber(String displayProbeNumber)
    {
        this.displayProbeNumber = displayProbeNumber;
    }

    public String getCreate_time()
    {
        return this.create_time;
    }

    public void setCreate_time(String create_time)
    {
        this.create_time = create_time;
    }

    public String getTab_InputName()
    {
        return this.tab_InputName;
    }

    public void setTab_InputName(String tab_InputName)
    {
        this.tab_InputName = tab_InputName;
    }

    public String getTabDisplayName()
    {
        return this.tabDisplayName;
    }

    public void setTabDisplayName(String tabDisplayName)
    {
        this.tabDisplayName = tabDisplayName;
    }
}
