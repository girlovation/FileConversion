package com.acn.file.conversion.tool.vo; 
 import java.util.LinkedHashMap; 
  public class DynamicJsonInVO {
	private java.lang.String modified;
	private java.lang.String identifier;
	private java.lang.String brand;


	public java.lang.String getModified() {
		return this.modified;
	}	public void setModified(java.lang.String modified) {
		this.modified = modified;
	}

	public java.lang.String getIdentifier() {
		return this.identifier;
	}	public void setIdentifier(java.lang.String identifier) {
		this.identifier = identifier;
	}

	public java.lang.String getBrand() {
		return this.brand;
	}	public void setBrand(java.lang.String brand) {
		this.brand = brand;
	}

	 public static DynamicJsonInVO setAllFields(LinkedHashMap<String, Object> valueMap) { 
		 DynamicJsonInVO tempDynamicObj = new DynamicJsonInVO();
			 tempDynamicObj.setModified(valueMap.get("modified").toString()); 
			 tempDynamicObj.setIdentifier(valueMap.get("identifier").toString()); 
			 tempDynamicObj.setBrand(valueMap.get("brand").toString()); 
 		 return tempDynamicObj; 
 } 
 }