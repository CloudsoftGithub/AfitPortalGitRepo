package com.Afit.DAO;

import com.Afit.MODEL.signup;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

@ManagedBean
@SessionScoped

public class UserDAO extends DAO {

    public void loginMthd(signup sigin) throws SQLException, Exception {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs1;

        Class.forName("com.mysql.jdbc.Driver");
         this.connectorMthd();

        ps = this.getCn().prepareStatement("SELECT serviceNo, username, password,surname,others  FROM members WHERE serviceNo= ? ");
        ps.setString(1, sigin.getServceno());

        rs1 = ps.executeQuery();

        try {
            Class.forName("com.mysql.jdbc.Driver");
             this.connectorMthd();

            ps = this.getCn().prepareStatement("SELECT serviceNo, username, password,surname,others  FROM members WHERE username= ? and password= ? ");
            ps.setString(1, sigin.getUsername());
            ps.setString(2, sigin.getPassword());

            ResultSet rs = ps.executeQuery();
            if (rs.next()) // found
            {
                if (rs1.next()) {

                    ExternalContext redcontext = FacesContext.getCurrentInstance().getExternalContext();
                    redcontext.redirect("usersDashboard.xhtml");   /// redirecting to  the 

                } else {

                    FacesContext.getCurrentInstance().addMessage(
                            null,
                            new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                    "Invalid service no!" + "Pls, use correct credentials.",
                                    "And, try Again"));
                }//end of the else-block 

            } else {
                FacesContext.getCurrentInstance().addMessage(
                        null,
                        new FacesMessage(FacesMessage.SEVERITY_ERROR,
                                "Invalid Login! " + " Pls, use correct credentials.",
                                "And, try Again"));
            }//end of the else-block 

        } catch (Exception ex) {
            System.out.println("Error in login() -->" + ex.getMessage());

            //return false;
        } finally {
            this.Close();
            //con.close();
            ps.close();
        }
        sigin.setServceno("");//clears
    }///end of method
}
