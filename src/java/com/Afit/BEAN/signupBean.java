package com.Afit.BEAN;

import com.Afit.DAO.DAO;
import com.Afit.DAO.signupDAO;
import com.Afit.MODEL.signup;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

@ManagedBean
@SessionScoped
public class signupBean extends DAO {

    PreparedStatement ps;
    ResultSet rs;
    ResultSet rsLgas;

    private String state;

    private List<String> States_List = new ArrayList<>();

    private List<String> Lgas_List = new ArrayList<>();

    private signup signp = new signup();

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public List<String> getLgas_List() {
        return Lgas_List;
    }

    public void setLgas_List(List<String> Lgas_List) {
        this.Lgas_List = Lgas_List;
    }

    public List<String> getStates_List() {
        return States_List;
    }

    public void setStates_List(List<String> States_List) {
        this.States_List = States_List;
    }

    public signup getSignp() {
        return signp;
    }

    public void setSignp(signup signp) {
        this.signp = signp;
    }

    public void signupMethod() throws Exception {

        signupDAO dao;
        try {
            dao = new signupDAO();
            dao.signupMethod(signp);
        } catch (Exception e) {
            throw e;
        }

    }

    public void retriveCurrentStateFromUI() {//get the current state on the UI 
        state = "";//set to clear the variables 

        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        state = ec.getRequestParameterMap().get("MembershipRegForm:state");

    }

    public List<String> get_StatesMthd() throws Exception {

        States_List.removeAll(States_List);

        this.connectorMthd();//DB Connectivity 

        try {

            ps = this.getCn().prepareStatement("SELECT state FROM states");
            rs = ps.executeQuery();
            
            System.err.println("Printed State: " + state);
            
            while (rs.next()) {
                States_List.add(rs.getString("state"));//retrieves all the UPLOADED states
            }//end of while-block

        } catch (Exception e) {
            FacesMessage messag = new FacesMessage(FacesMessage.SEVERITY_FATAL, "States Retrieval Error", e.getMessage() + " . Pls, try again");
            RequestContext.getCurrentInstance().showMessageInDialog(messag);
        } finally {
            //this.Close();
        }

        return States_List;

    }//end of method

    public List<String> get_LGAsMthd() throws Exception {
        retriveCurrentStateFromUI();//invokes the method

        Lgas_List.removeAll(Lgas_List);

        this.connectorMthd();//DB Connectivity 

        try {
            //ps = this.getCn().prepareStatement("SELECT lga FROM lgas INNER JOIN states ON statesid=states.id WHERE states.state = ?");

            ps = this.getCn().prepareStatement("SELECT lga FROM lgas");
            //ps.setString(1, state);
            rsLgas = ps.executeQuery();

            while (rsLgas.next()) {
                Lgas_List.add(rsLgas.getString("lga"));//retrieves all the UPLOADED states
                //RequestContext.getCurrentInstance().update("MembershipRegForm:MembershipCompleteRegPanel");

            }//end of while-block

        } catch (Exception e) {
            FacesMessage messag = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Lgas  Retrieval Error", e.getMessage() + " . Pls, try again");
            RequestContext.getCurrentInstance().showMessageInDialog(messag);
        } finally {
            this.Close();
        }

        return Lgas_List;

    }//end of method

}//end of the method
