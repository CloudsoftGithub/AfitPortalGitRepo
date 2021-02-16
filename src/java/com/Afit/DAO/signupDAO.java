package com.Afit.DAO;

import com.Afit.BEAN.DropDownViewForLGA;
import com.Afit.MODEL.signup;
import java.io.Serializable;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

public class signupDAO extends DAO {

    public String states;
    public String lgas;

    public String getStates() {
        return states;
    }

    public void setStates(String states) {
        this.states = states;
    }

    public String getLgas() {
        return lgas;
    }

    public void setLgas(String lgas) {
        this.lgas = lgas;
    }

    public void signupMethod(signup sigp) throws Exception {

        this.connectorMthd();//DB Connectivity 

        // Checking the multiple signup with same username
        PreparedStatement st1 = this.getCn().prepareStatement("select * from members where username=?");
        st1.setString(1, sigp.getUsername());

        ResultSet rs = st1.executeQuery(); /////////////this block of code check for the multiple username signup as stated above. BUT THE TEST WWAS DONE BELOW IN THE ELSE IF BLOCK

        //CHECKING FOR THE MULTIPLE USE OF THE SERVICE NO
        PreparedStatement st4 = this.getCn().prepareStatement("select * from members where serviceno=?");
        st4.setString(1, sigp.getSerialNo());

        ResultSet rs4 = st4.executeQuery();/////////////this block of code check for the multiple serviceNo signup as stated above. BUT THE TEST WWAS DONE BELOW IN THE ELSE IF BLOCK

        // Checking to prevent the use of already existing username 
        if (rs.next()) { // NOTE: the query state for this if block has been written above 

            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Signup Error", "This username has been signed up. Pls, use a different username");
            RequestContext.getCurrentInstance().showMessageInDialog(message);
            //this.Close();
            // st1.close();

        } else if (rs4.next()) //// NOTE: the query state for this if block has been written above 
        {
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Signup Error", "The 'service no' you supplied has been used. Pls, use a correct one");
            RequestContext.getCurrentInstance().showMessageInDialog(message);
            //this.Close();
            // st1.close();
        } else {

            System.err.println("State: " + states);
            System.err.println("LGA: " + lgas);

            String myflag = "Not_Approved";

            //Inserting the tuples into the db 
            try {
                this.connectorMthd();//DB connectivity invocation 
                PreparedStatement st = this.getCn().prepareStatement("INSERT INTO members values(null,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?, 'THRIFT CONTRIBUTIONS',?,?,?,?,?,?,?,?,?,?,?,?,?,?)");

                st.setString(1, sigp.getServceno());

                //Converting the Start Date from Java.util.Date to Java.Sql.Date
                java.util.Date utilRegDateQuery = sigp.getRegDate();
                java.sql.Date sqlRegDatequery = new java.sql.Date(utilRegDateQuery.getTime());

                st.setDate(2, sqlRegDatequery);

                st.setString(3, sigp.getSurename());
                st.setString(4, sigp.getOthernames());
                st.setString(5, sigp.getSpecifyNationality());

                st.setString(6, sigp.getNationality());

                st.setString(7, sigp.getStateOfOrigin());//

                st.setString(8, sigp.getLgaOrigin());//

                st.setString(9, sigp.getGsm());
                st.setString(10, sigp.getEmailId());
                st.setString(11, sigp.getSex());
                st.setString(12, sigp.getNextOfKinName());

                st.setString(13, sigp.getNextOfKinAddress());
                st.setString(14, sigp.getRelationship());

                st.setString(15, sigp.getCategory());
                st.setString(16, sigp.getPhoneNo());
                st.setDouble(17, sigp.getOpenBalance());

                st.setString(18, sigp.getAccountName());
                st.setDouble(19, sigp.getSavings());

                //Converting the Start Date from Java.util.Date to Java.Sql.Date
                java.util.Date utilStartDateQuery = sigp.getStartDate();
                java.sql.Date sqlStartDatequery = new java.sql.Date(utilStartDateQuery.getTime());
                st.setDate(20, sqlStartDatequery);

                st.setString(21, sigp.getMethod());
                st.setString(22, sigp.getBankName());
                st.setString(23, sigp.getAccountNo());
                st.setString(24, sigp.getBankAddress());
                st.setDouble(25, sigp.getTotalSavings());

                st.setDouble(26, sigp.getSavingbalance());
                st.setString(27, sigp.getStatus());

                st.setString(28, sigp.getUsername());
                st.setString(29, sigp.getPassword());
                //st.setString(30, sigp.getPinNo());
                //st.setString(31, sigp.getSerialNo());

                st.setString(30, myflag);// myflag is local variable which is used to store the status of the card i.e wether is used on not

                st.executeUpdate();
                st.close();

                FacesContext.getCurrentInstance().addMessage(
                        null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO,
                                "You succcessfully signup" + " thank you! ",
                                "you will be redirected to combination page"));

                ExternalContext redcontext = FacesContext.getCurrentInstance().getExternalContext();
                redcontext.redirect("successfulSignup.xhtml");
            } catch (Exception e) {

                FacesContext.getCurrentInstance().addMessage(
                        null,
                        new FacesMessage(FacesMessage.SEVERITY_FATAL,
                                "Error in signup." + " Pls, try again ",
                                " " + e));

            } finally {
                this.Close();
            }

        }//end of the else-block 
    }//end of method

}//enf of the class
