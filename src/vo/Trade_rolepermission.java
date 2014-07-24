package vo;
import java.sql.Timestamp;


public class Trade_rolepermission {
	private Long id;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	private Integer roleID;
	public Integer getRoleID() {
		return roleID;
	}
	public void setRoleID(Integer roleID) {
		this.roleID = roleID;
	}
	private Long modulePermissionID;
	public Long getModulePermissionID() {
		return modulePermissionID;
	}
	public void setModulePermissionID(Long modulePermissionID) {
		this.modulePermissionID = modulePermissionID;
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