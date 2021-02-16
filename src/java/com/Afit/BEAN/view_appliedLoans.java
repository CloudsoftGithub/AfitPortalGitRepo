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

public class view_appliedLoans extends DAO implements Serializable {

    PreparedStatement ps;
    ResultSet rs;
    // Connection con;

    private String recNo;
    private String servceno;
    private String name;
    private String tranDate;
    private String loanType;
    private double loanAmount;
    private int period;
    private double monthlyPay;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTranDate() {
        return tranDate;
    }

    public void setTranDate(String tranDate) {
        this.tranDate = tranDate;
    }

    public String getLoanType() {
        return loanType;
    }

    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public double getMonthlyPay() {
        return monthlyPay;
    }

    public void setMonthlyPay(double monthlyPay) {
        this.monthlyPay = monthlyPay;
    }

     
    public List<view_appliedLoans> getAppliedLoan_Info() throws Exception {
        connectorMthd();

        List<view_appliedLoans> PreEnrollmentViewInfo = new ArrayList<view_appliedLoans>();

        try {

            PreparedStatement ps = this.getCn().prepareStatement("SELECT recNo,serviceNo,name,TranDate,LoanType,LoanAmount,Period,MonthlyPay FROM loanapplication ");
            rs = ps.executeQuery();

            while (rs.next()) {
                view_appliedLoans tbl = new view_appliedLoans();

                tbl.setRecNo(rs.getString("recNo"));
                tbl.setServceno(rs.getString("serviceNo"));
                tbl.setName(rs.getString("name"));
                tbl.setTranDate(rs.getString("tranDate"));
                tbl.setLoanType(rs.getString("loanType"));
                tbl.setLoanAmount(rs.getDouble("loanAmount"));
                tbl.setPeriod(rs.getInt("period"));
                tbl.setMonthlyPay(rs.getDouble("monthlyPay"));

                PreEnrollmentViewInfo.add(tbl);
            }//end of while-block

            ps.close();
            this.Close();

        } catch (Exception e) {
             FacesContext.getCurrentInstance().addMessage(
                            null,
                            new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                    "Loan Application Error" + " Error occured"+e,
                                    ""));
        } finally {

            //rs.close();
            //  this.Close();
        }//end of finally-block

        return PreEnrollmentViewInfo;
    }//end of method

 
}//end of vla 
