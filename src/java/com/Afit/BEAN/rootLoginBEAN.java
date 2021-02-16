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

@ManagedBean
@SessionScoped
public class rootLoginBEAN extends DAO implements Serializable {

    private static final long serialVersionUID = -1;

    private String username;
    private String password;
    private String userType;

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

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String rootUserLogin() throws Exception {
        Connection con = null;
        PreparedStatement ps = null;
        String myusername = username.toString();
        String mypassword = password.toString();

        try {
            this.connectorMthd();//calls the method 'connectorMthd()' to create connection
         // con = (com.mysql.jdbc.Connection) DriverManager.getConnection("jdbc:mysql://mysql3000.mochahost.com/afitcoop_afitwebdb?user=" + myusername + "&" + "password=" + mypassword);

          con = DriverManager.getConnection("jdbc:mysql://localhost:3306/afitwebdb?user=" + myusername + "&" + "password=" + mypassword);
            
            ExternalContext redcontext = FacesContext.getCurrentInstance().getExternalContext();
            redcontext.redirect("rootuserDashboard.xhtml");   /// redirecting to  the 

            return "";

        } catch (Exception e) {

            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Invalid Login!" + " Pls, make sure you are a Root User, then supply correct credentials",
                    "and, Try Again "));

            return "";
        }

    }//

    public String signoutMethod() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        //return "/index.xhtml?faces-redirect=true";

        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "";
    }//end of signoutMethod

    /*
    
      
    public String adminuserLogin() throws Exception {
        
        this.connectorMthd();//calls the method 'connectorMthd()' to create connection

        try {

            Connection con = null;
            PreparedStatement ps = null;
            String myusername = username.toString();
            String mypassword = password.toString();

             PreparedStatement st = this.getCn().prepareStatement("select username, password from adminusers where username= ? and password= ? ");
            st.setString(1, myusername);
            st.setString(2, mypassword);

            ResultSet rs = st.executeQuery();
            if (rs.next()) // found
            {

                ExternalContext redcontext = FacesContext.getCurrentInstance().getExternalContext();
                redcontext.redirect("adminuserDashboard.xhtml");   /// redirecting to  the 
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
                            "Invalid Login! " + e.getMessage() + "  Pls, make sure you are an Admin User",
                            "Please, Try Again"));

            return "";
        }

    }//end of method
    
     */
}//end of class
