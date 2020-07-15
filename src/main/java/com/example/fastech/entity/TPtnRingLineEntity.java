package com.example.fastech.entity;

import javax.persistence.Column;

/**
 * <p>
 *
 * @author xh
 * @since 2020-04-17
 */
public class TPtnRingLineEntity {

    private String ptnNames;

    private String deviceLevel;

    private String ringLine;

    public String getPtnNames() {
        return ptnNames;
    }

    public void setPtnNames(String ptnNames) {
        this.ptnNames = ptnNames;
    }

    public String getDeviceLevel() {
        return deviceLevel;
    }

    public void setDeviceLevel(String deviceLevel) {
        this.deviceLevel = deviceLevel;
    }

    public String getRingLine() {
        return ringLine;
    }

    public void setRingLine(String ringLine) {
        this.ringLine = ringLine;
    }
}
