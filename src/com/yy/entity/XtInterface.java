package com.yy.entity;

public class XtInterface {
	private String Id;
	private String xtname;
	private String functionname;
	private String facetype;
	private String facename;
	private String remark;
	private String disabled;
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getXtname() {
		return xtname;
	}
	public void setXtname(String xtname) {
		this.xtname = xtname;
	}
	public String getFunctionname() {
		return functionname;
	}
	public void setFunctionname(String functionname) {
		this.functionname = functionname;
	}
	public String getFacetype() {
		return facetype;
	}
	public void setFacetype(String facetype) {
		this.facetype = facetype;
	}
	public String getFacename() {
		return facename;
	}
	public void setFacename(String facename) {
		this.facename = facename;
	}
	
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getDisabled() {
		return disabled;
	}
	public void setDisabled(String disabled) {
		this.disabled = disabled;
	}
	
}
