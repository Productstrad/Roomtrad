package vo;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.HashMap;


public class TradePermission {
	private Integer permissionID;
	public Integer getPermissionID() {
		return permissionID;
	}
	public void setPermissionID(Integer permissionID) {
		this.permissionID = permissionID;
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
	private Integer isVisible;
	public Integer getIsVisible() {
		return isVisible;
	}
	public void setIsVisible(Integer isVisible) {
		this.isVisible = isVisible;
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
	private Integer isButton;
	public Integer getIsButton() {
		return isButton;
	}
	public void setIsButton(Integer isButton) {
		this.isButton = isButton;
	}
	private Integer parentID;
	public Integer getParentID() {
		return parentID;
	}
	public void setParentID(Integer parentID) {
		this.parentID = parentID;
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