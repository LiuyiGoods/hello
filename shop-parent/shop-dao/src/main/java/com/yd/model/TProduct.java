package com.yd.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class TProduct  implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 3324183417819016811L;

	private Integer proId;

    private String proName;

    private BigDecimal proYprice;

    private BigDecimal proSprice;

    private BigDecimal proCprice;

    private Integer catId;

    private String proDetail;

    private Integer proNum;

    private Integer picId;

    private Integer proStatus;

    private Date cTime;

    public Integer getProId() {
        return proId;
    }

    public void setProId(Integer proId) {
        this.proId = proId;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName == null ? null : proName.trim();
    }

    public BigDecimal getProYprice() {
        return proYprice;
    }

    public void setProYprice(BigDecimal proYprice) {
        this.proYprice = proYprice;
    }

    public BigDecimal getProSprice() {
        return proSprice;
    }

    public void setProSprice(BigDecimal proSprice) {
        this.proSprice = proSprice;
    }

    public BigDecimal getProCprice() {
        return proCprice;
    }

    public void setProCprice(BigDecimal proCprice) {
        this.proCprice = proCprice;
    }

    public Integer getCatId() {
        return catId;
    }

    public void setCatId(Integer catId) {
        this.catId = catId;
    }

    public String getProDetail() {
        return proDetail;
    }

    public void setProDetail(String proDetail) {
        this.proDetail = proDetail == null ? null : proDetail.trim();
    }

    public Integer getProNum() {
        return proNum;
    }

    public void setProNum(Integer proNum) {
        this.proNum = proNum;
    }

    public Integer getPicId() {
        return picId;
    }

    public void setPicId(Integer picId) {
        this.picId = picId;
    }

    public Integer getProStatus() {
        return proStatus;
    }

    public void setProStatus(Integer proStatus) {
        this.proStatus = proStatus;
    }

    public Date getcTime() {
        return cTime;
    }

    public void setcTime(Date cTime) {
        this.cTime = cTime;
    }
}