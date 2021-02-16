package com.Afit.BEAN;

 
import com.Afit.DAO.DAO;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;
 
 
public class viewSavigns_report2 extends DAO {

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
    
    
    public void retriveCurrentUsernameFromUI() {//get the current username on the UI 
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        username = ec.getRequestParameterMap().get("certAppform:myusername");
        System.out.println("ABCD" + username);
    }

    public List<viewSavigns_report2> getSavings_reportInfo() throws Exception {
        this.connectorMthd();//invoked the method
        
        retriveCurrentUsernameFromUI();
          
         List<viewSavigns_report2> SavingsviewInfo = new ArrayList<viewSavigns_report2>();

        try {
            PreparedStatement ps = this.getCn().prepareStatement("SELECT serviceNo,type,TranDate,Year,Month,Details,Dr,Cr,Balance FROM savingsdetails ");
            //ps.setString(1, username);

 
            rs = ps.executeQuery();
            RequestContext.getCurrentInstance().update("certAppform:certAppPanel");

            while (rs.next()) {
                viewSavigns_report2 tbl = new viewSavigns_report2();
                tbl.setServiceNo(rs.getString("serviceNo"));
                tbl.setType(rs.getString("type"));
                tbl.setTransactionDate(rs.getString("TranDate"));
                tbl.setTransactionYear(rs.getString("Year"));
                tbl.setTransactionMonth(rs.getString("Month"));
                tbl.setDetails(rs.getString("details"));
                tbl.setDr(rs.getDouble("dr"));
                tbl.setCr(rs.getDouble("cr"));
                tbl.setBalance(rs.getDouble("balance"));

                //tbl.setDuration(rs.getString(9));
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
 
 
}//end of the class
