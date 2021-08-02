/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.base.biz.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author RAJ
 */
@Entity
@Table(name = "mnth_tax_dp")
@NamedQueries({
    @NamedQuery(name = "MnthTaxDp.findAll", query = "SELECT m FROM MnthTaxDp m")
    , @NamedQuery(name = "MnthTaxDp.findById", query = "SELECT m FROM MnthTaxDp m WHERE m.id = :id")
    , @NamedQuery(name = "MnthTaxDp.findByFinyear", query = "SELECT m FROM MnthTaxDp m WHERE m.finyear = :finyear")
    , @NamedQuery(name = "MnthTaxDp.findByMthNo", query = "SELECT m FROM MnthTaxDp m WHERE m.mthNo = :mthNo")
    , @NamedQuery(name = "MnthTaxDp.findByYrNo", query = "SELECT m FROM MnthTaxDp m WHERE m.yrNo = :yrNo")
    , @NamedQuery(name = "MnthTaxDp.findByEcode", query = "SELECT m FROM MnthTaxDp m WHERE m.ecode = :ecode")
    , @NamedQuery(name = "MnthTaxDp.findByTaxAmt", query = "SELECT m FROM MnthTaxDp m WHERE m.taxAmt = :taxAmt")
    , @NamedQuery(name = "MnthTaxDp.findByBskCode", query = "SELECT m FROM MnthTaxDp m WHERE m.bskCode = :bskCode")
    , @NamedQuery(name = "MnthTaxDp.findByDtDeposite", query = "SELECT m FROM MnthTaxDp m WHERE m.dtDeposite = :dtDeposite")
    , @NamedQuery(name = "MnthTaxDp.findByChalNo", query = "SELECT m FROM MnthTaxDp m WHERE m.chalNo = :chalNo")
    , @NamedQuery(name = "MnthTaxDp.findByTransdate", query = "SELECT m FROM MnthTaxDp m WHERE m.transdate = :transdate")
    , @NamedQuery(name = "MnthTaxDp.findBySuppFlag", query = "SELECT m FROM MnthTaxDp m WHERE m.suppFlag = :suppFlag")
    , @NamedQuery(name = "MnthTaxDp.findByCreatedBy", query = "SELECT m FROM MnthTaxDp m WHERE m.createdBy = :createdBy")
    , @NamedQuery(name = "MnthTaxDp.findByCreatedDate", query = "SELECT m FROM MnthTaxDp m WHERE m.createdDate = :createdDate")})
public class MnthTaxDp implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "FINYEAR")
    private String finyear;
    @Column(name = "MTH_NO")
    private Integer mthNo;
    @Column(name = "YR_NO")
    private Integer yrNo;
    @Column(name = "ECODE")
    private String ecode;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "TAX_AMT")
    private Double taxAmt;
    @Column(name = "BSK_CODE")
    private Integer bskCode;
    @Basic(optional = false)
    @Column(name = "DT_DEPOSITE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dtDeposite;
    @Column(name = "CHAL_NO")
    private String chalNo;
    @Basic(optional = false)
    @Column(name = "TRANSDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date transdate;
    @Column(name = "SUPP_FLAG")
    private Character suppFlag;
    @Column(name = "created_by")
    private String createdBy;
    @Basic(optional = false)
    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    public MnthTaxDp() {
    }

    public MnthTaxDp(Integer id) {
        this.id = id;
    }

    public MnthTaxDp(Integer id, Date dtDeposite, Date transdate, Date createdDate) {
        this.id = id;
        this.dtDeposite = dtDeposite;
        this.transdate = transdate;
        this.createdDate = createdDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFinyear() {
        return finyear;
    }

    public void setFinyear(String finyear) {
        this.finyear = finyear;
    }

    public Integer getMthNo() {
        return mthNo;
    }

    public void setMthNo(Integer mthNo) {
        this.mthNo = mthNo;
    }

    public Integer getYrNo() {
        return yrNo;
    }

    public void setYrNo(Integer yrNo) {
        this.yrNo = yrNo;
    }

    public String getEcode() {
        return ecode;
    }

    public void setEcode(String ecode) {
        this.ecode = ecode;
    }

    public Double getTaxAmt() {
        return taxAmt;
    }

    public void setTaxAmt(Double taxAmt) {
        this.taxAmt = taxAmt;
    }

    public Integer getBskCode() {
        return bskCode;
    }

    public void setBskCode(Integer bskCode) {
        this.bskCode = bskCode;
    }

    public Date getDtDeposite() {
        return dtDeposite;
    }

    public void setDtDeposite(Date dtDeposite) {
        this.dtDeposite = dtDeposite;
    }

    public String getChalNo() {
        return chalNo;
    }

    public void setChalNo(String chalNo) {
        this.chalNo = chalNo;
    }

    public Date getTransdate() {
        return transdate;
    }

    public void setTransdate(Date transdate) {
        this.transdate = transdate;
    }

    public Character getSuppFlag() {
        return suppFlag;
    }

    public void setSuppFlag(Character suppFlag) {
        this.suppFlag = suppFlag;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MnthTaxDp)) {
            return false;
        }
        MnthTaxDp other = (MnthTaxDp) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.base.biz.entity.MnthTaxDp[ id=" + id + " ]";
    }
    
}
