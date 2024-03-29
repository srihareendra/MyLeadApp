package com.javachap.domain.impl;

import com.javachap.domain.Category;
import com.javachap.domain.Lead;
import com.javachap.domain.User;

public class LeadImpl extends DomainImpl implements Lead {

	private static final long serialVersionUID = 4970184160256555723L;
	
	private String title;
	private String description;
	private String startdate;
	private String DueDate;
	private String priority;
	private String phone;
	private Float price;
	private Category category;
	private User owner;
	private String status;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getFirstName() {
		return startdate;
	}
	public void setFirstName(String firstName) {
		this.startdate = firstName;
	}
	public String getLastName() {
		return DueDate;
	}
	public void setLastName(String lastName) {
		this.DueDate = lastName;
	}
	public String getEmail() {
		return priority;
	}
	public void setEmail(String email) {
		this.priority = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public User getOwner() {
		return owner;
	}
	public void setOwner(User owner) {
		this.owner = owner;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("LeadImpl[");
		buffer.append("category = ").append(category);
		buffer.append(" description = ").append(description);
		buffer.append(" email = ").append(priority);
		buffer.append(" firstName = ").append(startdate);
		buffer.append(" lastName = ").append(DueDate);
		buffer.append(" owner = ").append(owner);
		buffer.append(" phone = ").append(phone);
		buffer.append(" price = ").append(price);
		buffer.append(" status = ").append(status);
		buffer.append(" title = ").append(title);
		buffer.append("]");
		return buffer.toString();
	}
}
