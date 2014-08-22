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
import dao.TradePermissionDao;
import vo.TradePermission;



@Controller
@RequestMapping("/trade_permission")
public class TradePermissionAction {
	
	private Logger log = LoggerFactory.getLogger(TradePermissionAction.class);
	
	@Autowired
	TradePermissionDao tradePermissionDao;	
	
	@RequestMapping(value = "/list.do")
	public String list(HttpServletRequest request,HttpServletResponse response			
			,Model model) {	
		Integer permissionID=ParamUtil.getIntegerParameter(request,"permissionID"));String permissionAction=ParamUtil.getStringParameter(request,"permissionAction"));String permissionName=ParamUtil.getStringParameter(request,"permissionName"));Integer sort=ParamUtil.getIntegerParameter(request,"sort"));Integer isVisible=ParamUtil.getIntegerParameter(request,"isVisible"));String script=ParamUtil.getStringParameter(request,"script"));String icon=ParamUtil.getStringParameter(request,"icon"));String permissionController=ParamUtil.getStringParameter(request,"permissionController"));String description=ParamUtil.getStringParameter(request,"description"));Integer isButton=ParamUtil.getIntegerParameter(request,"isButton"));Integer parentID=ParamUtil.getIntegerParameter(request,"parentID"));
		Map params = new HashMap();
		params.put("permissionID", permissionID);params.put("permissionAction", permissionAction);params.put("permissionName", permissionName);params.put("sort", sort);params.put("isVisible", isVisible);params.put("script", script);params.put("icon", icon);params.put("permissionController", permissionController);params.put("description", description);params.put("isButton", isButton);params.put("parentID", parentID);	
		int pageNo=Page.getCurrentPage(request);
		int pageSize=Page.getPageSize(request,20);		
		model.addAttribute("list", tradePermissionDao.find(params,pageNo,pageSize));			   
		Page.setPageBeans(tradePermissionDao.findCount(params), pageSize, request, model);		
		return "trade_permission/list";
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
		return "trade_permission/update";
	 }
	 
	 /**
	 * update 提交
	 * @param request
	 * @param response
	 * @param model	 
	 */
	@RequestMapping(value = "/updatepost.do")
	public void updatepost(HttpServletRequest request,HttpServletResponse response			
			,Model model) {		
		Integer permissionID=ParamUtil.getIntegerParameter(request,"permissionID");String permissionAction=ParamUtil.getStringParameter(request,"permissionAction");String permissionName=ParamUtil.getStringParameter(request,"permissionName");Integer sort=ParamUtil.getIntegerParameter(request,"sort");Integer isVisible=ParamUtil.getIntegerParameter(request,"isVisible");String script=ParamUtil.getStringParameter(request,"script");String icon=ParamUtil.getStringParameter(request,"icon");String permissionController=ParamUtil.getStringParameter(request,"permissionController");String description=ParamUtil.getStringParameter(request,"description");Integer isButton=ParamUtil.getIntegerParameter(request,"isButton");Integer parentID=ParamUtil.getIntegerParameter(request,"parentID");	
		TradePermission vo=new TradePermission();
		vo.setPermissionID(permissionID);vo.setPermissionAction(permissionAction);vo.setPermissionName(permissionName);vo.setSort(sort);vo.setIsVisible(isVisible);vo.setScript(script);vo.setIcon(icon);vo.setPermissionController(permissionController);vo.setDescription(description);vo.setIsButton(isButton);vo.setParentID(parentID);		
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
		return "trade_permission/add";
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
		Integer permissionID=ParamUtil.getIntegerParameter(request,"permissionID");String permissionAction=ParamUtil.getStringParameter(request,"permissionAction");String permissionName=ParamUtil.getStringParameter(request,"permissionName");Integer sort=ParamUtil.getIntegerParameter(request,"sort");Integer isVisible=ParamUtil.getIntegerParameter(request,"isVisible");String script=ParamUtil.getStringParameter(request,"script");String icon=ParamUtil.getStringParameter(request,"icon");String permissionController=ParamUtil.getStringParameter(request,"permissionController");String description=ParamUtil.getStringParameter(request,"description");Integer isButton=ParamUtil.getIntegerParameter(request,"isButton");Integer parentID=ParamUtil.getIntegerParameter(request,"parentID");	
		TradePermission vo=new TradePermission();
		vo.setPermissionID(permissionID);vo.setPermissionAction(permissionAction);vo.setPermissionName(permissionName);vo.setSort(sort);vo.setIsVisible(isVisible);vo.setScript(script);vo.setIcon(icon);vo.setPermissionController(permissionController);vo.setDescription(description);vo.setIsButton(isButton);vo.setParentID(parentID);		
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
