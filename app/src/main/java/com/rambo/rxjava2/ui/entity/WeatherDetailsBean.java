package com.rambo.rxjava2.ui.entity;

/**
 * 天气详情
 *
 * @author rambo
 * @version 1.0 2018-08-29
 * @since JDK 1.8
 */
public class WeatherDetailsBean {

    private String date;	//"28日星期二"
    private String high;	//"高温 34℃"
    private String fx;	    //"无持续风向"
    private String low;	    //"低温 24℃"
    private String fl;	    //"<![CDATA[<3级]]>"
    private String type;	//"多云"

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHigh() {
        return high;
    }

    public void setHigh(String high) {
        this.high = high;
    }

    public String getFx() {
        return fx;
    }

    public void setFx(String fx) {
        this.fx = fx;
    }

    public String getLow() {
        return low;
    }

    public void setLow(String low) {
        this.low = low;
    }

    public String getFl() {
        return fl;
    }

    public void setFl(String fl) {
        this.fl = fl;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }



}
