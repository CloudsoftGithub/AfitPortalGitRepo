package com.Afit.BEAN;
 
import com.Afit.DAO.UserDAO;
import com.Afit.MODEL.signup;
import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped

public class LoginBean implements Serializable{

   // private static final long serialVersionUID = 1L;
    
    private signup signin = new signup();

    public signup getSignin() {
        return signin;
    }

    public void setSignin(signup signin) {
        this.signin = signin;
    }

  
    public void loginProject() throws SQLException, IOException, Exception {
        
        UserDAO dao;
        try {
            dao = new UserDAO();
            dao.loginMthd(signin);
        } catch (Exception e) {
            throw e;
        }
        
    }//end of the method 
    
}//end of class 

