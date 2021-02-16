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

public class view_liquidation_history extends DAO implements Serializable {

    PreparedStatement ps;
    ResultSet rs;
    // Connection con;

    private String recNo;
    private String serviceno;
    private String remDate;
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

    public String getRemDate() {
        return remDate;
    }

    public void setRemDate(String remDate) {
        this.remDate = remDate;
    }

   
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    //RETRIEVING VALUES FROM THE 'loan_Application' UI
    public void retriveServiceNoFromUI() {//get the current 'serviceNo' on the UI 
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        serviceno = ec.getRequestParameterMap().get("liquidationHistroy_Form:myServiceNo");
    }//end of method

    public List<view_liquidation_history> getLiquidation_HistoryInfo() throws Exception {

        retriveServiceNoFromUI();
        connectorMthd();

        List<view_liquidation_history> Liquidation_History_ViewInfo = new ArrayList<view_liquidation_history>();

        try {

            PreparedStatement ps = this.getCn().prepareStatement("SELECT recNo,serviceNo,RemDate,Remark FROM remark WHERE serviceNo=? ");
            ps.setString(1, serviceno);

            rs = ps.executeQuery();

            while (rs.next()) {

                view_liquidation_history tbl = new view_liquidation_history();

                tbl.setRecNo(rs.getString("recNo"));
                tbl.setServiceno(rs.getString("serviceNo"));
                tbl.setRemDate(rs.getString("RemDate"));
                tbl.setRemark(rs.getString("remark"));

                Liquidation_History_ViewInfo.add(tbl);

            }//end of while-block

            ps.close();
            this.Close();

        } catch (Exception e) {
            throw e;
        } finally {

            //rs.close();
            //  this.Close();
        }//end of finally-block

        return Liquidation_History_ViewInfo;
    }//end of method

}//end of class
