package com.entity;


import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;
public class TBill {

    private Long id;

    private String billcode;

    private String productname;

    private BigDecimal totalprice;

    private Integer ispayment;

    private Date creationdate;

    private String proname;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBillcode() {
        return billcode;
    }

    public void setBillcode(String billcode) {
        this.billcode = billcode;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public BigDecimal getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(BigDecimal totalprice) {
        this.totalprice = totalprice;
    }

    public Integer getIspayment() {
        return ispayment;
    }

    public void setIspayment(Integer ispayment) {
        this.ispayment = ispayment;
    }

    public Date getCreationdate() {
        return creationdate;
    }
    @DateTimeFormat( pattern = "yyyy-MM-dd")
    public void setCreationdate(Date creationdate) {
        this.creationdate = creationdate;
    }

    public String getProname() {
        return proname;
    }

    public void setProname(String proname) {
        this.proname = proname;
    }


    public String toString() {
        return "XBill{" +
                "id=" + id +
                ", billcode='" + billcode + '\'' +
                ", productname='" + productname + '\'' +
                ", totalprice=" + totalprice +
                ", ispayment=" + ispayment +
                ", creationdate=" + creationdate +
                ", proname='" + proname + '\'' +
                '}';
    }
}
