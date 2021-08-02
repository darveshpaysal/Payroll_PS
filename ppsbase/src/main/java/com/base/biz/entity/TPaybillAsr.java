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
@Table(name = "t_paybill_asr")
@NamedQueries({
    @NamedQuery(name = "TPaybillAsr.findAll", query = "SELECT t FROM TPaybillAsr t")
    , @NamedQuery(name = "TPaybillAsr.findById", query = "SELECT t FROM TPaybillAsr t WHERE t.id = :id")
    , @NamedQuery(name = "TPaybillAsr.findByYrNo", query = "SELECT t FROM TPaybillAsr t WHERE t.yrNo = :yrNo")
    , @NamedQuery(name = "TPaybillAsr.findByMthNo", query = "SELECT t FROM TPaybillAsr t WHERE t.mthNo = :mthNo")
    , @NamedQuery(name = "TPaybillAsr.findBySalCode", query = "SELECT t FROM TPaybillAsr t WHERE t.salCode = :salCode")
    , @NamedQuery(name = "TPaybillAsr.findByEcode", query = "SELECT t FROM TPaybillAsr t WHERE t.ecode = :ecode")
    , @NamedQuery(name = "TPaybillAsr.findByCatCode", query = "SELECT t FROM TPaybillAsr t WHERE t.catCode = :catCode")
    , @NamedQuery(name = "TPaybillAsr.findByEmpName", query = "SELECT t FROM TPaybillAsr t WHERE t.empName = :empName")
    , @NamedQuery(name = "TPaybillAsr.findByFathName", query = "SELECT t FROM TPaybillAsr t WHERE t.fathName = :fathName")
    , @NamedQuery(name = "TPaybillAsr.findByDesigCode", query = "SELECT t FROM TPaybillAsr t WHERE t.desigCode = :desigCode")
    , @NamedQuery(name = "TPaybillAsr.findByDeptCode", query = "SELECT t FROM TPaybillAsr t WHERE t.deptCode = :deptCode")
    , @NamedQuery(name = "TPaybillAsr.findByPanNo", query = "SELECT t FROM TPaybillAsr t WHERE t.panNo = :panNo")
    , @NamedQuery(name = "TPaybillAsr.findByPranNo", query = "SELECT t FROM TPaybillAsr t WHERE t.pranNo = :pranNo")
    , @NamedQuery(name = "TPaybillAsr.findByBankAc", query = "SELECT t FROM TPaybillAsr t WHERE t.bankAc = :bankAc")
    , @NamedQuery(name = "TPaybillAsr.findByBankName", query = "SELECT t FROM TPaybillAsr t WHERE t.bankName = :bankName")
    , @NamedQuery(name = "TPaybillAsr.findByBskSal", query = "SELECT t FROM TPaybillAsr t WHERE t.bskSal = :bskSal")
    , @NamedQuery(name = "TPaybillAsr.findByDa", query = "SELECT t FROM TPaybillAsr t WHERE t.da = :da")
    , @NamedQuery(name = "TPaybillAsr.findByHra", query = "SELECT t FROM TPaybillAsr t WHERE t.hra = :hra")
    , @NamedQuery(name = "TPaybillAsr.findByTa", query = "SELECT t FROM TPaybillAsr t WHERE t.ta = :ta")
    , @NamedQuery(name = "TPaybillAsr.findByDaOnTa", query = "SELECT t FROM TPaybillAsr t WHERE t.daOnTa = :daOnTa")
    , @NamedQuery(name = "TPaybillAsr.findBySplPay", query = "SELECT t FROM TPaybillAsr t WHERE t.splPay = :splPay")
    , @NamedQuery(name = "TPaybillAsr.findByNpa", query = "SELECT t FROM TPaybillAsr t WHERE t.npa = :npa")
    , @NamedQuery(name = "TPaybillAsr.findByTelephInternetAllow", query = "SELECT t FROM TPaybillAsr t WHERE t.telephInternetAllow = :telephInternetAllow")
    , @NamedQuery(name = "TPaybillAsr.findByUniformAllow", query = "SELECT t FROM TPaybillAsr t WHERE t.uniformAllow = :uniformAllow")
    , @NamedQuery(name = "TPaybillAsr.findByPerfmBonus", query = "SELECT t FROM TPaybillAsr t WHERE t.perfmBonus = :perfmBonus")
    , @NamedQuery(name = "TPaybillAsr.findByMedicalAlw", query = "SELECT t FROM TPaybillAsr t WHERE t.medicalAlw = :medicalAlw")
    , @NamedQuery(name = "TPaybillAsr.findByOthAlw1", query = "SELECT t FROM TPaybillAsr t WHERE t.othAlw1 = :othAlw1")
    , @NamedQuery(name = "TPaybillAsr.findByOthAlw2", query = "SELECT t FROM TPaybillAsr t WHERE t.othAlw2 = :othAlw2")
    , @NamedQuery(name = "TPaybillAsr.findByTotEarn", query = "SELECT t FROM TPaybillAsr t WHERE t.totEarn = :totEarn")
    , @NamedQuery(name = "TPaybillAsr.findByItTaxDed", query = "SELECT t FROM TPaybillAsr t WHERE t.itTaxDed = :itTaxDed")
    , @NamedQuery(name = "TPaybillAsr.findByBenevolentDed", query = "SELECT t FROM TPaybillAsr t WHERE t.benevolentDed = :benevolentDed")
    , @NamedQuery(name = "TPaybillAsr.findByNpsDed", query = "SELECT t FROM TPaybillAsr t WHERE t.npsDed = :npsDed")
    , @NamedQuery(name = "TPaybillAsr.findByNpsVol", query = "SELECT t FROM TPaybillAsr t WHERE t.npsVol = :npsVol")
    , @NamedQuery(name = "TPaybillAsr.findByNpsEmployer", query = "SELECT t FROM TPaybillAsr t WHERE t.npsEmployer = :npsEmployer")
    , @NamedQuery(name = "TPaybillAsr.findByMiscDed", query = "SELECT t FROM TPaybillAsr t WHERE t.miscDed = :miscDed")
    , @NamedQuery(name = "TPaybillAsr.findByTotDed", query = "SELECT t FROM TPaybillAsr t WHERE t.totDed = :totDed")
    , @NamedQuery(name = "TPaybillAsr.findByBskSalRec", query = "SELECT t FROM TPaybillAsr t WHERE t.bskSalRec = :bskSalRec")
    , @NamedQuery(name = "TPaybillAsr.findByDaRec", query = "SELECT t FROM TPaybillAsr t WHERE t.daRec = :daRec")
    , @NamedQuery(name = "TPaybillAsr.findByHraRec", query = "SELECT t FROM TPaybillAsr t WHERE t.hraRec = :hraRec")
    , @NamedQuery(name = "TPaybillAsr.findByTaRec", query = "SELECT t FROM TPaybillAsr t WHERE t.taRec = :taRec")
    , @NamedQuery(name = "TPaybillAsr.findByDaOnTaRec", query = "SELECT t FROM TPaybillAsr t WHERE t.daOnTaRec = :daOnTaRec")
    , @NamedQuery(name = "TPaybillAsr.findBySplPayRec", query = "SELECT t FROM TPaybillAsr t WHERE t.splPayRec = :splPayRec")
    , @NamedQuery(name = "TPaybillAsr.findByOthAlw1Rec", query = "SELECT t FROM TPaybillAsr t WHERE t.othAlw1Rec = :othAlw1Rec")
    , @NamedQuery(name = "TPaybillAsr.findByOthAlw2Rec", query = "SELECT t FROM TPaybillAsr t WHERE t.othAlw2Rec = :othAlw2Rec")
    , @NamedQuery(name = "TPaybillAsr.findByMiscRec", query = "SELECT t FROM TPaybillAsr t WHERE t.miscRec = :miscRec")
    , @NamedQuery(name = "TPaybillAsr.findBySalaryRecovery", query = "SELECT t FROM TPaybillAsr t WHERE t.salaryRecovery = :salaryRecovery")
    , @NamedQuery(name = "TPaybillAsr.findByTotRec", query = "SELECT t FROM TPaybillAsr t WHERE t.totRec = :totRec")
    , @NamedQuery(name = "TPaybillAsr.findByBskSalRef", query = "SELECT t FROM TPaybillAsr t WHERE t.bskSalRef = :bskSalRef")
    , @NamedQuery(name = "TPaybillAsr.findByDaRef", query = "SELECT t FROM TPaybillAsr t WHERE t.daRef = :daRef")
    , @NamedQuery(name = "TPaybillAsr.findByHraRef", query = "SELECT t FROM TPaybillAsr t WHERE t.hraRef = :hraRef")
    , @NamedQuery(name = "TPaybillAsr.findByTaRef", query = "SELECT t FROM TPaybillAsr t WHERE t.taRef = :taRef")
    , @NamedQuery(name = "TPaybillAsr.findByDaOnTaRef", query = "SELECT t FROM TPaybillAsr t WHERE t.daOnTaRef = :daOnTaRef")
    , @NamedQuery(name = "TPaybillAsr.findBySplPayRef", query = "SELECT t FROM TPaybillAsr t WHERE t.splPayRef = :splPayRef")
    , @NamedQuery(name = "TPaybillAsr.findByOthAlw1Ref", query = "SELECT t FROM TPaybillAsr t WHERE t.othAlw1Ref = :othAlw1Ref")
    , @NamedQuery(name = "TPaybillAsr.findByOthAlw2Ref", query = "SELECT t FROM TPaybillAsr t WHERE t.othAlw2Ref = :othAlw2Ref")
    , @NamedQuery(name = "TPaybillAsr.findByItTaxRef", query = "SELECT t FROM TPaybillAsr t WHERE t.itTaxRef = :itTaxRef")
    , @NamedQuery(name = "TPaybillAsr.findByMiscRef", query = "SELECT t FROM TPaybillAsr t WHERE t.miscRef = :miscRef")
    , @NamedQuery(name = "TPaybillAsr.findByNpsRef", query = "SELECT t FROM TPaybillAsr t WHERE t.npsRef = :npsRef")
    , @NamedQuery(name = "TPaybillAsr.findByBenevolentRef", query = "SELECT t FROM TPaybillAsr t WHERE t.benevolentRef = :benevolentRef")
    , @NamedQuery(name = "TPaybillAsr.findByTotRef", query = "SELECT t FROM TPaybillAsr t WHERE t.totRef = :totRef")
    , @NamedQuery(name = "TPaybillAsr.findByGrossEarn", query = "SELECT t FROM TPaybillAsr t WHERE t.grossEarn = :grossEarn")
    , @NamedQuery(name = "TPaybillAsr.findByNetSal", query = "SELECT t FROM TPaybillAsr t WHERE t.netSal = :netSal")
    , @NamedQuery(name = "TPaybillAsr.findByNetPaybSal", query = "SELECT t FROM TPaybillAsr t WHERE t.netPaybSal = :netPaybSal")
    , @NamedQuery(name = "TPaybillAsr.findByItSalRel", query = "SELECT t FROM TPaybillAsr t WHERE t.itSalRel = :itSalRel")
    , @NamedQuery(name = "TPaybillAsr.findByBasicSal", query = "SELECT t FROM TPaybillAsr t WHERE t.basicSal = :basicSal")
    , @NamedQuery(name = "TPaybillAsr.findByRemark", query = "SELECT t FROM TPaybillAsr t WHERE t.remark = :remark")
    , @NamedQuery(name = "TPaybillAsr.findByVouchNo", query = "SELECT t FROM TPaybillAsr t WHERE t.vouchNo = :vouchNo")
    , @NamedQuery(name = "TPaybillAsr.findByImpFlag", query = "SELECT t FROM TPaybillAsr t WHERE t.impFlag = :impFlag")
    , @NamedQuery(name = "TPaybillAsr.findByBenevolentFlag", query = "SELECT t FROM TPaybillAsr t WHERE t.benevolentFlag = :benevolentFlag")
    , @NamedQuery(name = "TPaybillAsr.findByBasic7pay", query = "SELECT t FROM TPaybillAsr t WHERE t.basic7pay = :basic7pay")
    , @NamedQuery(name = "TPaybillAsr.findByDarate7th", query = "SELECT t FROM TPaybillAsr t WHERE t.darate7th = :darate7th")
    , @NamedQuery(name = "TPaybillAsr.findByCreatedBy", query = "SELECT t FROM TPaybillAsr t WHERE t.createdBy = :createdBy")
    , @NamedQuery(name = "TPaybillAsr.findByCreatedDate", query = "SELECT t FROM TPaybillAsr t WHERE t.createdDate = :createdDate")})
public class TPaybillAsr implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "YR_NO")
    private Integer yrNo;
    @Column(name = "MTH_NO")
    private Integer mthNo;
    @Column(name = "SAL_CODE")
    private Integer salCode;
    @Column(name = "ECODE")
    private String ecode;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "CAT_CODE")
    private Double catCode;
    @Column(name = "EMP_NAME")
    private String empName;
    @Column(name = "FATH_NAME")
    private String fathName;
    @Column(name = "DESIG_CODE")
    private String desigCode;
    @Column(name = "DEPT_CODE")
    private String deptCode;
    @Column(name = "PAN_NO")
    private String panNo;
    @Column(name = "PRAN_NO")
    private String pranNo;
    @Column(name = "BANK_AC")
    private String bankAc;
    @Column(name = "BANK_NAME")
    private String bankName;
    @Basic(optional = false)
    @Column(name = "BSK_SAL")
    private double bskSal;
    @Basic(optional = false)
    @Column(name = "DA")
    private double da;
    @Basic(optional = false)
    @Column(name = "HRA")
    private double hra;
    @Basic(optional = false)
    @Column(name = "TA")
    private double ta;
    @Basic(optional = false)
    @Column(name = "DA_ON_TA")
    private double daOnTa;
    @Basic(optional = false)
    @Column(name = "SPL_PAY")
    private double splPay;
    @Basic(optional = false)
    @Column(name = "NPA")
    private double npa;
    @Basic(optional = false)
    @Column(name = "teleph_internet_allow")
    private double telephInternetAllow;
    @Basic(optional = false)
    @Column(name = "uniform_allow")
    private double uniformAllow;
    @Basic(optional = false)
    @Column(name = "perfm_bonus")
    private double perfmBonus;
    @Basic(optional = false)
    @Column(name = "medical_alw")
    private double medicalAlw;
    @Basic(optional = false)
    @Column(name = "OTH_ALW1")
    private double othAlw1;
    @Basic(optional = false)
    @Column(name = "OTH_ALW2")
    private double othAlw2;
    @Basic(optional = false)
    @Column(name = "TOT_EARN")
    private double totEarn;
    @Basic(optional = false)
    @Column(name = "IT_TAX_DED")
    private double itTaxDed;
    @Basic(optional = false)
    @Column(name = "BENEVOLENT_DED")
    private double benevolentDed;
    @Basic(optional = false)
    @Column(name = "NPS_DED")
    private double npsDed;
    @Basic(optional = false)
    @Column(name = "NPS_VOL")
    private double npsVol;
    @Basic(optional = false)
    @Column(name = "NPS_EMPLOYER")
    private double npsEmployer;
    @Basic(optional = false)
    @Column(name = "MISC_DED")
    private double miscDed;
    @Basic(optional = false)
    @Column(name = "TOT_DED")
    private double totDed;
    @Basic(optional = false)
    @Column(name = "BSK_SAL_REC")
    private double bskSalRec;
    @Basic(optional = false)
    @Column(name = "DA_REC")
    private double daRec;
    @Basic(optional = false)
    @Column(name = "HRA_REC")
    private double hraRec;
    @Basic(optional = false)
    @Column(name = "TA_REC")
    private double taRec;
    @Basic(optional = false)
    @Column(name = "DA_ON_TA_REC")
    private double daOnTaRec;
    @Basic(optional = false)
    @Column(name = "SPL_PAY_REC")
    private double splPayRec;
    @Basic(optional = false)
    @Column(name = "OTH_ALW1_REC")
    private double othAlw1Rec;
    @Basic(optional = false)
    @Column(name = "OTH_ALW2_REC")
    private double othAlw2Rec;
    @Basic(optional = false)
    @Column(name = "MISC_REC")
    private double miscRec;
    @Basic(optional = false)
    @Column(name = "SALARY_RECOVERY")
    private double salaryRecovery;
    @Basic(optional = false)
    @Column(name = "TOT_REC")
    private double totRec;
    @Basic(optional = false)
    @Column(name = "BSK_SAL_REF")
    private double bskSalRef;
    @Basic(optional = false)
    @Column(name = "DA_REF")
    private double daRef;
    @Basic(optional = false)
    @Column(name = "HRA_REF")
    private double hraRef;
    @Basic(optional = false)
    @Column(name = "TA_REF")
    private double taRef;
    @Basic(optional = false)
    @Column(name = "DA_ON_TA_REF")
    private double daOnTaRef;
    @Basic(optional = false)
    @Column(name = "SPL_PAY_REF")
    private double splPayRef;
    @Basic(optional = false)
    @Column(name = "OTH_ALW1_REF")
    private double othAlw1Ref;
    @Basic(optional = false)
    @Column(name = "OTH_ALW2_REF")
    private double othAlw2Ref;
    @Basic(optional = false)
    @Column(name = "IT_TAX_REF")
    private double itTaxRef;
    @Basic(optional = false)
    @Column(name = "MISC_REF")
    private double miscRef;
    @Basic(optional = false)
    @Column(name = "NPS_REF")
    private double npsRef;
    @Basic(optional = false)
    @Column(name = "BENEVOLENT_REF")
    private double benevolentRef;
    @Basic(optional = false)
    @Column(name = "TOT_REF")
    private double totRef;
    @Basic(optional = false)
    @Column(name = "GROSS_EARN")
    private double grossEarn;
    @Basic(optional = false)
    @Column(name = "NET_SAL")
    private double netSal;
    @Basic(optional = false)
    @Column(name = "NET_PAYB_SAL")
    private double netPaybSal;
    @Column(name = "IT_SAL_REL")
    private Character itSalRel;
    @Basic(optional = false)
    @Column(name = "BASIC_SAL")
    private double basicSal;
    @Column(name = "REMARK")
    private String remark;
    @Column(name = "VOUCH_NO")
    private String vouchNo;
    @Column(name = "IMP_FLAG")
    private String impFlag;
    @Column(name = "BENEVOLENT_FLAG")
    private Character benevolentFlag;
    @Column(name = "BASIC_7PAY")
    private Double basic7pay;
    @Column(name = "DARATE_7TH")
    private Double darate7th;
    @Column(name = "created_by")
    private String createdBy;
    @Basic(optional = false)
    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    public TPaybillAsr() {
    }

    public TPaybillAsr(Integer id) {
        this.id = id;
    }

    public TPaybillAsr(Integer id, double bskSal, double da, double hra, double ta, double daOnTa, double splPay, double npa, double telephInternetAllow, double uniformAllow, double perfmBonus, double medicalAlw, double othAlw1, double othAlw2, double totEarn, double itTaxDed, double benevolentDed, double npsDed, double npsVol, double npsEmployer, double miscDed, double totDed, double bskSalRec, double daRec, double hraRec, double taRec, double daOnTaRec, double splPayRec, double othAlw1Rec, double othAlw2Rec, double miscRec, double salaryRecovery, double totRec, double bskSalRef, double daRef, double hraRef, double taRef, double daOnTaRef, double splPayRef, double othAlw1Ref, double othAlw2Ref, double itTaxRef, double miscRef, double npsRef, double benevolentRef, double totRef, double grossEarn, double netSal, double netPaybSal, double basicSal, Date createdDate) {
        this.id = id;
        this.bskSal = bskSal;
        this.da = da;
        this.hra = hra;
        this.ta = ta;
        this.daOnTa = daOnTa;
        this.splPay = splPay;
        this.npa = npa;
        this.telephInternetAllow = telephInternetAllow;
        this.uniformAllow = uniformAllow;
        this.perfmBonus = perfmBonus;
        this.medicalAlw = medicalAlw;
        this.othAlw1 = othAlw1;
        this.othAlw2 = othAlw2;
        this.totEarn = totEarn;
        this.itTaxDed = itTaxDed;
        this.benevolentDed = benevolentDed;
        this.npsDed = npsDed;
        this.npsVol = npsVol;
        this.npsEmployer = npsEmployer;
        this.miscDed = miscDed;
        this.totDed = totDed;
        this.bskSalRec = bskSalRec;
        this.daRec = daRec;
        this.hraRec = hraRec;
        this.taRec = taRec;
        this.daOnTaRec = daOnTaRec;
        this.splPayRec = splPayRec;
        this.othAlw1Rec = othAlw1Rec;
        this.othAlw2Rec = othAlw2Rec;
        this.miscRec = miscRec;
        this.salaryRecovery = salaryRecovery;
        this.totRec = totRec;
        this.bskSalRef = bskSalRef;
        this.daRef = daRef;
        this.hraRef = hraRef;
        this.taRef = taRef;
        this.daOnTaRef = daOnTaRef;
        this.splPayRef = splPayRef;
        this.othAlw1Ref = othAlw1Ref;
        this.othAlw2Ref = othAlw2Ref;
        this.itTaxRef = itTaxRef;
        this.miscRef = miscRef;
        this.npsRef = npsRef;
        this.benevolentRef = benevolentRef;
        this.totRef = totRef;
        this.grossEarn = grossEarn;
        this.netSal = netSal;
        this.netPaybSal = netPaybSal;
        this.basicSal = basicSal;
        this.createdDate = createdDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getYrNo() {
        return yrNo;
    }

    public void setYrNo(Integer yrNo) {
        this.yrNo = yrNo;
    }

    public Integer getMthNo() {
        return mthNo;
    }

    public void setMthNo(Integer mthNo) {
        this.mthNo = mthNo;
    }

    public Integer getSalCode() {
        return salCode;
    }

    public void setSalCode(Integer salCode) {
        this.salCode = salCode;
    }

    public String getEcode() {
        return ecode;
    }

    public void setEcode(String ecode) {
        this.ecode = ecode;
    }

    public Double getCatCode() {
        return catCode;
    }

    public void setCatCode(Double catCode) {
        this.catCode = catCode;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getFathName() {
        return fathName;
    }

    public void setFathName(String fathName) {
        this.fathName = fathName;
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

    public String getBankAc() {
        return bankAc;
    }

    public void setBankAc(String bankAc) {
        this.bankAc = bankAc;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public double getBskSal() {
        return bskSal;
    }

    public void setBskSal(double bskSal) {
        this.bskSal = bskSal;
    }

    public double getDa() {
        return da;
    }

    public void setDa(double da) {
        this.da = da;
    }

    public double getHra() {
        return hra;
    }

    public void setHra(double hra) {
        this.hra = hra;
    }

    public double getTa() {
        return ta;
    }

    public void setTa(double ta) {
        this.ta = ta;
    }

    public double getDaOnTa() {
        return daOnTa;
    }

    public void setDaOnTa(double daOnTa) {
        this.daOnTa = daOnTa;
    }

    public double getSplPay() {
        return splPay;
    }

    public void setSplPay(double splPay) {
        this.splPay = splPay;
    }

    public double getNpa() {
        return npa;
    }

    public void setNpa(double npa) {
        this.npa = npa;
    }

    public double getTelephInternetAllow() {
        return telephInternetAllow;
    }

    public void setTelephInternetAllow(double telephInternetAllow) {
        this.telephInternetAllow = telephInternetAllow;
    }

    public double getUniformAllow() {
        return uniformAllow;
    }

    public void setUniformAllow(double uniformAllow) {
        this.uniformAllow = uniformAllow;
    }

    public double getPerfmBonus() {
        return perfmBonus;
    }

    public void setPerfmBonus(double perfmBonus) {
        this.perfmBonus = perfmBonus;
    }

    public double getMedicalAlw() {
        return medicalAlw;
    }

    public void setMedicalAlw(double medicalAlw) {
        this.medicalAlw = medicalAlw;
    }

    public double getOthAlw1() {
        return othAlw1;
    }

    public void setOthAlw1(double othAlw1) {
        this.othAlw1 = othAlw1;
    }

    public double getOthAlw2() {
        return othAlw2;
    }

    public void setOthAlw2(double othAlw2) {
        this.othAlw2 = othAlw2;
    }

    public double getTotEarn() {
        return totEarn;
    }

    public void setTotEarn(double totEarn) {
        this.totEarn = totEarn;
    }

    public double getItTaxDed() {
        return itTaxDed;
    }

    public void setItTaxDed(double itTaxDed) {
        this.itTaxDed = itTaxDed;
    }

    public double getBenevolentDed() {
        return benevolentDed;
    }

    public void setBenevolentDed(double benevolentDed) {
        this.benevolentDed = benevolentDed;
    }

    public double getNpsDed() {
        return npsDed;
    }

    public void setNpsDed(double npsDed) {
        this.npsDed = npsDed;
    }

    public double getNpsVol() {
        return npsVol;
    }

    public void setNpsVol(double npsVol) {
        this.npsVol = npsVol;
    }

    public double getNpsEmployer() {
        return npsEmployer;
    }

    public void setNpsEmployer(double npsEmployer) {
        this.npsEmployer = npsEmployer;
    }

    public double getMiscDed() {
        return miscDed;
    }

    public void setMiscDed(double miscDed) {
        this.miscDed = miscDed;
    }

    public double getTotDed() {
        return totDed;
    }

    public void setTotDed(double totDed) {
        this.totDed = totDed;
    }

    public double getBskSalRec() {
        return bskSalRec;
    }

    public void setBskSalRec(double bskSalRec) {
        this.bskSalRec = bskSalRec;
    }

    public double getDaRec() {
        return daRec;
    }

    public void setDaRec(double daRec) {
        this.daRec = daRec;
    }

    public double getHraRec() {
        return hraRec;
    }

    public void setHraRec(double hraRec) {
        this.hraRec = hraRec;
    }

    public double getTaRec() {
        return taRec;
    }

    public void setTaRec(double taRec) {
        this.taRec = taRec;
    }

    public double getDaOnTaRec() {
        return daOnTaRec;
    }

    public void setDaOnTaRec(double daOnTaRec) {
        this.daOnTaRec = daOnTaRec;
    }

    public double getSplPayRec() {
        return splPayRec;
    }

    public void setSplPayRec(double splPayRec) {
        this.splPayRec = splPayRec;
    }

    public double getOthAlw1Rec() {
        return othAlw1Rec;
    }

    public void setOthAlw1Rec(double othAlw1Rec) {
        this.othAlw1Rec = othAlw1Rec;
    }

    public double getOthAlw2Rec() {
        return othAlw2Rec;
    }

    public void setOthAlw2Rec(double othAlw2Rec) {
        this.othAlw2Rec = othAlw2Rec;
    }

    public double getMiscRec() {
        return miscRec;
    }

    public void setMiscRec(double miscRec) {
        this.miscRec = miscRec;
    }

    public double getSalaryRecovery() {
        return salaryRecovery;
    }

    public void setSalaryRecovery(double salaryRecovery) {
        this.salaryRecovery = salaryRecovery;
    }

    public double getTotRec() {
        return totRec;
    }

    public void setTotRec(double totRec) {
        this.totRec = totRec;
    }

    public double getBskSalRef() {
        return bskSalRef;
    }

    public void setBskSalRef(double bskSalRef) {
        this.bskSalRef = bskSalRef;
    }

    public double getDaRef() {
        return daRef;
    }

    public void setDaRef(double daRef) {
        this.daRef = daRef;
    }

    public double getHraRef() {
        return hraRef;
    }

    public void setHraRef(double hraRef) {
        this.hraRef = hraRef;
    }

    public double getTaRef() {
        return taRef;
    }

    public void setTaRef(double taRef) {
        this.taRef = taRef;
    }

    public double getDaOnTaRef() {
        return daOnTaRef;
    }

    public void setDaOnTaRef(double daOnTaRef) {
        this.daOnTaRef = daOnTaRef;
    }

    public double getSplPayRef() {
        return splPayRef;
    }

    public void setSplPayRef(double splPayRef) {
        this.splPayRef = splPayRef;
    }

    public double getOthAlw1Ref() {
        return othAlw1Ref;
    }

    public void setOthAlw1Ref(double othAlw1Ref) {
        this.othAlw1Ref = othAlw1Ref;
    }

    public double getOthAlw2Ref() {
        return othAlw2Ref;
    }

    public void setOthAlw2Ref(double othAlw2Ref) {
        this.othAlw2Ref = othAlw2Ref;
    }

    public double getItTaxRef() {
        return itTaxRef;
    }

    public void setItTaxRef(double itTaxRef) {
        this.itTaxRef = itTaxRef;
    }

    public double getMiscRef() {
        return miscRef;
    }

    public void setMiscRef(double miscRef) {
        this.miscRef = miscRef;
    }

    public double getNpsRef() {
        return npsRef;
    }

    public void setNpsRef(double npsRef) {
        this.npsRef = npsRef;
    }

    public double getBenevolentRef() {
        return benevolentRef;
    }

    public void setBenevolentRef(double benevolentRef) {
        this.benevolentRef = benevolentRef;
    }

    public double getTotRef() {
        return totRef;
    }

    public void setTotRef(double totRef) {
        this.totRef = totRef;
    }

    public double getGrossEarn() {
        return grossEarn;
    }

    public void setGrossEarn(double grossEarn) {
        this.grossEarn = grossEarn;
    }

    public double getNetSal() {
        return netSal;
    }

    public void setNetSal(double netSal) {
        this.netSal = netSal;
    }

    public double getNetPaybSal() {
        return netPaybSal;
    }

    public void setNetPaybSal(double netPaybSal) {
        this.netPaybSal = netPaybSal;
    }

    public Character getItSalRel() {
        return itSalRel;
    }

    public void setItSalRel(Character itSalRel) {
        this.itSalRel = itSalRel;
    }

    public double getBasicSal() {
        return basicSal;
    }

    public void setBasicSal(double basicSal) {
        this.basicSal = basicSal;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getVouchNo() {
        return vouchNo;
    }

    public void setVouchNo(String vouchNo) {
        this.vouchNo = vouchNo;
    }

    public String getImpFlag() {
        return impFlag;
    }

    public void setImpFlag(String impFlag) {
        this.impFlag = impFlag;
    }

    public Character getBenevolentFlag() {
        return benevolentFlag;
    }

    public void setBenevolentFlag(Character benevolentFlag) {
        this.benevolentFlag = benevolentFlag;
    }

    public Double getBasic7pay() {
        return basic7pay;
    }

    public void setBasic7pay(Double basic7pay) {
        this.basic7pay = basic7pay;
    }

    public Double getDarate7th() {
        return darate7th;
    }

    public void setDarate7th(Double darate7th) {
        this.darate7th = darate7th;
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
        if (!(object instanceof TPaybillAsr)) {
            return false;
        }
        TPaybillAsr other = (TPaybillAsr) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.base.biz.entity.TPaybillAsr[ id=" + id + " ]";
    }
    
}
