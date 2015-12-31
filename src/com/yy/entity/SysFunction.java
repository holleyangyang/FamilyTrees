package com.yy.entity;

/**
 * @author ex-yangyang007
 *
 */
public class SysFunction {
	private String functionId;// FUNCTION_ID VARCHAR2(50) N 功能编号
	private String functionName;// FUNCTION_NAME VARCHAR2(50) N 功能名称
	private String functionDesc;// FUNCTION_DESC VARCHAR2(500) N 功能描述
	private String parentId;// PARENT_ID VARCHAR2(50) N 父功能
	private String parentName;// PARENT_NAME VARCHAR2(50) N 父功能
	private String remark;// REMARK VARCHAR2(500) Y 备注
	private String isDeleted;// IS_DELETED VARCHAR2(10) N '是' 是否在用
	private String createTimeDate;// CREATE_TIME DATE N sysdate 创建时间
	private String lastUpdateTime;// LAST_UPDATE_TIME DATE N sysdate 最后一次修改时间
	public String getFunctionId() {
		return functionId;
	}
	public void setFunctionId(String functionId) {
		this.functionId = functionId;
	}
	public String getFunctionName() {
		return functionName;
	}
	public void setFunctionName(String functionName) {
		this.functionName = functionName;
	}
	public String getFunctionDesc() {
		return functionDesc;
	}
	public void setFunctionDesc(String functionDesc) {
		this.functionDesc = functionDesc;
	}
	public String getParentId() {
		return parentId;
	}
	public void setParentId(String parentId) {
		this.parentId = parentId;
	}
	public String getParentName() {
		return parentName;
	}
	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	public String getIsDeleted() {
		return isDeleted;
	}
	public void setIsDeleted(String isDeleted) {
		this.isDeleted = isDeleted;
	}
	public String getCreateTimeDate() {
		return createTimeDate;
	}
	public void setCreateTimeDate(String createTimeDate) {
		this.createTimeDate = createTimeDate;
	}
	public String getLastUpdateTime() {
		return lastUpdateTime;
	}
	public void setLastUpdateTime(String lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}
	public String toString() {
		return "SysFunction [functionId=" + functionId + ", functionName="
				+ functionName + ", functionDesc=" + functionDesc
				+ ", parentId=" + parentId + ", parentName=" + parentName
				+ ", remark=" + remark + ", isDeleted=" + isDeleted
				+ ", createTimeDate=" + createTimeDate + ", lastUpdateTime="
				+ lastUpdateTime + "]";
	}
}
