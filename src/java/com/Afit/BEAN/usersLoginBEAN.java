package com.Afit.BEAN;

import com.Afit.DAO.DAO;
import com.Afit.MODEL.signup;
import java.io.IOException;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.primefaces.context.RequestContext;

@ManagedBean
@SessionScoped
public class usersLoginBEAN extends DAO implements Serializable {

    private static final long serialVersionUID = -1;

    private String username;
    private String password;

    private String serviceNo;

    private String surname;
    private String othernames;

    private String fullname;

    private String flag;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getServiceNo() {
        return serviceNo;
    }

    public void setServiceNo(String serviceNo) {
        this.serviceNo = serviceNo;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getOthernames() {
        return othernames;
    }

    public void setOthernames(String othernames) {
        this.othernames = othernames;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String usersLoginMthd() throws Exception {

        this.connectorMthd();//calls the method 'connectorMthd()' to create connection

        Connection con = null;
        PreparedStatement ps = null;
        String myusername = username.toString();
        String mypassword = password.toString();

        //CHECKING IF THE 'serviceNo already exist',  THEN the Memmber will not 'require any approval by the admin'
        //i.e All existing members will login immediatly after their signup without waiting for any approval
        PreparedStatement psExistingMem = this.getCn().prepareStatement("select * from emember where serviceNo= ? ");
        psExistingMem.setString(1, serviceNo.toString());
        ResultSet rsExistingMem = psExistingMem.executeQuery();
        
        if (rsExistingMem.next()) { //Found a member in the existing table
            //////////////////////////////////////////////////////
            //////////MODIFYING THE 'flag to "Approved" ' and redirect to the 'usersDashboard'
           
                try {

                    PreparedStatement sts = getCn().prepareStatement("UPDATE members SET flag='Approved' WHERE username=? ");
                    sts.setString(1, username);
                    sts.executeUpdate();
                    sts.close();

                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Membership Approval", "Your Membership Approval Request has been approved for " + '[' + this.username + ']' + ""));

                    //////////////////Redirecting to the user's dahsboard  
                    //ExternalContext redcontext = FacesContext.getCurrentInstance().getExternalContext();
                    ///redcontext.redirect("usersDashboard.xhtml");   /// redirecting to  the 
                } catch (Exception e) {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Error", "Pls, check your entries " + e));
                } finally {
                    //this.Close();
                }
            }else{
            //Do nothing
        }

        //CHECKING IF THE ACCOUNT HAS BEEN 'APPROVED'
        PreparedStatement ps2 = this.getCn().prepareStatement("select * from members where username= ? and password= ? AND flag='Not_Approved' ");
        ps2.setString(1, username.toString());
        ps2.setString(2, password.toString());
        ResultSet rs2 = ps2.executeQuery();

        try {
            PreparedStatement st = this.getCn().prepareStatement("select serviceNo, username, password,surname,others from members where username= ? and password= ? ");
            st.setString(1, myusername);
            st.setString(2, mypassword);

            ResultSet rs = st.executeQuery();

            

            ////////////
            if (rs2.next()) {//CHECKING IF THE ACCOUNT HAS BEEN 'APPROVED'

                System.out.println("Block working!");

                FacesContext.getCurrentInstance().addMessage(
                        null,
                        new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                "" + " Dear Member. Your account has NOT been approved!",
                                "Pls, contact the portal admin for details."));
            } else if (rs.next()) {// found a  CORRECT USERNAME & PASSWORD

                String myserviceNo = rs.getString(1);// get the Pulled parameter 1
                surname = rs.getString(4);
                othernames = rs.getString(5);

                fullname = surname + " " + othernames;

                if (myserviceNo.equalsIgnoreCase(serviceNo)) {//CHECKING IF THE SUPPLIED SERVICE CORRESPOND WITH THE USERNAME &PASSWORD
                    ExternalContext redcontext = FacesContext.getCurrentInstance().getExternalContext();
                    redcontext.redirect("usersDashboard.xhtml");   /// redirecting to  the 

                } else {

                    FacesContext.getCurrentInstance().addMessage(
                            null,
                            new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                    "Invalid SERVICE NO!" + " Pls, a use correct credentials.",
                                    "And, try Again"));
                    serviceNo = "";///clears the incorrect-service no from memory
                }

            } else {
                FacesContext.getCurrentInstance().addMessage(
                        null,
                        new FacesMessage(FacesMessage.SEVERITY_FATAL,
                                "Invalid username or password! " + "  Pls, use correct credentials",
                                "and try again"));
            }//end of else block

            return "";
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_FATAL,
                            "Invalid Login! " + e.getMessage() + "  Pls, make sure you enrolled before login",
                            "Please, Try Again" + e));

            return "";
        } finally {
            this.Close();
        }

    }//end of method

    public void pre_reportMethod() throws Exception {//STORINGNTHE USERNAME AGAIST ITS SERVICE NO
        try {
            PreparedStatement ps = this.getCn().prepareStatement(" INSERT INTO pre_reports VALUES(null, ?,?)");
            ps.setString(1, null);
            ps.setString(2, username);
            ps.setString(3, serviceNo);
            ps.executeUpdate();

        } catch (Exception e) {
            throw e;
        }
    }//end of the method
}//end of class
