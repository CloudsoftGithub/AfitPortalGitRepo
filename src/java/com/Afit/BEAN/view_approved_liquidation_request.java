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

public class view_approved_liquidation_request extends DAO implements Serializable {

    PreparedStatement ps;
    ResultSet rs;
    // Connection con;

    private String recNo;
    private String serviceno;
    private String name;
    private String transDate;
    private double liquidationAmount;
    private String ref;
    private String status;
    private String remark;

    public String getRecNo() {
        return recNo;
    }

    public void setRecNo(String recNo) {
        this.recNo = recNo;
    }

    public String getServiceno() {
        return serviceno;
    }

    public void setServiceno(String serviceno) {
        this.serviceno = serviceno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTransDate() {
        return transDate;
    }

    public void setTransDate(String transDate) {
        this.transDate = transDate;
    }

    public double getLiquidationAmount() {
        return liquidationAmount;
    }

    public void setLiquidationAmount(double liquidationAmount) {
        this.liquidationAmount = liquidationAmount;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
 

    public List<view_approved_liquidation_request> getApproved_LiquidationInfo() throws Exception {
        connectorMthd();

        List<view_approved_liquidation_request> LiquidationViewInfo = new ArrayList<view_approved_liquidation_request>();

        try {

            PreparedStatement ps = this.getCn().prepareStatement("SELECT recNo,serviceNo,Name,TranDate,LiquidationAmnt,ref,Status FROM liquidation WHERE Status='Approved' order by recNo ");
            rs = ps.executeQuery();

            while (rs.next()) {

                view_approved_liquidation_request tbl = new view_approved_liquidation_request();

                tbl.setRecNo(rs.getString("recNo"));
                tbl.setServiceno(rs.getString("serviceNo"));
                tbl.setName(rs.getString("Name"));
                tbl.setTransDate(rs.getString("TranDate"));
                tbl.setLiquidationAmount(rs.getDouble("LiquidationAmnt"));
                tbl.setRef(rs.getString("ref"));
                tbl.setStatus(rs.getString("status"));

                LiquidationViewInfo.add(tbl);

            }//end of while-block

            ps.close();
            this.Close();

        } catch (Exception e) {
            throw e;
        } finally {

            //rs.close();
            //  this.Close();
        }//end of finally-block

        return LiquidationViewInfo;
    }//end of method

   

}//end of class
