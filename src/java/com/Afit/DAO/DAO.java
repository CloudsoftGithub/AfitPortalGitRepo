package com.Afit.DAO;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.sql.DriverManager;

public class DAO {

    private Connection cn;
    private PreparedStatement ps;

    public Connection getCn() {
        return cn;
    }

    public void setCn(Connection cn) {
        this.cn = cn;
    }

    public PreparedStatement getPs() {
        return ps;
    }

    public void setPs(PreparedStatement ps) {
        this.ps = ps;
    }

    //creating conection with use of  connection string 
    public void connectorMthd() throws Exception {
        try {
            // Mysql connection on the Local Machine Local

            Class.forName("com.mysql.jdbc.Driver");
  
          //cn = (com.mysql.jdbc.Connection) DriverManager.getConnection("jdbc:mysql://mysql3000.mochahost.com/afitcoop_afitwebdb", "afitcoop_aftRoot","KY~A6hdCN@X~");
            
         cn = (com.mysql.jdbc.Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/afitwebdb?user=root&password=ash123");
        } catch (Exception e) {
            System.out.println("Error in login/Connecting() -->" + e.getMessage());
            throw e;
        } finally {
            // TODO Auto-generated catch block
            //ps.close();
            //cn.close();

            if (cn == null) {
                cn.close();
            } else {
                //do nothing
            }
        }//end of finally-block

    }//end of connector method 

    //close connection 
    public void Close() throws Exception {
        try {
            if (cn.isClosed() == false) {
                cn.close();
            }
        } catch (Exception e) {
            throw e;

        } finally {

            //this.Close();
        }
    }//end of method

}//end of the class
