package vo;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.HashMap;
import java.util.Date;


public class TradeUserrole {
	private Integer userRoleID;
	public Integer getUserRoleID() {
		return userRoleID;
	}
	public void setUserRoleID(Integer userRoleID) {
		this.userRoleID = userRoleID;
	}
	private Integer userID;
	public Integer getUserID() {
		return userID;
	}
	public void setUserID(Integer userID) {
		this.userID = userID;
	}
	private Integer roleID;
	public Integer getRoleID() {
		return roleID;
	}
	public void setRoleID(Integer roleID) {
		this.roleID = roleID;
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