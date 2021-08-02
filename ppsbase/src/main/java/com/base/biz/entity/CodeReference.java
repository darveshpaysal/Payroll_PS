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
@Table(name = "code_reference")
@NamedQueries({
    @NamedQuery(name = "CodeReference.findAll", query = "SELECT c FROM CodeReference c")
    , @NamedQuery(name = "CodeReference.findById", query = "SELECT c FROM CodeReference c WHERE c.id = :id")
    , @NamedQuery(name = "CodeReference.findByType", query = "SELECT c FROM CodeReference c WHERE c.type = :type")
    , @NamedQuery(name = "CodeReference.findByCode", query = "SELECT c FROM CodeReference c WHERE c.code = :code")
    , @NamedQuery(name = "CodeReference.findByDescription", query = "SELECT c FROM CodeReference c WHERE c.description = :description")
    , @NamedQuery(name = "CodeReference.findByActiveFlag", query = "SELECT c FROM CodeReference c WHERE c.activeFlag = :activeFlag")
    , @NamedQuery(name = "CodeReference.findByRefCode", query = "SELECT c FROM CodeReference c WHERE c.refCode = :refCode")
    , @NamedQuery(name = "CodeReference.findByCreatedBy", query = "SELECT c FROM CodeReference c WHERE c.createdBy = :createdBy")
    , @NamedQuery(name = "CodeReference.findByCreatedDate", query = "SELECT c FROM CodeReference c WHERE c.createdDate = :createdDate")})
public class CodeReference implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "type")
    private String type;
    @Column(name = "code")
    private String code;
    @Column(name = "description")
    private String description;
    @Column(name = "active_flag")
    private Boolean activeFlag;
    @Column(name = "ref_code")
    private String refCode;
    @Column(name = "created_by")
    private String createdBy;
    @Basic(optional = false)
    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    public CodeReference() {
    }

    public CodeReference(Integer id) {
        this.id = id;
    }

    public CodeReference(Integer id, String type, Date createdDate) {
        this.id = id;
        this.type = type;
        this.createdDate = createdDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getActiveFlag() {
        return activeFlag;
    }

    public void setActiveFlag(Boolean activeFlag) {
        this.activeFlag = activeFlag;
    }

    public String getRefCode() {
        return refCode;
    }

    public void setRefCode(String refCode) {
        this.refCode = refCode;
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
        if (!(object instanceof CodeReference)) {
            return false;
        }
        CodeReference other = (CodeReference) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.base.biz.entity.CodeReference[ id=" + id + " ]";
    }
    
}
