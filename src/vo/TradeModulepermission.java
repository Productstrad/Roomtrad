package vo;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.HashMap;
import java.util.Date;


public class TradeModulepermission {
	private Long modulePermissionID;
	public Long getModulePermissionID() {
		return modulePermissionID;
	}
	public void setModulePermissionID(Long modulePermissionID) {
		this.modulePermissionID = modulePermissionID;
	}
	private Integer moduleID;
	public Integer getModuleID() {
		return moduleID;
	}
	public void setModuleID(Integer moduleID) {
		this.moduleID = moduleID;
	}
	private Integer permissionID;
	public Integer getPermissionID() {
		return permissionID;
	}
	public void setPermissionID(Integer permissionID) {
		this.permissionID = permissionID;
	}
	private Integer createUserID;
	public Integer getCreateUserID() {
		return createUserID;
	}
	public void setCreateUserID(Integer createUserID) {
		this.createUserID = createUserID;
	}
	private Date createDate;
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	private Integer modifyUserID;
	public Integer getModifyUserID() {
		return modifyUserID;
	}
	public void setModifyUserID(Integer modifyUserID) {
		this.modifyUserID = modifyUserID;
	}
	private Date modifyDate;
	public Date getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
	private String recordStatus;
	public String getRecordStatus() {
		return recordStatus;
	}
	public void setRecordStatus(String recordStatus) {
		this.recordStatus = recordStatus;
	}
	private Integer isDeleted;
	public Integer getIsDeleted() {
		return isDeleted;
	}
	public void setIsDeleted(Integer isDeleted) {
		this.isDeleted = isDeleted;
	}
	@Override
	public String toString() {
		Map<String, Object> values=new HashMap<String, Object>();
		Field[] fields=this.getClass().getDeclaredFields();
		try{
			for (Field f : fields) {
			values.put(f.getName(), f.get(this));
			}
			return values.toString();
		}catch(Exception e){
			return e.toString();
		}
	}
}