package com.Afit.BEAN;

import com.Afit.DAO.DAO;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped

public class view_Approved_Members extends DAO implements Serializable {

    int reportCounter = 0;
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

    private String fromDate;
    private String toDate;

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

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public void retriveFromDateFromUI() {
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        fromDate = (String) ec.getRequestParameterMap().get("viewReEnrolledForm:FROMReportDate");
    }

    public void retriveToDateFromUI() {
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        toDate = (String) ec.getRequestParameterMap().get("viewReEnrolledForm:ToReportDate");
    }

    public void enableAprrovedButton() {
        retriveFromDateFromUI();//invoked 
        retriveToDateFromUI();//invoked 

        System.out.println("Testing fromDate: " + fromDate);
        System.out.println("Testing toDate: " + toDate);

    }//end of the method

    public List<view_Approved_Members> getApprovedMembersInfo() throws Exception {
        connectorMthd();

        String StringFromDate = "";
        String StringToDate = "";

        List<view_Approved_Members> PreEnrollmentViewInfo = new ArrayList<view_Approved_Members>();

        try {

            PreparedStatement ps = this.getCn().prepareStatement("SELECT recNo,serviceNo,regDate,surname,others,SpecifyNationality,nationality,state,lga,gsm,email,sex,savings,method,bank,status,username,flag FROM members WHERE(regDate BETWEEN ? AND ? AND flag='Approved' ) ");
            //PreparedStatement ps = this.getCn().prepareStatement("SELECT recNo,serviceNo,regDate,surname,others,SpecifyNationality,nationality,state,lga,gsm,email,sex,savings,method,bank,status,username,flag FROM members WHERE flag='Approved' ");

            ps.setString(1, fromDate);
            ps.setString(2, toDate);
            rs = ps.executeQuery();

            while (rs.next()) {
                view_Approved_Members tbl = new view_Approved_Members();

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

    public void reportGeneration() throws SQLException, Exception {
       
        enableAprrovedButton();//invoked
        
         this.connectorMthd();//invoked
         
         try {
            PreparedStatement ps = this.getCn().prepareStatement(" SELECT * FROM ( select 'RecNo','ServiceNo','regDate','surname','others','SpecifyNationality','nationality','state','lga','gsm','email','sex','nok','nokAddress','relationship','category','phone','accountType','openBalance','accountName','savings','startdate','method','bank','acctNo','bankAddress','totalsavings','savingBalance','Status','username' UNION ALL  SELECT RecNo,ServiceNo,regDate,surname,others,SpecifyNationality,nationality,state,lga,gsm,email,sex,nok,nokAddress,relationship,category,phone,accountType,openBalance,accountName,savings,startdate,method,bank,acctNo,bankAddress,totalsavings,savingBalance,Status,username FROM members   WHERE(regDate BETWEEN ? AND ? AND flag='Approved' ) )resulting_set  into outfile 'C:/export/ApprovedMembersReport.csv' FIELDS TERMINATED BY ',' OPTIONALLY ENCLOSED BY '\"' LINES TERMINATED BY '\\r\\n'  ");
            ps.setString(1, fromDate);
            ps.setString(2, toDate);
            rs = ps.executeQuery();

            if (rs.next()) {
              reportGenerationMessageMthd();//invoked 
            }//end of the if-block 

            
        } catch (Exception e) {

            throw e;

        } finally {
            ps.close();
            this.Close();
        }
 

    }//end of the method
    
    public void reportGenerationMessageMthd(){
        
          FacesContext.getCurrentInstance().addMessage(
                        null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO,
                                "" + "Report has been generated. BEETWEEN " + fromDate + " TO " + toDate,
                                "  Local te file in C:/export/...  "));
    }//end of the method 

}//end of class  
