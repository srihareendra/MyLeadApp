
package com.javachap.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.javachap.domain.Category;
import com.javachap.domain.Lead;
import com.javachap.domain.User;
import com.javachap.domain.impl.CategoryImpl;
import com.javachap.domain.impl.LeadImpl;
import com.javachap.domain.impl.UserImpl;
import com.javachap.service.LeadService;
import com.javachap.service.ServiceUtils;
import com.javachap.web.model.LeadListingForm;

public class LeadListingAction extends SecuredAction {

    public ActionForward lmsExecute(ActionMapping mapping,
                                 ActionForm form,
                                 HttpServletRequest request,
                                 HttpServletResponse response) {

        LeadListingForm leadListingForm = (LeadListingForm) form;
        
        System.out.println("LeadListingAction lmsExecute()... leadListingForm="+leadListingForm);
        
        /*try {
				Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/

        if (("delete").equalsIgnoreCase(leadListingForm.getAction())) {

            Long leadId = leadListingForm.getLeadId();
            delete(leadId, request);

        }
        else if (("deleteLeads").equalsIgnoreCase(leadListingForm.getAction())) {
            String[] leadIds = leadListingForm.getLeadIds();
            for (String leadIdString : leadIds) {

                Long leadId = Long.parseLong(leadIdString);
                delete(leadId, request);
            }
        }

        User user = (User) request.getSession().getAttribute("user");
        
        List<Lead> leadList = ServiceUtils.getLeadService().getLeadsByUser(user);
        if(leadList==null){
 
        	leadList= new ArrayList<Lead>();
    		Category category = new CategoryImpl();
    		category.setName("Test Name_1" );
    		category.setDescription("Test Description");
    		Lead lead = new LeadImpl();
    		
    		lead.setId(324L);
    		lead.setTitle("Test Title");
    		lead.setDescription("Test Description");
    		lead.setFirstName("Test");
    		lead.setLastName("test");
    		lead.setEmail("test");
    		lead.setPhone("12333");
    		lead.setPrice(10.2f);
    		lead.setStatus(Lead.Status.Published.toString());
    		
    		lead.setCategory(category);
    		lead.setOwner(user);
    		leadList.add(lead);
        }
        
        System.out.println("LeadListingAction lmsExecute().. befoere sleep. got leadList="+leadList);
        try {
				Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        request.setAttribute("leadList", leadList);

        return mapping.getInputForward();
    }

    public void delete(Long leadId, HttpServletRequest request) {
        LeadService leadService = ServiceUtils.getLeadService();
        boolean deleteSuccessfull = false;
        if(leadId != null && leadId > 0) {
            Lead lead = leadService.getLead(leadId);
            if (lead != null) {
                leadService.delete(lead);
                ActionMessages messages = new ActionMessages();
                messages.add(ActionMessages.GLOBAL_MESSAGE,
                                new ActionMessage("message.lead.delete"));
                saveMessages(request, messages);
                deleteSuccessfull = true;
            }
        }
        if(!deleteSuccessfull) {
            ActionErrors errors = new ActionErrors();
            errors.add(ActionErrors.GLOBAL_MESSAGE,
                        new ActionMessage("error.lead.deleted"));
            saveErrors(request, errors);
        }
    }
}
