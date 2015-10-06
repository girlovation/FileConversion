package com.acn.file.conversion.tool.vo; 
 import java.util.LinkedHashMap; 
 import java.util.Set;
 public class DynamicJsonInV {
	private  java.lang.String modified;
	private  java.lang.String identifier;
	private  java.lang.String brand;


	/*public static java.lang.String getModified() {
		return modified;
		
	}	public static void setModified(java.lang.String modified) {
		modified = modified;
	}

	public static java.lang.String getIdentifier() {
		return identifier;
		
	}	public static void setIdentifier(java.lang.String identifier) {
		identifier = identifier;
	}

	public static java.lang.String getBrand() {
		return brand;
		
	}	public static void setBrand(java.lang.String brand) {
		brand = brand;
	}
*/
	
	
	
	 public static DynamicJsonInV setAllFields(LinkedHashMap<String, Object> valueMap) { 
		 DynamicJsonInV tempObj = new DynamicJsonInV();
		 tempObj.setModified(valueMap.get("modified").toString()); 
		 tempObj.setIdentifier(valueMap.get("identifier").toString()); 
		 tempObj.setBrand(valueMap.get("brand").toString()); 
			return tempObj;
			
	 }


	public java.lang.String getModified() {
		return modified;
	}


	public void setModified(java.lang.String modified) {
		this.modified = modified;
	}


	public java.lang.String getIdentifier() {
		return identifier;
	}


	public void setIdentifier(java.lang.String identifier) {
		this.identifier = identifier;
	}


	public java.lang.String getBrand() {
		return brand;
	}


	public void setBrand(java.lang.String brand) {
		this.brand = brand;
	}


	
 }