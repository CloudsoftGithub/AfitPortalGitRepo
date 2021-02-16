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
import org.primefaces.context.RequestContext;

@ManagedBean
@SessionScoped

public class viewSavigns_report extends DAO implements Serializable {

    int counter = 0;
    PreparedStatement ps;
    ResultSet rs;
    // Connection con;

    private String serviceNo;
    private String type;
    private String transactionDate;
    private String transactionYear;
    private String transactionMonth;
    private String details;
    private double dr;
    private double cr;
    private double balance;
    private String username;

    public String getServiceNo() {
        return serviceNo;
    }

    public void setServiceNo(String serviceNo) {
        this.serviceNo = serviceNo;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getTransactionYear() {
        return transactionYear;
    }

    public void setTransactionYear(String transactionYear) {
        this.transactionYear = transactionYear;
    }

    public String getTransactionMonth() {
        return transactionMonth;
    }

    public void setTransactionMonth(String transactionMonth) {
        this.transactionMonth = transactionMonth;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public double getDr() {
        return dr;
    }

    public void setDr(double dr) {
        this.dr = dr;
    }

    public double getCr() {
        return cr;
    }

    public void setCr(double cr) {
        this.cr = cr;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void retriveServiceNoFromUI() {//get the current 'serviceNo' on the UI 
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        serviceNo = ec.getRequestParameterMap().get("viewSavingsReportForm:myServiceNo");
        System.out.println("Printing Usename from retriveUsernameFromUI Mthd: " + serviceNo);

    }//end of method

    public void retriveUsernameFromUI() {//get the current 'username' on the UI 
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        username = ec.getRequestParameterMap().get("viewSavingsReportForm:myusername");
        System.out.println("Testing Usename from retriveUsernameFromUI Mthd: " + username);
    }//end of method

    public void enableGoButton() {
        retriveServiceNoFromUI();//invoked the method
        retriveUsernameFromUI();//invoked the method

        if (serviceNo.equalsIgnoreCase("")) {
            System.out.println("Printing FROM enableGoButton: " + serviceNo);

            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_FATAL,
                            "Error Occured! " + " The service no is NOT retrieved. Please, login again.",
                            "and, try!"));

        }
    }//end of the method

    public List<viewSavigns_report> getSavings_reportInfo() throws Exception {
        this.connectorMthd();//invoked the method

        List<viewSavigns_report> SavingsviewInfo = new ArrayList<viewSavigns_report>();

        try {
            PreparedStatement ps = this.getCn().prepareStatement("SELECT serviceNo,type,TranDate,Year,Month,Details,Dr,Cr,Balance FROM savingsdetails WHERE ServiceNo= ? ");
            ps.setString(1, serviceNo);

            rs = ps.executeQuery();
  
            RequestContext.getCurrentInstance().update("viewSavingsReportForm:viewSavingsReportPanel");

            while (rs.next()) {
                viewSavigns_report tbl = new viewSavigns_report();
                tbl.setServiceNo(rs.getString("serviceNo"));
                tbl.setType(rs.getString("type"));
                tbl.setTransactionDate(rs.getString("TranDate"));
                tbl.setTransactionYear(rs.getString("Year"));
                tbl.setTransactionMonth(rs.getString("Month"));
                tbl.setDetails(rs.getString("details"));
                tbl.setDr(rs.getDouble("dr"));
                tbl.setCr(rs.getDouble("cr"));
                tbl.setBalance(rs.getDouble("balance"));

                SavingsviewInfo.add(tbl);
            }//end of while-block
    
            ps.close();
            this.Close();

        } catch (Exception e) {

            throw e;

        } finally {

            //rs.close();
            //  this.Close();
        }//end of finally-block

        return SavingsviewInfo;
    }//end of method

}//end of vla 
