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
@Table(name = "m_financialyear")
@NamedQueries({
    @NamedQuery(name = "MFinancialyear.findAll", query = "SELECT m FROM MFinancialyear m")
    , @NamedQuery(name = "MFinancialyear.findById", query = "SELECT m FROM MFinancialyear m WHERE m.id = :id")
    , @NamedQuery(name = "MFinancialyear.findByDefaultLocation", query = "SELECT m FROM MFinancialyear m WHERE m.defaultLocation = :defaultLocation")
    , @NamedQuery(name = "MFinancialyear.findByFinancialyear", query = "SELECT m FROM MFinancialyear m WHERE m.financialyear = :financialyear")
    , @NamedQuery(name = "MFinancialyear.findByStartdate", query = "SELECT m FROM MFinancialyear m WHERE m.startdate = :startdate")
    , @NamedQuery(name = "MFinancialyear.findByEnddate", query = "SELECT m FROM MFinancialyear m WHERE m.enddate = :enddate")
    , @NamedQuery(name = "MFinancialyear.findByPreviousFinyear", query = "SELECT m FROM MFinancialyear m WHERE m.previousFinyear = :previousFinyear")
    , @NamedQuery(name = "MFinancialyear.findByStatus", query = "SELECT m FROM MFinancialyear m WHERE m.status = :status")
    , @NamedQuery(name = "MFinancialyear.findByRecflag", query = "SELECT m FROM MFinancialyear m WHERE m.recflag = :recflag")
    , @NamedQuery(name = "MFinancialyear.findByCreatedBy", query = "SELECT m FROM MFinancialyear m WHERE m.createdBy = :createdBy")
    , @NamedQuery(name = "MFinancialyear.findByCreatedDate", query = "SELECT m FROM MFinancialyear m WHERE m.createdDate = :createdDate")})
public class MFinancialyear implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "DEFAULT_LOCATION")
    private String defaultLocation;
    @Basic(optional = false)
    @Column(name = "FINANCIALYEAR")
    private String financialyear;
    @Basic(optional = false)
    @Column(name = "STARTDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startdate;
    @Basic(optional = false)
    @Column(name = "ENDDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date enddate;
    @Basic(optional = false)
    @Column(name = "PREVIOUS_FINYEAR")
    private String previousFinyear;
    @Basic(optional = false)
    @Column(name = "STATUS")
    private String status;
    @Basic(optional = false)
    @Column(name = "RECFLAG")
    private String recflag;
    @Column(name = "created_by")
    private String createdBy;
    @Basic(optional = false)
    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    public MFinancialyear() {
    }

    public MFinancialyear(Integer id) {
        this.id = id;
    }

    public MFinancialyear(Integer id, String defaultLocation, String financialyear, Date startdate, Date enddate, String previousFinyear, String status, String recflag, Date createdDate) {
        this.id = id;
        this.defaultLocation = defaultLocation;
        this.financialyear = financialyear;
        this.startdate = startdate;
        this.enddate = enddate;
        this.previousFinyear = previousFinyear;
        this.status = status;
        this.recflag = recflag;
        this.createdDate = createdDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDefaultLocation() {
        return defaultLocation;
    }

    public void setDefaultLocation(String defaultLocation) {
        this.defaultLocation = defaultLocation;
    }

    public String getFinancialyear() {
        return financialyear;
    }

    public void setFinancialyear(String financialyear) {
        this.financialyear = financialyear;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public String getPreviousFinyear() {
        return previousFinyear;
    }

    public void setPreviousFinyear(String previousFinyear) {
        this.previousFinyear = previousFinyear;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRecflag() {
        return recflag;
    }

    public void setRecflag(String recflag) {
        this.recflag = recflag;
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
        if (!(object instanceof MFinancialyear)) {
            return false;
        }
        MFinancialyear other = (MFinancialyear) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.base.biz.entity.MFinancialyear[ id=" + id + " ]";
    }
    
}
