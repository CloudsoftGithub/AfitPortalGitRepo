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
public class Loan_applicationBEAN extends DAO implements Serializable {

    int counter = 0;
    int counter2 = 0;
    PreparedStatement ps;
    ResultSet rs;
    // Connection con;

    private String serviceNo;
    private String username;
    private String fullname;

    private String Loantype;
    private double LoanAmount;
    private int period;
    private double monthlyPay;

    private double Loanbalance;
    private double totalSavings;

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

    public String getLoantype() {
        return Loantype;
    }

    public void setLoantype(String Loantype) {
        this.Loantype = Loantype;
    }

    public double getLoanAmount() {
        return LoanAmount;
    }

    public void setLoanAmount(double LoanAmount) {
        this.LoanAmount = LoanAmount;
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

    public double getLoanbalance() {
        return Loanbalance;
    }

    public void setLoanbalance(double Loanbalance) {
        this.Loanbalance = Loanbalance;
    }

    public double getTotalSavings() {
        return totalSavings;
    }

    public void setTotalSavings(double totalSavings) {
        this.totalSavings = totalSavings;
    }

    
    //RETRIEVING VALUES FROM THE 'loan_Application' UI
    public void retriveServiceNoFromUI() {//get the current 'serviceNo' on the UI 
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        serviceNo = ec.getRequestParameterMap().get("loan_applicationForm:myServiceNo");
    }//end of method

    public void retriveFullNameFromUI() {//get the current 'fullname' on the UI 
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        fullname = ec.getRequestParameterMap().get("loan_applicationForm:myusername");
    }//end of method

    //RETRIEVING VALUES FROM THE 'loan_Application_details' UI
    public void retriveServiceNoFromLoanAppDetailsUI() {//get the current 'serviceNo' on the UI 
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        serviceNo = ec.getRequestParameterMap().get("loan_applicationDetailsForm:myServiceNo");
    }//end of method

    public void calculatingTheMonthlyPay(SelectEvent event) {

        //CALCULATING THE MONTHLY PAY BEFORE INSERTING THE TUPLES
        monthlyPay = LoanAmount / period;

    }//end of the method

    public void preProcessLoanMthd() throws Exception {

        retriveServiceNoFromUI();//invoked 
        retriveFullNameFromUI();//invoked 

        if (serviceNo.equalsIgnoreCase("")) {

            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_FATAL,
                            "Error Occured! " + " The service no is NOT retrieved. Please, login again.",
                            "and, try!"));

        } else if (LoanAmount == 0) {//MAKING SURE THAT LOAN AMOUNT IS NOT ZERO (i.e user must make a significant  entry) 

            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            "" + "Pls, sulpply the 'requested amount' for the loan",
                            "and, try again."));

        } else {

            //DELETE THE CONTENTS OF THE 'loanpreprocess' BY SERVICE NO before a new application
            Class.forName("com.mysql.jdbc.Driver");
            this.connectorMthd();//connectionestablished

            ps = this.getCn().prepareStatement(" DELETE FROM loanpreprocess WHERE ServiceNo =? ");
            ps.setString(1, serviceNo);
            ps.executeUpdate();

            try {//Process the loan 

                Class.forName("com.mysql.jdbc.Driver");
                this.connectorMthd();//connectionestablished

                ps = this.getCn().prepareStatement("INSERT INTO loanpreprocess VALUES(null, ?,?, now(),?,?,?,null)");
                ps.setString(1, serviceNo);
                ps.setString(2, fullname);

                ps.setString(3, Loantype);
                ps.setDouble(4, LoanAmount);
                ps.setInt(5, period);
                //ps.setDouble(6, monthlyPay);
                ps.executeUpdate();

                //CALCULATING THE MONTHLY PAY BEFORE INSERTING THE TUPLES
                monthlyPay = LoanAmount / period;

                ExternalContext redcontext = FacesContext.getCurrentInstance().getExternalContext();
                redcontext.redirect("loan_application_details.xhtml");   /// redirecting to  the 

                //clearVariables();//invoked to clear some variables, after a successfull entry
            } catch (Exception e) {
                FacesContext.getCurrentInstance().addMessage(
                        null,
                        new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                "Loan Application is NOT successful!" + "",
                                "Pls, try again."));
            } finally {
                this.Close();
                ps.close();
            }

            //PULLING THE LOAN BALANCE BY THE 'serviceNo'
            Class.forName("com.mysql.jdbc.Driver");
            this.connectorMthd();//connectionestablished

            ps = this.getCn().prepareStatement("SELECT Balance FROM mloangrant WHERE ServiceNo =? AND LoanType = ?");
            ps.setString(1, serviceNo);
            ps.setString(2, Loantype);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Loanbalance = rs.getDouble("Balance");
                System.out.println("Loan balance Test: " + Loanbalance);
            }

            //PULLING THE 'total savings' BY THE 'serviceNo' 
            Class.forName("com.mysql.jdbc.Driver");
            this.connectorMthd();//connectionestablished

            ps = this.getCn().prepareStatement("SELECT Balance FROM savingssmry WHERE ServiceNo =? ");
            ps.setString(1, serviceNo);
 
            ResultSet rs_Tsavings = ps.executeQuery();
            while (rs_Tsavings.next()) {
                 totalSavings = rs_Tsavings.getDouble("Balance");
                System.out.println("Total Savings Test: " + totalSavings);
            }
        }//end of the else block //end of the else-block

    }//end of the method

    public void loanAgreeButtonmthd() throws Exception {

        retriveServiceNoFromLoanAppDetailsUI();//invoked to get the 'service no' from the loan_Application_details

        //CHECKING IF THE  member with 'service no' has a zero(0) balance on the same type of loan or NOT
        //IF the loan balance IS NOT ZERO (meaning he has not paid), THEN THE SYSTEM SHOULD DENY HIM FROM APPLYING FOR THE SAME TYPE OF LOAN
        Class.forName("com.mysql.jdbc.Driver");
        this.connectorMthd();//connectionestablished

        ps = this.getCn().prepareStatement("SELECT Balance FROM mloangrant WHERE ServiceNo =? AND LoanType = ?");
        ps.setString(1, serviceNo);
        ps.setString(2, Loantype);

        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            Loanbalance = rs.getDouble("Balance");
            System.out.println("Loan balance Test: " + Loanbalance);
        }

        if (serviceNo.equalsIgnoreCase("")) {

            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_FATAL,
                            "Error Occured! " + " 'Loan Application cannot be fulfilled.' The service no is NOT retrieved. Please, login again.",
                            "and, try!"));

        } else if (Loanbalance > 0) {
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_FATAL,
                            "" + " 'You can NOT apply for the same type of loan'. This is because you have NOT excusted the current loan. Please, LIQUIDATE and try again.",
                            ""));
        } else {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                this.connectorMthd();//connectionestablished

                ps = this.getCn().prepareStatement("UPDATE loanpreprocess SET MonthlyPay = ? WHERE ServiceNo =? ");
                ps.setDouble(1, monthlyPay);
                ps.setString(2, serviceNo);
                ps.executeUpdate();

                RequestContext.getCurrentInstance().update("loan_applicationDetailsForm:loan_applicationDetailsPanel");

                counter += 1;

                if (counter > 0) {
                    copytuplesIntoLaonAppTable();//invoked the method 
                }//end of the if-block 

            } catch (Exception e) {
                throw e;
            }

        }//end of the else-block 

    }//end of the method

    public void loanDeclineButtonmthd() throws Exception {//Redirect to the login page
        ExternalContext redcontext = FacesContext.getCurrentInstance().getExternalContext();
        redcontext.redirect("Login.xhtml");   /// redirecting to  the 

    }//end of the method

    public void copytuplesIntoLaonAppTable() throws Exception {
        try {

            Class.forName("com.mysql.jdbc.Driver");
            this.connectorMthd();//connectionestablished

            ps = this.getCn().prepareStatement("INSERT into loanapplication SELECT * FROM loanpreprocess where ServiceNo= ?");
            ps.setString(1, serviceNo);

            ps.executeUpdate();

            clearVariables();//clears variables

            ExternalContext redcontext = FacesContext.getCurrentInstance().getExternalContext();
            redcontext.redirect("successful_loan_application.xhtml");   /// redirecting to  the  loan_success page

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,
                            "Loan Application is NOT successful! "+e + "",
                            "Pls, try again."));
        } finally {
            this.Close();
            ps.close();
        }

    }//end of the method

    public void loan_applicationMthd() throws Exception {

        retriveServiceNoFromUI();//invoked 
        retriveFullNameFromUI();//invoked 

        if (serviceNo.equalsIgnoreCase("")) {
            System.out.println("Printing FROM enableGoButton: " + serviceNo);

            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_FATAL,
                            "Error Occured! " + " The service no is NOT retrieved. Please, login again.",
                            "and, try!"));

        } else {

            try {

                Class.forName("com.mysql.jdbc.Driver");
                this.connectorMthd();//connectionestablished

                ps = this.getCn().prepareStatement("INSERT INTO loanapplication VALUES(null, ?,?, now(),?,?,?,?)");
                ps.setString(1, serviceNo);
                ps.setString(2, fullname);

                ps.setString(3, Loantype);
                ps.setDouble(4, LoanAmount);
                ps.setInt(5, period);
                ps.setDouble(6, monthlyPay);
                ps.executeUpdate();

                FacesContext.getCurrentInstance().addMessage(
                        null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO,
                                "A Successful Loan Application" + " Thank you!",
                                ""));
                clearVariables();//invoked to clear some variables, after a successfull entry

            } catch (Exception e) {
                FacesContext.getCurrentInstance().addMessage(
                        null,
                        new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                "Loan Application is NOT successful! "+ e + "",
                                "Pls, try again." + e));
            } finally {
                this.Close();
                ps.close();
            }

        } //end of the else-block

    }//end of the method

    public void clearVariables() {

        Loantype = "";
        LoanAmount = 0.0;
        monthlyPay = 0.0;
        period = 0;

    }//end of the method

}//END OF THE CLASS
