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
@Table(name = "form16")
@NamedQueries({
    @NamedQuery(name = "Form16.findAll", query = "SELECT f FROM Form16 f")
    , @NamedQuery(name = "Form16.findById", query = "SELECT f FROM Form16 f WHERE f.id = :id")
    , @NamedQuery(name = "Form16.findByCalcYear", query = "SELECT f FROM Form16 f WHERE f.calcYear = :calcYear")
    , @NamedQuery(name = "Form16.findByAssYear", query = "SELECT f FROM Form16 f WHERE f.assYear = :assYear")
    , @NamedQuery(name = "Form16.findByEcode", query = "SELECT f FROM Form16 f WHERE f.ecode = :ecode")
    , @NamedQuery(name = "Form16.findByEstimatedIncome", query = "SELECT f FROM Form16 f WHERE f.estimatedIncome = :estimatedIncome")
    , @NamedQuery(name = "Form16.findByFreeAccom", query = "SELECT f FROM Form16 f WHERE f.freeAccom = :freeAccom")
    , @NamedQuery(name = "Form16.findByGrossSalary", query = "SELECT f FROM Form16 f WHERE f.grossSalary = :grossSalary")
    , @NamedQuery(name = "Form16.findByActalHraLess", query = "SELECT f FROM Form16 f WHERE f.actalHraLess = :actalHraLess")
    , @NamedQuery(name = "Form16.findByExpenOnrentA", query = "SELECT f FROM Form16 f WHERE f.expenOnrentA = :expenOnrentA")
    , @NamedQuery(name = "Form16.findByExpenOnrentA1", query = "SELECT f FROM Form16 f WHERE f.expenOnrentA1 = :expenOnrentA1")
    , @NamedQuery(name = "Form16.findByLessHra", query = "SELECT f FROM Form16 f WHERE f.lessHra = :lessHra")
    , @NamedQuery(name = "Form16.findByTransportAll", query = "SELECT f FROM Form16 f WHERE f.transportAll = :transportAll")
    , @NamedQuery(name = "Form16.findByCrAll", query = "SELECT f FROM Form16 f WHERE f.crAll = :crAll")
    , @NamedQuery(name = "Form16.findByUniformAll", query = "SELECT f FROM Form16 f WHERE f.uniformAll = :uniformAll")
    , @NamedQuery(name = "Form16.findByWashingAll", query = "SELECT f FROM Form16 f WHERE f.washingAll = :washingAll")
    , @NamedQuery(name = "Form16.findByTotalExemption", query = "SELECT f FROM Form16 f WHERE f.totalExemption = :totalExemption")
    , @NamedQuery(name = "Form16.findByTotalSalary", query = "SELECT f FROM Form16 f WHERE f.totalSalary = :totalSalary")
    , @NamedQuery(name = "Form16.findByGpf", query = "SELECT f FROM Form16 f WHERE f.gpf = :gpf")
    , @NamedQuery(name = "Form16.findByPpf", query = "SELECT f FROM Form16 f WHERE f.ppf = :ppf")
    , @NamedQuery(name = "Form16.findByGis", query = "SELECT f FROM Form16 f WHERE f.gis = :gis")
    , @NamedQuery(name = "Form16.findByMscIntt", query = "SELECT f FROM Form16 f WHERE f.mscIntt = :mscIntt")
    , @NamedQuery(name = "Form16.findByLicPrem", query = "SELECT f FROM Form16 f WHERE f.licPrem = :licPrem")
    , @NamedQuery(name = "Form16.findByPli", query = "SELECT f FROM Form16 f WHERE f.pli = :pli")
    , @NamedQuery(name = "Form16.findByTutionFee", query = "SELECT f FROM Form16 f WHERE f.tutionFee = :tutionFee")
    , @NamedQuery(name = "Form16.findByUlip", query = "SELECT f FROM Form16 f WHERE f.ulip = :ulip")
    , @NamedQuery(name = "Form16.findByRepaymentHba", query = "SELECT f FROM Form16 f WHERE f.repaymentHba = :repaymentHba")
    , @NamedQuery(name = "Form16.findByNotifiedMutal", query = "SELECT f FROM Form16 f WHERE f.notifiedMutal = :notifiedMutal")
    , @NamedQuery(name = "Form16.findByNetSalary", query = "SELECT f FROM Form16 f WHERE f.netSalary = :netSalary")
    , @NamedQuery(name = "Form16.findByRentalIncome", query = "SELECT f FROM Form16 f WHERE f.rentalIncome = :rentalIncome")
    , @NamedQuery(name = "Form16.findBySubsidyHba", query = "SELECT f FROM Form16 f WHERE f.subsidyHba = :subsidyHba")
    , @NamedQuery(name = "Form16.findByTotalHouseIncome", query = "SELECT f FROM Form16 f WHERE f.totalHouseIncome = :totalHouseIncome")
    , @NamedQuery(name = "Form16.findByInttHba", query = "SELECT f FROM Form16 f WHERE f.inttHba = :inttHba")
    , @NamedQuery(name = "Form16.findByNetIncomeHouseProp", query = "SELECT f FROM Form16 f WHERE f.netIncomeHouseProp = :netIncomeHouseProp")
    , @NamedQuery(name = "Form16.findByBalance", query = "SELECT f FROM Form16 f WHERE f.balance = :balance")
    , @NamedQuery(name = "Form16.findByGratuityPension", query = "SELECT f FROM Form16 f WHERE f.gratuityPension = :gratuityPension")
    , @NamedQuery(name = "Form16.findByInttNsc", query = "SELECT f FROM Form16 f WHERE f.inttNsc = :inttNsc")
    , @NamedQuery(name = "Form16.findByInttBankDeposit", query = "SELECT f FROM Form16 f WHERE f.inttBankDeposit = :inttBankDeposit")
    , @NamedQuery(name = "Form16.findByAnyOtherIncome", query = "SELECT f FROM Form16 f WHERE f.anyOtherIncome = :anyOtherIncome")
    , @NamedQuery(name = "Form16.findByGrossTotal", query = "SELECT f FROM Form16 f WHERE f.grossTotal = :grossTotal")
    , @NamedQuery(name = "Form16.findByNetTaxableIncome", query = "SELECT f FROM Form16 f WHERE f.netTaxableIncome = :netTaxableIncome")
    , @NamedQuery(name = "Form16.findByNetTaxableIncomeRound", query = "SELECT f FROM Form16 f WHERE f.netTaxableIncomeRound = :netTaxableIncomeRound")
    , @NamedQuery(name = "Form16.findByIncomeTaxDue", query = "SELECT f FROM Form16 f WHERE f.incomeTaxDue = :incomeTaxDue")
    , @NamedQuery(name = "Form16.findByEducationCess", query = "SELECT f FROM Form16 f WHERE f.educationCess = :educationCess")
    , @NamedQuery(name = "Form16.findByNetTaxDue", query = "SELECT f FROM Form16 f WHERE f.netTaxDue = :netTaxDue")
    , @NamedQuery(name = "Form16.findByDedOnSalary", query = "SELECT f FROM Form16 f WHERE f.dedOnSalary = :dedOnSalary")
    , @NamedQuery(name = "Form16.findByDedOnOthers", query = "SELECT f FROM Form16 f WHERE f.dedOnOthers = :dedOnOthers")
    , @NamedQuery(name = "Form16.findByNetTaxPayble", query = "SELECT f FROM Form16 f WHERE f.netTaxPayble = :netTaxPayble")
    , @NamedQuery(name = "Form16.findByNsc", query = "SELECT f FROM Form16 f WHERE f.nsc = :nsc")
    , @NamedQuery(name = "Form16.findBySurcharge", query = "SELECT f FROM Form16 f WHERE f.surcharge = :surcharge")
    , @NamedQuery(name = "Form16.findByInttHbaDate", query = "SELECT f FROM Form16 f WHERE f.inttHbaDate = :inttHbaDate")
    , @NamedQuery(name = "Form16.findBySumTwo", query = "SELECT f FROM Form16 f WHERE f.sumTwo = :sumTwo")
    , @NamedQuery(name = "Form16.findBySumThree", query = "SELECT f FROM Form16 f WHERE f.sumThree = :sumThree")
    , @NamedQuery(name = "Form16.findBySumNine", query = "SELECT f FROM Form16 f WHERE f.sumNine = :sumNine")
    , @NamedQuery(name = "Form16.findBySumSixteen", query = "SELECT f FROM Form16 f WHERE f.sumSixteen = :sumSixteen")
    , @NamedQuery(name = "Form16.findByPaidAmount", query = "SELECT f FROM Form16 f WHERE f.paidAmount = :paidAmount")
    , @NamedQuery(name = "Form16.findByPaymentDate", query = "SELECT f FROM Form16 f WHERE f.paymentDate = :paymentDate")
    , @NamedQuery(name = "Form16.findByBankName", query = "SELECT f FROM Form16 f WHERE f.bankName = :bankName")
    , @NamedQuery(name = "Form16.findByBranchAddress", query = "SELECT f FROM Form16 f WHERE f.branchAddress = :branchAddress")
    , @NamedQuery(name = "Form16.findByBranchPhone", query = "SELECT f FROM Form16 f WHERE f.branchPhone = :branchPhone")
    , @NamedQuery(name = "Form16.findByBranchPin", query = "SELECT f FROM Form16 f WHERE f.branchPin = :branchPin")
    , @NamedQuery(name = "Form16.findByBranchDistrict", query = "SELECT f FROM Form16 f WHERE f.branchDistrict = :branchDistrict")
    , @NamedQuery(name = "Form16.findByTan", query = "SELECT f FROM Form16 f WHERE f.tan = :tan")
    , @NamedQuery(name = "Form16.findByTds", query = "SELECT f FROM Form16 f WHERE f.tds = :tds")
    , @NamedQuery(name = "Form16.findByFullName", query = "SELECT f FROM Form16 f WHERE f.fullName = :fullName")
    , @NamedQuery(name = "Form16.findByDesignation", query = "SELECT f FROM Form16 f WHERE f.designation = :designation")
    , @NamedQuery(name = "Form16.findByJeevan", query = "SELECT f FROM Form16 f WHERE f.jeevan = :jeevan")
    , @NamedQuery(name = "Form16.findByBond", query = "SELECT f FROM Form16 f WHERE f.bond = :bond")
    , @NamedQuery(name = "Form16.findByEduPer", query = "SELECT f FROM Form16 f WHERE f.eduPer = :eduPer")
    , @NamedQuery(name = "Form16.findBySurPer", query = "SELECT f FROM Form16 f WHERE f.surPer = :surPer")
    , @NamedQuery(name = "Form16.findByOthAll", query = "SELECT f FROM Form16 f WHERE f.othAll = :othAll")
    , @NamedQuery(name = "Form16.findByPrent", query = "SELECT f FROM Form16 f WHERE f.prent = :prent")
    , @NamedQuery(name = "Form16.findByLvCashNt", query = "SELECT f FROM Form16 f WHERE f.lvCashNt = :lvCashNt")
    , @NamedQuery(name = "Form16.findByMediclaim", query = "SELECT f FROM Form16 f WHERE f.mediclaim = :mediclaim")
    , @NamedQuery(name = "Form16.findByAnyother", query = "SELECT f FROM Form16 f WHERE f.anyother = :anyother")
    , @NamedQuery(name = "Form16.findByTta80", query = "SELECT f FROM Form16 f WHERE f.tta80 = :tta80")
    , @NamedQuery(name = "Form16.findByNpsDed", query = "SELECT f FROM Form16 f WHERE f.npsDed = :npsDed")
    , @NamedQuery(name = "Form16.findByNpsVol", query = "SELECT f FROM Form16 f WHERE f.npsVol = :npsVol")
    , @NamedQuery(name = "Form16.findByNpsBack", query = "SELECT f FROM Form16 f WHERE f.npsBack = :npsBack")
    , @NamedQuery(name = "Form16.findByInttHbaAft", query = "SELECT f FROM Form16 f WHERE f.inttHbaAft = :inttHbaAft")
    , @NamedQuery(name = "Form16.findByInttsac", query = "SELECT f FROM Form16 f WHERE f.inttsac = :inttsac")
    , @NamedQuery(name = "Form16.findByDisa40", query = "SELECT f FROM Form16 f WHERE f.disa40 = :disa40")
    , @NamedQuery(name = "Form16.findByDisa80", query = "SELECT f FROM Form16 f WHERE f.disa80 = :disa80")
    , @NamedQuery(name = "Form16.findByHandi40", query = "SELECT f FROM Form16 f WHERE f.handi40 = :handi40")
    , @NamedQuery(name = "Form16.findByHandi80", query = "SELECT f FROM Form16 f WHERE f.handi80 = :handi80")
    , @NamedQuery(name = "Form16.findByMediTreat", query = "SELECT f FROM Form16 f WHERE f.mediTreat = :mediTreat")
    , @NamedQuery(name = "Form16.findByInttHigEdu", query = "SELECT f FROM Form16 f WHERE f.inttHigEdu = :inttHigEdu")
    , @NamedQuery(name = "Form16.findByRebate89", query = "SELECT f FROM Form16 f WHERE f.rebate89 = :rebate89")
    , @NamedQuery(name = "Form16.findByRebate87", query = "SELECT f FROM Form16 f WHERE f.rebate87 = :rebate87")
    , @NamedQuery(name = "Form16.findByDonation", query = "SELECT f FROM Form16 f WHERE f.donation = :donation")
    , @NamedQuery(name = "Form16.findByDedOnOthersHead", query = "SELECT f FROM Form16 f WHERE f.dedOnOthersHead = :dedOnOthersHead")
    , @NamedQuery(name = "Form16.findByRebate89Head", query = "SELECT f FROM Form16 f WHERE f.rebate89Head = :rebate89Head")
    , @NamedQuery(name = "Form16.findByIncomeTaxDue1", query = "SELECT f FROM Form16 f WHERE f.incomeTaxDue1 = :incomeTaxDue1")
    , @NamedQuery(name = "Form16.findByGrossIncome", query = "SELECT f FROM Form16 f WHERE f.grossIncome = :grossIncome")
    , @NamedQuery(name = "Form16.findByBenificialDed", query = "SELECT f FROM Form16 f WHERE f.benificialDed = :benificialDed")
    , @NamedQuery(name = "Form16.findBySsa", query = "SELECT f FROM Form16 f WHERE f.ssa = :ssa")
    , @NamedQuery(name = "Form16.findByNpsAdd", query = "SELECT f FROM Form16 f WHERE f.npsAdd = :npsAdd")
    , @NamedQuery(name = "Form16.findByMedicSenc", query = "SELECT f FROM Form16 f WHERE f.medicSenc = :medicSenc")
    , @NamedQuery(name = "Form16.findByDepnSenc", query = "SELECT f FROM Form16 f WHERE f.depnSenc = :depnSenc")
    , @NamedQuery(name = "Form16.findBySrNo", query = "SELECT f FROM Form16 f WHERE f.srNo = :srNo")
    , @NamedQuery(name = "Form16.findByNpsEmplyrPrtEarn", query = "SELECT f FROM Form16 f WHERE f.npsEmplyrPrtEarn = :npsEmplyrPrtEarn")
    , @NamedQuery(name = "Form16.findByNpsEmplyrPrtRebate", query = "SELECT f FROM Form16 f WHERE f.npsEmplyrPrtRebate = :npsEmplyrPrtRebate")
    , @NamedQuery(name = "Form16.findByOwnerName", query = "SELECT f FROM Form16 f WHERE f.ownerName = :ownerName")
    , @NamedQuery(name = "Form16.findByOwnerPan", query = "SELECT f FROM Form16 f WHERE f.ownerPan = :ownerPan")
    , @NamedQuery(name = "Form16.findByStandDedLess40k", query = "SELECT f FROM Form16 f WHERE f.standDedLess40k = :standDedLess40k")
    , @NamedQuery(name = "Form16.findByHbaBankName", query = "SELECT f FROM Form16 f WHERE f.hbaBankName = :hbaBankName")
    , @NamedQuery(name = "Form16.findByHbaBankPan", query = "SELECT f FROM Form16 f WHERE f.hbaBankPan = :hbaBankPan")
    , @NamedQuery(name = "Form16.findByTtb80", query = "SELECT f FROM Form16 f WHERE f.ttb80 = :ttb80")
    , @NamedQuery(name = "Form16.findByEea", query = "SELECT f FROM Form16 f WHERE f.eea = :eea")
    , @NamedQuery(name = "Form16.findByGratuityExemp", query = "SELECT f FROM Form16 f WHERE f.gratuityExemp = :gratuityExemp")
    , @NamedQuery(name = "Form16.findByCreatedBy", query = "SELECT f FROM Form16 f WHERE f.createdBy = :createdBy")
    , @NamedQuery(name = "Form16.findByCreatedDate", query = "SELECT f FROM Form16 f WHERE f.createdDate = :createdDate")})
public class Form16 implements Serializable {

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
    @Basic(optional = false)
    @Column(name = "INTT_HBA_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date inttHbaDate;
    @Column(name = "SUM_TWO")
    private Double sumTwo;
    @Column(name = "SUM_THREE")
    private Double sumThree;
    @Column(name = "SUM_NINE")
    private Double sumNine;
    @Column(name = "SUM_SIXTEEN")
    private Double sumSixteen;
    @Column(name = "PAID_AMOUNT")
    private Double paidAmount;
    @Basic(optional = false)
    @Column(name = "PAYMENT_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date paymentDate;
    @Column(name = "BANK_NAME")
    private String bankName;
    @Column(name = "BRANCH_ADDRESS")
    private String branchAddress;
    @Column(name = "BRANCH_PHONE")
    private String branchPhone;
    @Column(name = "BRANCH_PIN")
    private Double branchPin;
    @Column(name = "BRANCH_DISTRICT")
    private String branchDistrict;
    @Column(name = "TAN")
    private String tan;
    @Column(name = "TDS")
    private String tds;
    @Column(name = "FULL_NAME")
    private String fullName;
    @Column(name = "DESIGNATION")
    private String designation;
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
    @Column(name = "LV_CASH_NT")
    private Double lvCashNt;
    @Column(name = "MEDICLAIM")
    private Double mediclaim;
    @Column(name = "ANYOTHER")
    private Double anyother;
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
    @Column(name = "SSA")
    private Double ssa;
    @Column(name = "NPS_ADD")
    private Double npsAdd;
    @Column(name = "MEDIC_SENC")
    private Double medicSenc;
    @Column(name = "DEPN_SENC")
    private Double depnSenc;
    @Column(name = "SR_NO")
    private Double srNo;
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

    public Form16() {
    }

    public Form16(Integer id) {
        this.id = id;
    }

    public Form16(Integer id, Date inttHbaDate, Date paymentDate, Date createdDate) {
        this.id = id;
        this.inttHbaDate = inttHbaDate;
        this.paymentDate = paymentDate;
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

    public Double getSumTwo() {
        return sumTwo;
    }

    public void setSumTwo(Double sumTwo) {
        this.sumTwo = sumTwo;
    }

    public Double getSumThree() {
        return sumThree;
    }

    public void setSumThree(Double sumThree) {
        this.sumThree = sumThree;
    }

    public Double getSumNine() {
        return sumNine;
    }

    public void setSumNine(Double sumNine) {
        this.sumNine = sumNine;
    }

    public Double getSumSixteen() {
        return sumSixteen;
    }

    public void setSumSixteen(Double sumSixteen) {
        this.sumSixteen = sumSixteen;
    }

    public Double getPaidAmount() {
        return paidAmount;
    }

    public void setPaidAmount(Double paidAmount) {
        this.paidAmount = paidAmount;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBranchAddress() {
        return branchAddress;
    }

    public void setBranchAddress(String branchAddress) {
        this.branchAddress = branchAddress;
    }

    public String getBranchPhone() {
        return branchPhone;
    }

    public void setBranchPhone(String branchPhone) {
        this.branchPhone = branchPhone;
    }

    public Double getBranchPin() {
        return branchPin;
    }

    public void setBranchPin(Double branchPin) {
        this.branchPin = branchPin;
    }

    public String getBranchDistrict() {
        return branchDistrict;
    }

    public void setBranchDistrict(String branchDistrict) {
        this.branchDistrict = branchDistrict;
    }

    public String getTan() {
        return tan;
    }

    public void setTan(String tan) {
        this.tan = tan;
    }

    public String getTds() {
        return tds;
    }

    public void setTds(String tds) {
        this.tds = tds;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
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

    public Double getLvCashNt() {
        return lvCashNt;
    }

    public void setLvCashNt(Double lvCashNt) {
        this.lvCashNt = lvCashNt;
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

    public Double getSrNo() {
        return srNo;
    }

    public void setSrNo(Double srNo) {
        this.srNo = srNo;
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
        if (!(object instanceof Form16)) {
            return false;
        }
        Form16 other = (Form16) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.base.biz.entity.Form16[ id=" + id + " ]";
    }
    
}
