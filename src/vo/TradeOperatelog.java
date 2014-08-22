package vo;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.HashMap;
import java.util.Date;


public class TradeOperatelog {
	private Long iD;
	public Long getID() {
		return iD;
	}
	public void setID(Long iD) {
		this.iD = iD;
	}
	private String processName;
	public String getProcessName() {
		return processName;
	}
	public void setProcessName(String processName) {
		this.processName = processName;
	}
	private String processDesc;
	public String getProcessDesc() {
		return processDesc;
	}
	public void setProcessDesc(String processDesc) {
		this.processDesc = processDesc;
	}
	private String methodName;
	public String getMethodName() {
		return methodName;
	}
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}
	private Integer userID;
	public Integer getUserID() {
		return userID;
	}
	public void setUserID(Integer userID) {
		this.userID = userID;
	}
	private String userName;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	private String iPAddress;
	public String getIPAddress() {
		return iPAddress;
	}
	public void setIPAddress(String iPAddress) {
		this.iPAddress = iPAddress;
	}
	private String description;
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	private Date createDate;
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	private String methodDesc;
	public String getMethodDesc() {
		return methodDesc;
	}
	public void setMethodDesc(String methodDesc) {
		this.methodDesc = methodDesc;
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