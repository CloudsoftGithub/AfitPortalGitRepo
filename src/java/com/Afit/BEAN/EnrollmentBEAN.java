package com.Afit.BEAN;

import com.Afit.DAO.enrollmentDAO;
import com.Afit.MODEL.enrollment;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class EnrollmentBEAN {
    //create an object for the MODEL

    private enrollment enrlmnt = new enrollment();

    public enrollment getEnrlmnt() {
        return enrlmnt;
    }

    public void setEnrlmnt(enrollment enrlmnt) {
        this.enrlmnt = enrlmnt;
    }

    public void enrollCustomermthd() throws Exception {
        enrollmentDAO dao;

        try {
            dao = new enrollmentDAO();
            dao.EnrollmentMthd(enrlmnt);
        } catch (Exception e) {
            throw e;
        }

    } //end of the method

}//end of the class
