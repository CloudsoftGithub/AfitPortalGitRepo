package com.Afit.BEAN;

import com.Afit.DAO.DAO;
import java.io.Serializable;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

@ManagedBean
@SessionScoped
public class Loan_liquidationBEAN extends DAO implements Serializable {

    int counter = 0;
    int counter2 = 0;
    PreparedStatement ps;
    ResultSet rs;
    // Connection con;

    private String serviceNo;
    private String name;
    private double liquidationAmount;
    private String ref;
    private String status;

    public String getServiceNo() {
        return serviceNo;
    }

    public void setServiceNo(String serviceNo) {
        this.serviceNo = serviceNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    //RETRIEVING VALUES FROM THE 'loan_Application' UI
    public void retriveServiceNoFromUI() {//get the current 'serviceNo' on the UI 
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        serviceNo = ec.getRequestParameterMap().get("loan_liquidationDetailsForm:myServiceNo");
    }//end of method

    public void retriveFullNameFromUI() {//get the current 'name' on the UI 
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        name = ec.getRequestParameterMap().get("loan_liquidationDetailsForm:name");
    }//end of method

    /*
     //RETRIEVING VALUES FROM THE 'loan_Application_details' UI
    public void retriveServiceNoFromLoanAppDetailsUI() {//get the current 'serviceNo' on the UI 
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        serviceNo = ec.getRequestParameterMap().get("loan_applicationDetailsForm:myServiceNo");
    }//end of method
     */
    public void processLoanLiquidationMthd() throws Exception {

        retriveServiceNoFromUI();//invoked 
        retriveFullNameFromUI();//invoked 

        if (serviceNo.equalsIgnoreCase("")) {

            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_FATAL,
                            "Loan Liquidation Error! " + " The service no is NOT retrieved. Please, login again.",
                            "and, try!"));

        } else if (liquidationAmount == 0) {//MAKING SURE THAT 'liquidation amount'  IS NOT ZERO (i.e user must make a significant  entry) 

            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            "" + "Pls, sulpply the 'liquidation amount' ",
                            "and, try again."));

        } else {
            String myStatus = "Not_Approved";

            try {//Process the liquidation  
                Class.forName("com.mysql.jdbc.Driver");

                this.connectorMthd();//connectionestablished

                ps = this.getCn().prepareStatement("INSERT INTO liquidation VALUES(null, ?,?, now(),?,?,?)");
                ps.setString(1, serviceNo);
                ps.setString(2, name);
                ps.setDouble(3, liquidationAmount);
                ps.setString(4, ref);
                ps.setString(5, myStatus);

                ps.executeUpdate();

               
                ExternalContext redcontext = FacesContext.getCurrentInstance().getExternalContext();
                redcontext.redirect("successful_loan_liquidation.xhtml");   /// redirecting to  the 
                //clearVariables();//invoked to clear some variables, after a successfull entry
            } catch (Exception e) {
                FacesContext.getCurrentInstance().addMessage(
                        null,
                        new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                "Loan Liquidation is NOT successful! " + e +"",
                                "Pls, try again." ));
            } finally {
                this.Close();
                ps.close();
            }

        }//end of the else block //end of the else-block

    }//end of the method

}//END OF THE CLASS
