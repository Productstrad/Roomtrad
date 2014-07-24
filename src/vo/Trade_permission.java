package vo;
import java.lang.Boolean;
import java.sql.Timestamp;


public class Trade_permission {
	private Integer id;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	private String permissionAction;
	public String getPermissionAction() {
		return permissionAction;
	}
	public void setPermissionAction(String permissionAction) {
		this.permissionAction = permissionAction;
	}
	private String permissionName;
	public String getPermissionName() {
		return permissionName;
	}
	public void setPermissionName(String permissionName) {
		this.permissionName = permissionName;
	}
	private Integer sort;
	public Integer getSort() {
		return sort;
	}
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	private String script;
	public String getScript() {
		return script;
	}
	public void setScript(String script) {
		this.script = script;
	}
	private String icon;
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	private String permissionController;
	public String getPermissionController() {
		return permissionController;
	}
	public void setPermissionController(String permissionController) {
		this.permissionController = permissionController;
	}
	private String description;
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	private Boolean isButton;
	public Boolean getIsButton() {
		return isButton;
	}
	public void setIsButton(Boolean isButton) {
		this.isButton = isButton;
	}
	private Integer parentID;
	public Integer getParentID() {
		return parentID;
	}
	public void setParentID(Integer parentID) {
		this.parentID = parentID;
	}
	private String createDate;
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	private Timestamp trad_Permissioncol;
	public Timestamp getTrad_Permissioncol() {
		return trad_Permissioncol;
	}
	public void setTrad_Permissioncol(Timestamp trad_Permissioncol) {
		this.trad_Permissioncol = trad_Permissioncol;
	}
	private Integer status;
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
}