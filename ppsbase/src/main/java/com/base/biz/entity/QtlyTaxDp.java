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
@Table(name = "qtly_tax_dp")
@NamedQueries({
    @NamedQuery(name = "QtlyTaxDp.findAll", query = "SELECT q FROM QtlyTaxDp q")
    , @NamedQuery(name = "QtlyTaxDp.findById", query = "SELECT q FROM QtlyTaxDp q WHERE q.id = :id")
    , @NamedQuery(name = "QtlyTaxDp.findByFinyear", query = "SELECT q FROM QtlyTaxDp q WHERE q.finyear = :finyear")
    , @NamedQuery(name = "QtlyTaxDp.findByQtrNo", query = "SELECT q FROM QtlyTaxDp q WHERE q.qtrNo = :qtrNo")
    , @NamedQuery(name = "QtlyTaxDp.findByEcode", query = "SELECT q FROM QtlyTaxDp q WHERE q.ecode = :ecode")
    , @NamedQuery(name = "QtlyTaxDp.findByReceiptNo", query = "SELECT q FROM QtlyTaxDp q WHERE q.receiptNo = :receiptNo")
    , @NamedQuery(name = "QtlyTaxDp.findByAmtDed", query = "SELECT q FROM QtlyTaxDp q WHERE q.amtDed = :amtDed")
    , @NamedQuery(name = "QtlyTaxDp.findByAmtRmtd", query = "SELECT q FROM QtlyTaxDp q WHERE q.amtRmtd = :amtRmtd")
    , @NamedQuery(name = "QtlyTaxDp.findByTransdate", query = "SELECT q FROM QtlyTaxDp q WHERE q.transdate = :transdate")
    , @NamedQuery(name = "QtlyTaxDp.findByCreatedBy", query = "SELECT q FROM QtlyTaxDp q WHERE q.createdBy = :createdBy")
    , @NamedQuery(name = "QtlyTaxDp.findByCreatedDate", query = "SELECT q FROM QtlyTaxDp q WHERE q.createdDate = :createdDate")})
public class QtlyTaxDp implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "FINYEAR")
    private String finyear;
    @Column(name = "QTR_NO")
    private String qtrNo;
    @Column(name = "ECODE")
    private String ecode;
    @Column(name = "RECEIPT_NO")
    private String receiptNo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "AMT_DED")
    private Double amtDed;
    @Column(name = "AMT_RMTD")
    private Double amtRmtd;
    @Basic(optional = false)
    @Column(name = "TRANSDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date transdate;
    @Column(name = "created_by")
    private String createdBy;
    @Basic(optional = false)
    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    public QtlyTaxDp() {
    }

    public QtlyTaxDp(Integer id) {
        this.id = id;
    }

    public QtlyTaxDp(Integer id, Date transdate, Date createdDate) {
        this.id = id;
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

    public String getQtrNo() {
        return qtrNo;
    }

    public void setQtrNo(String qtrNo) {
        this.qtrNo = qtrNo;
    }

    public String getEcode() {
        return ecode;
    }

    public void setEcode(String ecode) {
        this.ecode = ecode;
    }

    public String getReceiptNo() {
        return receiptNo;
    }

    public void setReceiptNo(String receiptNo) {
        this.receiptNo = receiptNo;
    }

    public Double getAmtDed() {
        return amtDed;
    }

    public void setAmtDed(Double amtDed) {
        this.amtDed = amtDed;
    }

    public Double getAmtRmtd() {
        return amtRmtd;
    }

    public void setAmtRmtd(Double amtRmtd) {
        this.amtRmtd = amtRmtd;
    }

    public Date getTransdate() {
        return transdate;
    }

    public void setTransdate(Date transdate) {
        this.transdate = transdate;
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
        if (!(object instanceof QtlyTaxDp)) {
            return false;
        }
        QtlyTaxDp other = (QtlyTaxDp) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.base.biz.entity.QtlyTaxDp[ id=" + id + " ]";
    }
    
}
