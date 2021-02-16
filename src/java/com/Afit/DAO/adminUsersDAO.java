 
package com.Afit.DAO;

import com.Afit.MODEL.adminUsersSignup;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

 
public class adminUsersDAO extends DAO{
   
    

    public void AdminCreationMthd(adminUsersSignup adminsigp) throws Exception {

        this.connectorMthd();

        ////////////// Checking the multiple signup with same username
        PreparedStatement st1 = this.getCn().prepareStatement("select * from adminusers where username=?");
        st1.setString(1, adminsigp.getUsername());

        ResultSet rs = st1.executeQuery(); /////////////this block of code check for the multiple username signup as stated above. BUT THE TEST WWAS DONE BELOW IN THE ELSE IF BLOCK
        if (rs.next()) { // NOTE: the query state for this if block has been written above 

            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Signup Error", "This 'Adminusername' has been signed up, pls use a different username");
            RequestContext.getCurrentInstance().showMessageInDialog(message);
            //this.Close();
            // st1.close();

        } else {

            try {//thic block of codes does the actual insertions 

                PreparedStatement st = this.getCn().prepareStatement("INSERT INTO adminusers values(?,?,?,?,?,?,Date(Now()))");
                st.setString(1, null);
                st.setString(2, adminsigp.getUsername());
                st.setString(3, adminsigp.getPassword());
                st.setString(4, adminsigp.getGsmNo());
                st.setString(5, adminsigp.getEmailID());
                st.setString(6, adminsigp.getName());
                st.executeUpdate();
                st.close();

                FacesContext.getCurrentInstance().addMessage(
                        null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO,
                                "You succcessfully signup" + " thank you! ",
                                ""));

                ExternalContext redcontext = FacesContext.getCurrentInstance().getExternalContext();
                redcontext.redirect("adminUserSuccesfulCreation.xhtml");

            } catch (Exception e) {
                FacesMessage messag = new FacesMessage(FacesMessage.SEVERITY_FATAL, "AdminUser Creation Error", e.getMessage() + " Pls, try again");
                RequestContext.getCurrentInstance().showMessageInDialog(messag);

            }//end of method

        }//end of else-block

    }//end of AdminCreationMthd
    
    
}//end of the class
