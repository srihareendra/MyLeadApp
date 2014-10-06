
package com.javachap.web.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionErrors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javachap.domain.User;
import com.javachap.domain.impl.UserImpl;
import com.javachap.service.ServiceUtils;
import com.javachap.web.model.LoginForm;

public class LoginAction extends Action {

    public ActionForward execute(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {
        LoginForm loginForm = (LoginForm) form;
        String action = loginForm.getAction();
        
        System.out.println(" LoginAction loginForm...."+loginForm);
        /*try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		/*
		Statement st = conn.createStatement();

		String sqlSTr = "CREATE TABLE USER (USR_ID int,USR_FIRST_NAME VARCHAR ,"
				+ "USR_LAST_NAME VARCHAR ,USR_EMAIL VARCHAR ,USR_PASSWORD VARCHAR ,USR_CREATED_DATE DATE ,   "
				+ "USR_MODIFIED_DATE DATE,      PRIMARY KEY(USR_ID),      UNIQUE(USR_EMAIL)   )";
		st.executeUpdate(sqlSTr);
		
		 //System.out.println(" LoginAction user table created....");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*sqlSTr ="CREATE TABLE CATEGORY(	CT_ID int,CT_NAME VARCHAR ,CT_DESCRIPTION VARCHAR , "
				+ "CT_CREATED_DATE DATE ,CT_MODIFIED_DATE DATE , PRIMARY KEY(CT_ID) , UNIQUE(CT_NAME)  )";
		st.executeUpdate(sqlSTr);
		 System.out.println(" LoginAction CATEGORY table created....sleepiog");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(" LoginAction lead table being created....");
		sqlSTr= "CREATE TABLE LEAD(LD_ID  INT ,LD_TITLE VARCHAR , "
				+ "LD_DESCRIPTION VARCHAR(400) NOT NULL,LD_FIRST_NAME VARCHAR(255) NOT NULL,LD_LAST_NAME VARCHAR ,LD_EMAIL VARCHAR ,"
				+ "LD_PHONE VARCHAR(100),LD_PRICE DECIMAL(19,2),LD_STATUS VARCHAR(100) NOT NULL, LD_OWNER_ID BIGINT NOT NULL,   "
				+ "LD_CATEGORY_ID BIGINT NOT NULL, LD_CREATED_DATE DATETIME,   LD_MODIFIED_DATE DATETIME, PRIMARY KEY(LD_ID), FOREIGN KEY (LD_OWNER_ID) REFERENCES USER(USR_ID),      FOREIGN KEY (LD_CATEGORY_ID) REFERENCES CATEGORY(CT_ID)   )";
		
		st.executeUpdate(sqlSTr);
		System.out.println(" LoginAction CATEGORY table created....sleeping");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(" LoginAction inserting values");
		st.execute("INSERT INTO USER (USR_ID,USR_FIRST_NAME, USR_LAST_NAME, USR_EMAIL, USR_PASSWORD, USR_CREATED_DATE, USR_MODIFIED_DATE) "
				+ "VALUES(53,'John', 'Miller', 'user@javachap.com', 'javachap', now(), now());");
		st.execute("INSERT INTO CATEGORY (CT_ID,CT_NAME, CT_DESCRIPTION) VALUES('43','Insurance', 'Insurance');");
		
		st.execute("INSERT INTO CATEGORY (CT_ID,CT_NAME, CT_DESCRIPTION) VALUES('32','IT Services', 'IT Services');");
		st.execute("INSERT INTO CATEGORY (CT_NAME, CT_DESCRIPTION) VALUES('Software', 'Software');");
		st.execute("INSERT INTO CATEGORY (CT_NAME, CT_DESCRIPTION) VALUES('Hardware', 'Hardware');");		
		
		st.execute("INSERT INTO CATEGORY (CT_NAME, CT_DESCRIPTION) VALUES('Financial Services', 'Financial Services');");
		st.execute("INSERT INTO CATEGORY (CT_NAME, CT_DESCRIPTION) VALUES('Construction', 'Construction');");
		st.execute("INSERT INTO CATEGORY (CT_NAME, CT_DESCRIPTION) VALUES('Consumer Loans', 'Consumer Loans');");
		 try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
          System.out.println(" LoginAction sleeping for 10 sec");
         try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
        
        ActionForward forward = mapping.getInputForward();
        if (("login").equalsIgnoreCase(action)) {
            String email = loginForm.getEmail();
            String password = loginForm.getPassword();
            User user =   user = new UserImpl();//ServiceUtils.getUserService().authenticate(email, password);
            user.setId(234L);
    		
    		user.setFirstName("java");
    		user.setLastName("chap"); 
    		user.setPassword("javachap");           
            user.setEmail("user@javachap.com");
                   
            request.getSession(true).setAttribute("user", user);
            forward = mapping.findForward("home");
            System.out.println(" LoginAction forward = "+forward);
            try {
    				Thread.sleep(5000);
    		} catch (InterruptedException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
            /*if (user != null) {
                request.getSession(true).setAttribute("user", user);
                forward = mapping.findForward("home");
            }
            else {
                ActionErrors errors = new ActionErrors();
                errors.add(ActionErrors.GLOBAL_MESSAGE,
                           new ActionMessage("error.login.failed"));
                saveErrors(request, errors);
            }*/
        }
        return forward;
    }
}
