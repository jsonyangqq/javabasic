package com.interview.javacode;

import java.util.ArrayList;

/**
 * @author json.yang
 * @Description Firut
 * @Date 2020-06-08
 */
public class Firut {
    private String fno;
    private int price;
    private  String kg;
    private int inventory;
    private String name;

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    public Firut(String fno, int price, String kg, int inventory, String name) {
        this.fno = fno;
        this.price = price;
        this.kg = kg;
        this.inventory = inventory;
        this.name = name;
    }

    public String getFno() {
        return fno;
    }

    public void setFno(String fno) {
        this.fno = fno;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getKg() {
        return kg;
    }

    public void setKg(String kg) {
        this.kg = kg;
    }

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Firut{" +
                "fno='" + fno + '\'' +
                ", price=" + price +
                ", kg='" + kg + '\'' +
                ", inventory=" + inventory +
                ", name='" + name + '\'' +
                '}';
    }
}