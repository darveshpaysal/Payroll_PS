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
@Table(name = "it_calc")
@NamedQueries({
    @NamedQuery(name = "ItCalc.findAll", query = "SELECT i FROM ItCalc i")
    , @NamedQuery(name = "ItCalc.findById", query = "SELECT i FROM ItCalc i WHERE i.id = :id")
    , @NamedQuery(name = "ItCalc.findByCalcYear", query = "SELECT i FROM ItCalc i WHERE i.calcYear = :calcYear")
    , @NamedQuery(name = "ItCalc.findByAssYear", query = "SELECT i FROM ItCalc i WHERE i.assYear = :assYear")
    , @NamedQuery(name = "ItCalc.findByEcode", query = "SELECT i FROM ItCalc i WHERE i.ecode = :ecode")
    , @NamedQuery(name = "ItCalc.findByEstimatedIncome", query = "SELECT i FROM ItCalc i WHERE i.estimatedIncome = :estimatedIncome")
    , @NamedQuery(name = "ItCalc.findByFreeAccom", query = "SELECT i FROM ItCalc i WHERE i.freeAccom = :freeAccom")
    , @NamedQuery(name = "ItCalc.findByGrossSalary", query = "SELECT i FROM ItCalc i WHERE i.grossSalary = :grossSalary")
    , @NamedQuery(name = "ItCalc.findByActalHraLess", query = "SELECT i FROM ItCalc i WHERE i.actalHraLess = :actalHraLess")
    , @NamedQuery(name = "ItCalc.findByExpenOnrentA", query = "SELECT i FROM ItCalc i WHERE i.expenOnrentA = :expenOnrentA")
    , @NamedQuery(name = "ItCalc.findByExpenOnrentA1", query = "SELECT i FROM ItCalc i WHERE i.expenOnrentA1 = :expenOnrentA1")
    , @NamedQuery(name = "ItCalc.findByLessHra", query = "SELECT i FROM ItCalc i WHERE i.lessHra = :lessHra")
    , @NamedQuery(name = "ItCalc.findByTransportAll", query = "SELECT i FROM ItCalc i WHERE i.transportAll = :transportAll")
    , @NamedQuery(name = "ItCalc.findByCrAll", query = "SELECT i FROM ItCalc i WHERE i.crAll = :crAll")
    , @NamedQuery(name = "ItCalc.findByUniformAll", query = "SELECT i FROM ItCalc i WHERE i.uniformAll = :uniformAll")
    , @NamedQuery(name = "ItCalc.findByWashingAll", query = "SELECT i FROM ItCalc i WHERE i.washingAll = :washingAll")
    , @NamedQuery(name = "ItCalc.findByTotalExemption", query = "SELECT i FROM ItCalc i WHERE i.totalExemption = :totalExemption")
    , @NamedQuery(name = "ItCalc.findByTotalSalary", query = "SELECT i FROM ItCalc i WHERE i.totalSalary = :totalSalary")
    , @NamedQuery(name = "ItCalc.findByGpf", query = "SELECT i FROM ItCalc i WHERE i.gpf = :gpf")
    , @NamedQuery(name = "ItCalc.findByPpf", query = "SELECT i FROM ItCalc i WHERE i.ppf = :ppf")
    , @NamedQuery(name = "ItCalc.findByGis", query = "SELECT i FROM ItCalc i WHERE i.gis = :gis")
    , @NamedQuery(name = "ItCalc.findByMscIntt", query = "SELECT i FROM ItCalc i WHERE i.mscIntt = :mscIntt")
    , @NamedQuery(name = "ItCalc.findByLicPrem", query = "SELECT i FROM ItCalc i WHERE i.licPrem = :licPrem")
    , @NamedQuery(name = "ItCalc.findByPli", query = "SELECT i FROM ItCalc i WHERE i.pli = :pli")
    , @NamedQuery(name = "ItCalc.findByTutionFee", query = "SELECT i FROM ItCalc i WHERE i.tutionFee = :tutionFee")
    , @NamedQuery(name = "ItCalc.findByUlip", query = "SELECT i FROM ItCalc i WHERE i.ulip = :ulip")
    , @NamedQuery(name = "ItCalc.findByRepaymentHba", query = "SELECT i FROM ItCalc i WHERE i.repaymentHba = :repaymentHba")
    , @NamedQuery(name = "ItCalc.findByNotifiedMutal", query = "SELECT i FROM ItCalc i WHERE i.notifiedMutal = :notifiedMutal")
    , @NamedQuery(name = "ItCalc.findByNetSalary", query = "SELECT i FROM ItCalc i WHERE i.netSalary = :netSalary")
    , @NamedQuery(name = "ItCalc.findByRentalIncome", query = "SELECT i FROM ItCalc i WHERE i.rentalIncome = :rentalIncome")
    , @NamedQuery(name = "ItCalc.findBySubsidyHba", query = "SELECT i FROM ItCalc i WHERE i.subsidyHba = :subsidyHba")
    , @NamedQuery(name = "ItCalc.findByTotalHouseIncome", query = "SELECT i FROM ItCalc i WHERE i.totalHouseIncome = :totalHouseIncome")
    , @NamedQuery(name = "ItCalc.findByInttHba", query = "SELECT i FROM ItCalc i WHERE i.inttHba = :inttHba")
    , @NamedQuery(name = "ItCalc.findByNetIncomeHouseProp", query = "SELECT i FROM ItCalc i WHERE i.netIncomeHouseProp = :netIncomeHouseProp")
    , @NamedQuery(name = "ItCalc.findByBalance", query = "SELECT i FROM ItCalc i WHERE i.balance = :balance")
    , @NamedQuery(name = "ItCalc.findByGratuityPension", query = "SELECT i FROM ItCalc i WHERE i.gratuityPension = :gratuityPension")
    , @NamedQuery(name = "ItCalc.findByInttNsc", query = "SELECT i FROM ItCalc i WHERE i.inttNsc = :inttNsc")
    , @NamedQuery(name = "ItCalc.findByInttBankDeposit", query = "SELECT i FROM ItCalc i WHERE i.inttBankDeposit = :inttBankDeposit")
    , @NamedQuery(name = "ItCalc.findByAnyOtherIncome", query = "SELECT i FROM ItCalc i WHERE i.anyOtherIncome = :anyOtherIncome")
    , @NamedQuery(name = "ItCalc.findByGrossTotal", query = "SELECT i FROM ItCalc i WHERE i.grossTotal = :grossTotal")
    , @NamedQuery(name = "ItCalc.findByNetTaxableIncome", query = "SELECT i FROM ItCalc i WHERE i.netTaxableIncome = :netTaxableIncome")
    , @NamedQuery(name = "ItCalc.findByNetTaxableIncomeRound", query = "SELECT i FROM ItCalc i WHERE i.netTaxableIncomeRound = :netTaxableIncomeRound")
    , @NamedQuery(name = "ItCalc.findByIncomeTaxDue", query = "SELECT i FROM ItCalc i WHERE i.incomeTaxDue = :incomeTaxDue")
    , @NamedQuery(name = "ItCalc.findByEducationCess", query = "SELECT i FROM ItCalc i WHERE i.educationCess = :educationCess")
    , @NamedQuery(name = "ItCalc.findByNetTaxDue", query = "SELECT i FROM ItCalc i WHERE i.netTaxDue = :netTaxDue")
    , @NamedQuery(name = "ItCalc.findByDedOnSalary", query = "SELECT i FROM ItCalc i WHERE i.dedOnSalary = :dedOnSalary")
    , @NamedQuery(name = "ItCalc.findByDedOnOthers", query = "SELECT i FROM ItCalc i WHERE i.dedOnOthers = :dedOnOthers")
    , @NamedQuery(name = "ItCalc.findByNetTaxPayble", query = "SELECT i FROM ItCalc i WHERE i.netTaxPayble = :netTaxPayble")
    , @NamedQuery(name = "ItCalc.findByNsc", query = "SELECT i FROM ItCalc i WHERE i.nsc = :nsc")
    , @NamedQuery(name = "ItCalc.findBySurcharge", query = "SELECT i FROM ItCalc i WHERE i.surcharge = :surcharge")
    , @NamedQuery(name = "ItCalc.findByInttHbaDate", query = "SELECT i FROM ItCalc i WHERE i.inttHbaDate = :inttHbaDate")
    , @NamedQuery(name = "ItCalc.findByJeevan", query = "SELECT i FROM ItCalc i WHERE i.jeevan = :jeevan")
    , @NamedQuery(name = "ItCalc.findByBond", query = "SELECT i FROM ItCalc i WHERE i.bond = :bond")
    , @NamedQuery(name = "ItCalc.findByEduPer", query = "SELECT i FROM ItCalc i WHERE i.eduPer = :eduPer")
    , @NamedQuery(name = "ItCalc.findBySurPer", query = "SELECT i FROM ItCalc i WHERE i.surPer = :surPer")
    , @NamedQuery(name = "ItCalc.findByOthAll", query = "SELECT i FROM ItCalc i WHERE i.othAll = :othAll")
    , @NamedQuery(name = "ItCalc.findByPrent", query = "SELECT i FROM ItCalc i WHERE i.prent = :prent")
    , @NamedQuery(name = "ItCalc.findByNoMths", query = "SELECT i FROM ItCalc i WHERE i.noMths = :noMths")
    , @NamedQuery(name = "ItCalc.findByMonTax", query = "SELECT i FROM ItCalc i WHERE i.monTax = :monTax")
    , @NamedQuery(name = "ItCalc.findByDocNo", query = "SELECT i FROM ItCalc i WHERE i.docNo = :docNo")
    , @NamedQuery(name = "ItCalc.findByLvCashNt", query = "SELECT i FROM ItCalc i WHERE i.lvCashNt = :lvCashNt")
    , @NamedQuery(name = "ItCalc.findByDocComplete", query = "SELECT i FROM ItCalc i WHERE i.docComplete = :docComplete")
    , @NamedQuery(name = "ItCalc.findByMediclaim", query = "SELECT i FROM ItCalc i WHERE i.mediclaim = :mediclaim")
    , @NamedQuery(name = "ItCalc.findByAnyother", query = "SELECT i FROM ItCalc i WHERE i.anyother = :anyother")
    , @NamedQuery(name = "ItCalc.findByChkTag", query = "SELECT i FROM ItCalc i WHERE i.chkTag = :chkTag")
    , @NamedQuery(name = "ItCalc.findByTransdate", query = "SELECT i FROM ItCalc i WHERE i.transdate = :transdate")
    , @NamedQuery(name = "ItCalc.findByUsername", query = "SELECT i FROM ItCalc i WHERE i.username = :username")
    , @NamedQuery(name = "ItCalc.findByTta80", query = "SELECT i FROM ItCalc i WHERE i.tta80 = :tta80")
    , @NamedQuery(name = "ItCalc.findByNpsDed", query = "SELECT i FROM ItCalc i WHERE i.npsDed = :npsDed")
    , @NamedQuery(name = "ItCalc.findByNpsVol", query = "SELECT i FROM ItCalc i WHERE i.npsVol = :npsVol")
    , @NamedQuery(name = "ItCalc.findByNpsBack", query = "SELECT i FROM ItCalc i WHERE i.npsBack = :npsBack")
    , @NamedQuery(name = "ItCalc.findByInttHbaAft", query = "SELECT i FROM ItCalc i WHERE i.inttHbaAft = :inttHbaAft")
    , @NamedQuery(name = "ItCalc.findByInttsac", query = "SELECT i FROM ItCalc i WHERE i.inttsac = :inttsac")
    , @NamedQuery(name = "ItCalc.findByDisa40", query = "SELECT i FROM ItCalc i WHERE i.disa40 = :disa40")
    , @NamedQuery(name = "ItCalc.findByDisa80", query = "SELECT i FROM ItCalc i WHERE i.disa80 = :disa80")
    , @NamedQuery(name = "ItCalc.findByHandi40", query = "SELECT i FROM ItCalc i WHERE i.handi40 = :handi40")
    , @NamedQuery(name = "ItCalc.findByHandi80", query = "SELECT i FROM ItCalc i WHERE i.handi80 = :handi80")
    , @NamedQuery(name = "ItCalc.findByMediTreat", query = "SELECT i FROM ItCalc i WHERE i.mediTreat = :mediTreat")
    , @NamedQuery(name = "ItCalc.findByInttHigEdu", query = "SELECT i FROM ItCalc i WHERE i.inttHigEdu = :inttHigEdu")
    , @NamedQuery(name = "ItCalc.findByRebate89", query = "SELECT i FROM ItCalc i WHERE i.rebate89 = :rebate89")
    , @NamedQuery(name = "ItCalc.findByRebate87", query = "SELECT i FROM ItCalc i WHERE i.rebate87 = :rebate87")
    , @NamedQuery(name = "ItCalc.findByDonation", query = "SELECT i FROM ItCalc i WHERE i.donation = :donation")
    , @NamedQuery(name = "ItCalc.findByDedOnOthersHead", query = "SELECT i FROM ItCalc i WHERE i.dedOnOthersHead = :dedOnOthersHead")
    , @NamedQuery(name = "ItCalc.findByRebate89Head", query = "SELECT i FROM ItCalc i WHERE i.rebate89Head = :rebate89Head")
    , @NamedQuery(name = "ItCalc.findByIncomeTaxDue1", query = "SELECT i FROM ItCalc i WHERE i.incomeTaxDue1 = :incomeTaxDue1")
    , @NamedQuery(name = "ItCalc.findByGrossIncome", query = "SELECT i FROM ItCalc i WHERE i.grossIncome = :grossIncome")
    , @NamedQuery(name = "ItCalc.findByBenificialDed", query = "SELECT i FROM ItCalc i WHERE i.benificialDed = :benificialDed")
    , @NamedQuery(name = "ItCalc.findByPensionFlag", query = "SELECT i FROM ItCalc i WHERE i.pensionFlag = :pensionFlag")
    , @NamedQuery(name = "ItCalc.findByPenEcode", query = "SELECT i FROM ItCalc i WHERE i.penEcode = :penEcode")
    , @NamedQuery(name = "ItCalc.findBySsa", query = "SELECT i FROM ItCalc i WHERE i.ssa = :ssa")
    , @NamedQuery(name = "ItCalc.findByNpsAdd", query = "SELECT i FROM ItCalc i WHERE i.npsAdd = :npsAdd")
    , @NamedQuery(name = "ItCalc.findByMedicSenc", query = "SELECT i FROM ItCalc i WHERE i.medicSenc = :medicSenc")
    , @NamedQuery(name = "ItCalc.findByDepnSenc", query = "SELECT i FROM ItCalc i WHERE i.depnSenc = :depnSenc")
    , @NamedQuery(name = "ItCalc.findByNpsEmplyrPrtEarn", query = "SELECT i FROM ItCalc i WHERE i.npsEmplyrPrtEarn = :npsEmplyrPrtEarn")
    , @NamedQuery(name = "ItCalc.findByNpsEmplyrPrtRebate", query = "SELECT i FROM ItCalc i WHERE i.npsEmplyrPrtRebate = :npsEmplyrPrtRebate")
    , @NamedQuery(name = "ItCalc.findByOwnerName", query = "SELECT i FROM ItCalc i WHERE i.ownerName = :ownerName")
    , @NamedQuery(name = "ItCalc.findByOwnerPan", query = "SELECT i FROM ItCalc i WHERE i.ownerPan = :ownerPan")
    , @NamedQuery(name = "ItCalc.findByStandDedLess40k", query = "SELECT i FROM ItCalc i WHERE i.standDedLess40k = :standDedLess40k")
    , @NamedQuery(name = "ItCalc.findByHbaBankName", query = "SELECT i FROM ItCalc i WHERE i.hbaBankName = :hbaBankName")
    , @NamedQuery(name = "ItCalc.findByHbaBankPan", query = "SELECT i FROM ItCalc i WHERE i.hbaBankPan = :hbaBankPan")
    , @NamedQuery(name = "ItCalc.findByTtb80", query = "SELECT i FROM ItCalc i WHERE i.ttb80 = :ttb80")
    , @NamedQuery(name = "ItCalc.findByEea", query = "SELECT i FROM ItCalc i WHERE i.eea = :eea")
    , @NamedQuery(name = "ItCalc.findByGratuityExemp", query = "SELECT i FROM ItCalc i WHERE i.gratuityExemp = :gratuityExemp")
    , @NamedQuery(name = "ItCalc.findByCreatedBy", query = "SELECT i FROM ItCalc i WHERE i.createdBy = :createdBy")
    , @NamedQuery(name = "ItCalc.findByCreatedDate", query = "SELECT i FROM ItCalc i WHERE i.createdDate = :createdDate")})
public class ItCalc implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "CALC_YEAR")
    private String calcYear;
    @Column(name = "ASS_YEAR")
    private String assYear;
    @Column(name = "ECODE")
    private String ecode;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "ESTIMATED_INCOME")
    private Double estimatedIncome;
    @Column(name = "FREE_ACCOM")
    private Double freeAccom;
    @Column(name = "GROSS_SALARY")
    private Double grossSalary;
    @Column(name = "ACTAL_HRA_LESS")
    private Double actalHraLess;
    @Column(name = "EXPEN_ONRENT_A")
    private Double expenOnrentA;
    @Column(name = "EXPEN_ONRENT_A1")
    private Double expenOnrentA1;
    @Column(name = "LESS_HRA")
    private Double lessHra;
    @Column(name = "TRANSPORT_ALL")
    private Double transportAll;
    @Column(name = "CR_ALL")
    private Double crAll;
    @Column(name = "UNIFORM_ALL")
    private Double uniformAll;
    @Column(name = "WASHING_ALL")
    private Double washingAll;
    @Column(name = "TOTAL_EXEMPTION")
    private Double totalExemption;
    @Column(name = "TOTAL_SALARY")
    private Double totalSalary;
    @Column(name = "GPF")
    private Double gpf;
    @Column(name = "PPF")
    private Double ppf;
    @Column(name = "GIS")
    private Double gis;
    @Column(name = "MSC_INTT")
    private Double mscIntt;
    @Column(name = "LIC_PREM")
    private Double licPrem;
    @Column(name = "PLI")
    private Double pli;
    @Column(name = "TUTION_FEE")
    private Double tutionFee;
    @Column(name = "ULIP")
    private Double ulip;
    @Column(name = "REPAYMENT_HBA")
    private Double repaymentHba;
    @Column(name = "NOTIFIED_MUTAL")
    private Double notifiedMutal;
    @Column(name = "NET_SALARY")
    private Double netSalary;
    @Column(name = "RENTAL_INCOME")
    private Double rentalIncome;
    @Column(name = "SUBSIDY_HBA")
    private Double subsidyHba;
    @Column(name = "TOTAL_HOUSE_INCOME")
    private Double totalHouseIncome;
    @Column(name = "INTT_HBA")
    private Double inttHba;
    @Column(name = "NET_INCOME_HOUSE_PROP")
    private Double netIncomeHouseProp;
    @Column(name = "BALANCE")
    private Double balance;
    @Column(name = "GRATUITY_PENSION")
    private Double gratuityPension;
    @Column(name = "INTT_NSC")
    private Double inttNsc;
    @Column(name = "INTT_BANK_DEPOSIT")
    private Double inttBankDeposit;
    @Column(name = "ANY_OTHER_INCOME")
    private Double anyOtherIncome;
    @Column(name = "GROSS_TOTAL")
    private Double grossTotal;
    @Column(name = "NET_TAXABLE_INCOME")
    private Double netTaxableIncome;
    @Column(name = "NET_TAXABLE_INCOME_ROUND")
    private Double netTaxableIncomeRound;
    @Column(name = "INCOME_TAX_DUE")
    private Double incomeTaxDue;
    @Column(name = "EDUCATION_CESS")
    private Double educationCess;
    @Column(name = "NET_TAX_DUE")
    private Double netTaxDue;
    @Column(name = "DED_ON_SALARY")
    private Double dedOnSalary;
    @Column(name = "DED_ON_OTHERS")
    private Double dedOnOthers;
    @Column(name = "NET_TAX_PAYBLE")
    private Double netTaxPayble;
    @Column(name = "NSC")
    private Double nsc;
    @Column(name = "SURCHARGE")
    private Double surcharge;
    @Column(name = "INTT_HBA_DATE")
    @Temporal(TemporalType.DATE)
    private Date inttHbaDate;
    @Column(name = "JEEVAN")
    private Double jeevan;
    @Column(name = "BOND")
    private Double bond;
    @Column(name = "EDU_PER")
    private Double eduPer;
    @Column(name = "SUR_PER")
    private Double surPer;
    @Column(name = "OTH_ALL")
    private Double othAll;
    @Column(name = "PRENT")
    private Double prent;
    @Column(name = "NO_MTHS")
    private Double noMths;
    @Column(name = "MON_TAX")
    private Double monTax;
    @Column(name = "DOC_NO")
    private String docNo;
    @Column(name = "LV_CASH_NT")
    private Double lvCashNt;
    @Column(name = "DOC_COMPLETE")
    private Character docComplete;
    @Column(name = "MEDICLAIM")
    private Double mediclaim;
    @Column(name = "ANYOTHER")
    private Double anyother;
    @Column(name = "CHK_TAG")
    private Character chkTag;
    @Basic(optional = false)
    @Column(name = "TRANSDATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date transdate;
    @Column(name = "USERNAME")
    private String username;
    @Column(name = "TTA80")
    private Double tta80;
    @Column(name = "NPS_DED")
    private Double npsDed;
    @Column(name = "NPS_VOL")
    private Double npsVol;
    @Column(name = "NPS_BACK")
    private Double npsBack;
    @Column(name = "INTT_HBA_AFT")
    private Double inttHbaAft;
    @Column(name = "INTTSAC")
    private Double inttsac;
    @Column(name = "DISA_40")
    private Double disa40;
    @Column(name = "DISA_80")
    private Double disa80;
    @Column(name = "HANDI_40")
    private Double handi40;
    @Column(name = "HANDI_80")
    private Double handi80;
    @Column(name = "MEDI_TREAT")
    private Double mediTreat;
    @Column(name = "INTT_HIG_EDU")
    private Double inttHigEdu;
    @Column(name = "REBATE_89")
    private Double rebate89;
    @Column(name = "REBATE_87")
    private Double rebate87;
    @Column(name = "DONATION")
    private Double donation;
    @Column(name = "DED_ON_OTHERS_HEAD")
    private String dedOnOthersHead;
    @Column(name = "REBATE_89_HEAD")
    private String rebate89Head;
    @Column(name = "INCOME_TAX_DUE_1")
    private Double incomeTaxDue1;
    @Column(name = "GROSS_INCOME")
    private Double grossIncome;
    @Column(name = "BENIFICIAL_DED")
    private Double benificialDed;
    @Column(name = "PENSION_FLAG")
    private Character pensionFlag;
    @Column(name = "PEN_ECODE")
    private String penEcode;
    @Column(name = "SSA")
    private Double ssa;
    @Column(name = "NPS_ADD")
    private Double npsAdd;
    @Column(name = "MEDIC_SENC")
    private Double medicSenc;
    @Column(name = "DEPN_SENC")
    private Double depnSenc;
    @Column(name = "NPS_EMPLYR_PRT_EARN")
    private Double npsEmplyrPrtEarn;
    @Column(name = "NPS_EMPLYR_PRT_REBATE")
    private Double npsEmplyrPrtRebate;
    @Column(name = "OWNER_NAME")
    private String ownerName;
    @Column(name = "OWNER_PAN")
    private String ownerPan;
    @Column(name = "STAND_DED_LESS_40K")
    private Double standDedLess40k;
    @Column(name = "HBA_BANK_NAME")
    private String hbaBankName;
    @Column(name = "HBA_BANK_PAN")
    private String hbaBankPan;
    @Column(name = "TTB80")
    private Double ttb80;
    @Column(name = "EEA")
    private Double eea;
    @Column(name = "GRATUITY_EXEMP")
    private Double gratuityExemp;
    @Column(name = "created_by")
    private String createdBy;
    @Basic(optional = false)
    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    public ItCalc() {
    }

    public ItCalc(Integer id) {
        this.id = id;
    }

    public ItCalc(Integer id, Date transdate, Date createdDate) {
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

    public String getCalcYear() {
        return calcYear;
    }

    public void setCalcYear(String calcYear) {
        this.calcYear = calcYear;
    }

    public String getAssYear() {
        return assYear;
    }

    public void setAssYear(String assYear) {
        this.assYear = assYear;
    }

    public String getEcode() {
        return ecode;
    }

    public void setEcode(String ecode) {
        this.ecode = ecode;
    }

    public Double getEstimatedIncome() {
        return estimatedIncome;
    }

    public void setEstimatedIncome(Double estimatedIncome) {
        this.estimatedIncome = estimatedIncome;
    }

    public Double getFreeAccom() {
        return freeAccom;
    }

    public void setFreeAccom(Double freeAccom) {
        this.freeAccom = freeAccom;
    }

    public Double getGrossSalary() {
        return grossSalary;
    }

    public void setGrossSalary(Double grossSalary) {
        this.grossSalary = grossSalary;
    }

    public Double getActalHraLess() {
        return actalHraLess;
    }

    public void setActalHraLess(Double actalHraLess) {
        this.actalHraLess = actalHraLess;
    }

    public Double getExpenOnrentA() {
        return expenOnrentA;
    }

    public void setExpenOnrentA(Double expenOnrentA) {
        this.expenOnrentA = expenOnrentA;
    }

    public Double getExpenOnrentA1() {
        return expenOnrentA1;
    }

    public void setExpenOnrentA1(Double expenOnrentA1) {
        this.expenOnrentA1 = expenOnrentA1;
    }

    public Double getLessHra() {
        return lessHra;
    }

    public void setLessHra(Double lessHra) {
        this.lessHra = lessHra;
    }

    public Double getTransportAll() {
        return transportAll;
    }

    public void setTransportAll(Double transportAll) {
        this.transportAll = transportAll;
    }

    public Double getCrAll() {
        return crAll;
    }

    public void setCrAll(Double crAll) {
        this.crAll = crAll;
    }

    public Double getUniformAll() {
        return uniformAll;
    }

    public void setUniformAll(Double uniformAll) {
        this.uniformAll = uniformAll;
    }

    public Double getWashingAll() {
        return washingAll;
    }

    public void setWashingAll(Double washingAll) {
        this.washingAll = washingAll;
    }

    public Double getTotalExemption() {
        return totalExemption;
    }

    public void setTotalExemption(Double totalExemption) {
        this.totalExemption = totalExemption;
    }

    public Double getTotalSalary() {
        return totalSalary;
    }

    public void setTotalSalary(Double totalSalary) {
        this.totalSalary = totalSalary;
    }

    public Double getGpf() {
        return gpf;
    }

    public void setGpf(Double gpf) {
        this.gpf = gpf;
    }

    public Double getPpf() {
        return ppf;
    }

    public void setPpf(Double ppf) {
        this.ppf = ppf;
    }

    public Double getGis() {
        return gis;
    }

    public void setGis(Double gis) {
        this.gis = gis;
    }

    public Double getMscIntt() {
        return mscIntt;
    }

    public void setMscIntt(Double mscIntt) {
        this.mscIntt = mscIntt;
    }

    public Double getLicPrem() {
        return licPrem;
    }

    public void setLicPrem(Double licPrem) {
        this.licPrem = licPrem;
    }

    public Double getPli() {
        return pli;
    }

    public void setPli(Double pli) {
        this.pli = pli;
    }

    public Double getTutionFee() {
        return tutionFee;
    }

    public void setTutionFee(Double tutionFee) {
        this.tutionFee = tutionFee;
    }

    public Double getUlip() {
        return ulip;
    }

    public void setUlip(Double ulip) {
        this.ulip = ulip;
    }

    public Double getRepaymentHba() {
        return repaymentHba;
    }

    public void setRepaymentHba(Double repaymentHba) {
        this.repaymentHba = repaymentHba;
    }

    public Double getNotifiedMutal() {
        return notifiedMutal;
    }

    public void setNotifiedMutal(Double notifiedMutal) {
        this.notifiedMutal = notifiedMutal;
    }

    public Double getNetSalary() {
        return netSalary;
    }

    public void setNetSalary(Double netSalary) {
        this.netSalary = netSalary;
    }

    public Double getRentalIncome() {
        return rentalIncome;
    }

    public void setRentalIncome(Double rentalIncome) {
        this.rentalIncome = rentalIncome;
    }

    public Double getSubsidyHba() {
        return subsidyHba;
    }

    public void setSubsidyHba(Double subsidyHba) {
        this.subsidyHba = subsidyHba;
    }

    public Double getTotalHouseIncome() {
        return totalHouseIncome;
    }

    public void setTotalHouseIncome(Double totalHouseIncome) {
        this.totalHouseIncome = totalHouseIncome;
    }

    public Double getInttHba() {
        return inttHba;
    }

    public void setInttHba(Double inttHba) {
        this.inttHba = inttHba;
    }

    public Double getNetIncomeHouseProp() {
        return netIncomeHouseProp;
    }

    public void setNetIncomeHouseProp(Double netIncomeHouseProp) {
        this.netIncomeHouseProp = netIncomeHouseProp;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Double getGratuityPension() {
        return gratuityPension;
    }

    public void setGratuityPension(Double gratuityPension) {
        this.gratuityPension = gratuityPension;
    }

    public Double getInttNsc() {
        return inttNsc;
    }

    public void setInttNsc(Double inttNsc) {
        this.inttNsc = inttNsc;
    }

    public Double getInttBankDeposit() {
        return inttBankDeposit;
    }

    public void setInttBankDeposit(Double inttBankDeposit) {
        this.inttBankDeposit = inttBankDeposit;
    }

    public Double getAnyOtherIncome() {
        return anyOtherIncome;
    }

    public void setAnyOtherIncome(Double anyOtherIncome) {
        this.anyOtherIncome = anyOtherIncome;
    }

    public Double getGrossTotal() {
        return grossTotal;
    }

    public void setGrossTotal(Double grossTotal) {
        this.grossTotal = grossTotal;
    }

    public Double getNetTaxableIncome() {
        return netTaxableIncome;
    }

    public void setNetTaxableIncome(Double netTaxableIncome) {
        this.netTaxableIncome = netTaxableIncome;
    }

    public Double getNetTaxableIncomeRound() {
        return netTaxableIncomeRound;
    }

    public void setNetTaxableIncomeRound(Double netTaxableIncomeRound) {
        this.netTaxableIncomeRound = netTaxableIncomeRound;
    }

    public Double getIncomeTaxDue() {
        return incomeTaxDue;
    }

    public void setIncomeTaxDue(Double incomeTaxDue) {
        this.incomeTaxDue = incomeTaxDue;
    }

    public Double getEducationCess() {
        return educationCess;
    }

    public void setEducationCess(Double educationCess) {
        this.educationCess = educationCess;
    }

    public Double getNetTaxDue() {
        return netTaxDue;
    }

    public void setNetTaxDue(Double netTaxDue) {
        this.netTaxDue = netTaxDue;
    }

    public Double getDedOnSalary() {
        return dedOnSalary;
    }

    public void setDedOnSalary(Double dedOnSalary) {
        this.dedOnSalary = dedOnSalary;
    }

    public Double getDedOnOthers() {
        return dedOnOthers;
    }

    public void setDedOnOthers(Double dedOnOthers) {
        this.dedOnOthers = dedOnOthers;
    }

    public Double getNetTaxPayble() {
        return netTaxPayble;
    }

    public void setNetTaxPayble(Double netTaxPayble) {
        this.netTaxPayble = netTaxPayble;
    }

    public Double getNsc() {
        return nsc;
    }

    public void setNsc(Double nsc) {
        this.nsc = nsc;
    }

    public Double getSurcharge() {
        return surcharge;
    }

    public void setSurcharge(Double surcharge) {
        this.surcharge = surcharge;
    }

    public Date getInttHbaDate() {
        return inttHbaDate;
    }

    public void setInttHbaDate(Date inttHbaDate) {
        this.inttHbaDate = inttHbaDate;
    }

    public Double getJeevan() {
        return jeevan;
    }

    public void setJeevan(Double jeevan) {
        this.jeevan = jeevan;
    }

    public Double getBond() {
        return bond;
    }

    public void setBond(Double bond) {
        this.bond = bond;
    }

    public Double getEduPer() {
        return eduPer;
    }

    public void setEduPer(Double eduPer) {
        this.eduPer = eduPer;
    }

    public Double getSurPer() {
        return surPer;
    }

    public void setSurPer(Double surPer) {
        this.surPer = surPer;
    }

    public Double getOthAll() {
        return othAll;
    }

    public void setOthAll(Double othAll) {
        this.othAll = othAll;
    }

    public Double getPrent() {
        return prent;
    }

    public void setPrent(Double prent) {
        this.prent = prent;
    }

    public Double getNoMths() {
        return noMths;
    }

    public void setNoMths(Double noMths) {
        this.noMths = noMths;
    }

    public Double getMonTax() {
        return monTax;
    }

    public void setMonTax(Double monTax) {
        this.monTax = monTax;
    }

    public String getDocNo() {
        return docNo;
    }

    public void setDocNo(String docNo) {
        this.docNo = docNo;
    }

    public Double getLvCashNt() {
        return lvCashNt;
    }

    public void setLvCashNt(Double lvCashNt) {
        this.lvCashNt = lvCashNt;
    }

    public Character getDocComplete() {
        return docComplete;
    }

    public void setDocComplete(Character docComplete) {
        this.docComplete = docComplete;
    }

    public Double getMediclaim() {
        return mediclaim;
    }

    public void setMediclaim(Double mediclaim) {
        this.mediclaim = mediclaim;
    }

    public Double getAnyother() {
        return anyother;
    }

    public void setAnyother(Double anyother) {
        this.anyother = anyother;
    }

    public Character getChkTag() {
        return chkTag;
    }

    public void setChkTag(Character chkTag) {
        this.chkTag = chkTag;
    }

    public Date getTransdate() {
        return transdate;
    }

    public void setTransdate(Date transdate) {
        this.transdate = transdate;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Double getTta80() {
        return tta80;
    }

    public void setTta80(Double tta80) {
        this.tta80 = tta80;
    }

    public Double getNpsDed() {
        return npsDed;
    }

    public void setNpsDed(Double npsDed) {
        this.npsDed = npsDed;
    }

    public Double getNpsVol() {
        return npsVol;
    }

    public void setNpsVol(Double npsVol) {
        this.npsVol = npsVol;
    }

    public Double getNpsBack() {
        return npsBack;
    }

    public void setNpsBack(Double npsBack) {
        this.npsBack = npsBack;
    }

    public Double getInttHbaAft() {
        return inttHbaAft;
    }

    public void setInttHbaAft(Double inttHbaAft) {
        this.inttHbaAft = inttHbaAft;
    }

    public Double getInttsac() {
        return inttsac;
    }

    public void setInttsac(Double inttsac) {
        this.inttsac = inttsac;
    }

    public Double getDisa40() {
        return disa40;
    }

    public void setDisa40(Double disa40) {
        this.disa40 = disa40;
    }

    public Double getDisa80() {
        return disa80;
    }

    public void setDisa80(Double disa80) {
        this.disa80 = disa80;
    }

    public Double getHandi40() {
        return handi40;
    }

    public void setHandi40(Double handi40) {
        this.handi40 = handi40;
    }

    public Double getHandi80() {
        return handi80;
    }

    public void setHandi80(Double handi80) {
        this.handi80 = handi80;
    }

    public Double getMediTreat() {
        return mediTreat;
    }

    public void setMediTreat(Double mediTreat) {
        this.mediTreat = mediTreat;
    }

    public Double getInttHigEdu() {
        return inttHigEdu;
    }

    public void setInttHigEdu(Double inttHigEdu) {
        this.inttHigEdu = inttHigEdu;
    }

    public Double getRebate89() {
        return rebate89;
    }

    public void setRebate89(Double rebate89) {
        this.rebate89 = rebate89;
    }

    public Double getRebate87() {
        return rebate87;
    }

    public void setRebate87(Double rebate87) {
        this.rebate87 = rebate87;
    }

    public Double getDonation() {
        return donation;
    }

    public void setDonation(Double donation) {
        this.donation = donation;
    }

    public String getDedOnOthersHead() {
        return dedOnOthersHead;
    }

    public void setDedOnOthersHead(String dedOnOthersHead) {
        this.dedOnOthersHead = dedOnOthersHead;
    }

    public String getRebate89Head() {
        return rebate89Head;
    }

    public void setRebate89Head(String rebate89Head) {
        this.rebate89Head = rebate89Head;
    }

    public Double getIncomeTaxDue1() {
        return incomeTaxDue1;
    }

    public void setIncomeTaxDue1(Double incomeTaxDue1) {
        this.incomeTaxDue1 = incomeTaxDue1;
    }

    public Double getGrossIncome() {
        return grossIncome;
    }

    public void setGrossIncome(Double grossIncome) {
        this.grossIncome = grossIncome;
    }

    public Double getBenificialDed() {
        return benificialDed;
    }

    public void setBenificialDed(Double benificialDed) {
        this.benificialDed = benificialDed;
    }

    public Character getPensionFlag() {
        return pensionFlag;
    }

    public void setPensionFlag(Character pensionFlag) {
        this.pensionFlag = pensionFlag;
    }

    public String getPenEcode() {
        return penEcode;
    }

    public void setPenEcode(String penEcode) {
        this.penEcode = penEcode;
    }

    public Double getSsa() {
        return ssa;
    }

    public void setSsa(Double ssa) {
        this.ssa = ssa;
    }

    public Double getNpsAdd() {
        return npsAdd;
    }

    public void setNpsAdd(Double npsAdd) {
        this.npsAdd = npsAdd;
    }

    public Double getMedicSenc() {
        return medicSenc;
    }

    public void setMedicSenc(Double medicSenc) {
        this.medicSenc = medicSenc;
    }

    public Double getDepnSenc() {
        return depnSenc;
    }

    public void setDepnSenc(Double depnSenc) {
        this.depnSenc = depnSenc;
    }

    public Double getNpsEmplyrPrtEarn() {
        return npsEmplyrPrtEarn;
    }

    public void setNpsEmplyrPrtEarn(Double npsEmplyrPrtEarn) {
        this.npsEmplyrPrtEarn = npsEmplyrPrtEarn;
    }

    public Double getNpsEmplyrPrtRebate() {
        return npsEmplyrPrtRebate;
    }

    public void setNpsEmplyrPrtRebate(Double npsEmplyrPrtRebate) {
        this.npsEmplyrPrtRebate = npsEmplyrPrtRebate;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerPan() {
        return ownerPan;
    }

    public void setOwnerPan(String ownerPan) {
        this.ownerPan = ownerPan;
    }

    public Double getStandDedLess40k() {
        return standDedLess40k;
    }

    public void setStandDedLess40k(Double standDedLess40k) {
        this.standDedLess40k = standDedLess40k;
    }

    public String getHbaBankName() {
        return hbaBankName;
    }

    public void setHbaBankName(String hbaBankName) {
        this.hbaBankName = hbaBankName;
    }

    public String getHbaBankPan() {
        return hbaBankPan;
    }

    public void setHbaBankPan(String hbaBankPan) {
        this.hbaBankPan = hbaBankPan;
    }

    public Double getTtb80() {
        return ttb80;
    }

    public void setTtb80(Double ttb80) {
        this.ttb80 = ttb80;
    }

    public Double getEea() {
        return eea;
    }

    public void setEea(Double eea) {
        this.eea = eea;
    }

    public Double getGratuityExemp() {
        return gratuityExemp;
    }

    public void setGratuityExemp(Double gratuityExemp) {
        this.gratuityExemp = gratuityExemp;
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
        if (!(object instanceof ItCalc)) {
            return false;
        }
        ItCalc other = (ItCalc) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.base.biz.entity.ItCalc[ id=" + id + " ]";
    }
    
}
