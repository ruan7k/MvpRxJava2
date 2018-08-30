package com.rambo.rxjava2.ui.entity;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import java.util.List;

/**
 * 天气bena
 *
 * @author rambo
 * @version 1.0 2018-08-29
 * @since JDK 1.8
 */
public class WeatherBean extends BaseObservable {

    private String city;
    private String aqi;
    private String ganmao;
    private String wendu;
    private WeatherDetailsBean yesterday;
    private List<WeatherDetailsBean> forecast;

    @Bindable
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Bindable
    public String getAqi() {
        return aqi;
    }

    public void setAqi(String aqi) {
        this.aqi = aqi;
    }

    @Bindable
    public String getGanmao() {
        return ganmao;
    }

    public void setGanmao(String ganmao) {
        this.ganmao = ganmao;
    }

    @Bindable
    public String getWendu() {
        return wendu;
    }

    public void setWendu(String wendu) {
        this.wendu = wendu;
    }

    @Bindable
    public WeatherDetailsBean getYesterday() {
        return yesterday;
    }

    public void setYesterday(WeatherDetailsBean yesterday) {
        this.yesterday = yesterday;
    }

    @Bindable
    public List<WeatherDetailsBean> getForecast() {
        return forecast;
    }

    public void setForecast(List<WeatherDetailsBean> forecast) {
        this.forecast = forecast;
    }



}
