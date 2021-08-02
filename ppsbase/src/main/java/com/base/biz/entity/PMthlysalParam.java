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
@Table(name = "p_mthlysal_param")
@NamedQueries({
    @NamedQuery(name = "PMthlysalParam.findAll", query = "SELECT p FROM PMthlysalParam p")
    , @NamedQuery(name = "PMthlysalParam.findById", query = "SELECT p FROM PMthlysalParam p WHERE p.id = :id")
    , @NamedQuery(name = "PMthlysalParam.findByYrNo", query = "SELECT p FROM PMthlysalParam p WHERE p.yrNo = :yrNo")
    , @NamedQuery(name = "PMthlysalParam.findByMthNo", query = "SELECT p FROM PMthlysalParam p WHERE p.mthNo = :mthNo")
    , @NamedQuery(name = "PMthlysalParam.findBySalCode", query = "SELECT p FROM PMthlysalParam p WHERE p.salCode = :salCode")
    , @NamedQuery(name = "PMthlysalParam.findByDescr", query = "SELECT p FROM PMthlysalParam p WHERE p.descr = :descr")
    , @NamedQuery(name = "PMthlysalParam.findByDayNum", query = "SELECT p FROM PMthlysalParam p WHERE p.dayNum = :dayNum")
    , @NamedQuery(name = "PMthlysalParam.findByFreezeFlg", query = "SELECT p FROM PMthlysalParam p WHERE p.freezeFlg = :freezeFlg")
    , @NamedQuery(name = "PMthlysalParam.findBySalPrepDt", query = "SELECT p FROM PMthlysalParam p WHERE p.salPrepDt = :salPrepDt")
    , @NamedQuery(name = "PMthlysalParam.findByCreatedBy", query = "SELECT p FROM PMthlysalParam p WHERE p.createdBy = :createdBy")
    , @NamedQuery(name = "PMthlysalParam.findByCreatedDate", query = "SELECT p FROM PMthlysalParam p WHERE p.createdDate = :createdDate")})
public class PMthlysalParam implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "YR_NO")
    private int yrNo;
    @Basic(optional = false)
    @Column(name = "MTH_NO")
    private int mthNo;
    @Basic(optional = false)
    @Column(name = "SAL_CODE")
    private int salCode;
    @Basic(optional = false)
    @Column(name = "DESCR")
    private String descr;
    @Basic(optional = false)
    @Column(name = "DAY_NUM")
    private int dayNum;
    @Column(name = "FREEZE_FLG")
    private Boolean freezeFlg;
    @Basic(optional = false)
    @Column(name = "SAL_PREP_DT")
    @Temporal(TemporalType.TIMESTAMP)
    private Date salPrepDt;
    @Column(name = "created_by")
    private String createdBy;
    @Basic(optional = false)
    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    public PMthlysalParam() {
    }

    public PMthlysalParam(Integer id) {
        this.id = id;
    }

    public PMthlysalParam(Integer id, int yrNo, int mthNo, int salCode, String descr, int dayNum, Date salPrepDt, Date createdDate) {
        this.id = id;
        this.yrNo = yrNo;
        this.mthNo = mthNo;
        this.salCode = salCode;
        this.descr = descr;
        this.dayNum = dayNum;
        this.salPrepDt = salPrepDt;
        this.createdDate = createdDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getYrNo() {
        return yrNo;
    }

    public void setYrNo(int yrNo) {
        this.yrNo = yrNo;
    }

    public int getMthNo() {
        return mthNo;
    }

    public void setMthNo(int mthNo) {
        this.mthNo = mthNo;
    }

    public int getSalCode() {
        return salCode;
    }

    public void setSalCode(int salCode) {
        this.salCode = salCode;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public int getDayNum() {
        return dayNum;
    }

    public void setDayNum(int dayNum) {
        this.dayNum = dayNum;
    }

    public Boolean getFreezeFlg() {
        return freezeFlg;
    }

    public void setFreezeFlg(Boolean freezeFlg) {
        this.freezeFlg = freezeFlg;
    }

    public Date getSalPrepDt() {
        return salPrepDt;
    }

    public void setSalPrepDt(Date salPrepDt) {
        this.salPrepDt = salPrepDt;
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
        if (!(object instanceof PMthlysalParam)) {
            return false;
        }
        PMthlysalParam other = (PMthlysalParam) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.base.biz.entity.PMthlysalParam[ id=" + id + " ]";
    }
    
}
