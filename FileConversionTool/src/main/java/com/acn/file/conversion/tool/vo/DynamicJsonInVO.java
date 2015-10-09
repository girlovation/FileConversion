package com.acn.file.conversion.tool.vo; 
 import java.util.LinkedHashMap; 
 import java.util.Set; 
 import com.acn.file.conversion.tool.constants.FileConversionConstants; 
  public class DynamicJsonInVO {
	private java.lang.String modified;
	private java.lang.String identifier;
	private java.lang.String brand;
	private java.lang.String id;


	public java.lang.String getModified() {
		return this.modified;
	}
	public void setModified(java.lang.String modified) {
		this.modified = FileConversionConstants.DOUBLE_QUOTE + modified+ FileConversionConstants.DOUBLE_QUOTE;
	}

	public java.lang.String getIdentifier() {
		return this.identifier;
	}
	public void setIdentifier(java.lang.String identifier) {
		this.identifier = FileConversionConstants.DOUBLE_QUOTE + identifier+ FileConversionConstants.DOUBLE_QUOTE;
	}

	public java.lang.String getBrand() {
		return this.brand;
	}
	public void setBrand(java.lang.String brand) {
		this.brand = FileConversionConstants.DOUBLE_QUOTE + brand+ FileConversionConstants.DOUBLE_QUOTE;
	}

	public java.lang.String getId() {
		return this.id;
	}
	public void setId(java.lang.String id) {
		this.id = FileConversionConstants.DOUBLE_QUOTE + id+ FileConversionConstants.DOUBLE_QUOTE;
	}

	 public static DynamicJsonInVO setAllFields(LinkedHashMap<String, Object> valueMap) { 
		 DynamicJsonInVO tempDynamicObj = new DynamicJsonInVO();
		 Set<String> keys = valueMap.keySet(); 
		 if(valueMap.get("modified")== null) { 
			 keys.remove("modified");
			 tempDynamicObj.setModified("null"); 
 		 } else { 
			 tempDynamicObj.setModified(valueMap.get("modified").toString()); 
 		 } 
		 if(valueMap.get("identifier")== null) { 
			 keys.remove("identifier");
			 tempDynamicObj.setIdentifier("null"); 
 		 } else { 
			 tempDynamicObj.setIdentifier(valueMap.get("identifier").toString()); 
 		 } 
		 if(valueMap.get("brand")== null) { 
			 keys.remove("brand");
			 tempDynamicObj.setBrand("null"); 
 		 } else { 
			 tempDynamicObj.setBrand(valueMap.get("brand").toString()); 
 		 } 
		 if(valueMap.get("id")== null) { 
			 keys.remove("id");
			 tempDynamicObj.setId("null"); 
 		 } else { 
			 tempDynamicObj.setId(valueMap.get("id").toString()); 
 		 } 
 		 return tempDynamicObj; 
 } 
 }