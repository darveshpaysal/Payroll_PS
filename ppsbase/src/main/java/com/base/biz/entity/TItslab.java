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
@Table(name = "t_itslab")
@NamedQueries({
    @NamedQuery(name = "TItslab.findAll", query = "SELECT t FROM TItslab t")
    , @NamedQuery(name = "TItslab.findById", query = "SELECT t FROM TItslab t WHERE t.id = :id")
    , @NamedQuery(name = "TItslab.findByCategory", query = "SELECT t FROM TItslab t WHERE t.category = :category")
    , @NamedQuery(name = "TItslab.findBySlabFrom", query = "SELECT t FROM TItslab t WHERE t.slabFrom = :slabFrom")
    , @NamedQuery(name = "TItslab.findBySlabTo", query = "SELECT t FROM TItslab t WHERE t.slabTo = :slabTo")
    , @NamedQuery(name = "TItslab.findByTaxPercent", query = "SELECT t FROM TItslab t WHERE t.taxPercent = :taxPercent")
    , @NamedQuery(name = "TItslab.findByCessPercent", query = "SELECT t FROM TItslab t WHERE t.cessPercent = :cessPercent")
    , @NamedQuery(name = "TItslab.findBySurcharge", query = "SELECT t FROM TItslab t WHERE t.surcharge = :surcharge")
    , @NamedQuery(name = "TItslab.findByFinYr", query = "SELECT t FROM TItslab t WHERE t.finYr = :finYr")
    , @NamedQuery(name = "TItslab.findByCreatedBy", query = "SELECT t FROM TItslab t WHERE t.createdBy = :createdBy")
    , @NamedQuery(name = "TItslab.findByCreatedDate", query = "SELECT t FROM TItslab t WHERE t.createdDate = :createdDate")})
public class TItslab implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "CATEGORY")
    private Character category;
    @Basic(optional = false)
    @Column(name = "SLAB_FROM")
    private double slabFrom;
    @Basic(optional = false)
    @Column(name = "SLAB_TO")
    private double slabTo;
    @Basic(optional = false)
    @Column(name = "TAX_PERCENT")
    private double taxPercent;
    @Basic(optional = false)
    @Column(name = "CESS_PERCENT")
    private double cessPercent;
    @Basic(optional = false)
    @Column(name = "SURCHARGE")
    private double surcharge;
    @Basic(optional = false)
    @Column(name = "FIN_YR")
    private String finYr;
    @Column(name = "created_by")
    private String createdBy;
    @Basic(optional = false)
    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    public TItslab() {
    }

    public TItslab(Integer id) {
        this.id = id;
    }

    public TItslab(Integer id, Character category, double slabFrom, double slabTo, double taxPercent, double cessPercent, double surcharge, String finYr, Date createdDate) {
        this.id = id;
        this.category = category;
        this.slabFrom = slabFrom;
        this.slabTo = slabTo;
        this.taxPercent = taxPercent;
        this.cessPercent = cessPercent;
        this.surcharge = surcharge;
        this.finYr = finYr;
        this.createdDate = createdDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Character getCategory() {
        return category;
    }

    public void setCategory(Character category) {
        this.category = category;
    }

    public double getSlabFrom() {
        return slabFrom;
    }

    public void setSlabFrom(double slabFrom) {
        this.slabFrom = slabFrom;
    }

    public double getSlabTo() {
        return slabTo;
    }

    public void setSlabTo(double slabTo) {
        this.slabTo = slabTo;
    }

    public double getTaxPercent() {
        return taxPercent;
    }

    public void setTaxPercent(double taxPercent) {
        this.taxPercent = taxPercent;
    }

    public double getCessPercent() {
        return cessPercent;
    }

    public void setCessPercent(double cessPercent) {
        this.cessPercent = cessPercent;
    }

    public double getSurcharge() {
        return surcharge;
    }

    public void setSurcharge(double surcharge) {
        this.surcharge = surcharge;
    }

    public String getFinYr() {
        return finYr;
    }

    public void setFinYr(String finYr) {
        this.finYr = finYr;
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
        if (!(object instanceof TItslab)) {
            return false;
        }
        TItslab other = (TItslab) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.base.biz.entity.TItslab[ id=" + id + " ]";
    }
    
}
