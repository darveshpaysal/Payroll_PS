
package com.base.biz.dto;

import com.base.common.util.AppUtil;
import java.util.Date;

/**
 *
 * @author PS
 */
public class UserDTO {
    private Integer id;
    private String donorId;
    private String name;
    private String mobile;
    private String email;
    private String uidCode;    
    private String uidNo;
    private byte[] uidImage;
    private String address;
    private String district;
    private String state;
    private Integer postalCode;
    private String country;
    private String role;
    private String userId;
    private String password;
    private Boolean activeFlag;
    private String createdBy;
    private Date createdDate;
    private String status;    
    private Boolean isNew = false;
    private String fullAddress;
    private Boolean donorProfile = false;
    private String uidCodeDesc;
    private Boolean changeDonor = false;
    
    public UserDTO(){
        
    } 


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDonorId() {
        return donorId;
    }

    public void setDonorId(String donorId) {
        this.donorId = donorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getUidCode() {
        return uidCode;
    }

    public void setUidCode(String uidCode) {
        this.uidCode = uidCode;
    }

    public String getUidNo() {
        return uidNo;
    }

    public void setUidNo(String uidNo) {
        this.uidNo = uidNo;
    }

    public byte[] getUidImage() {
        return uidImage;
    }

    public void setUidImage(byte[] uidImage) {
        this.uidImage = uidImage;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(Integer postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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
    
     public String getStatus() {
    status = (getActiveFlag() != null && getActiveFlag()) ? "Active" : "Inactive";
    return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
     public Boolean getIsNew() {
        return isNew;
    }

    public void setIsNew(Boolean isNew) {
        this.isNew = isNew;
    }

    public String getFullAddress() {
        StringBuilder sb = new StringBuilder(this.address);
        if (!AppUtil.isBlank(this.district)) {
            sb.append(", ");
            sb.append(this.district);
        }
        sb.append(", ");
        sb.append(this.state);
        if (this.postalCode != null && this.postalCode > 0) {
            sb.append(", ");
            sb.append(this.postalCode);
        }
        fullAddress = sb.toString();
        return fullAddress;
    }

    public void setFullAddress(String fullAddress) {        
        this.fullAddress = fullAddress;
    }

    public Boolean getDonorProfile() {
        return donorProfile;
    }

    public void setDonorProfile(Boolean donorProfile) {
        this.donorProfile = donorProfile;
    }

    public String getUidCodeDesc() {
        return uidCodeDesc;
    }

    public void setUidCodeDesc(String uidCodeDesc) {
        this.uidCodeDesc = uidCodeDesc;
    }

    public Boolean getChangeDonor() {
        return changeDonor;
    }

    public void setChangeDonor(Boolean changeDonor) {
        this.changeDonor = changeDonor;
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
        if (!(object instanceof UserDTO)) {
            return false;
        }
        UserDTO other = (UserDTO) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }
    
}
