package com.Afit.BEAN;

import com.Afit.DAO.DAO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

@ManagedBean
@SessionScoped
public class savingsRevisionBEAN extends DAO {

    String TheRetrievedAccountType = "";
    PreparedStatement ps;
    ResultSet rs;
    // Connection con;

    private String serviceNo;
    private String username;
    private String fullname;

    private String accountType;
    private double currentAmount;
    private double OldAmount;

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getServiceNo() {
        return serviceNo;
    }

    public void setServiceNo(String serviceNo) {
        this.serviceNo = serviceNo;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public double getCurrentAmount() {
        return currentAmount;
    }

    public void setCurrentAmount(double currentAmount) {
        this.currentAmount = currentAmount;
    }

    public double getOldAmount() {
        return OldAmount;
    }

    public void setOldAmount(double OldAmount) {
        this.OldAmount = OldAmount;
    }

    //RETRIEVING VALUES FROM THE 'SavingsRevision' UI
    public void retriveServiceNoFromUI() {//get the current 'serviceNo' on the UI 
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        serviceNo = ec.getRequestParameterMap().get("savings_RevisionForm:myServiceNo");
    }//end of method

    public void retriveFullNameFromUI() {//get the current 'fullname' on the UI 
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        fullname = ec.getRequestParameterMap().get("savings_RevisionForm:myusername");
    }//end of method

    //RETRIEVING VALUES FROM THE 'SavingsRevisionDetails' UI
    public void retriveServiceNoFROMSavingsRevisionDetails() {//get the current 'serviceNo' on the UI 
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        serviceNo = ec.getRequestParameterMap().get("savings_RevisionDetailsForm:myServiceNo");
    }//end of method

    public void retriveFullNameFROMSavingsRevisionDetails() {//get the current 'fullname' on the UI 
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        fullname = ec.getRequestParameterMap().get("savings_RevisionDetailsForm:myusername");
    }//end of method

    public void preProcessSavingsRevisionMthd() throws Exception {

        retriveServiceNoFromUI();//invoked 
        retriveFullNameFromUI();//invoked 

        if (serviceNo.equalsIgnoreCase("")) {
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_FATAL,
                            "Error Occured! " + " The service no could NOT be retrieved. Please, login again.",
                            "and, try!"));
        } else {

            //PULLING THE ACCOUNT TYPE AND THE Monthly contributions(savings) BALANCE BY THE 'serviceNo'
            Class.forName("com.mysql.jdbc.Driver");
            this.connectorMthd();//connectionestablished

            try {

                ps = this.getCn().prepareStatement("SELECT accountType,savings FROM members WHERE ServiceNo = ? ");
                ps.setString(1, serviceNo);

                ResultSet rs = ps.executeQuery();
                while (rs.next()) {//RETRIEVING THE ACCOUNT TYPE AND MONTHLY CONTRIBUTIONS
                    TheRetrievedAccountType = rs.getString("accountType");
                    OldAmount = rs.getDouble("savings");

                    System.out.println("Account Type Test: " + accountType);
                    System.out.println("Monthly Savings Test: " + OldAmount);

                    //CHECKING IF THE RETRIEVED ACCOUNT TYPE IS CORRECT
                    if (!accountType.equalsIgnoreCase(TheRetrievedAccountType)) {//NOT CORRECT

                        FacesContext.getCurrentInstance().addMessage(
                                null,
                                new FacesMessage(FacesMessage.SEVERITY_FATAL,
                                        "Invalid Account Type. " + " The selected account-type does NOT exist.",
                                        "Pls, select the correct aacount-type and try!"));

                    } else {//CORRECT
                        TheRetrievedAccountType = accountType;
                        OldAmount = rs.getDouble("savings");

                        ExternalContext redcontext = FacesContext.getCurrentInstance().getExternalContext();
                        redcontext.redirect("savingsRevision_details.xhtml");   /// redirecting to  the 'savings revision details page'

                    }//
                }//end of the while-block

            } catch (Exception e) {
                FacesContext.getCurrentInstance().addMessage(
                        null,
                        new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                "Savigs Revision is NOT successful!" + "",
                                "Pls, try again." + e));
            } finally {
                this.Close();
                ps.close();
            }

        }//end of the else-block

    }//end of the the method

    public void modifyMonthlySavingsMthd() throws Exception {//Saves the modified monthly contributions (savings)

        retriveServiceNoFROMSavingsRevisionDetails();//invoked 
        retriveFullNameFROMSavingsRevisionDetails();//invoked 

        if (serviceNo.equalsIgnoreCase("")) {
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_FATAL,
                            "Error Occured! " + " The service no could NOT be retrieved. Please, login again.",
                            "and, try!"));

        } else if (currentAmount == 0.0) {

            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_FATAL,
                            "" + " Please, supply the 'new (current)' amount",
                            "and, try again!"));

        } else {

            try {

                Class.forName("com.mysql.jdbc.Driver");
                this.connectorMthd();//connectionestablished

                ps = this.getCn().prepareStatement("INSERT into savingsrevision VALUES(null, ?,?,?, now() ,?,?)");
                ps.setString(1, serviceNo);
                ps.setString(2, fullname);
                ps.setString(3, accountType);

                ps.setDouble(4, OldAmount);
                ps.setDouble(5, currentAmount);
                ps.executeUpdate();

                clearVariables();//clears variables

                ExternalContext redcontext = FacesContext.getCurrentInstance().getExternalContext();
                redcontext.redirect("successful_savings_revision.xhtml");   /// redirecting to  the  loan_success page

            } catch (Exception e) {
                FacesContext.getCurrentInstance().addMessage(
                        null,
                        new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                "Savigs Revision is NOT successful!" + "",
                                "Pls, try again." + e));
            } finally {
                this.Close();
                ps.close();
            }

        }//end of the else-block

    }//end of the method

    public void clearVariables() {

        serviceNo = "";
        fullname = "";
        accountType = "";
        OldAmount = 0.0;
        currentAmount = 0.0;

    }//end of the method

}//END OF TTHE CLASS 
