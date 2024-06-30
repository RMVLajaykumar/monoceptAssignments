package com.monocept.model;

import java.io.Serializable;

public class Supplier implements Serializable{
	private String id;
	private String name;
	private long contactinformation;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	@Override
	public String toString() {
		return "Supplier [id=" + id + ", name=" + name + ", contactinformation=" + contactinformation + "]";
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getContactinformation() {
		return contactinformation;
	}
	public void setContactinformation(long contactinformation) {
		this.contactinformation = contactinformation;
	}
	public Supplier(String id, String name, long contactinformation) {
		super();
		this.id = id;
		this.name = name;
		this.contactinformation = contactinformation;
	}
	public Supplier() {
		super();
	}
	
	

}
