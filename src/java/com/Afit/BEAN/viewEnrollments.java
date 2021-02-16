package com.Afit.BEAN;

import com.Afit.DAO.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class viewEnrollments extends DAO {

    Connection con;
    PreparedStatement ps;
    ResultSet rs;

    private String enrollmentID;
    private String fullName;
    private String phoneNo;
    private String userName;
    private String password;
    private String pinNo;
    private String serialNo;
    private String agentId;
    private String dateEnrolled;

    public String getEnrollmentID() {
        return enrollmentID;
    }

    public void setEnrollmentID(String enrollmentID) {
        this.enrollmentID = enrollmentID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPinNo() {
        return pinNo;
    }

    public void setPinNo(String pinNo) {
        this.pinNo = pinNo;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public String getAgentId() {
        return agentId;
    }

    public void setAgentId(String agentId) {
        this.agentId = agentId;
    }

    public String getDateEnrolled() {
        return dateEnrolled;
    }

    public void setDateEnrolled(String dateEnrolled) {
        this.dateEnrolled = dateEnrolled;
    }

      
    public List<viewEnrollments> getEnrolledList() throws Exception {
        this.connectorMthd();//invoked the method fromthe 'DAO' Class

        List<viewEnrollments> storeInfo = new ArrayList<viewEnrollments>();

        try {
            ps = this.getCn().prepareStatement(" SELECT * FROM enrollment");
            rs = ps.executeQuery();
            while (rs.next()) {
                viewEnrollments tbl = new viewEnrollments();
                tbl.setEnrollmentID(rs.getString("enrollment_id"));
                //tbl.setEnrollmentID(rs.getString("enrollment_id"));
                tbl.setFullName(rs.getString("fullname"));
                tbl.setPhoneNo(rs.getString("phoneno"));

                tbl.setUserName(rs.getString("username"));
                tbl.setPassword(rs.getString("password"));
                tbl.setPinNo(rs.getString("pinNo"));
                tbl.setSerialNo(rs.getString("serialNo"));

                tbl.setAgentId(rs.getString("agent_id"));
                tbl.setDateEnrolled(rs.getString("DateEnrolled"));
                storeInfo.add(tbl);

            }//end of while-block
        } catch (Exception e) {
            throw e;
        } finally {

            try {
                rs.close();
                ps.close();
                con.close();
            } catch (Exception e) {
                e.printStackTrace();
                System.err.println("Error in Enrollmentel List Display: " + e.getMessage());
            }
        }//end of finally-block 
        return storeInfo;
    }//end of the method

}//end of the class 
