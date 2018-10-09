package com.entity;

import java.util.*;
public class ProviderData {
    private int total;

    private List<Provider> rows ;

    public void setTotal(int total) {
        this.total = total;
    }

    public void setRows(List<Provider> rows) {
        this.rows = rows;
    }

    public int getTotal() {
        return total;
    }

    public List<Provider> getRows() {
        return rows;
    }

    public ProviderData() {

    }
    public ProviderData(int total, List<Provider> rows) {

        this.total = total;
        this.rows = rows;
    }
}
