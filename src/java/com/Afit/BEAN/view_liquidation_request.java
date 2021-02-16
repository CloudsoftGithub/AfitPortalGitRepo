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

public class view_liquidation_request extends DAO implements Serializable {

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

    public void retriveCurrentServiceFromUI() {
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        serviceno = (String) ec.getRequestParameterMap().get("viewPreLiquidationForm:myServiceNo");
    }

    public List<view_liquidation_request> getPre_LiquidationInfo() throws Exception {
        connectorMthd();

        List<view_liquidation_request> PreLiquidationViewInfo = new ArrayList<view_liquidation_request>();

        try {

            PreparedStatement ps = this.getCn().prepareStatement("SELECT recNo,serviceNo,Name,TranDate,LiquidationAmnt,ref,Status FROM liquidation WHERE Status='Not_Approved' ");
            rs = ps.executeQuery();

            while (rs.next()) {

                view_liquidation_request tbl = new view_liquidation_request();

                tbl.setRecNo(rs.getString("recNo"));
                tbl.setServiceno(rs.getString("serviceNo"));
                tbl.setName(rs.getString("Name"));
                tbl.setTransDate(rs.getString("TranDate"));
                tbl.setLiquidationAmount(rs.getDouble("LiquidationAmnt"));
                tbl.setRef(rs.getString("ref"));
                tbl.setStatus(rs.getString("status"));

                PreLiquidationViewInfo.add(tbl);

            }//end of while-block

            ps.close();
            this.Close();

        } catch (Exception e) {
            throw e;
        } finally {

            //rs.close();
            //  this.Close();
        }//end of finally-block

        return PreLiquidationViewInfo;
    }//end of method

    public void liquidationApproval() throws Exception {
        int counter2 = 0;

        this.connectorMthd();//
        //CHECKS ID MEMBERS HAS DONE PRE-ENROLLMENT
        PreparedStatement st1 = getCn().prepareStatement("select * from liquidation where ServiceNo=? ");
        st1.setString(1, serviceno);
        ResultSet rs = st1.executeQuery();

        if (rs.next()) {//IF THE SERVICE NO. HAS APPLIED FOR LIQUDATION DO THIS ....

            try {

                PreparedStatement st = getCn().prepareStatement("UPDATE liquidation SET Status='Approved' WHERE ServiceNo=? ");
                st.setString(1, serviceno);
                st.executeUpdate();
                st.close();

                counter2++;

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Liquidation Approval", "Liquidation Approval Request has been approved for " + '[' + this.serviceno + ']' + "Pls, inform the applicant to proceed with his her/her loan application"));
                if (counter2 > 0) {

                    ClearingTheLoanBalance();
                }
            } catch (Exception e) {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "Pls, check your entries " + e));
            } finally {
                this.Close();
            }

        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Liquidation Error. This service no. has NOT applied for a Liquidation", ". Thank you!"));
            st1.close();
            this.Close();
        }

        serviceno = "";
    }//end of the method

    public void ClearingTheLoanBalance() throws Exception {

        this.connectorMthd();//invoked db instance 
        //CLEARING THE LOAN BALNCE IN THE 'mloangrant'
        try {
            PreparedStatement st = getCn().prepareStatement("UPDATE mloangrant SET Balance=0.0 WHERE ServiceNo=? ");
            st.setString(1, serviceno);
            st.executeUpdate();

            //INSERTING THE REMARK INTO THE 'remark' table
            insertingremarksMthd();

        } catch (Exception e) {
            throw e;
        } finally {
            this.Close();
        }

    }//end of the method

    public void declinebutton() throws Exception {

        insertingremarksMthd();//invoked 

    }//end of the method

    public void insertingremarksMthd() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        this.connectorMthd();//connectionestablished

        //CHECKS ID MEMBERS HAS DONE PRE-ENROLLMENT
        PreparedStatement st1 = getCn().prepareStatement("select * from liquidation where ServiceNo=? ");
        st1.setString(1, serviceno);
        ResultSet rs = st1.executeQuery();

        if (rs.next()) {//IF service no is found in the liquidation table
            try {
                ps = this.getCn().prepareStatement("INSERT INTO remark VALUES(null,?,now(),?)");
                ps.setString(1, serviceno);
                ps.setString(2, remark);
                ps.executeUpdate();

                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "The liquidation remarks has been saved for service no. " + "[" + serviceno + "]", ". Thank you!"));

            } catch (Exception e) {
                throw e;
            } finally {
                this.Close();
            }
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Remark Error. This service no. has NOT applied for a liquidation. So remark cant be sent.", ". Thank you!"));
            st1.close();
            this.Close();
        }

    }//end of the method

}//end of class
