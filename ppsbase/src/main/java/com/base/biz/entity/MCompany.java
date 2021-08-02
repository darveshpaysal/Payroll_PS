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
@Table(name = "m_company")
@NamedQueries({
    @NamedQuery(name = "MCompany.findAll", query = "SELECT m FROM MCompany m")
    , @NamedQuery(name = "MCompany.findById", query = "SELECT m FROM MCompany m WHERE m.id = :id")
    , @NamedQuery(name = "MCompany.findByCompName", query = "SELECT m FROM MCompany m WHERE m.compName = :compName")
    , @NamedQuery(name = "MCompany.findByCompAddress", query = "SELECT m FROM MCompany m WHERE m.compAddress = :compAddress")
    , @NamedQuery(name = "MCompany.findByCompAddress1", query = "SELECT m FROM MCompany m WHERE m.compAddress1 = :compAddress1")
    , @NamedQuery(name = "MCompany.findByCity", query = "SELECT m FROM MCompany m WHERE m.city = :city")
    , @NamedQuery(name = "MCompany.findByPhoneNo", query = "SELECT m FROM MCompany m WHERE m.phoneNo = :phoneNo")
    , @NamedQuery(name = "MCompany.findByFax", query = "SELECT m FROM MCompany m WHERE m.fax = :fax")
    , @NamedQuery(name = "MCompany.findByEMail", query = "SELECT m FROM MCompany m WHERE m.eMail = :eMail")
    , @NamedQuery(name = "MCompany.findByTradeTaxNo", query = "SELECT m FROM MCompany m WHERE m.tradeTaxNo = :tradeTaxNo")
    , @NamedQuery(name = "MCompany.findByGstNo", query = "SELECT m FROM MCompany m WHERE m.gstNo = :gstNo")
    , @NamedQuery(name = "MCompany.findByRegNo", query = "SELECT m FROM MCompany m WHERE m.regNo = :regNo")
    , @NamedQuery(name = "MCompany.findByProject", query = "SELECT m FROM MCompany m WHERE m.project = :project")
    , @NamedQuery(name = "MCompany.findByCreatedBy", query = "SELECT m FROM MCompany m WHERE m.createdBy = :createdBy")
    , @NamedQuery(name = "MCompany.findByCreatedDate", query = "SELECT m FROM MCompany m WHERE m.createdDate = :createdDate")})
public class MCompany implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "COMP_NAME")
    private String compName;
    @Basic(optional = false)
    @Column(name = "COMP_ADDRESS")
    private String compAddress;
    @Basic(optional = false)
    @Column(name = "COMP_ADDRESS1")
    private String compAddress1;
    @Basic(optional = false)
    @Column(name = "CITY")
    private String city;
    @Basic(optional = false)
    @Column(name = "PHONE_NO")
    private String phoneNo;
    @Basic(optional = false)
    @Column(name = "FAX")
    private String fax;
    @Basic(optional = false)
    @Column(name = "E_MAIL")
    private String eMail;
    @Basic(optional = false)
    @Column(name = "TRADE_TAX_NO")
    private String tradeTaxNo;
    @Basic(optional = false)
    @Column(name = "GST_NO")
    private String gstNo;
    @Basic(optional = false)
    @Column(name = "REG_NO")
    private String regNo;
    @Basic(optional = false)
    @Column(name = "PROJECT")
    private String project;
    @Column(name = "created_by")
    private String createdBy;
    @Basic(optional = false)
    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    public MCompany() {
    }

    public MCompany(Integer id) {
        this.id = id;
    }

    public MCompany(Integer id, String compName, String compAddress, String compAddress1, String city, String phoneNo, String fax, String eMail, String tradeTaxNo, String gstNo, String regNo, String project, Date createdDate) {
        this.id = id;
        this.compName = compName;
        this.compAddress = compAddress;
        this.compAddress1 = compAddress1;
        this.city = city;
        this.phoneNo = phoneNo;
        this.fax = fax;
        this.eMail = eMail;
        this.tradeTaxNo = tradeTaxNo;
        this.gstNo = gstNo;
        this.regNo = regNo;
        this.project = project;
        this.createdDate = createdDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompName() {
        return compName;
    }

    public void setCompName(String compName) {
        this.compName = compName;
    }

    public String getCompAddress() {
        return compAddress;
    }

    public void setCompAddress(String compAddress) {
        this.compAddress = compAddress;
    }

    public String getCompAddress1() {
        return compAddress1;
    }

    public void setCompAddress1(String compAddress1) {
        this.compAddress1 = compAddress1;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEMail() {
        return eMail;
    }

    public void setEMail(String eMail) {
        this.eMail = eMail;
    }

    public String getTradeTaxNo() {
        return tradeTaxNo;
    }

    public void setTradeTaxNo(String tradeTaxNo) {
        this.tradeTaxNo = tradeTaxNo;
    }

    public String getGstNo() {
        return gstNo;
    }

    public void setGstNo(String gstNo) {
        this.gstNo = gstNo;
    }

    public String getRegNo() {
        return regNo;
    }

    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
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
        if (!(object instanceof MCompany)) {
            return false;
        }
        MCompany other = (MCompany) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.base.biz.entity.MCompany[ id=" + id + " ]";
    }
    
}
