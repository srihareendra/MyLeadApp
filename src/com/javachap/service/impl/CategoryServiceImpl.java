/**
 * 
 */
package com.javachap.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.javachap.domain.Category;
import com.javachap.domain.Lead;
import com.javachap.domain.impl.CategoryImpl;
import com.javachap.service.CategoryService;


public class CategoryServiceImpl extends ServiceImpl implements CategoryService {

	private static final long serialVersionUID = 380026904541710183L;
	
	List<Category> categories= new ArrayList<Category>();
	
	/**
	 * Singleton Instance of CategoryServiceImpl
	 */
	private static CategoryServiceImpl categoryServiceImpl = new CategoryServiceImpl();
	
	/**
	 * Creates Instance of {@link CategoryServiceImpl}
	 */
	private CategoryServiceImpl(){	
		/*Category category = new CategoryImpl();
		category.setName("Test Name_1"  );
		category.setDescription("Test Description");
		category.setId(123L);
		 save(category);*/
	}
	
	/***
	 * Gets Instance of CategoryService
	 * @return CategoryService Implementation
	 */
	public static CategoryService getInstance(){	
		return categoryServiceImpl;
	}	

	/* (non-Javadoc)
	 * @see com.javachap.service.CategoryService#getAllCategories()
	 */
	@SuppressWarnings("unchecked")
	public List<Category> getAllCategories() {
		System.out.println("CategoryServiceImpl:getAllCategories entered ...  ");
	       try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		if(categories.isEmpty()){
			System.out.println("CategoryServiceImpl:getAllCategories entered categories is empty....");
			Category category = new CategoryImpl();
			category.setName("Test Name_" + System.currentTimeMillis());
			category.setDescription("Test Description");
			category.setId(123L);
			 save(category);
		}else{
			System.out.println("CategoryServiceImpl:getAllCategories entered categories is NOT empty....");
		}
		System.out.println("CategoryServiceImpl:getAllCategories entered ... categories= "+categories);
		return categories;	
	}

	/* (non-Javadoc)
	 * @see com.javachap.service.CategoryService#getCategory(java.lang.Long)
	 */
	public Category getCategory(Long categoryId) {
		System.out.println("CategoryServiceImpl:getCategory entered ... categoryId= "+categoryId);
		Category category = null;
		Iterator<Category> iterator=categories.listIterator();
		
		while(iterator.hasNext()){
			category=(Category)iterator.next();
			
			if(category.getId().longValue()==categoryId.longValue()){
				break;
			}
		}
		return category;
	}

	/* (non-Javadoc)
	 * @see com.javachap.service.CategoryService#getCategory(java.lang.String)
	 */
	public Category getCategory(String categoryName) {
		System.out.println("CategoryServiceImpl:getCategory entered ... categoryName= "+categoryName);
		Category category = null;
		Iterator<Category> iterator=categories.listIterator();
		
		while(iterator.hasNext()){
			category=(Category)iterator.next();
			
			if(category.getName().equalsIgnoreCase(categoryName)){
				break;
			}
		}
		return category;		
	}

	/* (non-Javadoc)
	 * @see com.javachap.service.CategoryService#save(com.javachap.domain.Category)
	 */
	public Category save(Category category) {
		System.out.println("CategoryServiceImpl:save entered ... category= "+category);
		categories.add(category);
		return category;		
	}
}
