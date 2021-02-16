package com.Afit.BEAN;

import com.Afit.DAO.DAO;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped

public class view_Enrolled_members extends DAO implements Serializable {

    PreparedStatement ps;
    ResultSet rs;
    // Connection con;

    private String recNo;
    private String servceno;
    private String regDate;
    private String surename;
    private String othernames;
    private String nationality;
    private String stateOfOrigin;
    private String lgaOrigin;
    private String gsm;
    private String emailId;
    private String sex;
    private String nextOfKinName;
    private String nextOfKinAddress;
    private String relationship;
    private String category;
    private String phoneNo;
    private double openBalance;
    private String accountName;
    private double Savings;
    private Date startDate;
    private String method;
    private String bankName;
    private String accountNo;
    private String bankAddress;
    private double totalSavings;
    private double Savingbalance;
    private String status;
    private String username;
    private String password;
    private String confirmPassword;
    private String pinNo;
    private String serialNo;

    private String flag;

    private String specifyNationality;

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getRecNo() {
        return recNo;
    }

    public void setRecNo(String recNo) {
        this.recNo = recNo;
    }

    public String getServceno() {
        return servceno;
    }

    public void setServceno(String servceno) {
        this.servceno = servceno;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    public String getSurename() {
        return surename;
    }

    public void setSurename(String surename) {
        this.surename = surename;
    }

    public String getOthernames() {
        return othernames;
    }

    public void setOthernames(String othernames) {
        this.othernames = othernames;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getStateOfOrigin() {
        return stateOfOrigin;
    }

    public void setStateOfOrigin(String stateOfOrigin) {
        this.stateOfOrigin = stateOfOrigin;
    }

    public String getLgaOrigin() {
        return lgaOrigin;
    }

    public void setLgaOrigin(String lgaOrigin) {
        this.lgaOrigin = lgaOrigin;
    }

    public String getGsm() {
        return gsm;
    }

    public void setGsm(String gsm) {
        this.gsm = gsm;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getNextOfKinName() {
        return nextOfKinName;
    }

    public void setNextOfKinName(String nextOfKinName) {
        this.nextOfKinName = nextOfKinName;
    }

    public String getNextOfKinAddress() {
        return nextOfKinAddress;
    }

    public void setNextOfKinAddress(String nextOfKinAddress) {
        this.nextOfKinAddress = nextOfKinAddress;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public double getOpenBalance() {
        return openBalance;
    }

    public void setOpenBalance(double openBalance) {
        this.openBalance = openBalance;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public double getSavings() {
        return Savings;
    }

    public void setSavings(double Savings) {
        this.Savings = Savings;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getBankAddress() {
        return bankAddress;
    }

    public void setBankAddress(String bankAddress) {
        this.bankAddress = bankAddress;
    }

    public double getTotalSavings() {
        return totalSavings;
    }

    public void setTotalSavings(double totalSavings) {
        this.totalSavings = totalSavings;
    }

    public double getSavingbalance() {
        return Savingbalance;
    }

    public void setSavingbalance(double Savingbalance) {
        this.Savingbalance = Savingbalance;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getPinNo() {
        return pinNo;
    }

    public void setPinNo(String pinNo) {
        this.pinNo = pinNo;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public String getSpecifyNationality() {
        return specifyNationality;
    }

    public void setSpecifyNationality(String specifyNationality) {
        this.specifyNationality = specifyNationality;
    }

    public void retriveCurrentUsernameFromUI() {
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        username = (String) ec.getRequestParameterMap().get("viewReEnrolledForm:myusername");
    }

    public List<view_Enrolled_members> getPre_EnrolledMembersInfo() throws Exception {
        connectorMthd();

        List<view_Enrolled_members> PreEnrollmentViewInfo = new ArrayList<view_Enrolled_members>();

        try {

            PreparedStatement ps = this.getCn().prepareStatement("SELECT recNo,serviceNo,regDate,surname,others,SpecifyNationality,nationality,state,lga,gsm,email,sex,savings,method,bank,status,username,flag FROM members WHERE flag='Not_Approved' ");
            rs = ps.executeQuery();

            while (rs.next()) {
                view_Enrolled_members tbl = new view_Enrolled_members();

                tbl.setRecNo(rs.getString("recNo"));
                tbl.setServceno(rs.getString("serviceNo"));
                tbl.setRegDate(rs.getString("regDate"));
                tbl.setSurename(rs.getString("surname"));
                tbl.setOthernames(rs.getString("others"));
                tbl.setSpecifyNationality(rs.getString("specifyNationality"));
                tbl.setNationality(rs.getString("nationality"));
                tbl.setStateOfOrigin(rs.getString("state"));
                tbl.setLgaOrigin(rs.getString("lga"));
                tbl.setGsm(rs.getString("gsm"));
                tbl.setEmailId(rs.getString("email"));
                tbl.setSex(rs.getString("sex"));
                tbl.setSavings(rs.getDouble("Savings"));
                tbl.setMethod(rs.getString("method"));
                tbl.setBankName(rs.getString("bank"));
                tbl.setStatus(rs.getString("status"));
                tbl.setUsername(rs.getString("username"));
                tbl.setFlag(rs.getString("flag"));

                PreEnrollmentViewInfo.add(tbl);
            }//end of while-block

            ps.close();
            this.Close();

        } catch (Exception e) {
            throw e;
        } finally {

            //rs.close();
            //  this.Close();
        }//end of finally-block

        return PreEnrollmentViewInfo;
    }//end of method

    public void membershipApproval() throws Exception {
        int counter2 = 0;
        System.out.println("Testing Username Ret. From UI" + username);

        this.connectorMthd();//
        //CHECKS ID MEMBERS HAS DONE PRE-ENROLLMENT
        PreparedStatement st1 = getCn().prepareStatement("select username from members where username=? ");
        st1.setString(1, username);
        ResultSet rs = st1.executeQuery();

        //CHECK IF account has been approved already
        PreparedStatement st2 = getCn().prepareStatement("select username from members where username=? AND flag= 'Approved' ");
        st2.setString(1, username);
        ResultSet rs3 = st2.executeQuery();
        if (rs3.next()) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Information for Membership Approval. This username HAS ALREADY done pre-enrollment, and account approval is been granted.", " So the account owner can log in!"));
        } else if (rs.next()) {

            try {
                System.out.println("Testing Immed. before the quesry" + username);
                PreparedStatement st = getCn().prepareStatement("UPDATE members SET flag='Approved' WHERE username=? ");
                st.setString(1, username);
                st.executeUpdate();
                st.close();

                counter2++;

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Membership Approval", "Your Membership Approval Request has been approved for " + '[' + this.username + ']' + ""));
                if (counter2 > 0) {
                    //sendApprovalMail();
                }
            } catch (Exception e) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "Pls, check your entries " + e));
            } finally {
                this.Close();
            }
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Membership Approval Error. This username has NOT applied for a memebership", ". Thank you!"));
            st1.close();
            this.Close();
        }

        username = "";
    }//end of the method

    public List<view_Enrolled_members> getView_SavingsReport() throws Exception {
        this.connectorMthd();

        List<view_Enrolled_members> stockviewInfo = new ArrayList<view_Enrolled_members>();

        try {

            PreparedStatement ps = this.getCn().prepareStatement("SELECT fullname,emailid,phone,program,c.username,cclno,SignedupDate,dateapplied,DATEDIFF(dateapplied,SignedupDate) FROM enrollment e inner join cert_application c ON e.username = c.username AND status='approved'");
            rs = ps.executeQuery();

            while (rs.next()) {
                view_Enrolled_members tbl = new view_Enrolled_members();

                /*
                
                tbl.setFullname(rs.getString("fullname"));
                tbl.setEmail(rs.getString("emailID"));
                tbl.setPhone(rs.getString("phone"));
                tbl.setProgram(rs.getString("program"));
                tbl.setUsername(rs.getString("username"));
                tbl.setCclNo(rs.getString("cclNo"));
                tbl.setDateSigneUp(rs.getString("SignedupDate"));
                tbl.setDateApplied(rs.getString("dateApplied"));
                tbl.setDuration(rs.getString(9));
                 */
                stockviewInfo.add(tbl);
            }//end of while-block

            ps.close();
            this.Close();

        } catch (Exception e) {
            throw e;
        } finally {

            try {
                rs.close();
                ps.close();
                this.Close();
            } catch (Exception e) {
                e.printStackTrace();
                System.err.println("Error while viewing cert-application: " + e.getMessage());
            }
        }//end of finally-block

        return stockviewInfo;
    }//end of method
}//end of vla 
