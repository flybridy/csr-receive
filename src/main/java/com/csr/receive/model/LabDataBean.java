package com.csr.receive.model;

import java.util.Date;

/**
 * 原始表数据
 * User: cdp
 * Date: 2018/8/27
 * Time: 13:33
 */
public class LabDataBean {
    private int id;
    private String INPUTPROBENUMBER;
    private String DISPROBENUMBER;
    private Date CREATEDON;
    private double DISTEMPERATURE;
    private double DISHUMIDITY;
    private Date record_time;

    public LabDataBean(String INPUTPROBENUMBER, String DISPROBENUMBER, Date CREATEDON, double DISTEMPERATURE, double DISHUMIDITY, Date record_time) {
        this.INPUTPROBENUMBER = INPUTPROBENUMBER;
        this.DISPROBENUMBER = DISPROBENUMBER;
        this.CREATEDON = CREATEDON;
        this.DISTEMPERATURE = DISTEMPERATURE;
        this.DISHUMIDITY = DISHUMIDITY;
        this.record_time = record_time;
    }

    public LabDataBean(int id, String INPUTPROBENUMBER, String DISPROBENUMBER, Date CREATEDON, double DISTEMPERATURE, double DISHUMIDITY, Date record_time) {
        this.id = id;
        this.INPUTPROBENUMBER = INPUTPROBENUMBER;
        this.DISPROBENUMBER = DISPROBENUMBER;
        this.CREATEDON = CREATEDON;
        this.DISTEMPERATURE = DISTEMPERATURE;
        this.DISHUMIDITY = DISHUMIDITY;
        this.record_time = record_time;
    }

    public LabDataBean() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getINPUTPROBENUMBER() {
        return INPUTPROBENUMBER;
    }

    public void setINPUTPROBENUMBER(String INPUTPROBENUMBER) {
        this.INPUTPROBENUMBER = INPUTPROBENUMBER;
    }

    public String getDISPROBENUMBER() {
        return DISPROBENUMBER;
    }

    public void setDISPROBENUMBER(String DISPROBENUMBER) {
        this.DISPROBENUMBER = DISPROBENUMBER;
    }

    public Date getCREATEDON() {
        return CREATEDON;
    }

    public void setCREATEDON(Date CREATEDON) {
        this.CREATEDON = CREATEDON;
    }

    public double getDISTEMPERATURE() {
        return DISTEMPERATURE;
    }

    public void setDISTEMPERATURE(double DISTEMPERATURE) {
        this.DISTEMPERATURE = DISTEMPERATURE;
    }

    public double getDISHUMIDITY() {
        return DISHUMIDITY;
    }

    public void setDISHUMIDITY(double DISHUMIDITY) {
        this.DISHUMIDITY = DISHUMIDITY;
    }

    public Date getRecord_time() {
        return record_time;
    }

    public void setRecord_time(Date record_time) {
        this.record_time = record_time;
    }

    @Override
    public String toString() {
        return "LabDataBean{" +
                "id=" + id +
                ", INPUTPROBENUMBER='" + INPUTPROBENUMBER + '\'' +
                ", DISPROBENUMBER='" + DISPROBENUMBER + '\'' +
                ", CREATEDON=" + CREATEDON +
                ", DISTEMPERATURE=" + DISTEMPERATURE +
                ", DISHUMIDITY=" + DISHUMIDITY +
                ", record_time=" + record_time +
                '}';
    }
}
