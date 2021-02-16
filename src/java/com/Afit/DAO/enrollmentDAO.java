package com.Afit.DAO;

import com.Afit.MODEL.enrollment;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

public class enrollmentDAO extends DAO {

    public String EnrollmentMthd(enrollment enrllmnt) throws Exception {

        this.connectorMthd();

        int counterDouble = 0;

        //CHECKS THE double enrolment for Customer (i.e this block of code prevents same customer - username to be registered morethan once
        try {

            PreparedStatement ps = this.getCn().prepareStatement("SELECT * FROM enrollment WHERE username = ? ");
            ps.setString(1, enrllmnt.getUsername());

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                counterDouble = counterDouble + 1;//incremented 
            }

        } catch (Exception e) {
            throw e;
        }//end of the cath-block 

        if (counterDouble > 0) {
            FacesMessage messag = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Customer Enrollment Error", "This Customer's username exists " + " Pls, try again");
            RequestContext.getCurrentInstance().showMessageInDialog(messag);

        } else {

            try {
                // System.out.println("Testing username: "+ sgnp.getUsername());
                PreparedStatement ps = this.getCn().prepareStatement("INSERT INTO enrollment VALUES(?,?,?,?,?,?,?,?, Now())");
                ps.setString(1, null);//it is null because the field 'userID' is auto-incremental
                ps.setString(2, enrllmnt.getFullame());
                ps.setString(3, enrllmnt.getGsm());
                ps.setString(4, enrllmnt.getUsername());
                ps.setString(5, enrllmnt.getPassword());
                ps.setString(6, enrllmnt.getPinNo());
                ps.setString(7, enrllmnt.getSerialNo());
                ps.setString(8, enrllmnt.getAgentID());
                ps.executeUpdate();

                FacesContext.getCurrentInstance().addMessage(
                        null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO,
                                "You succcessfully Enrolled a 'customer': " + enrllmnt.getUsername() + " thank you! ", "Pls, view the list of the registered customers."));

                //ExternalContext redcontext = FacesContext.getCurrentInstance().getExternalContext();
                //redcontext.redirect("successfulAgentCreation.xhtml");   /// redirecting to  the 

                return "";

            } catch (Exception e) {
                FacesMessage messag = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Customwe Enrollment Error", e.getMessage() + " Pls, try again");
                RequestContext.getCurrentInstance().showMessageInDialog(messag);
                return "";
            }

        }//end of the else-block 

        return "";

    }//end of the method

}//end of the class
