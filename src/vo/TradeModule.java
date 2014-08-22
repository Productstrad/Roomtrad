package vo;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.HashMap;


public class TradeModule {
	private Integer moduleID;
	public Integer getModuleID() {
		return moduleID;
	}
	public void setModuleID(Integer moduleID) {
		this.moduleID = moduleID;
	}
	private String moduleName;
	public String getModuleName() {
		return moduleName;
	}
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}
	private String moduleLinkUrl;
	public String getModuleLinkUrl() {
		return moduleLinkUrl;
	}
	public void setModuleLinkUrl(String moduleLinkUrl) {
		this.moduleLinkUrl = moduleLinkUrl;
	}
	private String moduleIcon;
	public String getModuleIcon() {
		return moduleIcon;
	}
	public void setModuleIcon(String moduleIcon) {
		this.moduleIcon = moduleIcon;
	}
	private Integer parentNo;
	public Integer getParentNo() {
		return parentNo;
	}
	public void setParentNo(Integer parentNo) {
		this.parentNo = parentNo;
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
	private Integer isLeaf;
	public Integer getIsLeaf() {
		return isLeaf;
	}
	public void setIsLeaf(Integer isLeaf) {
		this.isLeaf = isLeaf;
	}
	private Integer isMenu;
	public Integer getIsMenu() {
		return isMenu;
	}
	public void setIsMenu(Integer isMenu) {
		this.isMenu = isMenu;
	}
	private Integer isDeleted;
	public Integer getIsDeleted() {
		return isDeleted;
	}
	public void setIsDeleted(Integer isDeleted) {
		this.isDeleted = isDeleted;
	}
	private String moduleController;
	public String getModuleController() {
		return moduleController;
	}
	public void setModuleController(String moduleController) {
		this.moduleController = moduleController;
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