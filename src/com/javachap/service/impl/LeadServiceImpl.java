package com.javachap.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.javachap.domain.Category;
import com.javachap.domain.Lead;
import com.javachap.domain.User;
import com.javachap.domain.impl.CategoryImpl;
import com.javachap.domain.impl.LeadImpl;
import com.javachap.domain.impl.UserImpl;
import com.javachap.service.LeadService;
 

/**
 * @author Varma
 */

public class LeadServiceImpl extends ServiceImpl implements LeadService {

	private static final long serialVersionUID = 872905902784301462L;
	
	List<Lead> leadList= new ArrayList<Lead> ();
 	
	/**
	 * Singleton Instance of LeadServiceImpl
	 */
	private static LeadServiceImpl leadServiceImpl = new LeadServiceImpl();
	
	/**
	 * Creates Instance of {@link LeadServiceImpl}
	 */
	private LeadServiceImpl(){		
		
		/*User user = new UserImpl();
		user.setFirstName("java");
		user.setLastName("chap");
		user.setEmail("email"+System.currentTimeMillis());
		user.setPassword("test");
		
		Category category = new CategoryImpl();
		category.setName("Test Name_1" );
		category.setDescription("Test Description");
		Lead lead = new LeadImpl();
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
		save(lead);*/
	}
	
	/***
	 * Gets Instance of LeadService
	 * @return LeadService Implementation
	 */
	public static LeadServiceImpl getInstance(){	
		return leadServiceImpl;
	}
	
	/* (non-Javadoc)
	 * @see com.javachap.service.LeadService#delete(com.javachap.domain.Lead)
	 */
	public void delete(Lead lead) {
		System.out.println("LeadServiceImpl:delete entered ...leadto delete = "+lead);
		Lead leadToDelete;
        Iterator<Lead> iterator=   leadList.iterator();
        while(iterator.hasNext()){
        	leadToDelete= (Lead) iterator.next();
        	if(lead.getId().longValue()==leadToDelete.getId().longValue()){
        		leadList.remove(leadToDelete);
        		break;
        	}
        	lead = null;
        }
	}

	/* (non-Javadoc)
	 * @see com.javachap.service.LeadService#getLead(java.lang.Long)
	 */
	public Lead getLead(Long id) {
		System.out.println("LeadServiceImpl:getLead entered ...id = "+id);
	       try {
				Thread.sleep(8000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		Lead lead = null;
        long idVal= id.longValue();
        Iterator<Lead> iterator=   leadList.iterator();
        while(iterator.hasNext()){
        	lead= (Lead) iterator.next();
        	if(lead.getId().longValue()==idVal){
        		break;
        	}
        	lead = null;
        }
		return lead;	
	}

	/* (non-Javadoc)
	 * @see com.javachap.service.LeadService#save(com.javachap.domain.Lead)
	 */
	public Lead save(Lead lead) {
		System.out.println("LeadServiceImpl:save entered ...lead to save = "+lead);
	       try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	       
	       lead.setId((long)(leadList.size()+1));
	       
		leadList.add(lead);
		return lead;
	}
	
	/* (non-Javadoc)
	 * @see com.javachap.service.LeadService#getLeadsByUser(com.javachap.domain.User)
	 */
	@SuppressWarnings("unchecked")
	public List<Lead> getLeadsByUser(User user) {
		
		System.out.println("LeadServiceImpl:getLeadsByUser entered ...user = "+user);
		
		System.out.println("LeadServiceImpl:getLeadsByUser entered ...leadList  = "+leadList);
        try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<Lead> leads = null; 		
		Lead lead = null;  
        Iterator<Lead> iterator=   leadList.iterator();
        while(iterator.hasNext()){
        	System.out.println("LeadServiceImpl:getLeadsByUser entered ...iterator.hasNext() entered #### leads="+leads);
        /*   try {
    			Thread.sleep(1000);
    		} catch (InterruptedException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}*/
        	if(leads==null){
        		leads = new ArrayList<Lead>(); 
        	}        	
        	lead= (Lead) iterator.next();	
        	/*System.out.println("LeadServiceImpl:getLeadsByUser entered ...iterator.hasNext() RETRIVED lead from lsit = "+lead);

        	System.out.println("LeadServiceImpl:getLeadsByUser entered ...iterator.hasNext()  ADDING leads="+leads);
        	try {
    			Thread.sleep(5000);
    		} catch (InterruptedException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}*/
        	if(lead.getOwner().getId().longValue()==user.getId().longValue()){
        		leads.add(lead);
        	}       	
		}	
    	/*try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
        return leads;	
	}
}