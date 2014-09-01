package action;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import util.ParamUtil;
import util.MessageKit;
import util.Page;
import util.StringUtil;
import dao.TradePermissionDao;
import vo.TradePermission;



@Controller
@RequestMapping("/tradepermission")
public class TradePermissionAction {
	
	private Logger log = LoggerFactory.getLogger(TradePermissionAction.class);
	
	@Autowired
	TradePermissionDao tradePermissionDao;	
	
	@RequestMapping(value = "/list.do")
	public String list(HttpServletRequest request,HttpServletResponse response			
			,Model model) {	
		Integer permissionID=ParamUtil.getIntegerParameter(request,"permissionID");
		String permissionAction=ParamUtil.getStringParameter(request,"permissionAction");
		String permissionName=ParamUtil.getStringParameter(request,"permissionName");
		Integer sort=ParamUtil.getIntegerParameter(request,"sort");
		Integer isVisible=ParamUtil.getIntegerParameter(request,"isVisible");
		String script=ParamUtil.getStringParameter(request,"script");
		String icon=ParamUtil.getStringParameter(request,"icon");
		String permissionController=ParamUtil.getStringParameter(request,"permissionController");
		String description=ParamUtil.getStringParameter(request,"description");
		Integer isButton=ParamUtil.getIntegerParameter(request,"isButton");
		Integer parentID=ParamUtil.getIntegerParameter(request,"parentID");
		
		Map params = new HashMap();
		params.put("permissionID", permissionID);
		params.put("permissionAction", permissionAction);
		params.put("permissionName", permissionName);
		params.put("sort", sort);
		params.put("isVisible", isVisible);
		params.put("script", script);
		params.put("icon", icon);
		params.put("permissionController", permissionController);
		params.put("description", description);
		params.put("isButton", isButton);
		params.put("parentID", parentID);
			
		int pageNo=Page.getCurrentPage(request);
		int pageSize=Page.getPageSize(request,20);		
		model.addAttribute("list", tradePermissionDao.find(params,pageNo,pageSize));			   
		Page.setPageBeans(tradePermissionDao.findCount(params), pageSize, request, model);		
		return "tradepermission/list";
	 }	
	
	/**
	 * update vo详细信息显示页
	 * @param request
	 * @param response
	 * @param model
	 * @return	 
	 */
	@RequestMapping(value = "/update.do")
	public String update(HttpServletRequest request,HttpServletResponse response			
			,Model model) {	
		Integer id=ParamUtil.getIntegerParameter(request, "id");
		TradePermission vo=tradePermissionDao.findByPK(id);
		model.addAttribute("vo", vo);
		return "tradepermission/update";
	 }
	 
	 /**
	 * 提交更新，根据参数更新对象
	 * @param request
	 * @param response
	 * @param id
	 * @param model
	 * @author mengdz
	 */
	@RequestMapping(value = "/updatepost.do")	
	public void updatepost(HttpServletRequest request,HttpServletResponse response
			,Model model) {		
		Map<String, Object> paramsMap=new HashMap<String, Object>();
		if(StringUtil.isNotNullorEmpty(ParamUtil.getStringParameter(request, "permissionID_set"))){
			paramsMap.put("permissionID_set", ParamUtil.getIntegerParameter(request, "permissionID_set"));
		}
		if(StringUtil.isNotNullorEmpty(ParamUtil.getStringParameter(request, "permissionAction_set"))){
			paramsMap.put("permissionAction_set", ParamUtil.getStringParameter(request, "permissionAction_set"));
		}
		if(StringUtil.isNotNullorEmpty(ParamUtil.getStringParameter(request, "permissionName_set"))){
			paramsMap.put("permissionName_set", ParamUtil.getStringParameter(request, "permissionName_set"));
		}
		if(StringUtil.isNotNullorEmpty(ParamUtil.getStringParameter(request, "sort_set"))){
			paramsMap.put("sort_set", ParamUtil.getIntegerParameter(request, "sort_set"));
		}
		if(StringUtil.isNotNullorEmpty(ParamUtil.getStringParameter(request, "isVisible_set"))){
			paramsMap.put("isVisible_set", ParamUtil.getIntegerParameter(request, "isVisible_set"));
		}
		if(StringUtil.isNotNullorEmpty(ParamUtil.getStringParameter(request, "script_set"))){
			paramsMap.put("script_set", ParamUtil.getStringParameter(request, "script_set"));
		}
		if(StringUtil.isNotNullorEmpty(ParamUtil.getStringParameter(request, "icon_set"))){
			paramsMap.put("icon_set", ParamUtil.getStringParameter(request, "icon_set"));
		}
		if(StringUtil.isNotNullorEmpty(ParamUtil.getStringParameter(request, "permissionController_set"))){
			paramsMap.put("permissionController_set", ParamUtil.getStringParameter(request, "permissionController_set"));
		}
		if(StringUtil.isNotNullorEmpty(ParamUtil.getStringParameter(request, "description_set"))){
			paramsMap.put("description_set", ParamUtil.getStringParameter(request, "description_set"));
		}
		if(StringUtil.isNotNullorEmpty(ParamUtil.getStringParameter(request, "isButton_set"))){
			paramsMap.put("isButton_set", ParamUtil.getIntegerParameter(request, "isButton_set"));
		}
		if(StringUtil.isNotNullorEmpty(ParamUtil.getStringParameter(request, "parentID_set"))){
			paramsMap.put("parentID_set", ParamUtil.getIntegerParameter(request, "parentID_set"));
		}
		
		if(StringUtil.isNotNullorEmpty(ParamUtil.getStringParameter(request, "permissionID"))){
			paramsMap.put("permissionID", ParamUtil.getIntegerParameter(request, "permissionID"));
		}
		if(StringUtil.isNotNullorEmpty(ParamUtil.getStringParameter(request, "permissionAction"))){
			paramsMap.put("permissionAction", ParamUtil.getStringParameter(request, "permissionAction"));
		}
		if(StringUtil.isNotNullorEmpty(ParamUtil.getStringParameter(request, "permissionName"))){
			paramsMap.put("permissionName", ParamUtil.getStringParameter(request, "permissionName"));
		}
		if(StringUtil.isNotNullorEmpty(ParamUtil.getStringParameter(request, "sort"))){
			paramsMap.put("sort", ParamUtil.getIntegerParameter(request, "sort"));
		}
		if(StringUtil.isNotNullorEmpty(ParamUtil.getStringParameter(request, "isVisible"))){
			paramsMap.put("isVisible", ParamUtil.getIntegerParameter(request, "isVisible"));
		}
		if(StringUtil.isNotNullorEmpty(ParamUtil.getStringParameter(request, "script"))){
			paramsMap.put("script", ParamUtil.getStringParameter(request, "script"));
		}
		if(StringUtil.isNotNullorEmpty(ParamUtil.getStringParameter(request, "icon"))){
			paramsMap.put("icon", ParamUtil.getStringParameter(request, "icon"));
		}
		if(StringUtil.isNotNullorEmpty(ParamUtil.getStringParameter(request, "permissionController"))){
			paramsMap.put("permissionController", ParamUtil.getStringParameter(request, "permissionController"));
		}
		if(StringUtil.isNotNullorEmpty(ParamUtil.getStringParameter(request, "description"))){
			paramsMap.put("description", ParamUtil.getStringParameter(request, "description"));
		}
		if(StringUtil.isNotNullorEmpty(ParamUtil.getStringParameter(request, "isButton"))){
			paramsMap.put("isButton", ParamUtil.getIntegerParameter(request, "isButton"));
		}
		if(StringUtil.isNotNullorEmpty(ParamUtil.getStringParameter(request, "parentID"))){
			paramsMap.put("parentID", ParamUtil.getIntegerParameter(request, "parentID"));
		}
		int effect=tradePermissionDao.update(paramsMap);
		MessageKit.displayJsonResult(response, effect, null, null, null);		
	}
	 
	 /**
	 * update 提交
	 * @param request
	 * @param response
	 * @param model	 
	 */
	@RequestMapping(value = "/updatevopost.do")
	public void updatevopost(HttpServletRequest request,HttpServletResponse response			
			,Model model) {		
		Integer permissionID=ParamUtil.getIntegerParameter(request,"permissionID");
		String permissionAction=ParamUtil.getStringParameter(request,"permissionAction");
		String permissionName=ParamUtil.getStringParameter(request,"permissionName");
		Integer sort=ParamUtil.getIntegerParameter(request,"sort");
		Integer isVisible=ParamUtil.getIntegerParameter(request,"isVisible");
		String script=ParamUtil.getStringParameter(request,"script");
		String icon=ParamUtil.getStringParameter(request,"icon");
		String permissionController=ParamUtil.getStringParameter(request,"permissionController");
		String description=ParamUtil.getStringParameter(request,"description");
		Integer isButton=ParamUtil.getIntegerParameter(request,"isButton");
		Integer parentID=ParamUtil.getIntegerParameter(request,"parentID");
			
		TradePermission vo=new TradePermission();
		vo.setPermissionID(permissionID);
		vo.setPermissionAction(permissionAction);
		vo.setPermissionName(permissionName);
		vo.setSort(sort);
		vo.setIsVisible(isVisible);
		vo.setScript(script);
		vo.setIcon(icon);
		vo.setPermissionController(permissionController);
		vo.setDescription(description);
		vo.setIsButton(isButton);
		vo.setParentID(parentID);
				
		int effect=tradePermissionDao.update(vo);
		MessageKit.displayJsonResult(response, effect, null, null, null);
	 }	
	
	/**
	 * add vo详细信息显示页
	 * @param request
	 * @param response
	 * @param model
	 * @return	
	 */
	@RequestMapping(value = "/add.do")
	public String add(HttpServletRequest request,HttpServletResponse response			
			,Model model) {			
		return "tradepermission/add";
	 }
	 
	 /**
	 * add 提交
	 * @param request
	 * @param response
	 * @param model	 
	 */
	@RequestMapping(value = "/addpost.do")
	public void addpost(HttpServletRequest request,HttpServletResponse response			
			,Model model) {	
		Integer permissionID=ParamUtil.getIntegerParameter(request,"permissionID");
		String permissionAction=ParamUtil.getStringParameter(request,"permissionAction");
		String permissionName=ParamUtil.getStringParameter(request,"permissionName");
		Integer sort=ParamUtil.getIntegerParameter(request,"sort");
		Integer isVisible=ParamUtil.getIntegerParameter(request,"isVisible");
		String script=ParamUtil.getStringParameter(request,"script");
		String icon=ParamUtil.getStringParameter(request,"icon");
		String permissionController=ParamUtil.getStringParameter(request,"permissionController");
		String description=ParamUtil.getStringParameter(request,"description");
		Integer isButton=ParamUtil.getIntegerParameter(request,"isButton");
		Integer parentID=ParamUtil.getIntegerParameter(request,"parentID");
			
		TradePermission vo=new TradePermission();
		vo.setPermissionID(permissionID);
		vo.setPermissionAction(permissionAction);
		vo.setPermissionName(permissionName);
		vo.setSort(sort);
		vo.setIsVisible(isVisible);
		vo.setScript(script);
		vo.setIcon(icon);
		vo.setPermissionController(permissionController);
		vo.setDescription(description);
		vo.setIsButton(isButton);
		vo.setParentID(parentID);
				
		int effect=tradePermissionDao.insert(vo);
		MessageKit.displayJsonResult(response, effect, null, null, null);
	 }
	 
	@RequestMapping(value = "/delete.do")
	public void delete(HttpServletRequest request,HttpServletResponse response			
			,Model model) {	
		Integer id=ParamUtil.getIntegerParameter(request, "id");		
		int effect=tradePermissionDao.delete(id);
		MessageKit.displayJsonResult(response, effect, null, null, null);
	 }
}
