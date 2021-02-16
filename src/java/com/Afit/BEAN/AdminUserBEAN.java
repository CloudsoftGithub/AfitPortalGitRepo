 
package com.Afit.BEAN;

import com.Afit.DAO.adminUsersDAO;
import com.Afit.MODEL.adminUsersSignup;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

 @ManagedBean
@SessionScoped
public class AdminUserBEAN {
    
    adminUsersSignup signp = new adminUsersSignup();

    public adminUsersSignup getSignp() {
        return signp;
    }

    public void setSignp(adminUsersSignup signp) {
        this.signp = signp;
    }
     
    
    public void adminUsersMthd() throws Exception{
        adminUsersDAO dao;
        try {
        dao = new adminUsersDAO();
        dao.AdminCreationMthd(signp);
        } catch (Exception e) {
            throw e;
        }
        
    }//end of the method 
    
}//end of the class
