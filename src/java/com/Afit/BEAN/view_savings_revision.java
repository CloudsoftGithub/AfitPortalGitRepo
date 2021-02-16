package com.Afit.BEAN;

import com.Afit.DAO.DAO;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

public class view_savings_revision extends DAO implements Serializable {

    PreparedStatement ps;
    ResultSet rs;
    // Connection con;

    private String recNo;
    private String servceno;
    private String name;
    private String type;
    private String tranDate;
    private double oldAmount;
    private double currentAmount;

    private String fromDate;
    private String toDate;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTranDate() {
        return tranDate;
    }

    public void setTranDate(String tranDate) {
        this.tranDate = tranDate;
    }

    public double getOldAmount() {
        return oldAmount;
    }

    public void setOldAmount(double oldAmount) {
        this.oldAmount = oldAmount;
    }

    public double getCurrentAmount() {
        return currentAmount;
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

    public void setCurrentAmount(double currentAmount) {
        this.currentAmount = currentAmount;
    }

    public void retriveFromDateFromUI() {
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        fromDate = (String) ec.getRequestParameterMap().get("viewSavingsRevisionForm:FROMReportDate");
    }

    public void retriveToDateFromUI() {
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        toDate = (String) ec.getRequestParameterMap().get("viewSavingsRevisionForm:ToReportDate");
    }

    public void enableAprrovedButton() {
        retriveFromDateFromUI();//invoked 
        retriveToDateFromUI();//invoked 

        System.out.println("Testing fromDate: " + fromDate);
        System.out.println("Testing toDate: " + toDate);

    }//end of the method

    public List<view_savings_revision> getSavingsRevision_Info() throws Exception {
        connectorMthd();

        List<view_savings_revision> savingsRevisionViewInfo = new ArrayList<view_savings_revision>();

        try {

            //PreparedStatement ps = this.getCn().prepareStatement("SELECT recNo,serviceNo,name,type,TranDate,OldAmount,CurrentAmount FROM savingsrevision ");
            PreparedStatement ps = this.getCn().prepareStatement("SELECT recNo,serviceNo,name,type,TranDate,OldAmount,CurrentAmount FROM savingsrevision WHERE(TranDate BETWEEN ? AND ? )  ");
            ps.setString(1, fromDate);
            ps.setString(2, toDate);
            rs = ps.executeQuery();

            while (rs.next()) {
                view_savings_revision tbl = new view_savings_revision();

                tbl.setRecNo(rs.getString("recNo"));
                tbl.setServceno(rs.getString("serviceNo"));
                tbl.setName(rs.getString("name"));
                tbl.setType(rs.getString("type"));
                tbl.setTranDate(rs.getString("tranDate"));
                tbl.setOldAmount(rs.getDouble("oldAmount"));
                tbl.setCurrentAmount(rs.getDouble("currentAmount"));

                savingsRevisionViewInfo.add(tbl);
            }//end of while-block

            ps.close();
            this.Close();

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            "Loan Application Error" + " Error occured",
                            ""));
        } finally {

            //rs.close();
            //  this.Close();
        }//end of finally-block

        return savingsRevisionViewInfo;
    }//end of method

    public void reportGeneration() throws SQLException, Exception {

        enableAprrovedButton();//invoked

        this.connectorMthd();//invoked

        try {
            PreparedStatement ps = this.getCn().prepareStatement(" SELECT * FROM ( select 'RecNo','ServiceNo','Name','Type','TranDate','OldAmount','CurrentAmount' UNION ALL  SELECT RecNo,ServiceNo,Name,Type,TranDate,OldAmount,CurrentAmount FROM savingsrevision   WHERE(TranDate BETWEEN ? AND ? ) )resulting_set  into outfile 'C:/export/SavingsRevisionReport.csv' FIELDS TERMINATED BY ',' OPTIONALLY ENCLOSED BY '\"' LINES TERMINATED BY '\\r\\n'  ");
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

    public void reportGenerationMessageMthd() {

        FacesContext.getCurrentInstance().addMessage(
                null,
                new FacesMessage(FacesMessage.SEVERITY_INFO,
                        "" + "Report has been generated. BEETWEEN " + fromDate + " TO " + toDate,
                        "  Local te file in C:/export/...  "));
    }//end of the method 
}//end of vla 
