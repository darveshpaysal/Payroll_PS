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
@Table(name = "m_users")
@NamedQueries({
    @NamedQuery(name = "MUsers.findAll", query = "SELECT m FROM MUsers m")
    , @NamedQuery(name = "MUsers.findById", query = "SELECT m FROM MUsers m WHERE m.id = :id")
    , @NamedQuery(name = "MUsers.findByUserId", query = "SELECT m FROM MUsers m WHERE m.userId = :userId")
    , @NamedQuery(name = "MUsers.findByUserName", query = "SELECT m FROM MUsers m WHERE m.userName = :userName")
    , @NamedQuery(name = "MUsers.findByUserPassword", query = "SELECT m FROM MUsers m WHERE m.userPassword = :userPassword")
    , @NamedQuery(name = "MUsers.findByAccountState", query = "SELECT m FROM MUsers m WHERE m.accountState = :accountState")
    , @NamedQuery(name = "MUsers.findByCreationDt", query = "SELECT m FROM MUsers m WHERE m.creationDt = :creationDt")
    , @NamedQuery(name = "MUsers.findByPassExpDt", query = "SELECT m FROM MUsers m WHERE m.passExpDt = :passExpDt")
    , @NamedQuery(name = "MUsers.findByWrongAttm", query = "SELECT m FROM MUsers m WHERE m.wrongAttm = :wrongAttm")
    , @NamedQuery(name = "MUsers.findByUserType", query = "SELECT m FROM MUsers m WHERE m.userType = :userType")
    , @NamedQuery(name = "MUsers.findByComment", query = "SELECT m FROM MUsers m WHERE m.comment = :comment")
    , @NamedQuery(name = "MUsers.findByRecflag", query = "SELECT m FROM MUsers m WHERE m.recflag = :recflag")
    , @NamedQuery(name = "MUsers.findByCreatedBy", query = "SELECT m FROM MUsers m WHERE m.createdBy = :createdBy")
    , @NamedQuery(name = "MUsers.findByCreatedDate", query = "SELECT m FROM MUsers m WHERE m.createdDate = :createdDate")})
public class MUsers implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "user_id")
    private String userId;
    @Basic(optional = false)
    @Column(name = "user_name")
    private String userName;
    @Basic(optional = false)
    @Column(name = "user_password")
    private String userPassword;
    @Basic(optional = false)
    @Column(name = "account_state")
    private String accountState;
    @Basic(optional = false)
    @Column(name = "creation_dt")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDt;
    @Basic(optional = false)
    @Column(name = "pass_exp_dt")
    @Temporal(TemporalType.TIMESTAMP)
    private Date passExpDt;
    @Column(name = "wrong_attm")
    private Integer wrongAttm;
    @Basic(optional = false)
    @Column(name = "user_type")
    private String userType;
    @Column(name = "comment_")
    private String comment;
    @Basic(optional = false)
    @Column(name = "recflag")
    private String recflag;
    @Column(name = "created_by")
    private String createdBy;
    @Basic(optional = false)
    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    public MUsers() {
    }

    public MUsers(Integer id) {
        this.id = id;
    }

    public MUsers(Integer id, String userId, String userName, String userPassword, String accountState, Date creationDt, Date passExpDt, String userType, String recflag, Date createdDate) {
        this.id = id;
        this.userId = userId;
        this.userName = userName;
        this.userPassword = userPassword;
        this.accountState = accountState;
        this.creationDt = creationDt;
        this.passExpDt = passExpDt;
        this.userType = userType;
        this.recflag = recflag;
        this.createdDate = createdDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getAccountState() {
        return accountState;
    }

    public void setAccountState(String accountState) {
        this.accountState = accountState;
    }

    public Date getCreationDt() {
        return creationDt;
    }

    public void setCreationDt(Date creationDt) {
        this.creationDt = creationDt;
    }

    public Date getPassExpDt() {
        return passExpDt;
    }

    public void setPassExpDt(Date passExpDt) {
        this.passExpDt = passExpDt;
    }

    public Integer getWrongAttm() {
        return wrongAttm;
    }

    public void setWrongAttm(Integer wrongAttm) {
        this.wrongAttm = wrongAttm;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
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
        if (!(object instanceof MUsers)) {
            return false;
        }
        MUsers other = (MUsers) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.base.biz.entity.MUsers[ id=" + id + " ]";
    }
    
}
