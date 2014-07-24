package vo;
import java.sql.Timestamp;


public class Trade_modulepermission {
	private Long id;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	private Timestamp createDate;
	public Timestamp getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}
	private Integer status;
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
}