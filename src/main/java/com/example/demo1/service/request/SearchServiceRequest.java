package com.example.demo1.service.request;

import java.io.Serializable;

public class SearchServiceRequest implements Serializable {
    private String keyword;

    private Double distance;

    private double posUserX;

    private double posUserY;

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    public double getPosUserX() {
        return posUserX;
    }

    public void setPosUserX(double posUserX) {
        this.posUserX = posUserX;
    }

    public double getPosUserY() {
        return posUserY;
    }

    public void setPosUserY(double posUserY) {
        this.posUserY = posUserY;
    }
}
