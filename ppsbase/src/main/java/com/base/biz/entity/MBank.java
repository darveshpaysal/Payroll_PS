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
@Table(name = "m_bank")
@NamedQueries({
    @NamedQuery(name = "MBank.findAll", query = "SELECT m FROM MBank m")
    , @NamedQuery(name = "MBank.findById", query = "SELECT m FROM MBank m WHERE m.id = :id")
    , @NamedQuery(name = "MBank.findByBankCode", query = "SELECT m FROM MBank m WHERE m.bankCode = :bankCode")
    , @NamedQuery(name = "MBank.findByBankName", query = "SELECT m FROM MBank m WHERE m.bankName = :bankName")
    , @NamedQuery(name = "MBank.findByAddress", query = "SELECT m FROM MBank m WHERE m.address = :address")
    , @NamedQuery(name = "MBank.findByBranch", query = "SELECT m FROM MBank m WHERE m.branch = :branch")
    , @NamedQuery(name = "MBank.findByCity", query = "SELECT m FROM MBank m WHERE m.city = :city")
    , @NamedQuery(name = "MBank.findByPhone", query = "SELECT m FROM MBank m WHERE m.phone = :phone")
    , @NamedQuery(name = "MBank.findByFax", query = "SELECT m FROM MBank m WHERE m.fax = :fax")
    , @NamedQuery(name = "MBank.findByAccNo", query = "SELECT m FROM MBank m WHERE m.accNo = :accNo")
    , @NamedQuery(name = "MBank.findByCreatedBy", query = "SELECT m FROM MBank m WHERE m.createdBy = :createdBy")
    , @NamedQuery(name = "MBank.findByCreatedDate", query = "SELECT m FROM MBank m WHERE m.createdDate = :createdDate")})
public class MBank implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "BANK_CODE")
    private String bankCode;
    @Basic(optional = false)
    @Column(name = "BANK_NAME")
    private String bankName;
    @Basic(optional = false)
    @Column(name = "ADDRESS")
    private String address;
    @Basic(optional = false)
    @Column(name = "BRANCH")
    private String branch;
    @Basic(optional = false)
    @Column(name = "CITY")
    private String city;
    @Basic(optional = false)
    @Column(name = "PHONE")
    private String phone;
    @Basic(optional = false)
    @Column(name = "FAX")
    private String fax;
    @Basic(optional = false)
    @Column(name = "ACC_NO")
    private String accNo;
    @Column(name = "created_by")
    private String createdBy;
    @Basic(optional = false)
    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    public MBank() {
    }

    public MBank(Integer id) {
        this.id = id;
    }

    public MBank(Integer id, String bankCode, String bankName, String address, String branch, String city, String phone, String fax, String accNo, Date createdDate) {
        this.id = id;
        this.bankCode = bankCode;
        this.bankName = bankName;
        this.address = address;
        this.branch = branch;
        this.city = city;
        this.phone = phone;
        this.fax = fax;
        this.accNo = accNo;
        this.createdDate = createdDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getAccNo() {
        return accNo;
    }

    public void setAccNo(String accNo) {
        this.accNo = accNo;
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
        if (!(object instanceof MBank)) {
            return false;
        }
        MBank other = (MBank) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.base.biz.entity.MBank[ id=" + id + " ]";
    }
    
}
