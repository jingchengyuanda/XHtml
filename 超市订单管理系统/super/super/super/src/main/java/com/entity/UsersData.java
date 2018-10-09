package com.entity;

import java.util.*;

public class UsersData {
    private int total;

    private List<Users> rows ;

    public UsersData() {

    }
    public UsersData(int total, List<Users> rows) {

        this.total = total;
        this.rows = rows;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void setRows(List<Users> rows) {
        this.rows = rows;
    }

    public int getTotal() {
        return total;
    }

    public List<Users> getRows() {
        return rows;
    }
}
