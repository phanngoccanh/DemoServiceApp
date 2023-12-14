package com.example.demo1.service.dto;

import java.io.Serializable;

public class SupplierDTO implements Serializable {
    private String supplierId;

    private String supplierName;

    private String supplierParentId;

    private String address;

    private String phone;

    private double posX;

    private double posY;

    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getSupplierParentId() {
        return supplierParentId;
    }

    public void setSupplierParentId(String supplierParentId) {
        this.supplierParentId = supplierParentId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public double getPosX() {
        return posX;
    }

    public void setPosX(double posX) {
        this.posX = posX;
    }

    public double getPosY() {
        return posY;
    }

    public void setPosY(double posY) {
        this.posY = posY;
    }
}
