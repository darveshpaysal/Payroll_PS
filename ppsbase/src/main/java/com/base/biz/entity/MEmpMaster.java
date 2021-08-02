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
@Table(name = "m_emp_master")
@NamedQueries({
    @NamedQuery(name = "MEmpMaster.findAll", query = "SELECT m FROM MEmpMaster m")
    , @NamedQuery(name = "MEmpMaster.findById", query = "SELECT m FROM MEmpMaster m WHERE m.id = :id")
    , @NamedQuery(name = "MEmpMaster.findByEcode", query = "SELECT m FROM MEmpMaster m WHERE m.ecode = :ecode")
    , @NamedQuery(name = "MEmpMaster.findByFirstName", query = "SELECT m FROM MEmpMaster m WHERE m.firstName = :firstName")
    , @NamedQuery(name = "MEmpMaster.findByMiddleName", query = "SELECT m FROM MEmpMaster m WHERE m.middleName = :middleName")
    , @NamedQuery(name = "MEmpMaster.findByLastName", query = "SELECT m FROM MEmpMaster m WHERE m.lastName = :lastName")
    , @NamedQuery(name = "MEmpMaster.findByName", query = "SELECT m FROM MEmpMaster m WHERE m.name = :name")
    , @NamedQuery(name = "MEmpMaster.findByDob", query = "SELECT m FROM MEmpMaster m WHERE m.dob = :dob")
    , @NamedQuery(name = "MEmpMaster.findByFathName", query = "SELECT m FROM MEmpMaster m WHERE m.fathName = :fathName")
    , @NamedQuery(name = "MEmpMaster.findByBirthPlace", query = "SELECT m FROM MEmpMaster m WHERE m.birthPlace = :birthPlace")
    , @NamedQuery(name = "MEmpMaster.findByDoj", query = "SELECT m FROM MEmpMaster m WHERE m.doj = :doj")
    , @NamedQuery(name = "MEmpMaster.findByDesigCode", query = "SELECT m FROM MEmpMaster m WHERE m.desigCode = :desigCode")
    , @NamedQuery(name = "MEmpMaster.findByDeptCode", query = "SELECT m FROM MEmpMaster m WHERE m.deptCode = :deptCode")
    , @NamedQuery(name = "MEmpMaster.findByPanNo", query = "SELECT m FROM MEmpMaster m WHERE m.panNo = :panNo")
    , @NamedQuery(name = "MEmpMaster.findByPranNo", query = "SELECT m FROM MEmpMaster m WHERE m.pranNo = :pranNo")
    , @NamedQuery(name = "MEmpMaster.findByMobile", query = "SELECT m FROM MEmpMaster m WHERE m.mobile = :mobile")
    , @NamedQuery(name = "MEmpMaster.findByEmail", query = "SELECT m FROM MEmpMaster m WHERE m.email = :email")
    , @NamedQuery(name = "MEmpMaster.findByLocAdd1", query = "SELECT m FROM MEmpMaster m WHERE m.locAdd1 = :locAdd1")
    , @NamedQuery(name = "MEmpMaster.findByLocAdd2", query = "SELECT m FROM MEmpMaster m WHERE m.locAdd2 = :locAdd2")
    , @NamedQuery(name = "MEmpMaster.findByLocDistrict", query = "SELECT m FROM MEmpMaster m WHERE m.locDistrict = :locDistrict")
    , @NamedQuery(name = "MEmpMaster.findByLocState", query = "SELECT m FROM MEmpMaster m WHERE m.locState = :locState")
    , @NamedQuery(name = "MEmpMaster.findByLocCountry", query = "SELECT m FROM MEmpMaster m WHERE m.locCountry = :locCountry")
    , @NamedQuery(name = "MEmpMaster.findByLocPostalCode", query = "SELECT m FROM MEmpMaster m WHERE m.locPostalCode = :locPostalCode")
    , @NamedQuery(name = "MEmpMaster.findByPerAdd1", query = "SELECT m FROM MEmpMaster m WHERE m.perAdd1 = :perAdd1")
    , @NamedQuery(name = "MEmpMaster.findByPerAdd2", query = "SELECT m FROM MEmpMaster m WHERE m.perAdd2 = :perAdd2")
    , @NamedQuery(name = "MEmpMaster.findByPerDistrict", query = "SELECT m FROM MEmpMaster m WHERE m.perDistrict = :perDistrict")
    , @NamedQuery(name = "MEmpMaster.findByPerState", query = "SELECT m FROM MEmpMaster m WHERE m.perState = :perState")
    , @NamedQuery(name = "MEmpMaster.findByPerCountry", query = "SELECT m FROM MEmpMaster m WHERE m.perCountry = :perCountry")
    , @NamedQuery(name = "MEmpMaster.findByPerPostalCode", query = "SELECT m FROM MEmpMaster m WHERE m.perPostalCode = :perPostalCode")
    , @NamedQuery(name = "MEmpMaster.findByBankName", query = "SELECT m FROM MEmpMaster m WHERE m.bankName = :bankName")
    , @NamedQuery(name = "MEmpMaster.findByIfscCode", query = "SELECT m FROM MEmpMaster m WHERE m.ifscCode = :ifscCode")
    , @NamedQuery(name = "MEmpMaster.findByAcctNo", query = "SELECT m FROM MEmpMaster m WHERE m.acctNo = :acctNo")
    , @NamedQuery(name = "MEmpMaster.findByEmpStatus", query = "SELECT m FROM MEmpMaster m WHERE m.empStatus = :empStatus")
    , @NamedQuery(name = "MEmpMaster.findByBasic", query = "SELECT m FROM MEmpMaster m WHERE m.basic = :basic")
    , @NamedQuery(name = "MEmpMaster.findByTransportAllow", query = "SELECT m FROM MEmpMaster m WHERE m.transportAllow = :transportAllow")
    , @NamedQuery(name = "MEmpMaster.findBySplAllow", query = "SELECT m FROM MEmpMaster m WHERE m.splAllow = :splAllow")
    , @NamedQuery(name = "MEmpMaster.findByUniformAllow", query = "SELECT m FROM MEmpMaster m WHERE m.uniformAllow = :uniformAllow")
    , @NamedQuery(name = "MEmpMaster.findByTelephInternetAllow", query = "SELECT m FROM MEmpMaster m WHERE m.telephInternetAllow = :telephInternetAllow")
    , @NamedQuery(name = "MEmpMaster.findByPerfmBonus", query = "SELECT m FROM MEmpMaster m WHERE m.perfmBonus = :perfmBonus")
    , @NamedQuery(name = "MEmpMaster.findByMedical", query = "SELECT m FROM MEmpMaster m WHERE m.medical = :medical")
    , @NamedQuery(name = "MEmpMaster.findByIncomeTax", query = "SELECT m FROM MEmpMaster m WHERE m.incomeTax = :incomeTax")
    , @NamedQuery(name = "MEmpMaster.findByUserId", query = "SELECT m FROM MEmpMaster m WHERE m.userId = :userId")
    , @NamedQuery(name = "MEmpMaster.findByPassword", query = "SELECT m FROM MEmpMaster m WHERE m.password = :password")
    , @NamedQuery(name = "MEmpMaster.findByActiveFlag", query = "SELECT m FROM MEmpMaster m WHERE m.activeFlag = :activeFlag")
    , @NamedQuery(name = "MEmpMaster.findByPayReleaseFlag", query = "SELECT m FROM MEmpMaster m WHERE m.payReleaseFlag = :payReleaseFlag")
    , @NamedQuery(name = "MEmpMaster.findByCreatedBy", query = "SELECT m FROM MEmpMaster m WHERE m.createdBy = :createdBy")
    , @NamedQuery(name = "MEmpMaster.findByCreatedDate", query = "SELECT m FROM MEmpMaster m WHERE m.createdDate = :createdDate")
    , @NamedQuery(name = "MEmpMaster.findByModifiedBy", query = "SELECT m FROM MEmpMaster m WHERE m.modifiedBy = :modifiedBy")
    , @NamedQuery(name = "MEmpMaster.findByModifiedDate", query = "SELECT m FROM MEmpMaster m WHERE m.modifiedDate = :modifiedDate")})
public class MEmpMaster implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "ecode")
    private String ecode;
    @Basic(optional = false)
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "middle_name")
    private String middleName;
    @Basic(optional = false)
    @Column(name = "last_name")
    private String lastName;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "dob")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dob;
    @Column(name = "FATH_NAME")
    private String fathName;
    @Column(name = "birth_place")
    private String birthPlace;
    @Basic(optional = false)
    @Column(name = "doj")
    @Temporal(TemporalType.TIMESTAMP)
    private Date doj;
    @Column(name = "DESIG_CODE")
    private String desigCode;
    @Column(name = "DEPT_CODE")
    private String deptCode;
    @Basic(optional = false)
    @Column(name = "pan_no")
    private String panNo;
    @Basic(optional = false)
    @Column(name = "pran_no")
    private String pranNo;
    @Basic(optional = false)
    @Column(name = "mobile")
    private String mobile;
    @Column(name = "email")
    private String email;
    @Column(name = "loc_add1")
    private String locAdd1;
    @Column(name = "loc_add2")
    private String locAdd2;
    @Column(name = "loc_district")
    private String locDistrict;
    @Column(name = "loc_state")
    private String locState;
    @Basic(optional = false)
    @Column(name = "loc_country")
    private String locCountry;
    @Column(name = "loc_postal_code")
    private Integer locPostalCode;
    @Column(name = "per_add1")
    private String perAdd1;
    @Column(name = "per_add2")
    private String perAdd2;
    @Column(name = "per_district")
    private String perDistrict;
    @Column(name = "per_state")
    private String perState;
    @Basic(optional = false)
    @Column(name = "per_country")
    private String perCountry;
    @Column(name = "per_postal_code")
    private Integer perPostalCode;
    @Basic(optional = false)
    @Column(name = "bank_name")
    private String bankName;
    @Basic(optional = false)
    @Column(name = "ifsc_code")
    private String ifscCode;
    @Basic(optional = false)
    @Column(name = "acct_no")
    private String acctNo;
    @Basic(optional = false)
    @Column(name = "emp_status")
    private String empStatus;
    @Basic(optional = false)
    @Column(name = "basic")
    private double basic;
    @Basic(optional = false)
    @Column(name = "transport_allow")
    private double transportAllow;
    @Basic(optional = false)
    @Column(name = "spl_allow")
    private double splAllow;
    @Basic(optional = false)
    @Column(name = "uniform_allow")
    private double uniformAllow;
    @Basic(optional = false)
    @Column(name = "teleph_internet_allow")
    private double telephInternetAllow;
    @Basic(optional = false)
    @Column(name = "perfm_bonus")
    private double perfmBonus;
    @Basic(optional = false)
    @Column(name = "medical")
    private double medical;
    @Basic(optional = false)
    @Column(name = "income_tax")
    private double incomeTax;
    @Column(name = "user_id")
    private String userId;
    @Column(name = "password")
    private String password;
    @Column(name = "active_flag")
    private Boolean activeFlag;
    @Column(name = "pay_release_flag")
    private Character payReleaseFlag;
    @Column(name = "created_by")
    private String createdBy;
    @Basic(optional = false)
    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Column(name = "modified_by")
    private String modifiedBy;
    @Column(name = "modified_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedDate;

    public MEmpMaster() {
    }

    public MEmpMaster(Integer id) {
        this.id = id;
    }

    public MEmpMaster(Integer id, String ecode, String firstName, String lastName, String name, Date dob, Date doj, String panNo, String pranNo, String mobile, String locCountry, String perCountry, String bankName, String ifscCode, String acctNo, String empStatus, double basic, double transportAllow, double splAllow, double uniformAllow, double telephInternetAllow, double perfmBonus, double medical, double incomeTax, Date createdDate) {
        this.id = id;
        this.ecode = ecode;
        this.firstName = firstName;
        this.lastName = lastName;
        this.name = name;
        this.dob = dob;
        this.doj = doj;
        this.panNo = panNo;
        this.pranNo = pranNo;
        this.mobile = mobile;
        this.locCountry = locCountry;
        this.perCountry = perCountry;
        this.bankName = bankName;
        this.ifscCode = ifscCode;
        this.acctNo = acctNo;
        this.empStatus = empStatus;
        this.basic = basic;
        this.transportAllow = transportAllow;
        this.splAllow = splAllow;
        this.uniformAllow = uniformAllow;
        this.telephInternetAllow = telephInternetAllow;
        this.perfmBonus = perfmBonus;
        this.medical = medical;
        this.incomeTax = incomeTax;
        this.createdDate = createdDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEcode() {
        return ecode;
    }

    public void setEcode(String ecode) {
        this.ecode = ecode;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getFathName() {
        return fathName;
    }

    public void setFathName(String fathName) {
        this.fathName = fathName;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public Date getDoj() {
        return doj;
    }

    public void setDoj(Date doj) {
        this.doj = doj;
    }

    public String getDesigCode() {
        return desigCode;
    }

    public void setDesigCode(String desigCode) {
        this.desigCode = desigCode;
    }

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    public String getPanNo() {
        return panNo;
    }

    public void setPanNo(String panNo) {
        this.panNo = panNo;
    }

    public String getPranNo() {
        return pranNo;
    }

    public void setPranNo(String pranNo) {
        this.pranNo = pranNo;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLocAdd1() {
        return locAdd1;
    }

    public void setLocAdd1(String locAdd1) {
        this.locAdd1 = locAdd1;
    }

    public String getLocAdd2() {
        return locAdd2;
    }

    public void setLocAdd2(String locAdd2) {
        this.locAdd2 = locAdd2;
    }

    public String getLocDistrict() {
        return locDistrict;
    }

    public void setLocDistrict(String locDistrict) {
        this.locDistrict = locDistrict;
    }

    public String getLocState() {
        return locState;
    }

    public void setLocState(String locState) {
        this.locState = locState;
    }

    public String getLocCountry() {
        return locCountry;
    }

    public void setLocCountry(String locCountry) {
        this.locCountry = locCountry;
    }

    public Integer getLocPostalCode() {
        return locPostalCode;
    }

    public void setLocPostalCode(Integer locPostalCode) {
        this.locPostalCode = locPostalCode;
    }

    public String getPerAdd1() {
        return perAdd1;
    }

    public void setPerAdd1(String perAdd1) {
        this.perAdd1 = perAdd1;
    }

    public String getPerAdd2() {
        return perAdd2;
    }

    public void setPerAdd2(String perAdd2) {
        this.perAdd2 = perAdd2;
    }

    public String getPerDistrict() {
        return perDistrict;
    }

    public void setPerDistrict(String perDistrict) {
        this.perDistrict = perDistrict;
    }

    public String getPerState() {
        return perState;
    }

    public void setPerState(String perState) {
        this.perState = perState;
    }

    public String getPerCountry() {
        return perCountry;
    }

    public void setPerCountry(String perCountry) {
        this.perCountry = perCountry;
    }

    public Integer getPerPostalCode() {
        return perPostalCode;
    }

    public void setPerPostalCode(Integer perPostalCode) {
        this.perPostalCode = perPostalCode;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getIfscCode() {
        return ifscCode;
    }

    public void setIfscCode(String ifscCode) {
        this.ifscCode = ifscCode;
    }

    public String getAcctNo() {
        return acctNo;
    }

    public void setAcctNo(String acctNo) {
        this.acctNo = acctNo;
    }

    public String getEmpStatus() {
        return empStatus;
    }

    public void setEmpStatus(String empStatus) {
        this.empStatus = empStatus;
    }

    public double getBasic() {
        return basic;
    }

    public void setBasic(double basic) {
        this.basic = basic;
    }

    public double getTransportAllow() {
        return transportAllow;
    }

    public void setTransportAllow(double transportAllow) {
        this.transportAllow = transportAllow;
    }

    public double getSplAllow() {
        return splAllow;
    }

    public void setSplAllow(double splAllow) {
        this.splAllow = splAllow;
    }

    public double getUniformAllow() {
        return uniformAllow;
    }

    public void setUniformAllow(double uniformAllow) {
        this.uniformAllow = uniformAllow;
    }

    public double getTelephInternetAllow() {
        return telephInternetAllow;
    }

    public void setTelephInternetAllow(double telephInternetAllow) {
        this.telephInternetAllow = telephInternetAllow;
    }

    public double getPerfmBonus() {
        return perfmBonus;
    }

    public void setPerfmBonus(double perfmBonus) {
        this.perfmBonus = perfmBonus;
    }

    public double getMedical() {
        return medical;
    }

    public void setMedical(double medical) {
        this.medical = medical;
    }

    public double getIncomeTax() {
        return incomeTax;
    }

    public void setIncomeTax(double incomeTax) {
        this.incomeTax = incomeTax;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getActiveFlag() {
        return activeFlag;
    }

    public void setActiveFlag(Boolean activeFlag) {
        this.activeFlag = activeFlag;
    }

    public Character getPayReleaseFlag() {
        return payReleaseFlag;
    }

    public void setPayReleaseFlag(Character payReleaseFlag) {
        this.payReleaseFlag = payReleaseFlag;
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

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
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
        if (!(object instanceof MEmpMaster)) {
            return false;
        }
        MEmpMaster other = (MEmpMaster) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.base.biz.entity.MEmpMaster[ id=" + id + " ]";
    }
    
}
