package com.Afit.BEAN;

import com.Afit.DAO.DAO;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

@ManagedBean
@SessionScoped
public class profileInfoBEAN extends DAO implements Serializable {

    PreparedStatement ps;
    ResultSet rs;

    private String username;
    private String servicesNo;
    private String surename;
    private String othernames;
    private String stateOfOrigin;
    private String lgaOrigin;
    private String gsm;
    private String emailId;
    private String sex;
    private String nextOfKinName;
    private String relationship;
    private String phoneNo;

    //setters and getters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getServicesNo() {
        return servicesNo;
    }

    public void setServicesNo(String servicesNo) {
        this.servicesNo = servicesNo;
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

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public void retriveUsernameFromUI() {//get the current 'username' on the UI 
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        username = ec.getRequestParameterMap().get("userProfileForm:myuser");
        System.out.println(" Testing 'username' retriveUsernameFromUI METHOD: " + username);
    }//end of method

    public void pullingProfileInfoMthd() throws ClassNotFoundException, SQLException, Exception {//retrieving the subject ID
        System.out.println("Im working! ");
        
    }//end of the method 
    
    public void pullingProfileInfoMthd2() throws ClassNotFoundException, SQLException, Exception {//retrieving the subject ID
        //this block of code is used to retrieve some stored varibles from db
        
        retriveUsernameFromUI();//invokes the method 

        Class.forName("com.mysql.jdbc.Driver");
         this.connectorMthd();
        try {
            ///Retrieving the user selected subjects from selectedsubjects table
            ps = this.getCn().prepareStatement("SELECT serviceNo FROM members  WHERE Username=?");
            ps.setString(1, "asheer20201");

            ResultSet rss = ps.executeQuery();

            if (rss.next()) {//if found result 

                servicesNo = rss.getString(1);
                System.out.println("Testing 'service No' from the pullingProfileInfoMthd METHOD" + servicesNo );
                //RequestContext.getCurrentInstance().update("userProfileForm:userProfilePanel");
            }
        } catch (Exception e) {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error ocured", "Please signin again.  And try again. " + e);
            RequestContext.getCurrentInstance().showMessageInDialog(message);

        }

    }//end of method 

}//end of the class
